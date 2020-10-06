import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http'
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AuthGuard } from './auth/auth.guard';
import { ViewusecaseComponent } from './viewusecase/viewusecase.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AddusecaseComponent } from './addusecase/addusecase.component';
import { ErrorComponent } from './error/error.component';
import { LogOutComponent } from './log-out/log-out.component';
import { UseCaseListComponent } from './use-case-list/use-case-list.component';
import { TriggerComponent } from './trigger/trigger.component';
import { SegmentComponent } from './segment/segment.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DragDropModule} from '@angular/cdk/drag-drop';
import { OffersComponent } from './offers/offers.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    ViewusecaseComponent,
    NavbarComponent,
    AddusecaseComponent,
    ErrorComponent,
    LogOutComponent,
    UseCaseListComponent,
    TriggerComponent,
    SegmentComponent,
    OffersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserModule,
    BrowserAnimationsModule,
    DragDropModule

  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
