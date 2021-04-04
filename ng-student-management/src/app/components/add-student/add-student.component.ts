import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.scss']
})
export class AddStudentComponent implements OnInit {

  hobbyDiv = false;
  hobbies = [];
  studentData = [];

  firstName: String = ""
  lastName: String = ""
  age: String = ""
  city: String = ""
  height: String = ""
  weight: String = ""
  hobby: String = ""
  id: String = ""

  firstNameError = false;
  lastNameError = false;

  constructor(
    private studentService: StudentServiceService,
    private activatedRoute: ActivatedRoute,

  ) { }

  ngOnInit(): void {
    if (this.activatedRoute.snapshot.params.id != null) {
      this.hobbyDiv = true
      let studentId = this.activatedRoute.snapshot.params.id;

      this.studentService.getStudent(studentId).subscribe((res: any) => {
        this.studentData = res;

        this.id = res.id
        this.hobbies = res.hobbies
        this.firstName = res.firstName
        this.lastName = res.lastName
        this.age = res.age
        this.city = res.city
        this.height = res.height
        this.weight = res.weight
      })
    }

  }

  addHobby() {
    this.hobbyDiv = false;

    this.hobbies.push({ "name": this.hobby })
    console.log(this.hobbies)
    this.hobbyDiv = true;
  }

  saveStudent() {

    if (this.firstName == "") {
      this.firstNameError = true;
      this.lastNameError = false;
    }
    else if (this.lastName == "") {
      this.lastNameError = true;
      this.firstNameError = false;
    }
    else {
      this.firstNameError = false;
      this.lastNameError = false;


      if (this.activatedRoute.snapshot.params.id == null) {
        const student = {
          firstName: this.firstName,
          lastName: this.lastName,
          age: this.age,
          city: this.city,
          height: this.height,
          weight: this.weight,
          hobbies: this.hobbies
        }

        this.studentService.saveStudent(JSON.stringify(student)).subscribe((res: any) => {
          if (res.responseCode == 300) {
            alert(res.message);
            window.location.reload();
          }
          else {
            alert(res.message);
          }
        })
      }
      else {
        const student = {
          id: this.id,
          firstName: this.firstName,
          lastName: this.lastName,
          age: this.age,
          city: this.city,
          height: this.height,
          weight: this.weight,
          hobbies: this.hobbies
        }

        this.studentService.updateStudent(JSON.stringify(student)).subscribe((res: any) => {
          if (res.responseCode == 301) {
            alert(res.message);
            window.location.reload();
          }
          else {
            alert(res.message);
          }

        })
      }
    }
  }
}
