import {Question} from "./question";

export class ModelStatementQuestion{
  statement: string;
  question: Question;

  constructor(statement: string, question: Question) {
    this.statement = statement;
    this.question = question;
  }
}
