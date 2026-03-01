import { Routes } from '@angular/router';
import { App } from './app';

export const routes: Routes = [
    {
        path: 'deps',

        loadComponent: () => {
            return import('./views/view-departments/view-departments').then((m) => m.ViewDepartments);
        },

        children: [
            {
                path: 'form',
                loadComponent: () => import('./component/departmentForm/form').then((m) => m.Form)
            },
            {
                path: 'edit/:id',
                loadComponent: () => import('./component/edit-form/edit-form').then((m) => m.EditForm)
            },
        ],
    },
    {
        path: 'dep/:id',

        loadComponent: () => import('./views/view-scientists/view-scientists').then((m) => m.ViewScientists),

        children: [
            {
                path: 'form',
                loadComponent: () => import('./component/scientist-form/scientist-form').then((m) => m.ScientistForm)
            },
            {
                path: 'edit/:id',
                loadComponent: () => import('./component/edit-scientist/edit-scientist').then((m) => m.EditScientist)
            },
            {
                path: 'details/:id',
                loadComponent: () => import('./component/scientist-details/scientist-details').then((m) => m.ScientistDetails)
            }
        ],
    }
];
