import {Grupo} from '../grupo/grupo';

export class Usuario {

  id: number;
  email: string;
  cadastro: Date;
  ativo: boolean;
  grupo: Grupo;

}
