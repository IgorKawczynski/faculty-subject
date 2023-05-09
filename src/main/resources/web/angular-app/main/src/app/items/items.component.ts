import { Component, OnInit } from '@angular/core';
import {ItemResponseDTO} from "./items";
import {ItemsService} from "./items.service";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  public items: ItemResponseDTO[] = [];
  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.getAllItems();
  }

  public getAllItems(): void {
    this.itemsService.getAllItems().subscribe((response: any) =>{
      this.items = response;
    })
  }

}
