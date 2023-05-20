import {NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './users/users.component';
import { ItemsComponent } from './items/items.component';
import { HttpClientModule } from "@angular/common/http";
import { ButtonModule } from "primeng/button"
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TableModule } from 'primeng/table';
import { UserAddFormComponent } from './user-add-form/user-add-form.component';
import { ItemAddFormComponent } from './item-add-form/item-add-form.component';
import { MessageService } from "primeng/api";
import { InputTextModule } from 'primeng/inputtext';
import { CheckboxModule } from 'primeng/checkbox';
import { RadioButtonModule } from 'primeng/radiobutton';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { ToastModule } from "primeng/toast";


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ItemsComponent,
    UserAddFormComponent,
    ItemAddFormComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        RouterModule,
        BrowserAnimationsModule,
        ButtonModule,
        TableModule,
        InputTextModule,
        CheckboxModule,
        RadioButtonModule,
        FormsModule,
        ToastModule,
        ReactiveFormsModule
    ],
  providers: [MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
