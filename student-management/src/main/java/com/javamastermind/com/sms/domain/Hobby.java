package com.javamastermind.com.sms.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "hobby")
public class Hobby {

	@Id
	@Column(name = "hobby_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "hobby")
	private Set<StudentHobby> studentHobbies;

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

	public Set<StudentHobby> getStudentHobbies() {
		return studentHobbies;
	}

	public void setStudentHobbies(Set<StudentHobby> studentHobbies) {
		this.studentHobbies = studentHobbies;
	}
}
