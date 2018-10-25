import { Component, OnInit } from '@angular/core';
import { Cat } from '../model/cat';
import { CatService } from '../cat.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cat-form',
  templateUrl: './cat-form.component.html',
  styleUrls: ['./cat-form.component.css']
})
export class CatFormComponent implements OnInit {

  constructor(private catService: CatService) { }

  private selected$: Cat = {};
  private model: Cat = {};

  ngOnInit() {
    this.catService.getSelectedCatSource().subscribe(
      selectedCat => {
        this.selected$ = selectedCat;
        this.model = Object.assign({}, selectedCat);
      }
    );
  }

  save(){
    this.selected$.name = this.model.name;
    this.selected$.color = this.model.color;
    this.catService.updateCat(this.model).subscribe(
      data => {console.log("Success")},
      error => {alert("error" + error);
       console.log(error)}
    );
  }

}
