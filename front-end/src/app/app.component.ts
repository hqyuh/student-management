import { Component } from '@angular/core';
import {Student} from "./common/student";
import {StudentService} from "./service/student.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public students!: Student[];

  constructor(private studentService: StudentService) {

  }

  ngOnInit(): void {
    this.getStudents();
  }

  public getStudents(): void {
    this.studentService.getStudent().subscribe(
      (response: Student[]) => {
        this.students = response;
      });
  }

}
