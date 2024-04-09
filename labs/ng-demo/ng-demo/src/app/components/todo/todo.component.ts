import {Component, inject, OnInit} from '@angular/core';
import {StoreService} from "../../services/store.service";
import {distinctUntilChanged, map} from "rxjs";
import {Todo} from "../../model";

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent implements OnInit {
    //store = inject(StoreService).store
  protected todos!: Todo[]
  viewModel = inject(StoreService)
    .store
    .pipe(
      map(model => model.todos),
      distinctUntilChanged()
    )

  ngOnInit() {
    this.viewModel.subscribe(todos => this.todos = todos)
      // this.store.pipe(
      //   map(model => model.todos),
      //   distinctUntilChanged()
      // ).subscribe(todos => console.log("Todo-Component", todos))
  }
}
