import { Component, OnInit } from '@angular/core';
import { UsersService } from "./users.service";
import { UserResponseDTO } from "./users";
import {Router} from "@angular/router";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {

  public users: UserResponseDTO[] = [];
  constructor(private usersService: UsersService, private router: Router) { }

  ngOnInit(): void {
    this.getAllUsers();
    console.log("users: ", this.users); // getAllUsers is asynchronic so it will be empty list
  }

  public route(url: string) {
    this.router.navigateByUrl(url).then(() => null);
  }

  public getAllUsers(): void {
    this.usersService.getAllUsers().subscribe((response: any) =>{
      this.users = response;
    })
  }

}
