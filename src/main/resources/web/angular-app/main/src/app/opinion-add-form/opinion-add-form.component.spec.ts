import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpinionAddFormComponent } from './opinion-add-form.component';

describe('OpinionAddFormComponent', () => {
  let component: OpinionAddFormComponent;
  let fixture: ComponentFixture<OpinionAddFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OpinionAddFormComponent]
    });
    fixture = TestBed.createComponent(OpinionAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
