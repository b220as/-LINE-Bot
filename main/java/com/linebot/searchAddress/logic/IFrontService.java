package com.linebot.searchAddress.logic;

import com.linebot.searchAddress.repository.ZipcodeDto;

public interface IFrontService {
    public ZipcodeDto getAddress(String zipcode);
}
