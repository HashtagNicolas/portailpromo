package fr.afcepf.al33.bnm.wsemail.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender sender;

	@RequestMapping("/envoi")
	public String sendMail() {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		String listeDestinataire[] = { "portailpromo33@mailo.com", "portailpromotional33@gmail.com" };
		try {
			helper.setTo(listeDestinataire);
			helper.setText("Bonjour portail_promotion_ws_email ;-) \n" + "Application.properties & Gmail ; \n"
			        + "envoyé par  un  RestController");
			helper.setSubject("Courriel de test Portail promotion / bnm");
			sender.send(message);
		} catch (Exception e) {
			return "<p>  ENVOI DU COURRIEL [ KO ]  </p> \n" + "<p> " + e  + "  </p>";
		}

		return "<p>  ENVOI DU COURRIEL [ OK ]   </p> \n";
	}
}
