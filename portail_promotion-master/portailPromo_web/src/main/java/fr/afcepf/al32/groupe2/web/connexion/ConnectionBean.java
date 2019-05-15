package fr.afcepf.al32.groupe2.web.connexion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al32.groupe2.entity.Promotion;
import fr.afcepf.al32.groupe2.entity.Shop;
import fr.afcepf.al32.groupe2.entity.Shopkeeper;
import fr.afcepf.al32.groupe2.entity.User;
import fr.afcepf.al32.groupe2.service.IAuthenticationService;

@Component
@SessionScope
public class ConnectionBean {

	@Autowired
	private IAuthenticationService authenticationService;

	private User loggedUser;

	private String login;

	private String password;

	private String message;

	public String connect() {
		String suite="/invite/connexion/simpleConnexion";
		//AQ1905
		// ws_authentification.base_url=http://localhost:8088/portail_promotion_ws_authentification/rest/auth
		String urlAuth = "http://localhost:8088/portail_promotion_ws_authentification/rest/auth/login" +
				"?login=" + login + "&password=" + password;
		RestTemplate restTemplate = new RestTemplate();
		Long userId = restTemplate.getForObject(urlAuth, Long.class);

		User newUser = authenticationService.findOneById(userId);
		
		//AQ1905

		if(newUser != null) {
			loggedUser = newUser;
			suite = "/invite/fichesPromotion/pageAffichagePromotions";
			message = null;
		} else {
			message = "Informations de connexion incorrectes";
		}

		return suite;
	}

	public String logout() {
		loggedUser = null;
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		

		return "../../index.xhtml";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getLoggedUser() {
		return loggedUser;
	}

	public String getMessage() {
		return message;
	}
	
	

}
