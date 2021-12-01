package com.yk.jdbc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    //define fields
    //define constructors
    //define getters setters
    //define toString
    //annotate fields


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL) //since reviews are related to course and if course is deleted review should too.
    @JoinColumn(name="course_id")
    private List<Review> reviews;


    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(                                                     //many to many creates a new table and
                                                                    // refers everything from third table.
            name = "course_student",                                //created table name
            joinColumns = @JoinColumn(name="course_id"),            //point of reference 1
            inverseJoinColumns = @JoinColumn(name="student_id"))    //other table reference
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public  Course(){}

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //helper method for adding reviews
    public void addReview(Review tempReview){
        if(null==reviews){
            reviews=new ArrayList<>();
        }
        reviews.add(tempReview);
    }

    //helper method for adding student
    public void addStudent(Student tempStudent){
        if(null==students){
            students=new ArrayList<>();
        }
        students.add(tempStudent);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
