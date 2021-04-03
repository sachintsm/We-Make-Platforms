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

  constructor(
    private router: Router,
    private studentService: StudentServiceService
  ) { }

  async ngOnInit() {

    await this.studentService.getAllStudnets().subscribe((res: any[]) => {
      this.students = res;
      console.log(res);
      console.log(this.students);

    })
  }

  addStudent() {
    this.router.navigate(['/add-student']);
  }

  editStudent(id){
    
  }

  deleteStudent(id){
    
    this.studentService.deleteStudent(id).subscribe(res => {
      console.log(res);
      
    })
  }
}
