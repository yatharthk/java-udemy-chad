package com.yk.jdbc.entity;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    //annotate the class with  entity and map to db table

    //define the fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private Instructor instructor;


    //annotate the fields with db column names

    //create constructors
    public InstructorDetail() {
        super();
        // TODO Auto-generated constructor stub
    }


    public InstructorDetail(String youtubeChannel, String hobby) {
        super();
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    //generate getter/setter methods
    public String getYoutubeChannel() {
        return youtubeChannel;
    }


    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }


    public String getHobby() {
        return hobby;
    }


    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public int getId() {
        return id;
    }


    //generate toString() method
    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
    }


    public Instructor getInstructor() {
        return instructor;
    }


    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
