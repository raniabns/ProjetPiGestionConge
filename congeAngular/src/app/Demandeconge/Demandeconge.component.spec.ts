import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Demandeconge } from './Demandeconge.component';

describe('UserProfileComponent', () => {
  let component: Demandeconge;
  let fixture: ComponentFixture<Demandeconge>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Demandeconge ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Demandeconge);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
