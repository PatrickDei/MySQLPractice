import { Component, OnInit } from '@angular/core';
import {QuestionService} from '../services/question.service';
import {Question} from '../models/question';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {

  questions: Question[];

  constructor(private questionService: QuestionService) { }

  ngOnInit(): void {
    this.questionService.getAllQuestions()
      .subscribe(
        q => this.questions = q
      );
  }

}
