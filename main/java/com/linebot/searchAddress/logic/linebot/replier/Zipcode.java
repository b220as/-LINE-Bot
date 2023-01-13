package com.linebot.searchAddress.logic.linebot.replier;

import com.linebot.searchAddress.logic.FrontService;
import com.linebot.searchAddress.repository.ZipcodeDto;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;

public class Zipcode implements Replier {
    private MessageEvent<TextMessageContent> event;

    public Zipcode(MessageEvent<TextMessageContent> event) {
        this.event = event;
    }

    @Override
    public com.linecorp.bot.model.message.Message reply() {
        TextMessageContent tmc = event.getMessage();
        String text = tmc.getText();
        FrontService frontService = new FrontService();
        ZipcodeDto zipcodeDto = frontService.getAddress(text);
        if (zipcodeDto != null) {
            return new TextMessage(zipcodeDto.getAddress());
        } else {
            return new TextMessage("該当する住所が見つかりませんでした");
        }
    }
}

