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
    this.realAnswer = this.question.answer;
  }

  ngOnInit(): void {
  }

  validateStatementOnClick() {
    let statement = this.validateStatement.value.statement;
    if (statement != null) {
      let data = new ModelStatementQuestion(statement, this.question);
      this.questionService.validateStatement(data)
        .subscribe({
          next: (v: RestResponse) => {
              this.usersAnswer = v;
              //TODO fix that shitt bruda
              console.log('all', v);
              console.log('info' , v.info);
              console.log('status' , v.status);
              console.log('data' , v.data);
              this.snackBar.open("Correct!", "Hide", {
              duration: 3000,
            } );
          },
          error: (e) => this.snackBar.open("Error: " + e, "Hide", {
            duration: 3000,
          } ),
        });
      console.log(statement);
    }

  }
}
