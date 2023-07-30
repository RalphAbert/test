package com.example.demo5.repository;

import com.example.demo5.entity.User;
import com.example.demo5.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> getAll(){
        List<User> movies = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM User ", User.class);
            movies = query.getResultList();
        }catch (Exception e){
            e.printStackTrace(System.out);
        }

        return movies;
    }
    public User getOne(String id) {
        User u = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM nd WHERE id=:id");
            query.setParameter("id", id);
            u = (User) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return u;
    }

//    public Boolean add(movie lop) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.persist(lop);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return false;
//    }
//
//    public Boolean update(movie lop) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.merge(lop);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return false;
//    }
//
//    public Boolean delete(movie lop) {
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            transaction = session.beginTransaction();
//            session.delete(lop);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//        return false;
//    }
}
