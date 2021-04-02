package com.javamastermind.com.sms.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
class StudentHobbyKey implements Serializable {

    @Column(name = "student_id")
    Long studentId;

    @Column(name = "hobby_id")
    Long hobbyId;

    public StudentHobbyKey(Long studentId, Long hobbyId) {
        this.studentId = studentId;
        this.hobbyId = hobbyId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentHobbyKey that = (StudentHobbyKey) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(hobbyId, that.hobbyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, hobbyId);
    }

}
