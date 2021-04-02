package com.javamastermind.com.sms.domain;


import javax.persistence.*;

@Entity
public class StudentHobby {

    @EmbeddedId
    StudentHobbyKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("hobbyId")
    @JoinColumn(name = "hobby_id")
    Hobby hobby;

    public StudentHobby(StudentHobbyKey id, Student student, Hobby hobby) {
        this.id = id;
        this.student = student;
        this.hobby = hobby;
    }

    public StudentHobbyKey getId() {
        return id;
    }

    public void setId(StudentHobbyKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }
}
