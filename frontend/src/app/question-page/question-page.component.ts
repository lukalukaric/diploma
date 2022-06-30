import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {QuestionService} from "../service/question-service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {DOCUMENT} from "@angular/common";
import {Question} from "../service/question";
import {J} from "@angular/cdk/keycodes";

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.scss']
})
export class QuestionPageComponent implements OnInit {
  validateStatement = new FormGroup({
    statement: new FormControl("")
  });
  typeOfQuestion = "";
  questionText = "";

  constructor(private snackBar: MatSnackBar, private questionService: QuestionService, @Inject(DOCUMENT) private document: Document) {
    if(this.document.location.href.endsWith("randomQuestion")){
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getRandomQuestion());
    }
    else if(this.document.location.href.endsWith("selectQuestion")){
      this.typeOfQuestion="randomQuestion";
      this.waitForQuestion(this.questionService.getSelectQuestion());
    }
  }
  async waitForQuestion(param: any) {
    this.questionText = (await param).question;
  }

  ngOnInit(): void {
  }

  validateStatementOnClick() {
    let statement = this.validateStatement.value.statement;
    this.questionService.validateStatement(statement)
      .subscribe({
        next: (v) => {
          this.snackBar.open("Correct!", "Hide", {
            duration: 3000,
          } );
          this.validateStatement.reset();
        },
        error: (e) => this.snackBar.open("Error: " + e, "Hide", {
          duration: 3000,
        } )
      });
    console.log(statement);
  }
}
