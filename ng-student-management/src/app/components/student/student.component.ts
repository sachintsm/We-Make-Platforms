import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentServiceService } from '../../services/student-service.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.scss']
})
export class StudentComponent implements OnInit {

  students = [];
  noData = false;

  constructor(
    private router: Router,
    private studentService: StudentServiceService
  ) { }

  async ngOnInit() {

    this.noData = true;

    await this.studentService.getAllStudnets().subscribe((res: any[]) => {
      this.students = res;

      if (this.students.length != 0) {
        this.noData = false;
      }
    })
  }

  addStudent() {
    this.router.navigate(['/add-student']);
  }

  editStudent(id) {
    this.router.navigate(['/edit-student/' + id])
  }

  deleteStudent(id) {
    var answer = window.confirm("Are you sure you want to delete?");
    if (answer) {
      this.studentService.deleteStudent(id).subscribe((res: any) => {
        console.log(res);

        if (res.responseCode == 290) {
          alert(res.message);
          window.location.reload();
        }
        else (
          alert(res.message)
        )
      })
    }
  }

  viewStudent(id) {
    this.router.navigate(['/student-data/' + id]);
  }
}
