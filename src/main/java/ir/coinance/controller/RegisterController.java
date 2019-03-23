package ir.coinance.controller;

import ir.coinance.config.security.exception.CustomException;
import ir.coinance.controller.util.ControllerExceptionHandling;
import ir.coinance.dto.UserAddDto;
import ir.coinance.service.MobileVerificationService;
import ir.coinance.service.SmsService;
import ir.coinance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/register")
@Validated
public class RegisterController extends ControllerExceptionHandling {

    @Autowired
    private UserService userService;

    @Autowired
    private MobileVerificationService mobileVerificationService;

    @Autowired
    private SmsService smsService;

    @PostMapping("/")
    public ResponseEntity register(@RequestBody @Valid UserAddDto userAddDto) throws CustomException {
        return ResponseEntity.ok(userService.register(userAddDto));
    }

    @PostMapping("/getVerificationCode")
    public ResponseEntity getVerificationCode(@RequestParam("mobileNumber") @Size(min = 13, max = 13, message = "{mobile.length}") String mobileNumber) throws CustomException {
        return new ResponseEntity(smsService.send(mobileNumber), HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity verify(@RequestParam("mobileNumber") String mobileNumber,
                                 @RequestParam("verificationCode") String verificationCode) throws CustomException {
        return new ResponseEntity(mobileVerificationService.verify(mobileNumber, verificationCode), HttpStatus.OK);
    }
}
