import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditScientist } from './edit-scientist';

describe('EditScientist', () => {
  let component: EditScientist;
  let fixture: ComponentFixture<EditScientist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditScientist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditScientist);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
