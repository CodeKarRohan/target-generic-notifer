package com.target.notifier.service;


import com.target.notifier.enity.Consumer;
import com.target.notifier.exception.ConsumerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsumerService {

    Consumer createConsumer(Consumer consumer) throws ConsumerException;
    List<Consumer> getAllConsumer();
    Consumer getConsumer(String name);

}
