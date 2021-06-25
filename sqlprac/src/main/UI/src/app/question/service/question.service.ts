import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {Question} from '../../models/question';
import {catchError, tap} from 'rxjs/operators';
import {log} from 'util';
import {handleError} from '../../errorHandler';
import {API_URL} from '../../constants/app.constants';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private url = API_URL + '/question';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type' : 'application/json'})
  };

  constructor(private http: HttpClient) { }

  getAllQuestions(): Observable<Question[]>{
    return this.http.get<Question[]>(this.url)
      .pipe(
          tap( () => console.log('successfully fetched questions')),
          catchError(handleError('getAllQuestions'))
      );
  }

  getQuestionWithId(id: string): Observable<Question>{
    return this.http.get(this.url + '/' + id)
      .pipe(
        tap( () => console.log('successfully fetched question with id = ' + id)),
        catchError(handleError('getQuestionWithId'))
      );
  }
}
