package com.epam.training.javasecurity.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m from Message m where m.to = ?1")
    Iterable<Message> findAllToCurrentUser(User user);

    Message findOne(Long id);
}
