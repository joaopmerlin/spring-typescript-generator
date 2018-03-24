import {Component, OnInit} from '@angular/core';
import {UsuarioService} from "./usuario.service";
import {Usuario} from './usuario';
import {Empresa} from '../empresa/empresa';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  listUsuario: Usuario[];
  selectedUsuario = new Usuario();
  showModal = false;

  constructor(private usuarioService: UsuarioService) {
  }

  ngOnInit(): void {
    this.getUsers();
  }

  save(arg0: Usuario) {
    this.usuarioService.save(arg0).subscribe(e => {
      this.selectedUsuario = e;
      this.getUsers();
      this.showModal = false;
    });
  }

  getUsers() {
    this.usuarioService.getUsers().subscribe(e => {
      this.listUsuario = e;
    });
  }

  getEmpresa(id: number) {
    this.usuarioService.getEmpresa(id).subscribe(e => {
    });
  }

  getUser(id: number, teste: number) {
    this.usuarioService.getUser(id, teste).subscribe(e => {
    });
  }


}
