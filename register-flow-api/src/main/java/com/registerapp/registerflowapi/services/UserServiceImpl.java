package com.registerapp.registerflowapi.services;

import com.registerapp.registerflowapi.exceptions.CustomAuthException;
import com.registerapp.registerflowapi.models.User;
import com.registerapp.registerflowapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws CustomAuthException {
        return null;
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws CustomAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.*)$");
        if (null != email) {
            email = email.toLowerCase(Locale.ROOT);
        } else {
            throw new CustomAuthException("Email cannot be null");
        }
        if (!pattern.matcher(email).matches())
            throw new CustomAuthException("Invalid email format");

        Integer count = userRepository.getCountByEmail(email);
        if (count > 0)
            throw new CustomAuthException("Email already in use");
        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
