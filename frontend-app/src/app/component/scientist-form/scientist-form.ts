import { Component, inject } from '@angular/core';
import { Scientist } from '../../model/scientist';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DepartmentService } from '../../service/department-service';

@Component({
  selector: 'app-scientist-form',
  imports: [FormsModule],
  templateUrl: './scientist-form.html',
  styleUrl: './scientist-form.scss',
})
export class ScientistForm{
  departmentId: string = ''

  departmentService = inject(DepartmentService)
  route = inject(ActivatedRoute);
  router = inject(Router)

  sci: Omit<Scientist, 'id'> = {
    age: 0, 
    degree: '',
    departmentName: '',
    firstName: '',
    lastName: ''
  }

  onSubmit() {
    const segments = this.router.url.split('/');
    
    const id = segments[2];

    this.departmentService.addScientistAPI(this.sci, id);
  }

  goBack() {
    // "../" utnie ostatni człon (/form) i przeniesie Cię do rodzica
    this.router.navigate(['../'], { relativeTo: this.route });
  } 
}
