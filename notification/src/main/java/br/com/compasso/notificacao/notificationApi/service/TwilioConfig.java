package br.com.compasso.notificacao.notificationApi.service;

public class TwilioConfig {


    final String ACCOUNT_SID ="YOUR ACCOUNT SID";
    final String AUTH_TOKEN ="YOUR AUTH TOKEN";
    final String phoneNumber = "+5162199912";

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getACCOUNT_SID() {
        return ACCOUNT_SID;
    }

    public String getAUTH_TOKEN() {
        return AUTH_TOKEN;
    }
}
