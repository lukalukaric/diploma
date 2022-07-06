import {ResponseModel} from "./response-model";

export class RestResponse{
  status: number;
  info: string;
  data: Array<ResponseModel>;

  constructor(status: number, info: string, data: Array<ResponseModel>) {
    this.status = status;
    this.info = info;
    this.data = data;
  }
}
