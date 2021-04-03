import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { StudentServiceService } from 'src/app/services/student-service.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.scss']
})
export class AddStudentComponent implements OnInit {

  hobbyDiv = false;
  hobbies = [];

  firstName: String = ""
  lastName: String = ""
  age: String = ""
  city: String = ""
  height: String = ""
  weight: String = ""
  hobby: String = ""

  firstNameError = false;
  lastNameError = false;

  constructor(
    private studentService: StudentServiceService
  ) { }

  ngOnInit(): void {
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
        if (res.successCode == 300) {
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
