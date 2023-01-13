package com.linebot.searchAddress.logic.linebot.replier;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;

public class Follow implements Replier{
    private FollowEvent event;
    public Follow(FollowEvent event){
        this.event = event;
    }

    @Override
    public Message reply(){
        String text = "「郵便番号」を入力すると\n住所が返信されます";
        return new TextMessage(text);
    }
}
