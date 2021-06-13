package com.target.notifier.impl;


import com.target.notifier.enity.Topic;
import com.target.notifier.exception.TopicException;
import com.target.notifier.repository.TopicRepository;
import com.target.notifier.service.TopicService;
import com.target.notifier.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Override
    public Topic getATopic(String name) {

        return null;
    }

    @Override
    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    @Override
    public Topic createTopic(Topic topic) throws TopicException {

        if (null == topic){
            throw  new TopicException("Invalid topic passed");
        }
        if (!ValidationUtil.isStringValid(topic.getName())){
            throw  new TopicException("Invalid topic name");

        }

        return topicRepository.save(topic);
    }



    @Override
    public Topic updateTopic(Topic topic) {
        return null;
    }
}
