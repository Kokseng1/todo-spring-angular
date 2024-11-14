import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiURL = 'http://localhost:8080/task/allTasks';
  
  constructor(private http: HttpClient) {}

  getAllTasks() : Observable<any> {
    return this.http.get(this.apiURL)
  }
}
