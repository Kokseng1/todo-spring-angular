import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private apiURL = 'http://localhost:8080/task/allTasks';

  constructor(private http: HttpClient) {}

  getAllTasks(): Observable<any> {
    // console.log(this.http.get(this.apiURL));
    return this.http.get(this.apiURL);
    const hardcodedTasks = [
      {
        id: 1,
        name: 'Task 1',
        description: 'This is a hardcoded task description',
        completed: false,
      },
      {
        id: 2,
        name: 'Task 2',
        description: 'Another hardcoded task description',
        completed: true,
      },
    ];

    // Return the hardcoded tasks wrapped in an Observable using 'of'
    // return of(hardcodedTasks);
  }
}
