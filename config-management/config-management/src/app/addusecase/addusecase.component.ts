import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UseCase } from '../models/use-case';
import { UsecaseService } from '../service/usecase.service';
declare var $: any;


@Component({
  selector: 'app-addusecase',
  templateUrl: './addusecase.component.html',
  styleUrls: ['./addusecase.component.css']
})
export class AddusecaseComponent implements OnInit {

  useCase = new UseCase()

  clickOnSave=false;

  msg:string;
  msgExist=false;

  constructor(private router:Router,private useCaseService:UsecaseService) { }

  ngOnInit() {
  }




  UseCaseSubmit() {

    this.useCase.userEmail=sessionStorage.getItem("authenticateUser");

    if(!this.useCase.name&&!this.useCase.desc) {

      this.msg="Name and Description required";
      this.msgExist=true;
      $('.alert').show()


    }

    else if(!this.useCase.name) {

      this.msg="name is required";
      this.msgExist=true;
      $('.alert').show()


    }

    else if(!this.useCase.desc) {

      this.msg="description is required";
      this.msgExist=true;
      $('.alert').show()


    }

    else {

    this.useCaseService.UseCaseSubmit(this.useCase).subscribe((response)=> {
      this.msg=response.response;
      this.msgExist=true;
      $('.alert').show()


      if(response.response==="Use Case Submit Sucessfully") {
        
        this.clickOnSave=true;



      }

    },(error)=> {

      this.msg="some error exist";
      this.msgExist=true;
      $('.alert').show()

    })
  }
  }
  cancelForm() {

    this.useCase.name="";
    this.useCase.desc="";
    this.useCase.sdate="";
    this.useCase.edate="";
    this.useCase.direction="";
    this.useCase.campeing="";
    this.useCase.businesslog="";


  }

  moveToTrigger() {

    if(!this.useCase.name&&!this.useCase.desc) {

      this.msg="Name and Description required";
      this.msgExist=true;
      $('.alert').show()



     
    }

    else if(!this.useCase.name) {

      this.msg="name is required";
      this.msgExist=true;
      $('.alert').show()



    }

    else if(!this.useCase.desc) {

      this.msg="description is required";
      this.msgExist=true;
      $('.alert').show()


    }

    else {

      if(this.clickOnSave) {


    this.router.navigate(['/trigger',this.useCase.name]);
    }
    else { 

      this.useCase.userEmail=sessionStorage.getItem("authenticateUser");

      
      this.useCaseService.UseCaseSubmit(this.useCase).subscribe((response)=> {
        this.msg=response.response;
        this.msgExist=true;
        $('.alert').show()

  

      if(response.response==="Use Case Submit Sucessfully") {

      this.router.navigate(['/trigger',this.useCase.name]);
      }
      



    },(error)=> {

      this.msg="Some error exist";
      this.msgExist=true;
      $('.alert').show()



    })




    
    
    }
    }
  }
  closeAlert() {

    $('.alert').hide()
  
  
  }
  

}
