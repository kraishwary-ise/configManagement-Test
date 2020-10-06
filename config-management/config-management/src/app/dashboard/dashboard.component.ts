import { Component, Input, OnInit } from '@angular/core';
import { ViewUseCaseService } from '../service/view-use-case.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html'
})
export class DashboardComponent implements OnInit {


  listUseCase=[]


  constructor(private viewUseCase:ViewUseCaseService) { 

    this.viewUseCase.getListUseCase(sessionStorage.getItem('authenticateUser')).subscribe(response=> {

      this.listUseCase=response;

      console.log(response)

    },error=> {

      console.log(error);

      

    }) 

  }

  ngOnInit() {
  }

}
