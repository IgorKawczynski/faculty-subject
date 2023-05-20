import { Component } from '@angular/core';
import { UserRequestDTO } from '../dtos/user-request-dto';
import { MessageService, PrimeNGConfig } from "primeng/api";
import { Router } from "@angular/router";
import { UserAddFormService } from "./user-add-form.service";

@Component({
  selector: 'app-user-add-form',
  templateUrl: './user-add-form.component.html',
  styleUrls: ['./user-add-form.component.css']
})
export class UserAddFormComponent {

  userRequestDto: UserRequestDTO = new UserRequestDTO();

  constructor(
    private registerService: UserAddFormService,
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private messageService: MessageService){
  }

  ngOnInit(): void {

  }

  btnRegister(): void {
    this.registerUser();
  }

  public registerUser() {
    this.registerService
      .registerUser(this.userRequestDto).subscribe(
      (response: any) => {
        this.messageService.add({
          life: 3000,
          severity: 'success',
          summary: 'Register',
          detail: 'You have successfully registered in!'
        })
      },
      (error) => {
        console.log("Error :", error)
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: error?.error
        });
      });
  }
}
