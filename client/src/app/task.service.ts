import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiURL = 'http://localhost:8080/task';

  constructor(private http: HttpClient) {}

  getAllTasks(): Observable<any> {
    // console.log(this.http.get(this.apiURL));
    return this.http.get(`${this.apiURL}/allTasks`);
  }

  updateTaskStatus(taskId: number, status: boolean): Observable<any> {
    return this.http.put(`${this.apiURL}/${taskId}`, { status });
  }
}
