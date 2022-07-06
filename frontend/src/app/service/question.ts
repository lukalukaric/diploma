export class Question{
  id: string;
  question: string;
  answer: string;
  type: string

  constructor(id: string, question: string, answer: string, type:string) {
    this.id = id;
    this.question = question;
    this.answer = answer;
    this.type = type;
  }
}
