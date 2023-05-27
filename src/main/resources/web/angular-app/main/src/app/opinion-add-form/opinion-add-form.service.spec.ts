import { TestBed } from '@angular/core/testing';

import { OpinionAddFormService } from './opinion-add-form.service';

describe('OpinionAddFormService', () => {
  let service: OpinionAddFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OpinionAddFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
