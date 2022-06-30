import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponent} from "./landing-page/landing-page.component";
import {QuestionPageComponent} from "./question-page/question-page.component";

const routes: Routes = [
  { path: 'home', component: LandingPageComponent } ,
  { path: 'randomQuestion', component: QuestionPageComponent } ,
  { path: 'countQuestion', component: QuestionPageComponent } ,
  { path: '', redirectTo: '/home',  pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
