package com.epam.training.user;

import com.epam.training.user.util.MailMessage;
import com.epam.training.user.util.SmtpClient;
import com.epam.training.user.util.MailMessage.Builder;

public class EmailService {
	
    private SmtpClient smtpClient;

	public void sendRegistrationEmail(String email) {
		MailMessage message = new Builder()
	            .withFrom("java@example.com")
	            .withTo(email)
	            .withSubject("Hello!")
	            .withText("Sent from a nice OO code snippet!")
	            .build();
	    smtpClient.send(message);
	}

	public boolean isEmailValid(String email) {
		return email.contains("@");
	}

}
