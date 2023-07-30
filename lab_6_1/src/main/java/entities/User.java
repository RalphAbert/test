package entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(length = 40)
    private String id;

    @Column(length = 40)
    private String password;

    @Column(length = 40)
    private String fullname;

    @Column(length = 40)
    private String email;

    @Column(length = 40)
    private Boolean admin = false;

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;


    public User(String id, String password, String fullname, String email) {
        this.id = id;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", admin=" + admin +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
