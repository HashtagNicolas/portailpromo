package fr.afcepf.al33.wsauthentification.service.itf;

import fr.afcepf.al33.wsauthentification.entity.User;

public interface IAuthenticationService {

	
	public User findOneByLoginAndPassword(String login, String password);

}
