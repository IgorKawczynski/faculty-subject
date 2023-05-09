import { Component, OnInit } from '@angular/core';
import { UsersService } from "./users.service";
import { UserResponseDTO } from "./users";


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {

  public users: UserResponseDTO[] = [];
  dataSource = this.users;

  constructor(private usersService: UsersService) { }

  ngOnInit(): void {
    this.getAllUsers();
    console.log("users: ", this.users); // getAllUsers is asynchronic so it will be empty list
  }

  public getAllUsers(): void {
    this.usersService.getAllUsers().subscribe((response: any) =>{
      console.log("Response from server: ", response);
      this.users = response;
      this.dataSource = response;
    })
  }

}
