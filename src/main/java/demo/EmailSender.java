package demo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

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

			// Email Body Part
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \n\n This is Test email from Java \n\n Regards, \n QA Team");

			// Attachment Part
			MimeBodyPart attachmentPart = new MimeBodyPart();
			String filePath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			System.out.println("Attachment path is :" + filePath);
			attachmentPart.attachFile(new File(filePath));
			
			
			// combine Email Body and Attachment Part
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentPart);
			message.setContent(multipart);
			
			// Send Email
			Transport.send(message);
			System.out.println("Email Sent Successfully with Attacahment****");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}