package co.edu.poli.proyecto.services;

import com.twilio.rest.api.v2010.account.Message;
import co.edu.poli.proyecto.model.Mail;
import co.edu.poli.proyecto.model.SMS;

public interface ISmsAndMailService {

	public void sendEmail (Mail mail);
	public Message sendSMS(SMS sms);
}
