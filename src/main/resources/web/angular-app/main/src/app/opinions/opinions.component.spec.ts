import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OpinionsComponent } from './opinions.component';

describe('OpinionsComponent', () => {
  let component: OpinionsComponent;
  let fixture: ComponentFixture<OpinionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OpinionsComponent]
    });
    fixture = TestBed.createComponent(OpinionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
