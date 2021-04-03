package com.javamastermind.com.sms.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hobby")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,  property = "id")
public class Hobby {

	@Id
	@Column(name = "hobby_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(targetEntity = Student.class, mappedBy = "hobbies", cascade = CascadeType.ALL)
	private Set<Student> studentHobbies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudentHobbies() {
		return studentHobbies;
	}

	public void setStudentHobbies(Set<Student> studentHobbies) {
		this.studentHobbies = studentHobbies;
	}
}
