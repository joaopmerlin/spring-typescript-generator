import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Usuario} from './usuario';

@Injectable()
export class UsuarioService {

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`/user`);
  }

  public findOne(id: number): Observable<Usuario> {
    return this.http.get<Usuario>(`/user/${id}`);
  }

  public delete(id: number): Observable<void> {
    return this.http.delete<void>(`/user/${id}`);
  }

  public save(arg0: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`/user`, arg0);
  }

}
