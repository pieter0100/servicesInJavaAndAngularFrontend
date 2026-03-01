import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScientistDetails } from './scientist-details';

describe('ScientistDetails', () => {
  let component: ScientistDetails;
  let fixture: ComponentFixture<ScientistDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ScientistDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScientistDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
