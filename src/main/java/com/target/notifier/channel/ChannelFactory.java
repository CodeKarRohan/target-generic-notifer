package com.target.notifier.channel;

public class ChannelFactory {

    // factory class to get channel
    public Channel getChannel(String type){

        type = type.toUpperCase();

        switch (type){
            case "EMAIL" : return  new Email();
            case "SLACK"  : return  new Slack();
            default: return null;
        }
    }
}
