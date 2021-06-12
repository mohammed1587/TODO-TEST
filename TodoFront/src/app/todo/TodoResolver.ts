import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot} from '@angular/router';
import {TODO} from './TODO';
import {TodoService} from './todo.service';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TodoResolverService implements Resolve<TODO> {

  constructor(private todoService: TodoService, private router: Router) {
  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<TODO> | Promise<TODO> | TODO {
    return this.todoService.getTodoDetails(Number(route.paramMap.get('id'))).pipe(
      map(data => {
        if (!data) {
          this.router.navigate(['pageNotFound']);
        }
        return data;
      }));
  }
}
