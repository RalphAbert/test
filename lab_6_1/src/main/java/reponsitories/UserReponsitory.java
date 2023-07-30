package reponsitories;

import entities.Favorite;
import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
public class UserReponsitory {

    public ArrayList<User> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql  = "FROM User";
            TypedQuery query = (TypedQuery) session.createQuery(sql,User.class);
            return (ArrayList<User>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void save(User user) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(user);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }

        }
    }

    public User findOne(String ma){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT  gh FROM User gh  WHERE gh.id = :id";
            TypedQuery query = (TypedQuery) session.createQuery(sql,User.class);
            query.setParameter("id",ma);
            return (User) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }
       return null;
    }

    public static void main(String[] args) {
       User user  = new User("U2","fighting","hehe","hehe");
       new UserReponsitory().save(user);
        System.out.println(new UserReponsitory().findAll());
    }

}
