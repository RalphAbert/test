package entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;
import java.util.Date;

@Entity
public class Report {
    @Id
    private String id;

    private Long likes;

    private Date newest;

    private Date oldest;

    public Report(String id, Long likes, Date newest, Date oldest) {
       this.id = id;
        this.likes = likes;
        this.newest = newest;
        this.oldest = oldest;
    }

    public Report() {
    }

    public String getId() {
        return id;
    }

    public void setId(String group) {
        this.id = group;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Date getNewest() {
        return newest;
    }

    public void setNewest(Date newest) {
        this.newest = newest;
    }

    public Date getOldest() {
        return oldest;
    }

    public void setOldest(Date oldest) {
        this.oldest = oldest;
    }


}
