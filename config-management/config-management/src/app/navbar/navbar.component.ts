import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  email:string;

  constructor(private loginService:LoginService) {

    this.email=sessionStorage.getItem('authenticateUser');

   }

  ngOnInit() {
  }

}
