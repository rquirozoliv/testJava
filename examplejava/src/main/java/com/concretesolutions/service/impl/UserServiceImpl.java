package com.concretesolutions.service.impl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.concretesolutions.dto.UserDTO;
import com.concretesolutions.exception.EmailAlreadyRegisteredException;
import com.concretesolutions.exception.LoginUserException;
import com.concretesolutions.model.Phone;
import com.concretesolutions.model.User;
import com.concretesolutions.repository.UserRepository;
import com.concretesolutions.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	public static final String EMAIL_ALREADY_REGISTERED = "El correo ya registrado";
	public static final String SYSTEM_ERROR = "Error de sistema";
	public static final String EMAIL_NOT_REGISTERED = "Usuario o contraseña inválidos";
	

	@Autowired
	private UserRepository userRepository;

	public User saveUser(UserDTO userDTO) {
		User optionalUser = this.userRepository.findOneByEmail(userDTO.getEmail());
		if (null != optionalUser) {
			try {
				throw new EmailAlreadyRegisteredException(EMAIL_ALREADY_REGISTERED, HttpStatus.INTERNAL_SERVER_ERROR);
			} catch (EmailAlreadyRegisteredException e) {
				e.printStackTrace();
			}
		}

		User us = new User();
		us.setEmail(userDTO.getEmail());
		us.setName(userDTO.getName());
		us.setPassword(userDTO.getPassword());
		us.setPhones(new ArrayList<>());
		
		us.getPhones().forEach(phonesDTO -> {
			Phone phone = new Phone();
			phone.setNumber(phonesDTO.getNumber());
			phone.setCityCode(phonesDTO.getCityCode());
			phone.setCountryCode(phonesDTO.getCountryCode());
			us.getPhones().add(phone);
		});

		Date toDate = new Date();
		us.setCreated(toDate);
		us.setModified(toDate);
		us.setLast_login(toDate);
		this.userRepository.save(us);
		return us;
	}


	public User loginUser(String email, String password) throws LoginUserException {
		User optionalUser = this.userRepository.findByEmailAndPassword(email, password);
		if(null == optionalUser)
			throw new LoginUserException(EMAIL_NOT_REGISTERED, HttpStatus.INTERNAL_SERVER_ERROR) ;
		
		return optionalUser;
	}

}

