import { Component, inject, OnInit } from '@angular/core';
import { DepartmentService } from '../../service/department-service';
import { RouterOutlet, RouterLinkWithHref } from '@angular/router';

@Component({
  selector: 'app-view-departments',
  imports: [RouterOutlet, RouterLinkWithHref],
  standalone: true,
  templateUrl: './view-departments.html',
  styleUrl: './view-departments.scss',
})
export class ViewDepartments implements OnInit{
  departmentService = inject(DepartmentService);

  ngOnInit(): void {
    this.departmentService.getDepartmentsFromAPI()
  }

  deleteDepartment(id: string) {
    this.departmentService.deleteDepartmentAPI(id)
  }
}
