import { Component, inject, signal, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DepartmentService } from '../../service/department-service';
import { Scientist } from '../../model/scientist';

@Component({
  selector: 'app-scientist-details',
  imports: [],
  templateUrl: './scientist-details.html',
  styleUrl: './scientist-details.scss',
})
export class ScientistDetails {
  departmentService = inject(DepartmentService);
  
  route = inject(ActivatedRoute);

  scientistId: string = '';

  scientist = signal<Scientist>({
    id: '',
    firstName: '',
    lastName: '',
    degree: '',
    departmentName: '',
    age: 0
  })

  @Input()
  set id(scientistId: string) {
    this.scientistId = scientistId;
    this.fetchScientist(scientistId);
  }

  fetchScientist(id: string) {
    this.departmentService.getScientistAPI(id).subscribe({
      next: (dep) => this.scientist.set(dep),
      
      error: (err) => console.error(err)
    })
  }
}
