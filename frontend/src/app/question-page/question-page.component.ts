import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {QuestionService} from "../service/question-service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-question-page',
  templateUrl: './question-page.component.html',
  styleUrls: ['./question-page.component.scss']
})
export class QuestionPageComponent implements OnInit {
  validateStatement = new FormGroup({
    statement: new FormControl("")
  });

  constructor(private snackBar: MatSnackBar, private questionService: QuestionService) { }

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
