import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import {AuthGuard} from './auth/auth.guard';
import { ViewusecaseComponent } from './viewusecase/viewusecase.component';
import { AddusecaseComponent } from './addusecase/addusecase.component';
import { ErrorComponent } from './error/error.component';
import { LogOutComponent } from './log-out/log-out.component';
import { RouteGuardService } from './service/route-guard.service';
import { TriggerComponent } from './trigger/trigger.component';
import {OffersComponent} from './offers/offers.component';



const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'dashboard', component:DashboardComponent , canActivate:[RouteGuardService]},
  {path:'usecase',component:ViewusecaseComponent,canActivate:[RouteGuardService]},
  {path:'addUseCase',component:AddusecaseComponent,canActivate:[RouteGuardService]},
  { path:'trigger/:useCaseName',component:TriggerComponent,canActivate:[RouteGuardService]},
  { path:'offers/:useCaseName',component:OffersComponent,canActivate:[RouteGuardService]},

  {path:'logout',component:LogOutComponent},
  { path:'**',component:ErrorComponent}
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
