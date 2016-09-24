package com.epam.data;

import java.util.List;

import com.epam.data.util.Cart;
import com.epam.data.util.Feedback;
import com.epam.data.util.User;

public interface DataStore {

    void save(User user);

    void remove(User user);

    void modfiy(User user);

    List<User> getActiveUsers();

    List<User> getAllUsers();

    void save(Feedback feedback);

    void remove(Feedback feedback);

    void modfiy(Feedback feedback);

    List<Feedback> getAllFeedback();

    void save(Cart cart);

    List<Cart> getUserCart(User user);

}
