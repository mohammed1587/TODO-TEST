import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TodoService} from '../todo.service';
import {Router} from '@angular/router';
import {TODO} from '../TODO';

@Component({
  selector: 'app-new-todo',
  templateUrl: './new-todo.component.html',
  styleUrls: ['./new-todo.component.css']
})
export class NewTodoComponent implements OnInit {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private todoService: TodoService,
              private router: Router,
  ) {
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.formGroup = this.formBuilder.group({
      name: ['', Validators.required],
      description: [''],
    });
  }

  submit() {
    const formValue = this.formGroup.value;
    const todo = new TODO();
    Object.assign(todo, formValue);
    todo.done = false;

    this.todoService.newTodo(todo).subscribe(() => {
      this.router.navigate(['/allTodo']);
    });
  }

  get formGroupControl() {
    return this.formGroup.controls;
  }
}
