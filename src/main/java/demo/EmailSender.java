package demo;

import java.util.Properties;

import com.aventstack.extentreports.model.Log;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {

	public static void main(String[] args) {

		final String senderEmail = "Swakshprabesh@gmail.com";
		final String appPassword = "uautvmejhgiiquwo";
		final String recipientEmail = "Swakshprabesh@gmail.com";
		Properties pro = new Properties();

		// SMTP server properties
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.host", "smtp.gmail.com");
		pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.port", "587");

		// Create a session with Authentication
		Session session = Session.getDefaultInstance(pro, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPassword);
			}

		});
		session.setDebug(true);
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject("Test email from Automation QA Team");
			message.setText("Hello \n This is a test email from QA Team \n Regards, \n QA Team");

			// Send Email

			Transport.send(message);
			System.out.println("Email Sent Successfully with Attacahment****");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}