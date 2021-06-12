import {Component, OnInit} from '@angular/core';
import {TODO} from '../TODO';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-todo-details',
  templateUrl: './todo-details.component.html',
  styleUrls: ['./todo-details.component.css']
})
export class TodoDetailsComponent implements OnInit {

  todo: TODO;

  constructor(private route: ActivatedRoute,
  ) {
  }

  ngOnInit() {
    this.route.data.subscribe((data: { todo: TODO }) => {
      this.todo = data.todo;


    });
  }

  translate(done: boolean) {
    return done ? 'Done' : 'Not Done';
  }
}
