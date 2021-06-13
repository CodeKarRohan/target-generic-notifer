package com.target.notifier.controller;

import com.target.notifier.enity.Topic;
import com.target.notifier.exception.TopicException;
import com.target.notifier.service.TopicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {

    //create new topic

    @Autowired
    TopicService topicService;

    @PostMapping("")
    @ApiOperation(value = "Creates new topic, returns the same.",
            notes = "Api is used to create new Topic.")
    HttpEntity<Topic> createTopic(@RequestBody Topic topic) throws  TopicException{

         Topic newTopic = null;
            newTopic = topicService.createTopic(topic);
        return new ResponseEntity<Topic>(newTopic, new HttpHeaders(), HttpStatus.CREATED);


    }

    @GetMapping("")
    @ApiOperation(value = "Returns list of all topics.",
            notes = "Api is used get all topics.")
    HttpEntity<List<Topic>> getAllTopic() throws  TopicException{

        List<Topic> topics = null;
        topics = topicService.getAllTopic();

        if (null == topics || topics.size() <= 0){
            throw  new TopicException("No topics found");
        }
        return new ResponseEntity<List<Topic>>(topics, new HttpHeaders(), HttpStatus.OK);


    }


}
