import { Injectable } from '@angular/core';
import {Todo} from "../model/todo";
import {set} from "../model/model";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  async findAll() {
    const response = await fetch("https://jsonplaceholder.typicode.com/todos")
    const todos: Todo[] = await response.json()
    console.log("Todo's loaded", todos)
    set(model => {
      model.todos = todos
    })
  }

}
