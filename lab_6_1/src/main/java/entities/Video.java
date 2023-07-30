package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = "Video.findByKeyword",
                query = "SELECT DISTINCT o.video FROM Favorite o"
                        + " WHERE o.video.title LIKE :keyword"),
        @NamedQuery(name = "Video.findByUser",
                query = "SELECT o.video FROM Favorite o"
                        + " WHERE o.user.id=:id"),
        @NamedQuery(name = "Video.findInRange",
                query = "SELECT DISTINCT o.video FROM Favorite o"
                        + " WHERE o.likeDate BETWEEN :min AND :max"),
        @NamedQuery(name = "Video.findInMonths",
                query = "SELECT DISTINCT o.video FROM Favorite o"
                        + " WHERE month(o.likeDate) IN (:months)")
})

@Entity
@Table(name= "video")
public class Video {

    @Id
    @Column(length = 40)
    private String id;

    @Column(length = 40)
    private String title;

    @Column(length = 40)
    private String poster;

    @Column(length = 40)
    private String description;


    private Integer views = 0;

    private Boolean active = true;

    @OneToMany(mappedBy = "video")
    List<Favorite> favorites;

    public Video(String id, String title, String poster, String description) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.description = description;
    }

    public Video() {
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", active=" + active +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
