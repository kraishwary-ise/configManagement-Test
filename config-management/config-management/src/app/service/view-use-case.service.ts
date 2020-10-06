import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginUser } from '../models/login-user';

@Injectable({
  providedIn: 'root'
})
export class ViewUseCaseService {

  constructor(private http:HttpClient) { 
}


getListUseCase(userEmail) {


  return this.http.post<any>("http://localhost:8080/api/dashboard",userEmail)
  



}

importUseCase(userEmail) {


  return this.http.post<any>("http://localhost:8080/api/importUseCase",userEmail)
  



}



}
