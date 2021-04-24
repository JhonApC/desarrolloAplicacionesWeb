package co.edu.poli.proyecto.services;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import co.edu.poli.proyecto.model.Mail;
import co.edu.poli.proyecto.model.SMS;

@Service
public class MailServiceImpl implements ISmsAndMailService {
	public static final String ACCOUNT_SID = "AC26c3ab68b6f5f17c81707bddb9cdbd69";
	public static final String AUTH_TOKEN = "cf9bc38a8e28cdf7d3b0a34566c0da1e";
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendEmail(Mail mail) {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			mimeMessageHelper.setText(mail.getMailContent());
			mail.getAttachments().forEach(data -> {
				System.out.println(data);
				try {
					File file = new File((String) data);
					mimeMessageHelper.addAttachment(file.getName(), file);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			});

			mailSender.send(mimeMessageHelper.getMimeMessage());

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Message sendSMS(SMS sms) {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(new com.twilio.type.PhoneNumber(sms.getPhoneNumberTo()),
				new com.twilio.type.PhoneNumber("+17077394257"), // The Twilio phone number
				sms.getBody()).create();

		return message;
	}

}
