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

    @Column(name = "name")
    private String name;

    @Column(name = "groupId")
    private int groupId;

    @Column(name = "userId")
    private int userId;

    @Column(name = "date")
    private Date date;






}
