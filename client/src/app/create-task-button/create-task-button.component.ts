import { Component } from '@angular/core';
import { TaskService } from '../task.service';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-task-button',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './create-task-button.component.html',
  styleUrl: './create-task-button.component.css',
})
export class CreateTaskButtonComponent {
  showPanel: boolean = false;
  newTaskName: string = '';

  constructor(private taskService: TaskService) {}

  toggleCreateTaskPanel(): void {
    this.showPanel = !this.showPanel;
  }

  createTask(): void {
    if (this.newTaskName.trim()) {
      // Call the service to save the new task
      this.taskService.createTask(this.newTaskName).subscribe({
        next: (response) => {
          console.log('Task created:', response);
          this.newTaskName = ''; // Clear the input
          this.showPanel = false; // Close the panel
        },
        error: (err) => console.error('Error creating task:', err),
      });
    } else {
      alert('Task name cannot be empty');
    }
  }
}
