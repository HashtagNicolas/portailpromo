package fr.afcepf.al33.bnm.wsemail.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages= {"fr.afcepf.al33.bnm"})
public class PortailPromotionWsEmailApplication  {

    public static void main(String[] args) {
        SpringApplication.run(PortailPromotionWsEmailApplication.class, args);
    }
}
/*
@SpringBootApplication(scanBasePackages= {"fr.afcepf.al33.bnm"})
public class PortailPromotionWsEmailApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(PortailPromotionWsEmailApplication.class, args);
	}

	@Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
	    String listeDestinataires[] = { "portailpromo33@mailo.com", "portailpromotional33@gmail.com" };
	    wsEmailDTO courriel = new wsEmailDTO();
	    courriel.setListeDestinataires( listeDestinataires);
	    courriel.setPieceJointe(new ClassPathResource("coup_de_pied.jpg"));
	    courriel.setSujetMessage("Courriel de test Portail promotion / bnm");
	    courriel.setTexteMessage("Message portail_promotion_ws_email   envoyé par  un  Web Service Rest");
	    courriel.setTitrePieceJointe("coup_de_pied.jpg");
	}
}
	*/

