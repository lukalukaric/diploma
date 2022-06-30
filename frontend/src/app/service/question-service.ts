import {lastValueFrom, Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {RestResponse} from "./rest-response";
import {Injectable} from "@angular/core";
import {Question} from "./question";

@Injectable({
  providedIn: "root"
})
export class QuestionService{

  constructor(private http: HttpClient){ }

  public validateStatement(statement: any): Observable<RestResponse> {
    return this.http.post<RestResponse>('/api/validate', statement, {
      responseType: "text" as "json",
    })
  }

  public async getRandomQuestion() :Promise<Question> {
    var tmp = this.http.get('/api/randomQuestion');
    // @ts-ignore
    return await lastValueFrom(tmp);
  }
}
