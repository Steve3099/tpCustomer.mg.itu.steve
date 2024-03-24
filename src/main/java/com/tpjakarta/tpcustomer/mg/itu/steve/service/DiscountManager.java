/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpcustomer.mg.itu.steve.service;

import com.tpjakarta.tpcustomer.mg.itu.steve.entity.Discount;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Steve
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
    
}
