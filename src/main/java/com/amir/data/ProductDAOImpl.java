package com.amir.data;

import com.amir.data.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{


    @Autowired
    SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Product product) {
        Session session = sessionFactory.openSession();
        session.save(product);
        session.close();
    }

    @Override
    public List<Product> findAll() {
        try(Session session = getSession()) {
            Query query = session.createQuery("FROM Product");
            List<Product> list = query.list();
            session.close();
            return list;
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.flush();
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }

}