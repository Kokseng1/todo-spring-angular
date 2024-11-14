import { Component } from '@angular/core';
import { TaskService } from '../task.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [HttpClientModule, CommonModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css',
})
export class TaskListComponent {
  tasks: any[] = [];

  constructor(private taskServuce: TaskService) {}

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {
    this.taskServuce.getAllTasks().subscribe((data) => {
      this.tasks = data;
    });
  }
}
