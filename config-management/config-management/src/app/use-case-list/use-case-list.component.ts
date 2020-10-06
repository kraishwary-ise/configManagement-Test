import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExportImportService } from '../service/export-import.service';
import { UsecaseService } from '../service/usecase.service';
declare var $: any;


@Component({
  selector: 'app-use-case-list',
  templateUrl: './use-case-list.component.html',
  styleUrls: ['./use-case-list.component.css']
})
export class UseCaseListComponent implements OnInit {


  SelectedUseCaseName;

  @Input() listUseCase

  msg:string;
  msgExist=false;


  constructor(private exportImport:ExportImportService,private useCaseService: UsecaseService,private router:Router ) { }

  ngOnInit() {
  }







eachUseCase(event:any,res:any) {


  console.log(res);

  this.exportImport.eachUseCase(res).subscribe(response=> {
    this.msg="UseCase " + res.name +   " has been Exported Successfully"
    this.msgExist=true;
    $('.alert').show()

    
  },error=> {
    this.msg="Some error has occured while Exporting " + res.name;
    this.msgExist=true;
  })

}

deleteUseCase(event:any,res:any) {

  this.useCaseService.deleteUseCase(res).subscribe(response=> {
    this.msg="Use Case " + res.name + " has deleted Sucessfully"
    this.msgExist=true;
    $('.alert').show()


  },error=> {
    this.msg="Some error has occured while deleting the UseCase " + res.name;
    this.msgExist=true;
  })
 
  this.exportImport.deleteExportUseCase(res).subscribe(response=> {
    this.msg="Use Case " + res.name +" has deleted Sucessfully"
    this.msgExist=true;
    $('.alert').show()


  },error=> {
    this.msg="Some error has occured while deleting the UseCase " + res.name;
    this.msgExist=true;
  })


}

closeAlert() {

  $('.alert').hide()


}

openTrigger(event:any,res:any) {

  this.router.navigate(['/trigger',res.name]);
  
}


}


