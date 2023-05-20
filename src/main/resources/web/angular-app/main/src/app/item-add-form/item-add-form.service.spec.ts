import { TestBed } from '@angular/core/testing';

import { ItemAddFormService } from './item-add-form.service';

describe('ItemAddFormService', () => {
  let service: ItemAddFormService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemAddFormService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
