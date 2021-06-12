import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TodoRoutingModule } from './todo-routing.module';
import { TodoListComponent } from './todo-list/todo-list.component';
import { TodoDetailsComponent } from './todo-details/todo-details.component';
import { NewTodoComponent } from './new-todo/new-todo.component';
import {TableModule} from 'primeng/table';
import {ButtonModule, CardModule, CheckboxModule} from 'primeng';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


@NgModule({
  declarations: [TodoListComponent, TodoDetailsComponent, NewTodoComponent],
  exports: [
    TodoListComponent
  ],
  imports: [
    CommonModule,
    TodoRoutingModule,
    TableModule,
    CheckboxModule,
    ButtonModule,
    FormsModule,
    CardModule,
    ReactiveFormsModule,
  ]
})
export class TodoModule { }
