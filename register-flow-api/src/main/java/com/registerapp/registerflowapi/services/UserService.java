package com.registerapp.registerflowapi.services;

import com.registerapp.registerflowapi.exceptions.CustomAuthException;
import com.registerapp.registerflowapi.models.User;
import jakarta.security.auth.message.AuthException;

public interface UserService {

    User validateUser(String email, String password) throws CustomAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws CustomAuthException;
}
