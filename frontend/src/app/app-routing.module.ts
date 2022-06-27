import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LandingPageComponentComponent} from "./landing-page-component/landing-page-component.component";
import {FooterComponentComponent} from "./footer-component/footer-component.component";

const routes: Routes = [
  { path: 'home', component: LandingPageComponentComponent } ,
  { path: 'try', component: FooterComponentComponent } ,
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
