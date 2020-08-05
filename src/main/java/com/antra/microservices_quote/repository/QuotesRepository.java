package com.antra.microservices_quote.repository;

import com.antra.microservices_quote.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuotesRepository extends JpaRepository<Quote,Integer> {
    List<Quote> findByUserName(String username);
}
