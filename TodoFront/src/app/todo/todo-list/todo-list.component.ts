import {Component, OnInit} from '@angular/core';
import {TodoService} from '../todo.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent implements OnInit {

  todos: any[];

  cols: any[];

  constructor(private todoService: TodoService, private router: Router) {
  }

  ngOnInit() {

    this.cols = [
      {field: 'id', header: 'ID', width: '550'},
      {field: 'name', header: 'Name', width: '150'},
      {field: 'done', header: 'Done', width: '150'}
    ];

    this.getAllTodo();
  }

  getAllTodo() {
    this.todoService.getAllTodo().subscribe(list => {
      this.todos = list;
    });
  }

  changeStatus(id) {
    this.todoService.changeTodoStatus(id).subscribe(list => {
      this.todos = list;
    });
  }

  goTo(id) {
    this.router.navigate(['/details', id]);
  }
}
