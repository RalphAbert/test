package reponsitories;

import entities.Favorite;
import entities.Video;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class VideoReponsitory {
    public ArrayList<Video> findAll(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql  = "FROM Video";
            TypedQuery query = (TypedQuery) session.createQuery(sql,Video.class);
            return (ArrayList<Video>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public void save(Video video) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.save(video);
                trans.commit();
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
            }

        }
    }

    public Video findOne(String ma){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT  gh FROM Video gh  WHERE gh.id = :id";
            TypedQuery query = (TypedQuery) session.createQuery(sql,Video.class);
            query.setParameter("id",ma);
            return (Video) query.getSingleResult();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
       Video video = new Video("V1","hehe","hehe","hehe");
      // Video vide = new Video("V2","haha","haha","haha");
        new VideoReponsitory().save(video);
        System.out.println(new VideoReponsitory().findAll());
    }
}
