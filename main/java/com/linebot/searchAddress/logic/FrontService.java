package com.linebot.searchAddress.logic;

import com.linebot.searchAddress.repository.ZipcodeDto;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FrontService implements IFrontService {

    /**
     * 郵便番号検索サービス"zipcloud"のAPI
     */
    private static final String URL = "https://zip-cloud.appspot.com/api/search?zipcode={zipcode}";

    @Override
    public ZipcodeDto getAddress(String zipcode) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(URL, String.class, zipcode);
        System.out.println(result);
        ZipcodeDto zipcodeDto = new ZipcodeDto();
        try {
            JSONObject json1 = new JSONObject(result);
            JSONArray json2 = json1.getJSONArray("results");
            JSONObject json3 = json2.getJSONObject(0);
            zipcodeDto.setZipcode(json3.getString("zipcode"));
            zipcodeDto.setPrefcode(json3.getString("prefcode"));
            zipcodeDto.setAddress1(json3.getString("address1"));
            zipcodeDto.setAddress2(json3.getString("address2"));
            zipcodeDto.setAddress3(json3.getString("address3"));
            zipcodeDto.setKana1(json3.getString("kana1"));
            zipcodeDto.setKana2(json3.getString("kana2"));
            zipcodeDto.setKana3(json3.getString("kana3"));
            return zipcodeDto;
        } catch (JSONException e) {
            return null;
        }
    }
}
