import {Component, OnInit} from '@angular/core';
import {ConfirmationService} from "primeng/api";
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

  constructor(private usuarioService: UsuarioService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.getUsers();
  }

  delete(id: number) {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      accept: () => {
        this.usuarioService.delete(id).subscribe(e => {
          this.getUsers();
        });
      }
    });
  }

  save(arg0: Usuario) {
    this.usuarioService.save(arg0).subscribe(e => {
      this.getUsers();
      this.showModal = false;
    });
  }

  getUser(id: number, teste: number) {
    this.usuarioService.getUser(id, teste).subscribe(e => {
    });
  }

  getEmpresa(id: number) {
    this.usuarioService.getEmpresa(id).subscribe(e => {
    });
  }

  getUsers() {
    this.usuarioService.getUsers().subscribe(e => {
      this.listUsuario = e;
    });
  }

  new() {
    this.selectedUsuario = new Usuario();
    this.showModal = true;
  }

  edit(usuario: Usuario) {
    this.selectedUsuario = JSON.parse(JSON.stringify(usuario));
    this.showModal = true;
  }
}
