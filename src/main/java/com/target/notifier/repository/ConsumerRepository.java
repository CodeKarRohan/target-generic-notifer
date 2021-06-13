package com.target.notifier.repository;

import com.target.notifier.enity.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

    List<Consumer> findByTopicId(int topicId);

    List<Consumer> findByTopicIdAndName(int topicId, String consumerName);

}
