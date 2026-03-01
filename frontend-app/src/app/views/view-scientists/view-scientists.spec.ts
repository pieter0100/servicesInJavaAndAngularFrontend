import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewScientists } from './view-scientists';

describe('ViewScientists', () => {
  let component: ViewScientists;
  let fixture: ComponentFixture<ViewScientists>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewScientists]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewScientists);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
