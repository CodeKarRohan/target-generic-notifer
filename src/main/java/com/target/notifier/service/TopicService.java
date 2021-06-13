package com.target.notifier.service;


import com.target.notifier.enity.Topic;
import com.target.notifier.exception.TopicException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopicService {

    Topic getATopic(String name);

    List<Topic> getAllTopic();

    Topic createTopic(Topic topic) throws TopicException;

    Topic updateTopic(Topic topic);


}
