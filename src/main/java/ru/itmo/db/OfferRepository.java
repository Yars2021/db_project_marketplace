package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<InternalOffer, Integer> {
    List<InternalOffer> findBySalesman(String salesman);
    List<InternalOffer> findByBuyer(String buyer);
    List<InternalOffer> findByStatus(Integer status);
}