package com.target.notifier.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Consumer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer {

    @Id
    private int id;

    private String name;

    private String emailId;

    private  String slackId;

    private short notificationType;

    private int topicId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false, name ="topicId",
            referencedColumnName = "id")
    private Topic topic;


    @Override
    public  int hashCode(){
        return this.getId();
    }

}
