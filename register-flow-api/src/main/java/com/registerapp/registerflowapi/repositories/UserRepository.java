package com.registerapp.registerflowapi.repositories;

import com.registerapp.registerflowapi.exceptions.CustomAuthException;
import com.registerapp.registerflowapi.models.User;

public interface UserRepository {
    Integer create(String firstName, String lastName, String email, String password) throws CustomAuthException;

    User FindByEmailAndPassword(String email, String password) throws CustomAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);
}
