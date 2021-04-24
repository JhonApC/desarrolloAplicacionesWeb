package co.edu.poli.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.proyecto.model.Mail;
import co.edu.poli.proyecto.model.SMS;
import co.edu.poli.proyecto.services.ISmsAndMailService;

@RequestMapping("/api/notificacion/")
@RestController
public class NotificacionController {

	@Autowired
	private ISmsAndMailService service;

	@PostMapping("mail")
	public String sendEmail(@RequestBody Mail mail) {
		this.service.sendEmail(mail);
		return "Email sent successfully";
	}

	@PostMapping("sms")
	public Message sendSMS(@RequestBody SMS sms) {
		return this.service.sendSMS(sms);
	}

}
