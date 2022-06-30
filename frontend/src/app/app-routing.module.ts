import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {QuestionPageComponent} from "./question-page/question-page.component";
import {Q} from "@angular/cdk/keycodes";
import {QuestionService} from "./service/question-service";

const routes: Routes = [
  { path: 'home', component: LandingPageComponent } ,
  { path: 'selectQuestion', component: QuestionPageComponent } ,
  { path: 'aggregateQuestion', component: QuestionPageComponent } ,
  { path: 'groupByQuestion', component: QuestionPageComponent } ,
  { path: 'orderByQuestion', component: QuestionPageComponent } ,
  { path: 'havingQuestion' , component: QuestionPageComponent } ,
  { path: 'randomQuestion', component: QuestionPageComponent } ,
  { path: '', redirectTo: '/home',  pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
