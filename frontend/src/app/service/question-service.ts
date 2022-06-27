import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {RestResponse} from "./rest-response";
import {Injectable} from "@angular/core";

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
}
