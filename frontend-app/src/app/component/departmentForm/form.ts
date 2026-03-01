import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DepartmentService } from '../../service/department-service';
import { Department } from '../../model/department';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-form',
  imports: [FormsModule, RouterLink],
  templateUrl: './form.html',
  styleUrl: './form.scss',
})
export class Form {
  departmentService = inject(DepartmentService);

  newDepartment: Omit<Department, 'id'> = {
    departmentBuildingNumber: 0,
    departmentName: '',
  }

  onSubmit() {
    this.departmentService.addDepartmentAPI(this.newDepartment)
  }
}
