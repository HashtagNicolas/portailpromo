package fr.afcepf.al33.wsauthentification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al33.wsauthentification.dao.itf.UserDao;
import fr.afcepf.al33.wsauthentification.entity.User;
import fr.afcepf.al33.wsauthentification.service.itf.IAuthenticationService;


@Component
public class AuthenticationService implements IAuthenticationService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findOneByLoginAndPassword(String login, String password) {
		return userDao.findOneByLoginAndPassword(login, password);
	}

}
