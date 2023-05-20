import { TestBed } from '@angular/core/testing';

import { UserAddFormService } from './user-add-form.service';

describe('UserAddFormService', () => {
  let service: UserAddFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserAddFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
