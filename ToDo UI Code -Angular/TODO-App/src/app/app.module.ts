import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {HttpClient } from '@angular/common/http';


import { AppComponent } from './app.component';
import { TodoListComponent } from './components/todo-list/todo-list.component';
import { ViewTaskComponent } from './components/view-task/view-task.component';
import { ToDoServiceService } from './services/to-do-service.service';


@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    ViewTaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,    
    RouterModule.forRoot([
     { path:'todoList',
      component:TodoListComponent
     },
     { path:'viewTask',
     component:ViewTaskComponent
    }
    ])
  ],
  providers: [ToDoServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
