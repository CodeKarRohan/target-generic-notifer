package com.target.notifier.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TOPIC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id
    int id;

    String name;

}
