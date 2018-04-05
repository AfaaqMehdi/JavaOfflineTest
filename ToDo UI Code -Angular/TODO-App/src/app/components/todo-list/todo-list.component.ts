import { Component, OnInit } from '@angular/core';
import { ToDoServiceService } from './../../services/to-do-service.service';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {
  taskName: any;
  taskList: any = [];

  addTaskUrl = 'http://localhost:9001/api/todo/add/';
  deleteTaskUrl = 'http://localhost:9001/api/todo/deleteTask/';
  updateTaskUrl = 'http://localhost:9001/api/todo/updateTask/task';

  constructor(private taskService: ToDoServiceService) {

  }

  ngOnInit() {
  }

  addTask() {
    console.log('add Clicked');
    console.log(this.taskName);
    this.taskService.addTask(this.addTaskUrl, this.taskName).subscribe(
      data => {
        this.taskList = data;
        console.log(this.taskList);
      },
      err => {
        console.log("Error occured");
      }
    );
  }

  updateTask(taskId: string) {
    console.log('update Clicked');
    console.log(taskId);
    this.taskService.updateTask(this.updateTaskUrl, taskId).subscribe(
      data => {
        this.taskList = data;
        console.log(this.taskList);
      },
      error => {
        console.log("Error occured");
      }
    );
  }

  deleteTask(taskId: string) {
    console.log('delete Clicked');
    console.log(taskId);
    this.taskService.deleteTask(this.deleteTaskUrl, taskId).subscribe(
      data => {
        this.taskList = data;
        console.log(this.taskList);
      },
      error => {
        console.log("Error occured");
      }
    );
  }

}
