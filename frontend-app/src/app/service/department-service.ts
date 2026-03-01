import { inject, Injectable, signal } from '@angular/core';
import { Department } from '../model/department';
import { HttpClient } from '@angular/common/http';
import { Scientist } from '../model/scientist';

@Injectable({
  providedIn: 'root',
})
export class DepartmentService {
  departments = signal<Array<Department>>([]);

  scientists = signal<Array<Scientist>>([]);

  http = inject(HttpClient);

  getDepartmentsFromAPI() {
    const url = '/departments'

    this.http.get(url).subscribe((response: any) => {
      this.departments.set(response.departments);
    })
  }

  deleteDepartmentAPI(id: string) {
    const url = '/departments/' + id;
    
    this.http.delete(url).subscribe({
      next: () => this.getDepartmentsFromAPI(),

      error: () => console.log("nie udalo sie usnac")
    })
  }

  addDepartmentAPI(department: Omit<Department, 'id'>) {
    const url = '/departments';

    this.http.post(url, department).subscribe({
      next: () => this.getDepartmentsFromAPI(),

      error: () => console.log('nie udalo sie dodac')
    })
  }

  getDepartmentAPI(id: string) {
    const url = '/departments/' + id;
    
    return this.http.get<Department>(url);
  }

  updateDepartmentAPI(department: any) {
    var dep: Omit<Department, 'id'> = {
      departmentBuildingNumber: department.departmentBuildingNumber,
      departmentName: department.departmentName
    }

    const url = '/departments/' + department.id;

    this.http.put(url, dep).subscribe({
      next: () => this.getDepartmentsFromAPI(),

      error: () => console.log('nie udalo sie dodac')
    })
  }

  getDepartmentScientistsAPI(id: string) {
    const url = '/scientists/dep/' + id 

    this.http.get(url).subscribe((response: any) => {
      console.log(response.scientists);
      
        this.scientists.set(response.scientists)
    })
  }

  deleteScientistAPI(id: string, depId: string) {
    const url = '/scientists/' + id 

    this.http.delete(url).subscribe({
      next: () => this.getDepartmentScientistsAPI(depId),

      error: () => console.log("nie udalo sie usnac")
    })
  }

  addScientistAPI(scientist: Omit<Scientist, 'id'>, id: string) {
    const url = '/scientists';

    
    this.getDepartmentAPI(id).subscribe({
        next: (dep) => {
            // To wykona się dopiero jak przyjdą dane!
            console.log('Przyszła nazwa:', dep.departmentName);
            
            // 2. Ustaw nazwę
            scientist.departmentName = dep.departmentName;
            
            // 3. DOPIERO TERAZ wyślij POST
            this.http.post(url, scientist).subscribe({
                next: () => {
                    console.log('Dodano naukowca!');
                    // 4. Odśwież listę
                    this.getDepartmentScientistsAPI(id);
                },
                error: (err) => console.error('Nie udało się dodać', err)
            });
        },
        error: (err) => console.error('Nie udało się pobrać wydziału', err)
    });
  }

  getScientistAPI(id: string) {
    const url = '/scientists/' + id;
    
    return this.http.get<Scientist>(url);
  }

  updateScientistAPI(scientist: any, sciId: string, departmentId: string) {
    var sci: Omit<Scientist, 'id'> = {
      firstName: scientist.firstName,
      lastName: scientist.lastName,
      degree: scientist.degree,
      departmentName: scientist.departmentName,
      age: scientist.age
    }

    const url = '/scientists/' + sciId;

    console.log(sci);
    

    this.http.put(url, sci).subscribe({
      next: () => this.getDepartmentScientistsAPI(departmentId),

      error: () => console.log('nie udalo sie dodac')
    })
  }
}
