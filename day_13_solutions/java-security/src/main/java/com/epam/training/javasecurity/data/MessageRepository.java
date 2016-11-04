package com.epam.training.javasecurity.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    @Query("select m from Message m where m.to.id = ?#{principal.id}")
    Iterable<Message> findAllToCurrentUser();
    

    Message findOne(Long id);
}
