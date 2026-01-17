package com.spring.liquidasss.dao;

import com.spring.liquidasss.models.Product;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Repository
public class ProductDao {

    private SessionFactory sessionFactory;

    @Transactional
    public List<Product> getProducts(){
        return this.sessionFactory.getCurrentSession().createQuery("from PRODUCT").list();
    }

    @Transactional
    public Product addProduct(Product product){
        this.sessionFactory.getCurrentSession().save(product);
        return product;
    }

    @Transactional
    public Product getProduct(int id){
        return this.sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Transactional
    public Product updateProduct(Product product){
        this.sessionFactory.getCurrentSession().update(String.valueOf(Product.class), product);
        return product;
    }

    @Transactional
    public Boolean deleteProduct(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Object persistenceInstance = session.load(Product.class, id);

        if (persistenceInstance != null) {
            session.delete(persistenceInstance);
            return true;
        }
        return false;
    }

}
