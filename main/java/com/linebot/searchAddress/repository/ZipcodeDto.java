package com.linebot.searchAddress.repository;

public class ZipcodeDto {
    /**
     * 郵便番号
     */
    String zipcode;

    /**
     * 都道府県コード
     */
    String prefcode;

    /**
     * 都道府県名
     */
    String address1;

    /**
     * 市町村名
     */
    String address2;

    /**
     * 町域名
     */
    String address3;

    /**
     * 都道府県名カナ
     */
    String kana1;

    /**
     * 市区町村名カナ
     */
    String kana2;

    /**
     * 町域名カナ
     */
    String kana3;

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPrefcode(String prefcode) {
        this.prefcode = prefcode;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setKana1(String kana1) {
        this.kana1 = kana1;
    }

    public void setKana2(String kana2) {
        this.kana2 = kana2;
    }

    public void setKana3(String kana3) {
        this.kana3 = kana3;
    }

    public String getAddress() {
        return address1 + address2 + address3;
    }

}
