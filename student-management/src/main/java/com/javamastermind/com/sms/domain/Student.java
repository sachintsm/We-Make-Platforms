package com.javamastermind.com.sms.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity(name = "STUDENTS")
@Table(name = "STUDENTS")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    @NotEmpty(message = "First Name should not be null!")
    private String firstName;

    @Column(name = "lastName")
    @NotEmpty(message = "Last Name should not be null!")
    private String LastName;

    @Column(name = "age")
    private String age;

    @Column(name = "city")
    private String city;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @Column(name = "hobbySet")
    @ManyToMany
    @JoinTable(
            name = "student_hobby",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private Set<Hobby> hobbySet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Set<Hobby> getHobbySet() {
        return hobbySet;
    }

    public void setHobbySet(Set<Hobby> hobbySet) {
        this.hobbySet = hobbySet;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", LastName=" + LastName + ", age=" + age + ", city=" + city
                + ", height=" + height + ", weight=" + weight + ", hobbySet=" + hobbySet + "]";
    }

}
