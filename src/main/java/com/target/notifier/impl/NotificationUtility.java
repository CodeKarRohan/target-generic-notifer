package com.target.notifier.impl;

import com.target.notifier.channel.*;
import com.target.notifier.enity.Consumer;
import com.target.notifier.enity.Message;
import com.target.notifier.enity.NotificationResponse;
import com.target.notifier.enity.Topic;
import com.target.notifier.repository.TopicRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotificationUtility {

    public void sendMail(Channel channel,
                         Consumer consumer,
                         Message message,
                         Map<Consumer, MessageDelivery> response) {

        Email email = (Email) channel;
        email.setEmailId(consumer.getEmailId());
        email.setFrom(message.getFrom());
        email.setMessage(message);
        response.put(consumer, email.sendMessage());
    }

    public void sendSlackMessae(Channel channel,
                                Consumer consumer,
                                Message message,
                                Map<Consumer, MessageDelivery> response) {

        Slack slack = (Slack) channel;
        slack.setSlackId(consumer.getSlackId());
        slack.setFrom(message.getFrom());
        slack.setMessage(message);

        response.put(consumer, slack.sendMessage());


    }

    public List<NotificationResponse> responseBuilder(Map<Consumer,
            MessageDelivery> response) {

        List<NotificationResponse> responses = new ArrayList<>();

        for (Consumer c : response.keySet()) {
            NotificationResponse c1 = new NotificationResponse();
            c1.setConsumerName(c.getName());
            c1.setMessageDelivery(response.get(c));
            c1.setTopicName(c.getTopic().getName());
            responses.add(c1);

        }

        return responses;

    }


    /**
     * @param topicRepository
     * @param name
     * @return
     */
    public List<Topic> getAllTopicByName(TopicRepository topicRepository,
                                         String name) {

        return topicRepository.findByName(name);
    }


    public void performNotificationOperation(
            List<Consumer> consumers,
            Message message,
            Map<Consumer, MessageDelivery> finalStatus) {
        ChannelFactory channelFactory = new ChannelFactory();
        Channel channel = null;
        for (Consumer consumer : consumers) {

            if (consumer.getNotificationType() == 1) {
                //send mail
                channel = channelFactory.getChannel("EMAIL");
                this.sendMail(channel, consumer, message, finalStatus);
            } else if (consumer.getNotificationType() == 2) {
                channel = channelFactory.getChannel("SLACK");
                this.sendSlackMessae(channel, consumer, message, finalStatus);
            } else {
                channel = channelFactory.getChannel("EMAIL");
                this.sendMail(channel, consumer, message, finalStatus);
                channel = channelFactory.getChannel("SLACK");
                this.sendSlackMessae(channel, consumer, message, finalStatus);
            }
        }

    }

}
