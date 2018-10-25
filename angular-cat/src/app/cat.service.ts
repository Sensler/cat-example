import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cat } from './model/cat';

@Injectable({
  providedIn: 'root'
})
export class CatService {

  constructor(private http: HttpClient) { }

  getCats(){
    return this.http.get<Cat>('http://localhost:8080/cats');
  }

}
