package fr.afcepf.al33.wsauthentification.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.ws.dto.UserDTO;
import fr.afcepf.al33.wsauthentification.entity.User;
import fr.afcepf.al33.wsauthentification.service.itf.IAuthenticationService;

@RestController
@RequestMapping(value="/rest/auth", headers="Accept=application/json")
public class AuthentificationCtrl {

	@Autowired
	private IAuthenticationService authenticationService;

	@GetMapping("/login")
	public UserDTO getLoggedUser(@RequestParam String login, @RequestParam String password) {

		User user = authenticationService.findOneByLoginAndPassword(login, password);

		UserDTO userDTO = new UserDTO(user.getId(), user.getLastName(), user.getFirstName(), user.getEmail(),
				user.getPhoneNumber());

		return userDTO;
	}
}
