import { Component, OnInit } from '@angular/core';
import {ItemResponseDTO} from "./items";
import {ItemsService} from "./items.service";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  private items: ItemResponseDTO[] = [];
  public x: string = "h";
  constructor(private itemsService: ItemsService) { }

  ngOnInit(): void {
    this.getAllItems();
    let x = this.itemsService.pomocy();
    console.log("items: ", this.items);
    console.log("pomocy: ", x);
    let x2 = this.pomocy();
    console.log("pomocy@: ", x2);
  }

  public getAllItems(): void {
    this.itemsService.getAllItems().subscribe((response: any) =>{
      this.items = response;
    })
  }

  public pomocy(): string {
    this.itemsService.pomocy().subscribe((response: any) =>{
      this.x = response;
    })
    return this.x;
  }

}
