package com.epam.training.user;

import javax.xml.bind.ValidationException;

import com.epam.training.user.util.Database;
import com.epam.training.user.util.MailMessage;
import com.epam.training.user.util.SmtpClient;
import com.epam.training.user.util.User;

public class UserService {

    private Database database;
    private SmtpClient smtpClient;

    public void register(String email, String password) throws ValidationException {
        if (!email.contains("@"))
            throw new ValidationException("The email argument is not a valid email: " + email);
        User user = new User(email, password);
        database.save(user);
        MailMessage message = new MailMessage.Builder()
                .withFrom("java@example.com")
                .withTo(email)
                .withSubject("Hello!")
                .withText("Sent from a nice OO code snippet!")
                .build();
        smtpClient.send(message);
    }

}
