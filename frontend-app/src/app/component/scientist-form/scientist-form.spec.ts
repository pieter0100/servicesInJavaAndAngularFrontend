import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScientistForm } from './scientist-form';

describe('ScientistForm', () => {
  let component: ScientistForm;
  let fixture: ComponentFixture<ScientistForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScientistForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScientistForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
