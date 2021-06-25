import { Injectable } from '@angular/core';
import {User} from './user.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {API_URL} from '../constants/app.constants';
import {log} from 'util';
import {catchError, tap} from 'rxjs/operators';
import {handleError} from '../errorHandler';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  currentUser: User | null;

  private userUrl = API_URL + '/api/user';

  constructor(private http: HttpClient) { }

  getCurrentUser(): Observable<User>{
    return this.http.get<User>(this.userUrl)
      .pipe(
        tap( res => console.log(res)),
        catchError(handleError('getCurrentUser'))
      );
  }

  isRole(role: string): boolean{
    if(this.currentUser)
      return this.currentUser.authorities.some( authority => authority === role);
    return false;
  }
}
