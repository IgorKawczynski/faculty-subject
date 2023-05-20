import { Component, OnInit } from '@angular/core';
import {ItemResponseDTO} from "./items";
import {ItemsService} from "./items.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css']
})
export class ItemsComponent implements OnInit {

  public items: ItemResponseDTO[] = [];
  constructor(private itemsService: ItemsService, private router: Router) { }

  ngOnInit(): void {
    this.getAllItems();
  }

  public route(url: string) {
    this.router.navigateByUrl(url).then(() => null);
  }

  public getAllItems(): void {
    this.itemsService.getAllItems().subscribe((response: any) =>{
      this.items = response;
    })
  }

}
