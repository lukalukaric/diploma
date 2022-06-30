export class Question{
  id: number;
  question: string;
  answer: string;
  type: string

  constructor(id: number, question: string, answer: string, type:string) {
    this.id = id;
    this.question = question;
    this.answer = answer;
    this.type = type;
  }
}
