import { Component, inject, OnInit, Input,} from '@angular/core';
import { DepartmentService } from '../../service/department-service';
import { Department } from '../../model/department';
import { RouterOutlet, RouterLinkWithHref } from '@angular/router';
import { Routes } from '@angular/router';

@Component({
  selector: 'app-view-scientists',
  imports: [RouterOutlet, RouterLinkWithHref],
  templateUrl: './view-scientists.html',
  styleUrl: './view-scientists.scss',
})
export class ViewScientists{
  departmentService = inject(DepartmentService);

  departmentId: string = ''

  department: Department = {
    departmentBuildingNumber: 0,
    id: '',
    departmentName: ''
  }

  @Input()
  set id(departmentId: string) {
    this.departmentId = departmentId;
    this.fetchDepartment(departmentId);
  }

  fetchDepartment(id: string){
    this.departmentService.getDepartmentScientistsAPI(id)

    this.departmentService.getDepartmentAPI(id).subscribe((res) => {
      this.department = res
      console.log(res);
      
    })
  }

  deleteScientist(id: string) {
    this.departmentService.deleteScientistAPI(id, this.departmentId)

    // this.fetchDepartment(this.departmentId)
  }
}
