package com.fariba.springrestdemo.dao;

import com.fariba.springrestdemo.entity.Customer;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = currentSession.createQuery("select c from Customer c order by c.lastName", Customer.class);
        List<Customer> customers = customerQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Customer where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();
        String queryText = "select c from Customer c";
        if (StringUtils.isNotBlank(searchName)) {
            queryText += " where lower(c.firstName) like :searchName or lower(c.lastName) like :searchName";
        } else {
            queryText += " order by c.lastName";
        }
        Query query = session.createQuery(queryText, Customer.class);
        if (StringUtils.isNotBlank(searchName)) query.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
        List<Customer> customers = query.getResultList();
        return customers;
    }
}
