package com.target.notifier.impl;

import com.target.notifier.enity.Message;
import com.target.notifier.exception.NotificationException;
import com.target.notifier.repository.ConsumerRepository;
import com.target.notifier.repository.TopicRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TU_NotificationServiceImpl {

    @InjectMocks
    NotificationServiceImpl notificationServiceImpl;

    @Mock
    TopicRepository topicRepository;

    @Mock
    ConsumerRepository consumerRepository;

    @Before()
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    /**
     * Example test like this many tests can be added
     * @throws NotificationException
     */
    @Test(expected = NotificationException.class)
    public void testSendNotificationInValMailId() throws NotificationException {

        notificationServiceImpl.sendNotification("xxxx",
                "TEST",
                new Message());

    }





}
