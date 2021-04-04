import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { StudentComponent } from './components/student/student.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { StudentDataComponent } from './components/student-data/student-data.component';
import { EditStudentComponent } from './components/edit-student/edit-student.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'student', component: StudentComponent },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'student-data/:id', component: StudentDataComponent },
  { path: 'edit-student/:id', component: EditStudentComponent }

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
