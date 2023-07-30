package reponsitories;

import entities.Report;
import entities.Video;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class ReportReponsitory {
    public ArrayList<Report> getFavariteWithCheck() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            String sql = "SELECT new Report(o.video.title,count(o),max(o.likeDate),min(o.likeDate))FROM Favorite  o" +
                    " group by o.video.title";

            TypedQuery query = (TypedQuery) session.createQuery(sql, Report.class);
            return (ArrayList<Report>) query.getResultList();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new ReportReponsitory().getFavariteWithCheck());
    }
}
