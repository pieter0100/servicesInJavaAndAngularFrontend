import { Component, inject, OnInit, Input, signal } from '@angular/core';
import { DepartmentService } from '../../service/department-service';
import { Department } from '../../model/department';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-edit-form',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './edit-form.html',
  styleUrl: './edit-form.scss',
})
export class EditForm{
  departmentService = inject(DepartmentService)

  department = signal<Omit<Department, 'id'>>({
    departmentBuildingNumber: 0,
    departmentName: ''
  })

  @Input()
  set id(departmentId: string) {
    this.fetchDepartment(departmentId);
  }

  fetchDepartment(id: string) {
    this.departmentService.getDepartmentAPI(id).subscribe({
      next: (dep) => this.department.set(dep),
      
      error: (err) => console.error(err)
    });
  }

  onSubmit() {
    let depName = this.department().departmentName;
    let depNumber = Number(this.department().departmentBuildingNumber);

    var dep: Omit<Department, 'id'> = {
      departmentBuildingNumber: depNumber,
      departmentName: depName
    }

    this.departmentService.updateDepartmentAPI(this.department())
  }
}
