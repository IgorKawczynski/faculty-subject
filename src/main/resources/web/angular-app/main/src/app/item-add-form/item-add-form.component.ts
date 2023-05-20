import { Component } from '@angular/core';
import {MessageService, PrimeNGConfig} from "primeng/api";
import {Router} from "@angular/router";
import {ItemRequestDTO} from "../dtos/item-request-dto";
import {ItemAddFormService} from "./item-add-form.service";

@Component({
  selector: 'app-item-add-form',
  templateUrl: './item-add-form.component.html',
  styleUrls: ['./item-add-form.component.css']
})
export class ItemAddFormComponent {

  itemRequestDto: ItemRequestDTO = new ItemRequestDTO();

  constructor(
    private itemAddFormService: ItemAddFormService,
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private messageService: MessageService){
  }

  ngOnInit(): void {

  }

  btnAddItem(): void {
    this.addItem();
  }

  public addItem() {
    this.itemAddFormService
      .addItem(this.itemRequestDto).subscribe(
      (response: any) => {
        this.messageService.add({
          life: 3000,
          severity: 'success',
          summary: 'Item added',
          detail: 'You have successfully added an item!'
        })
      },
      (error) => {
        this.messageService.add({
          severity: 'error',
          summary: 'Error',
          detail: error?.error
        });
      });
  }

}
