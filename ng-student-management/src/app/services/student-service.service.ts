import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  findAllStudentsUri = 'http://localhost:8080/v1/getAllStudents';
  findStudentUri = 'http://localhost:8080/v1/findStudent';
  deleteStudentUri = 'http://localhost:8080/v1/deleteStudent';
  updateStudentUri = 'http://localhost:8080/v1/updateStudent';
  saveStudentUri = 'http://localhost:8080/v1/saveStudent';

  constructor(
    private http: HttpClient,
  ) { }

  getAllStudnets() {
    return this.http.get(this.findAllStudentsUri);
  }

  getStudent(id) {
    return this.http.get(this.findStudentUri + "/?id=" + id);
  }

  deleteStudent(id) {
    return this.http.delete(this.deleteStudentUri + "/?id=" + id);
  }

  updateStudent(student) {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json; charset=utf-8');

    return this.http.put(this.updateStudentUri, student, { headers: headers });
  }

  saveStudent(student) {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json; charset=utf-8');

    return this.http.post(this.saveStudentUri, student, { headers: headers });
  }

}
