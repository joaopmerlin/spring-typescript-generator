import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Grupo} from './grupo';

@Injectable()
export class GrupoService {

  constructor(private http: HttpClient) {
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`/grupo/${id}`);
  }

  public save(arg0: Grupo): Observable<Grupo> {
    return this.http.post<Grupo>(`/grupo`, arg0);
  }

  public findAll(): Observable<Grupo[]> {
    return this.http.get<Grupo[]>(`/grupo`);
  }

  public findOne(id: number): Observable<Grupo> {
    return this.http.get<Grupo>(`/grupo/${id}`);
  }

}
