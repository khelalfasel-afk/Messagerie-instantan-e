package com.example.de.copy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, MessageId> {
    List<Message> findByExpediteurEmailAndDestinataireEmailOrExpediteurEmailAndDestinataireEmailOrderByCreatedAtAsc(String expediteurEmail1, String destinataireEmail1, String expediteurEmail2, String destinataireEmail2);

    
}

