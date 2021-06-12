import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TodoListComponent} from './todo-list/todo-list.component';
import {TodoDetailsComponent} from './todo-details/todo-details.component';
import {TodoResolverService} from './TodoResolver';
import {NewTodoComponent} from './new-todo/new-todo.component';


const routes: Routes = [
  {path: '', component: TodoListComponent},
  {
    path: 'details/:id', component: TodoDetailsComponent,
    resolve: {
      todo: TodoResolverService
    },
  },
  {path: 'newTodo', component: NewTodoComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TodoRoutingModule {
}
