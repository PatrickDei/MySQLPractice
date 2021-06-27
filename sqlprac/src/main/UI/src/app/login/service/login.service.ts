import { Injectable } from '@angular/core';
import {API_URL} from '../../constants/app.constants';
import {HttpClient} from '@angular/common/http';
import {Credentials} from '../credentials.model';
import {Observable} from 'rxjs';
import {JwtToken} from '../jwt-token.model';
import {catchError, tap} from 'rxjs/operators';
import {handleError} from '../../errorHandler';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private url = API_URL + '/api/authenticate';

  constructor(private http: HttpClient) { }

  authenticate(userCredentials: Credentials): Observable<JwtToken>{
    return this.http.post<JwtToken>(this.url, userCredentials)
      .pipe(
        tap( res => console.log(res)),
        catchError(handleError('authenticate'))
      );
  }

  logout(): void{
    localStorage.removeItem('token');
  }
}
