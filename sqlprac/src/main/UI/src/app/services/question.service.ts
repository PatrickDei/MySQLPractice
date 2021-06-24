import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Question} from '../models/question';
import {catchError, tap} from 'rxjs/operators';
import {log} from 'util';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private url = 'http://localhost:8080/question';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor(private http: HttpClient) { }

  getAllQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(this.url)
      .pipe(
          tap( () => console.log('successfully fetched questions')),
          catchError(this.handleError('getAllQuestions'))
      );
  }

  getQuestionWithId(id: string): Observable<Question>{
    return this.http.get(this.url + '/' + id)
      .pipe(
        tap( () => console.log('successfully fetched question with id = ' + id)),
        catchError(this.handleError('getQuestionWithId'))
      );
  }

  private handleError<T>(operation: string = 'operation', result?: T): any{
    return (error: any): Observable<T> => {
      console.error(operation);
      console.error(error);
      return of(result as T);
    };
  }
}
