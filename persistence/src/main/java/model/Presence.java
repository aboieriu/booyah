package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by DELIA on 17.09.2015.
 */

@Entity
@Table(name = "presence")
public class Presence {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;


    @Column(name = "groupId")
    private Long groupId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "date")
    private Date date;

    public Presence() {
    }

    public Presence( Long groupId, Long userId, Date date) {

        this.groupId = groupId;
        this.userId = userId;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
