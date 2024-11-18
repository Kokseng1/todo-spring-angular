import { Component } from '@angular/core';
import { TaskService } from '../task.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { LogoutButtonComponent } from '../logout-button/logout-button.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [HttpClientModule, CommonModule, LogoutButtonComponent, FormsModule],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css',
})
export class TaskListComponent {
  tasks: any[] = [];
  isLoading: boolean = true;

  constructor(private taskService: TaskService) {}

  ngOnInit(): void {
    this.getTasks();
  }

  getTasks(): void {
    this.taskService.getAllTasks().subscribe((data) => {
      this.tasks = data;
      this.isLoading = false;
    });
  }

  toggleTaskStatus(task: any): void {
    this.taskService
      .updateTaskStatus(task.id, task.status)
      .subscribe((data) => {});
  }

  delete(task: any): void {
    this.taskService.deleteTask(task.id).subscribe((data) => {});
  }
}
