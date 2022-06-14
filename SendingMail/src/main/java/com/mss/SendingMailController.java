package com.mss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendingMailController {
	@Autowired
	private SendingMailService SendingMailService;
	
	@GetMapping("/send-mail/{mail}")
     public String sendingMail(@PathVariable String mail) {
    	 return SendingMailService.sendingMail(mail);
     }
//	@GetMapping("/verified")
//	public String verify() {
//		return "successfully verified";
//	}
} 
