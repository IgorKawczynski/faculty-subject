import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserAddFormComponent } from './user-add-form.component';

describe('UserAddFormComponent', () => {
  let component: UserAddFormComponent;
  let fixture: ComponentFixture<UserAddFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserAddFormComponent]
    });
    fixture = TestBed.createComponent(UserAddFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
