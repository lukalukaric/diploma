import {ResponseModel} from "./response-model";

export class RestResponse{
  status: number;
  info: string;
  data: Array<ResponseModel>;
  answer: string;

  constructor(status: number, info: string, data: Array<ResponseModel>, answer: string) {
    this.status = status;
    this.info = info;
    this.data = data;
    this.answer = answer;
  }
}
