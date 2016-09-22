package com.epam.training.user;

import javax.xml.bind.ValidationException;

import com.epam.training.user.util.Database;
import com.epam.training.user.util.User;

public class UserService {

    private Database database;
    private EmailService emailService;

    public void register(String email, String password) throws ValidationException {
        if (!emailService.isEmailValid(email))
            throw new ValidationException("The email argument is not a valid email: " + email);
        saveUser(email, password);
        emailService.sendRegistrationEmail(email);
    }

    private void saveUser(String email, String password) {
    	User user = new User(email, password);
    	database.save(user);
    }

}
