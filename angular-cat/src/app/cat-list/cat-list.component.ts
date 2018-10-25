import { Component, OnInit } from '@angular/core';
import { Cat } from '../model/cat';
import { CatService } from '../cat.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cat-list',
  templateUrl: './cat-list.component.html',
  styleUrls: ['./cat-list.component.css']
})
export class CatListComponent implements OnInit {

  private cats$: Object;

  constructor(private catService: CatService) { }

  ngOnInit() {
  	this.catService.getCats().subscribe(
  	  data => this.cats$ = data
  	);
  }

  onCatClick(cat: Cat) {
    this.catService.setSelectedCat(cat);
  }

}
