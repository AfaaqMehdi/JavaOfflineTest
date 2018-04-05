import { Component, OnInit } from '@angular/core';
import { ToDoServiceService } from './../../services/to-do-service.service';

@Component({
  selector: 'app-view-task',
  templateUrl: './view-task.component.html',
  styleUrls: ['./view-task.component.css']
})
export class ViewTaskComponent implements OnInit {

  retrieveTaskUrl = 'http://localhost:9001/api/todo/task/taskStatus';
  taskList: any = [];

  constructor(private taskService: ToDoServiceService) { }

  ngOnInit() {
    this.retrieveTask();
  }

  retrieveTask() {
    console.log('retrieveTask Clicked');
    this.taskService.fetchTask(this.retrieveTaskUrl).subscribe(data => {
      this.taskList = data;
      console.log(this.taskList);
    },
      error => {
        console.error("Error occured");
      }
    );
  }

}
