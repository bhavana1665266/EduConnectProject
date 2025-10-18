import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { EduConnectRoutingModule } from "./educonnect-routing.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { StudentCreateComponent } from "./components/studentcreate/studentcreate.component";
import { TeacherCreateComponent } from "./components/teachercreate/teachercreate.component";
import { CourseCreateComponent } from "./components/coursecreate/coursecreate.component";
import { Enrollment } from "./models/Enrollment";
import { EnrollmentComponent } from "./components/enrollment/enrollment.component";

@NgModule({
  declarations: [
    StudentCreateComponent,
    TeacherCreateComponent,
    CourseCreateComponent,
    EnrollmentComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  exports: [
    
  ]
})
export class EduconnectModule {}
