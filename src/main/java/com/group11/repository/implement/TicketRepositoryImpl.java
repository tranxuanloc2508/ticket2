/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.repository.implement;

import com.group11.pojos.Seat;
import com.group11.pojos.Ticket;
import com.group11.repository.TicketRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author LocNe
 */
@Repository
@Transactional
public class TicketRepositoryImpl implements TicketRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Override
    public boolean addTicket(Ticket p) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
           
            session.save(p);

            return true;
        } catch (Exception ex) {
            System.err.println("=== ADD TICKET ERRER ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Seat> getSeat() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q;
        q = s.createQuery("From Seat");
        return q.getResultList();
    }

    @Override
    public Seat getSeatId(int i) {
       Session s = sessionFactory.getObject().getCurrentSession();
       return s.get(Seat.class,i);
    }

    @Override
    public Ticket getTicketId(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
       return s.get(Ticket.class,i);
    }

    @Override
    public List<Seat> getSeat(int id) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Seat> query = builder.createQuery(Seat.class);
        Root root = query.from(Seat.class);
        query.select(root).where(builder.gt(root.get("carid"), id));
        Query q = s.createQuery(query);
        return q.getResultList();
    }
    
}
