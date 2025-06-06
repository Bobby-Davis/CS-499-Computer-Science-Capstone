import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RescueAnimalsComponent } from './rescue-animals.component';

describe('RescueAnimalsComponent', () => {
  let component: RescueAnimalsComponent;
  let fixture: ComponentFixture<RescueAnimalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RescueAnimalsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RescueAnimalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
