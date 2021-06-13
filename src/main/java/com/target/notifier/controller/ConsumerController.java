package com.target.notifier.controller;

import com.target.notifier.enity.Consumer;
import com.target.notifier.enity.Topic;
import com.target.notifier.exception.ConsumerException;
import com.target.notifier.service.ConsumerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @PostMapping("")
    @ApiOperation(value = "Returns new created Consumer.",
            notes = "Api is used to create new consumer.")
    HttpEntity<Consumer> createNewConsumer(@RequestBody Consumer consumer)
            throws ConsumerException {

        Consumer cons = consumerService.createConsumer(consumer);
        return new ResponseEntity<Consumer>(cons, new HttpHeaders(), HttpStatus.CREATED);

    }

    @GetMapping("")
    @ApiOperation(value = "Returns list of consumers",
            notes = "Api is used to get all consumers.")
    HttpEntity<List<Consumer>> GetAllConsumer()
            throws ConsumerException {

        List<Consumer> cons = consumerService.getAllConsumer();

        if (null == cons || cons.size() <= 0) {
            throw new ConsumerException("No consumer found");
        }
        return new ResponseEntity<List<Consumer>>(cons, new HttpHeaders(),
                HttpStatus.OK);

    }


}
