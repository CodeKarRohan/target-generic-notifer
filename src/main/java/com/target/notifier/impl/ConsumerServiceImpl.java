package com.target.notifier.impl;

import com.target.notifier.enity.Consumer;
import com.target.notifier.exception.ConsumerException;
import com.target.notifier.repository.ConsumerRepository;
import com.target.notifier.service.ConsumerService;
import com.target.notifier.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {


    @Autowired
    ConsumerRepository consumerRepository;

    @Override
    public Consumer createConsumer(Consumer consumer) throws ConsumerException {

        if (consumer == null) {
            throw new ConsumerException("Invalid consumer");
        }

        if (!ValidationUtil.isStringValid(consumer.getName())) {
            throw new ConsumerException("Invalid consumer name");
        }
        if (consumer.getNotificationType() <= 0) {
            consumer.setNotificationType((short) 1);
        }

        if (!ValidationUtil.EmailValidator(consumer.getEmailId())) {
            throw new ConsumerException("Invalid email  id");
        }

        return consumerRepository.save(consumer);

    }

    @Override
    public List<Consumer> getAllConsumer() {
        return consumerRepository.findAll();
    }

    @Override
    public Consumer getConsumer(String name) {
        return null;
    }
}
