package com.target.notifier.controller;

import com.target.notifier.channel.MessageDelivery;
import com.target.notifier.enity.Message;
import com.target.notifier.enity.NotificationResponse;
import com.target.notifier.exception.NotificationException;
import com.target.notifier.repository.TopicRepository;
import com.target.notifier.service.NotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
@Api(value = "Notification sender", description = "Operations pertaining to sending notification.")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @Autowired
    TopicRepository topicRepository;


    /**
     * @param message
     * @return
     * @throws NotificationException
     */
    @PostMapping("")
    @ApiOperation(value = "Returns list of messages sent with consumer details",
            notes = "Api is used for sending notification to all consumers.")
    HttpEntity<List<NotificationResponse>> sendNotificationToAll(
            @RequestBody Message message) throws NotificationException {
        List<NotificationResponse> res =
                notificationService.notifyAll(message);
        return new ResponseEntity<List<NotificationResponse>>(
                res, new HttpHeaders(), HttpStatus.OK);
    }


    /**
     * @param name
     * @param message
     * @return
     * @throws NotificationException
     */
    @PostMapping("/topic/{name}")
    @ApiOperation(value = "Returns list of messages sent with consumer details",
            notes = "Api is used for sending notification to all consumers " +
                    "subscribed to a particular topic.")
    HttpEntity<List<NotificationResponse>> sendNotificationToTopic(
            @PathVariable(value = "name") String name,
            @RequestBody Message message) throws NotificationException {

        List<NotificationResponse> res =
                notificationService.notifyConsumers(name, message);
        return new ResponseEntity<List<NotificationResponse>>(
                res, new HttpHeaders(), HttpStatus.OK);

    }


    /**
     * @param message
     * @param name
     * @param consumerName
     * @return
     * @throws NotificationException
     */
    @PostMapping("/topic/{name}/consumer/{consumerName}")
    @ApiOperation(value = "Returns list of messages sent with consumer details",
            notes = "Api is used for sending notification to a particular consumer.")
    HttpEntity<List<NotificationResponse>> sendNotificationToConsumer(
            @RequestBody Message message,
            @PathVariable(value = "name") String name,
            @PathVariable(value = "consumerName") String consumerName) throws NotificationException {

        List<NotificationResponse> res = notificationService.notifyConsumer(name,
                consumerName, message);
        return new ResponseEntity<List<NotificationResponse>>(
                res, new HttpHeaders(), HttpStatus.OK);

    }

    /**
     * @param message
     * @param mailId
     * @param slackid
     * @return
     * @throws NotificationException
     */
    @PostMapping("/nofify")
    @ApiOperation(value = "Returns list of messages sent with details",
            notes = "Generic api is used to send message to specified mail and slack id..")
    HttpEntity<List<MessageDelivery>> generalNotification(
            @RequestBody Message message,
            @RequestParam(name = "email", required = false) String mailId,
            @RequestParam(name = "slackid", required = false) String slackid) throws NotificationException {

        List<MessageDelivery> msd = notificationService.sendNotification(mailId,
                slackid,
                message);

        return new ResponseEntity<List<MessageDelivery>>(
                msd, new HttpHeaders(), HttpStatus.OK);

    }
}
