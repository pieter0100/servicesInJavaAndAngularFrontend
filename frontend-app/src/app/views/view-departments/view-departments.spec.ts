import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDepartments } from './view-departments';

describe('ViewDepartments', () => {
  let component: ViewDepartments;
  let fixture: ComponentFixture<ViewDepartments>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewDepartments]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewDepartments);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
