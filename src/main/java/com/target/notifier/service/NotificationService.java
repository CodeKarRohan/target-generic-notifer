package com.target.notifier.service;


import com.target.notifier.channel.MessageDelivery;
import com.target.notifier.enity.Message;
import com.target.notifier.enity.NotificationResponse;
import com.target.notifier.exception.NotificationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotificationService {

    List<NotificationResponse> notifyAll(Message message);

    List<NotificationResponse> notifyConsumers(String topicName, Message message) throws NotificationException;

    List<NotificationResponse> notifyConsumer(String topicName, String consumerName, Message message) throws NotificationException;

    List<MessageDelivery> sendNotification(String mailid, String slackId, Message message) throws NotificationException;


}
