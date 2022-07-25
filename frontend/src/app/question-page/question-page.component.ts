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
  question: Question= new Question("","","", "");
  questionText = "";
  realAnswer: any;
  usersAnswer: any;

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
    if(this.question.type === "aggregate"){
      this.realAnswer = "Pravilna rešitev je: " + this.question.answer;
    }
    else{
      this.realAnswer = "Pravilna rešitev je ID: " + this.question.answer;
    }

  }

  ngOnInit(): void {
  }

  fillFields(restResponse : RestResponse){
    if(restResponse.status === 200){
      this.snackBar.open("Pravilno! :)", "Skrij", {
        duration: 3000,
      } );
    }
    else{
      this.snackBar.open("Ne pravilno :( Poizkusi ponovno.", "Skrij", {
        duration: 3000,
      } );
    }
    this.usersAnswer = "";
    if(this.question.type === "aggregate"){
      // @ts-ignore
      this.usersAnswer = restResponse.data.pop().text;
    }
    else{
      restResponse.data.forEach(value => {
        this.usersAnswer += value.name + " ";
      });
      this.usersAnswer += "\n";
      restResponse.data.forEach(value => {
        this.usersAnswer += value.text + " ";
      });
    }


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
            this.fillFields(response);
          },
          error: (e) => this.snackBar.open("Error: " + e, "Hide", {
            duration: 3000,
          } ),
        });
      console.log(statement);
    }
  }
}
