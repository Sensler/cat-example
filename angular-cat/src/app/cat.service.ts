import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cat } from './model/cat';
import { BehaviorSubject  } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CatService {

  private selectedCatSource = new BehaviorSubject({});

  constructor(private http: HttpClient) { }

  getCats(){
    return this.http.get<Cat>('http://localhost:8080/cats');
  }

  setSelectedCat(cat: Cat) {
    this.selectedCatSource.next(cat);
  }

  getSelectedCatSource(){
    return this.selectedCatSource;
  }

  updateCat(cat: Cat){
    return this.http.put('http://localhost:8080/cats/'+ cat.id, cat);
  }

}
