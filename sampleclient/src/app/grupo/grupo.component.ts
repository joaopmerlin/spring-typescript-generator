import {Component, OnInit} from '@angular/core';
import {ConfirmationService} from 'primeng/api';
import {GrupoService} from './grupo.service';
import {Grupo} from './grupo';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styleUrls: ['./grupo.component.css']
})
export class GrupoComponent implements OnInit {

  listGrupo: Grupo[];
  selectedGrupo = new Grupo();
  showModal = false;

  constructor(private grupoService: GrupoService, private confirmationService: ConfirmationService) {
  }

  ngOnInit(): void {
    this.findAll();
  }

  delete(id: number) {
    this.confirmationService.confirm({
      message: 'Do you want to delete this record?',
      accept: () => {
        this.grupoService.delete(id).subscribe(e => {
          this.findAll();
        });
      }
    });
  }

  save(arg0: Grupo) {
    this.grupoService.save(arg0).subscribe(e => {
      this.findAll();
      this.showModal = false;
    });
  }

  findAll() {
    this.grupoService.findAll().subscribe(e => {
      this.listGrupo = e;
    });
  }

  findOne(id: number) {
    this.grupoService.findOne(id).subscribe(e => {
    });
  }

  new() {
    this.selectedGrupo = new Grupo();
    this.showModal = true;
  }

  edit(grupo: Grupo) {
    this.selectedGrupo = JSON.parse(JSON.stringify(grupo));
    this.showModal = true;
  }
}
