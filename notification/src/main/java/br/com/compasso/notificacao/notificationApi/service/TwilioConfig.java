package br.com.compasso.notificacao.notificationApi.service;

public class TwilioConfig {


    final String ACCOUNT_SID ="ACfea9cd549bb7be7e7f9ae4b84096284f";
    final String AUTH_TOKEN ="b25cce86aa3f13a99e22f84a65a54167";
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
