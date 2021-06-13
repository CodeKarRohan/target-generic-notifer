package com.target.notifier.repository;

import com.target.notifier.enity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    List<Topic> findByName(String name);
}
