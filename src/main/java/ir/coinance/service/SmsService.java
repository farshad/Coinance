package ir.coinance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
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
    private MobileVerificationService mobileVerificationService;

    public String getToken() throws Exception {
        String token = "";
        Map<String, Object> params = Map.of("UserApiKey", userApiKey, "SecretKey", secretKey);
        Map<String, Object> response = restTemplate.postForObject(smsGateway + "Token", params, HashMap.class);
        if (!response.isEmpty()) {
            if ((Boolean) response.get("IsSuccessful")){
                token = response.get("TokenKey").toString();
            }
        } else throw new Exception("sms token not available");

        return token;
    }

    public void send() {
        String token = null;
        try {
            token = getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("cache-control", "no-cache");
        headers.set("Content-Type", "application/json");
        headers.set("x-sms-ir-secure-token", token);

        String message = "کد تایید شما:";

        Map<String, Object> params = Map.of(
                "Messages", new String[]{"تست"},
                "MobileNumbers", new String[]{"09031888448"},
                "LineNumber", lineNumber,
                "SendDateTime", "",
                "CanContinueInCaseOfError", false);
        mobileVerificationService.getVerficationCode();
        //Map<String, String> response = restTemplate.postForObject(smsGateway + "MessageSend", new HttpEntity<>(params, headers), HashMap.class);
    }

}
