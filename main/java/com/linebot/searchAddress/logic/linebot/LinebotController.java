package com.linebot.searchAddress.logic.linebot;

import com.linebot.searchAddress.logic.linebot.replier.Zipcode;
import com.linebot.searchAddress.logic.linebot.replier.Follow;
import com.linecorp.bot.client.LineBlobClient;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@LineMessageHandler
public class LinebotController {

    private LineBlobClient client;
    private static final Logger log = LoggerFactory.getLogger(LinebotController.class);

    @Autowired
    public LinebotController(LineBlobClient client) {
        this.client = client;
    }

    @EventMapping
    public Message handleFollow(FollowEvent event) {
        Follow follow = new Follow(event);
        return follow.reply();
    }

    @EventMapping
    public Message handleMessage(MessageEvent<TextMessageContent> event) {
        Zipcode zipcode = new Zipcode(event);
        return zipcode.reply();
    }
}