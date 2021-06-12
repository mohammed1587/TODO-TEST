import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TODO} from './TODO';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAllTodo(): Observable<TODO[]> {
    return this.httpClient.get<TODO[]>(environment.APIUrl + '/getAllTodo');
  }

  getTodoDetails(id: number): Observable<TODO> {
    return this.httpClient.get<TODO>(environment.APIUrl + '/getTodoDetails/' + id);
  }

  changeTodoStatus(id: number): Observable<TODO[]> {
    return this.httpClient.get<TODO[]>(environment.APIUrl + '/changeTodoStatus/' + id);
  }

  newTodo(todo: TODO): Observable<TODO> {
    return this.httpClient.post<TODO>(environment.APIUrl + '/newTodo', todo);
  }
}
