import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NameEmail } from '../models/name-email';
import { Trigger } from '../models/trigger';
import { TriggerService } from '../service/trigger.service';

declare var $:any;



@Component({
  selector: 'app-trigger',
  templateUrl: './trigger.component.html',
  styleUrls: ['./trigger.component.css']
})
export class TriggerComponent implements OnInit {


  nameEmail=[];

  trigger = [];

  triggerSelected=[];
  name;
  email;
  msg;
  msgExist=false;

  triggerForm=new Trigger();

  constructor(private router:Router,private triggerService:TriggerService,private route:ActivatedRoute) { 

    this.triggerService.getTrigger().subscribe(response=> {

      this.trigger=response;

      console.log(this.trigger);

    },error=> {
      console.log(error)
    })

 this.route.paramMap.subscribe(params=> {

     this.name=params.get('useCaseName');

      })

      this.email=sessionStorage.getItem('authenticateUser');


  }

  drop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
                        event.container.data,
                        event.previousIndex,
                        event.currentIndex);
    }
  }


  ngOnInit() {


    



  }


  save() {


    if(this.triggerSelected.length==0) {
      this.msg="please select at least one trigger library";
      this.msgExist=true;
      $('.alert').show();

    }

    else {

    this.nameEmail=[];
    for(let i=0;i<this.triggerSelected.length;i++) {



      this.nameEmail.push(new NameEmail(this.name,this.email,this.triggerSelected[i].name));


  }
  this.triggerService.saveTrigger(this.nameEmail).subscribe(response=> {

    console.log(response)
    this.msg="save successfully";
    this.msgExist=true;
    $('.alert').show();


  },error=> {

    this.msg="some error occured";
    this.msgExist=true;
    $('.alert').show();

    
  })
  }


  }


  openOffers() {

    this.router.navigate(['/offers',this.name]);

  }


  closeAlert() {

    $('.alert').hide()
  
  
  }
  
}
