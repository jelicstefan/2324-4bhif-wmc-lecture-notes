import {Component, inject, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {StoreService} from "./services/store.service";
import {TodoService} from "./services/todo.service";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  store = inject(StoreService).store
  todoService = inject(TodoService)

  ngOnInit() {
    this.todoService.findAll()
  }
}
