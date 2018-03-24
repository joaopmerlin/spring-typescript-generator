import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Usuario} from './usuario';
import {Empresa} from '../empresa/empresa';

@Injectable()
export class UsuarioService {

  constructor(private http: HttpClient) {
  }

  public save(arg0: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`/user`, arg0);
  }

  public getUsers(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(`/user`);
  }

  public getEmpresa(id: number): Observable<Empresa> {
    return this.http.get<Empresa>(`/user/empresa?id=${id}`);
  }

  public getUser(id: number, teste: number): Observable<Usuario> {
    return this.http.get<Usuario>(`/user/${id}?teste=${teste}`);
  }

}
