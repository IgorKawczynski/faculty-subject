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


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    ItemsComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        RouterModule,
        BrowserAnimationsModule,
        ButtonModule,
        TableModule

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
