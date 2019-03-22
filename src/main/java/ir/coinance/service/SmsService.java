package ir.coinance.service;

import ir.coinance.config.security.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class SmsService {

    @Value("${sms.userApiKey}")
    private String userApiKey;

    @Value("${sms.secretKey}")
    private String secretKey;

    @Value("${sms.gateWay}")
    private String smsGateway;

    @Value("${sms.lineNumber}")
    private String lineNumber;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MobileVerificationService mobileVerificationService;

    public String getToken() throws CustomException {
        String token = "";
        Map<String, Object> params = Map.of("UserApiKey", userApiKey, "SecretKey", secretKey);
        Map<String, Object> response = restTemplate.postForObject(smsGateway + "Token", params, HashMap.class);
        if (!response.isEmpty()) {
            if ((Boolean) response.get("IsSuccessful")) {
                token = response.get("TokenKey").toString();
            }
        } else throw new CustomException(messageSource.getMessage("server.error.call.to.support",null, Locale.US));

        return token;
    }

    public Boolean send(String mobileNumber) throws CustomException{
        HttpHeaders headers = new HttpHeaders();
        headers.set("cache-control", "no-cache");
        headers.set("Content-Type", "application/json");
        headers.set("x-sms-ir-secure-token", getToken());

        if (mobileVerificationService.waitingCheck(mobileNumber)){
            throw new CustomException("لطفا ۲ دقیقه دیگر تلاش کنید");
        }

        String message = "کد تایید شما: " + mobileVerificationService.getVerificationCode(mobileNumber);

        Map<String, Object> params = Map.of(
                "Messages", new String[]{message},
                "MobileNumbers", new String[]{mobileNumber},
                "LineNumber", lineNumber,
                "SendDateTime", "",
                "CanContinueInCaseOfError", false);

        Map<String, Object> response = restTemplate.postForObject(smsGateway + "MessageSend", new HttpEntity<>(params, headers), HashMap.class);

         if ((Boolean) response.get("IsSuccessful")){
            return true;
        } else throw new CustomException(messageSource.getMessage("server.error.call.to.support",null, Locale.US));
    }

}
