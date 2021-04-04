import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { StudentServiceService } from 'src/app/services/student-service.service';

interface student {
  id: String,
  firstName: String,
  lastName: String,
  age: String,
  city: String
  height: String,
  weight: String,
  hobbies: [{
    id: String
    name: String
  }]
}
@Component({
  selector: 'app-student-data',
  templateUrl: './student-data.component.html',
  styleUrls: ['./student-data.component.scss']
})
export class StudentDataComponent implements OnInit {
  studentData: student[] = [];
  hobbies = [];
  constructor(
    private activatedRoute: ActivatedRoute,
    private studentService: StudentServiceService

  ) { }

  ngOnInit(): void {

    let studentId = this.activatedRoute.snapshot.params.id;

    this.studentService.getStudent(studentId).subscribe((res: any) => {
      this.studentData = res;
      this.hobbies = res.hobbies

    })


  }

}
