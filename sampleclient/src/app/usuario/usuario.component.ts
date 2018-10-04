import {Component, OnInit} from '@angular/core';
import {ConfirmationService} from 'primeng/api';
import {UsuarioService} from './usuario.service';
import {Usuario} from './usuario';
import {Grupo} from "../grupo/grupo";
import {GrupoService} from "../grupo/grupo.service";

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  listUsuario: Usuario[];
  selectedUsuario = new Usuario();
  showModal = false;
  grupoOptions: Grupo[] = [];

  constructor(private usuarioService: UsuarioService, private grupoService: GrupoService, private confirmationService: ConfirmationService) {
    this.grupoService.findAll().subscribe(e => this.grupoOptions = e);
  }

  ngOnInit(): void {
    this.findAll();
  }

  delete(id: number) {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      accept: () => {
        this.usuarioService.delete(id).subscribe(e => {
          this.findAll();
        });
      }
    });
  }

  save(arg0: Usuario) {
    this.usuarioService.save(arg0).subscribe(e => {
      this.findAll();
      this.showModal = false;
    });
  }

  findAll() {
    this.usuarioService.findAll().subscribe(e => {
      this.listUsuario = e;
    });
  }

  findOne(id: number) {
    this.usuarioService.findOne(id).subscribe(e => {
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
