package reponsitories;


import entities.Favorite;
import entities.User;
import entities.Video;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class FavoriteReponsitory {
    public ArrayList<Favorite> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql  = "FROM Favorite";
            TypedQuery query = (TypedQuery) session.createQuery(sql,Favorite.class);
            return (ArrayList<Favorite>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void save(Favorite favorite) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(favorite);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }

        }
    }

    public Favorite findOne(String ma){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT  gh FROM User gh  WHERE gh.id = :id";
            TypedQuery query = (TypedQuery) session.createQuery(sql,Favorite.class);
            query.setParameter("id",ma);
            return (Favorite) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Favorite favorite = new Favorite(new UserReponsitory().findOne("U2"),new VideoReponsitory().findOne("V1"));
        new FavoriteReponsitory().save(favorite);
        System.out.println(new FavoriteReponsitory().getVideoWithidVideo("V1"));
    }

    public ArrayList<Video> getVideoWithTitle(String title) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT DISTINCT o.video FROM Favorite o "
                    + " WHERE o.video.title LIKE  CONCAT('%',:keyword,'%')";
            TypedQuery query = (TypedQuery) session.createQuery(sql,Video.class);
            query.setParameter("keyword",title);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<User> getVideoWithidVideo(String title) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT o.user FROM Favorite o WHERE o.video.id= :vid";
            TypedQuery query = (TypedQuery) session.createQuery(sql,User.class);
            query.setParameter("vid",title);
            return (ArrayList<User>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Video> getFavariteWithCheck(String check) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT o FROM Video o WHERE o.favorites IS EMPTY";
            if(check.equalsIgnoreCase("1")){
                sql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
            }
            TypedQuery query = (TypedQuery) session.createQuery(sql,Video.class);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Video> getVideoWithTitleByNameQuery(String title) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            TypedQuery<Video>query=session.createNamedQuery("Video.findByKeyword",Video.class);
            query.setParameter("keyword", title);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Video> getVideoWithUserNameByNameQuery(String userName) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            TypedQuery<Video>query=session.createNamedQuery("Video.findByUser",Video.class);
            query.setParameter("id", userName);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Video> getVideoWithUserNameByNameQuery(Integer fromDate,Integer toDate) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            TypedQuery<Video>query=session.createNamedQuery("Video.findInRange",Video.class);
            query.setParameter("min", fromDate);
            query.setParameter("max", toDate);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Video> getVideoWithMonthByNameQuery(List<Integer> months) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            TypedQuery<Video>query=session.createNamedQuery("Video.findInMonths",Video.class);
            query.setParameter("months", months);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
