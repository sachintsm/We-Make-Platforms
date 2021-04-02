package com.javamastermind.com.sms.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "HOBBY")
@Table(name = "HOBBY")
public class Hobby {

	@Id
	@Column(name = "hobby_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "hobby")
	@ManyToMany(mappedBy = "hobbySet")
	private Set<Student> name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Student> getName() {
		return name;
	}

	public void setName(Set<Student> name) {
		this.name = name;
	}
}
