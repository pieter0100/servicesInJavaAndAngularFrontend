import { Component, inject, Input, signal } from '@angular/core';
import { DepartmentService } from '../../service/department-service';
import { Scientist } from '../../model/scientist';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-scientist',
  imports: [FormsModule],
  templateUrl: './edit-scientist.html',
  styleUrl: './edit-scientist.scss',
})
export class EditScientist {
  departmentService = inject(DepartmentService)

  route = inject(ActivatedRoute);
  router = inject(Router)

  scientistId: string = ''

  scientist = signal<Omit<Scientist, 'id'>>({
    firstName: '',
    lastName: '',
    degree: '',
    departmentName: '',
    age: 0
  });

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

  onSubmit() {
    const segments = this.router.url.split('/');
    
    const id = segments[2];
    // console.log(this.);
    
    this.departmentService.updateScientistAPI(this.scientist(), this.scientistId, id);
  }

  goBack() {
    this.router.navigate(['../../'], { relativeTo: this.route });
  }
}
