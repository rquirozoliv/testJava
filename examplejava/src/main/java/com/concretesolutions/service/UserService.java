package com.concretesolutions.service;

import com.concretesolutions.dto.UserDTO;
import com.concretesolutions.exception.LoginUserException;
import com.concretesolutions.model.User;

public interface UserService {
	
    public User saveUser(UserDTO userDTO);
    public User loginUser(String email, String password) throws LoginUserException;
    

}
