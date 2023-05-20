import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UsersComponent } from "./users/users.component";
import { ItemsComponent } from "./items/items.component";
import {ItemAddFormComponent} from "./item-add-form/item-add-form.component";
import {UserAddFormComponent} from "./user-add-form/user-add-form.component";


const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full' },
  { path: 'users', component: UsersComponent },
  { path: 'items', component: ItemsComponent },
  { path: 'users/register', component: UserAddFormComponent },
  { path: 'items/new', component: ItemAddFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
