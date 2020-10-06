import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewUseCaseService } from '../service/view-use-case.service';
declare var $: any;

@Component({
  selector: 'app-viewusecase',
  templateUrl: './viewusecase.component.html',
  styleUrls: ['./viewusecase.component.css']
})
export class ViewusecaseComponent implements OnInit {

  hiddenelement=true;

  listUseCase=[];

  email;

  msg;

  msgExist=false;


  constructor(private viewUseCase:ViewUseCaseService,private router:Router) {



    this.viewUseCase.getListUseCase(sessionStorage.getItem('authenticateUser')).subscribe(response=> {

      this.listUseCase=response;

      console.log(response)

    },error=> {

      console.log(error);

      

    }) 

    
    
  }

  ngOnInit() {
  }
  
  listOrAddUseCase() {

    this.router.navigate(['/addUseCase'])
    


  }

  importUseCase() {

    this.email=sessionStorage.getItem('authenticateUser');


    this.viewUseCase.importUseCase(this.email).subscribe(response=> {

      this.msg="UseCases Imported Sucessfully. please reload the page to see all imported UseCases";
      this.msgExist=true;
      $('.alert').show()

    }, error=> {
      this.msg="Some Errror Occured"
      this.msgExist=true;
      $('.alert').show()
    })

    


  }

  closeAlert() {

    $('.alert').hide()
  
  
  }
  

}



