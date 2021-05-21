package br.com.compasso.notificacao.notificationApi.service;

import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class SmsService {

    Logger logger = LoggerFactory.getLogger(SmsService.class);
    public boolean enviaSms(String mensagem, String telefone){

        //Acessando componetes do Twilio
        TwilioConfig twilioConfig = new TwilioConfig();
        Twilio.init(twilioConfig.getACCOUNT_SID(), twilioConfig.getAUTH_TOKEN());

        try {
            logger.info("Enviando SMS para o Cliente");
            Message message = Message.creator(
                    new PhoneNumber(telefone),
                    new PhoneNumber(twilioConfig.getPhoneNumber()),
                    mensagem)
                    .create();

        } catch (TwilioException i){
            logger.error("Erro ao enviar SMS para o cliente id" + i.getCause());
        }

       return true;
    }
}
