package kz.eldos.testapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User implements Serializable {

    /*
     * Fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Size.List({
            @Size(min = 4, message = "Пароль слишком короткий"),
            @Size(max = 50, message = "Пароль слишком длинный")
    })
    private String password;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    /*
     * Entity Basics
     */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name=" + name + ", date=" + date + ", password=" + password + "}";
    }
}
