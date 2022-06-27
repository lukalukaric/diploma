import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button";
import { LandingPageComponent } from './landing-page/landing-page.component';
import { QuestionPageComponent } from './question-page/question-page.component';
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import {QuestionService} from "./service/question-service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LandingPageComponent,
    QuestionPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [QuestionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
