export class RestResponse{
  status: number;
  info: string;

  constructor(status: number, info: string) {
    this.status = status;
    this.info = info;
  }
}
