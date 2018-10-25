import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CatListComponent } from './cat-list/cat-list.component';
import { CatFormComponent } from './cat-form/cat-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CatListComponent,
    CatFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
