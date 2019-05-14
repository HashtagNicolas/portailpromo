package fr.afcepf.al33.bnm.wsemail.controller;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.bnm.wsemail.wsEmailDTO;

@RestController
public class EmailController {

    // Déclaration du  sender JavaMail    
    @Autowired
	private JavaMailSender sender;
    private static final  String  messageRetour =  "ENVOI DU COURRIEL"; 

//    @RequestMapping(value="/envoi", headers="Accept=application/json")

	@RequestMapping("/envoi")
	public String sendMail() {
	    
	      String listeDestinataires[] = { "portailpromo33@mailo.com", "portailpromotional33@gmail.com" };    
	      //String listeDestinataire[] = { "portailpromo33@mailo.com" };

	      // Futur paramètres RequestParam	      
	      wsEmailDTO courriel = new wsEmailDTO();
	      courriel.setListeDestinataires( listeDestinataires);
	      courriel.setPieceJointe(new ClassPathResource("coup_de_pied.jpg"));
	      courriel.setSujetMessage("Courriel de test Portail promotion / bnm");
	      courriel.setTexteMessage("Message portail_promotion_ws_email   envoyé par  un  Web Service Rest");
	      courriel.setTitrePieceJointe("coup_de_pied.jpg");

        // Envoi des emails & de gestion des retours. 
		try {
	        // Préparation de la structure d'envoi du courriel
	        MimeMessage Enveloppe = sender.createMimeMessage();
	        MimeMessageHelper helper;
	        //Si Pas de pièce jointe
	        if( courriel.getTitrePieceJointe() == null ) 
	            // message simple
	            helper = new MimeMessageHelper( Enveloppe );
	        else {
	            // true permet d'activer un format de message multiparties
	            helper = new MimeMessageHelper( Enveloppe, true );
	            helper.addAttachment( courriel.getTitrePieceJointe(), courriel.getPieceJointe() );
	        }
	        // Préparation de l'envoi
			helper.setTo( courriel.getListeDestinataires() );
			helper.setSubject(  courriel.getSujetMessage() );
            helper.setText( courriel.getTexteMessage() );  
			// Envoi du courriel
			sender.send( Enveloppe );
		} 
		catch ( Exception erreur ) {
		    return "<p>  " + messageRetour + " [ KO ]  </p> \n <p> " + erreur  + "  </p>";
		}
		return  "<p>  " + messageRetour + " [ OK ]   </p> \n";
	}		
}
