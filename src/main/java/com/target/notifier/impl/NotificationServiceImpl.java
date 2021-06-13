package com.target.notifier.impl;

import com.target.notifier.channel.*;
import com.target.notifier.enity.Consumer;
import com.target.notifier.enity.Message;
import com.target.notifier.enity.NotificationResponse;
import com.target.notifier.enity.Topic;
import com.target.notifier.exception.NotificationException;
import com.target.notifier.repository.ConsumerRepository;
import com.target.notifier.repository.TopicRepository;
import com.target.notifier.service.NotificationService;
import com.target.notifier.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ConsumerRepository consumerRepository;

    NotificationUtility nUtil = new NotificationUtility();

    /**
     *
     * @param message
     * @return
     */
    @Override
    public List<NotificationResponse> notifyAll(Message message) {

        List<Consumer>  consumers = consumerRepository.findAll();
        Map<Consumer, MessageDelivery> finalStatus = new HashMap<>();
        nUtil.performNotificationOperation(consumers, message, finalStatus);
       return  nUtil.responseBuilder(finalStatus);
    }

    /**
     * For a particular topic, all subscribed consumers will get this message
     * @param topicName
     * @param message
     * @return
     */
    @Override
    public List<NotificationResponse> notifyConsumers(String topicName,
                                                      Message message) throws NotificationException {

        if (!ValidationUtil.isStringValid(topicName)){
            throw new NotificationException(" Invalid topic name ");
        }
        List<Topic> topics = nUtil.getAllTopicByName(topicRepository,
                topicName);

        if (null == topics|| topics.size() <= 0){
            throw new NotificationException(" NO topics found with this name ");
        }
        // need to find all consumer for this topic
        List<Consumer> allConsumer = new ArrayList<>();
        for (Topic topic : topics){
            allConsumer.addAll(consumerRepository.findByTopicId(topic.getId()));
        }

        Map<Consumer, MessageDelivery> finalStatus = new HashMap<>();
        nUtil.performNotificationOperation(
                allConsumer,
                message,
                finalStatus
        );
        return  nUtil.responseBuilder(finalStatus);
    }

    @Override
    public List<NotificationResponse> notifyConsumer(String topicName,
                                                     String consumerName,
                                                     Message message) throws NotificationException {
        if (!ValidationUtil.isStringValid(topicName)){
            throw new NotificationException(" Invalid topic name ");
        }
        List<Topic> topics = nUtil.getAllTopicByName(topicRepository,
                topicName.toUpperCase());

        if (null == topics|| topics.size() <= 0){
            throw new NotificationException(" No topics found with this name.");
        }
        List<Consumer> allConsumer = new ArrayList<>();
        allConsumer = consumerRepository.findByTopicIdAndName(topics.get(0).getId(), consumerName);
        Map<Consumer, MessageDelivery> finalStatus = new HashMap<>();
        nUtil.performNotificationOperation(
                allConsumer,
                message,
                finalStatus
        );
        return  nUtil.responseBuilder(finalStatus);
    }

    /**
     *
     * @param mailid
     * @param slackId
     * @param message
     * @return
     * @throws NotificationException
     */
    @Override
    public List<MessageDelivery> sendNotification(String mailid, String slackId, Message message) throws NotificationException {
        List<MessageDelivery> msd =new  ArrayList<>();
        if( ValidationUtil.isStringValid(mailid)){
            if (!ValidationUtil.EmailValidator(mailid)){

                throw new NotificationException("Not a valid email id");
            }
            else{

                Email email = new Email();
                email.setMessage(message);
                email.setEmailId(mailid);
                email.setFrom("GENERIC NOTIFIER");
                msd.add(email.sendMessage());

            }
        }

        if (ValidationUtil.isStringValid(slackId)){
            Slack slack = new Slack();
            slack.setMessage(message);
            slack.setSlackId(slackId);
            slack.setFrom("GENERIC NOTIFIER");
            msd.add(slack.sendMessage());
        }
        return  msd;
    }
}
