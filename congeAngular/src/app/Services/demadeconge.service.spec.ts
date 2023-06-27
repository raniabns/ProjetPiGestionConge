import { TestBed } from '@angular/core/testing';

import { DemadecongeService } from './demadeconge.service';

describe('DemadecongeService', () => {
  let service: DemadecongeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DemadecongeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
