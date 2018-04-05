import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';

@Injectable()
export class ToDoServiceService {

  constructor(private http: HttpClient) { }

  fetchTask(url: string) {
    console.log(url);
    return this.http.get(url).catch(this.handleError);
  }

  addTask(url: string, taskName: string) {
    return this.http.post(url, taskName).catch(this.handleError);
  }

  updateTask(url: string, taskId: string) {
    return this.http.put(url, { "id": taskId }).catch(this.handleError);
  }

  deleteTask(url: string, taskId: string) {
    return this.http.delete(url + taskId).catch(this.handleError);
  }

  public handleError(error: Response) {
    console.error(error);
    return Observable.throw(error.json() || 'Server error');
  }

}
