import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {QuestionService} from "../service/question-service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {DOCUMENT} from "@angular/common";
import {Question} from "../service/question";
import {ModelStatementQuestion} from "../service/model-statement-question";
import {RestResponse} from "../service/rest-response";

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.scss']
})
export class QuestionPageComponent implements OnInit {
  validateStatement = new FormGroup({
    statement: new FormControl(""),
  });
  typeOfQuestion = "";
  question: Question= new Question("","","", "", "");
  questionText = "";
  realAnswer: any;
  usersAnswer: any;
  showAnswers = false;
  correctIcon = false;
  wrongIcon = false;

  constructor(private snackBar: MatSnackBar, private questionService: QuestionService, @Inject(DOCUMENT) private document: Document) {
    if(this.document.location.href.endsWith("selectQuestion")){
      this.typeOfQuestion="selectQuestion";
      this.waitForQuestion(this.questionService.getSelectQuestion());
    }
    else if(this.document.location.href.endsWith("aggregateQuestion")){
      this.typeOfQuestion="aggregateQuestion";
      this.waitForQuestion(this.questionService.getAggregateQuestion());
    }
    else if(this.document.location.href.endsWith("groupByQuestion")){
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getGroupByQuestion());
    }
    else if(this.document.location.href.endsWith("orderByQuestion")){
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getOrderByQuestion());
    }
    else if(this.document.location.href.endsWith("havingQuestion")){
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getHavingQuestion());
    }
    else{
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getRandomQuestion());
    }
  }
  async waitForQuestion(param: any) {
    this.question = await param;
    this.questionText = (await param).question;
  }

  ngOnInit(): void {
  }

  fillFields(restResponse : RestResponse){
    if(restResponse.status === 200){
      this.correctIcon = true;
      this.wrongIcon = false;
      this.snackBar.open("Pravilno! :)", "Skrij", {
        duration: 3000,
      } );
    }
    else{
      this.correctIcon = false;
      this.wrongIcon = true;
      this.snackBar.open("Ne pravilno :( Poizkusi ponovno.", "Skrij", {
        duration: 3000,
      } );
    }
    this.usersAnswer = "";

    restResponse.data.forEach(value => {
      this.usersAnswer += value.text + " ";
    });

    this.realAnswer = restResponse.answer;
  }

  validateStatementOnClick() {
    let statement = this.validateStatement.value.statement;
    if (statement != null) {
      let data = new ModelStatementQuestion(statement, this.question);
      this.questionService.validateStatement(data)
        .subscribe({
          next: v => {
            // @ts-ignore
            let response = JSON.parse(v);
            console.log('all', response);
            console.log('status' ,response.status);
            console.log('info' ,response.info);
            console.log('data' ,response.data);
            console.log('answer', response.answer);
            this.fillFields(response);
          },
          error: (e) => this.snackBar.open("Error: " + e, "Hide", {
            duration: 3000,
          } ),
        });
      console.log(statement);
    }
    this.showAnswers = true;
  }
}
