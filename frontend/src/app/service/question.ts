export class Question{
  id: string;
  question: string;
  correctStatement: string;
  type: string;
  answer: string;

  constructor(id: string, question: string, correctStatement: string, type:string, answer: string) {
    this.id = id;
    this.question = question;
    this.correctStatement = correctStatement;
    this.type = type;
    this.answer = answer;
  }
}
