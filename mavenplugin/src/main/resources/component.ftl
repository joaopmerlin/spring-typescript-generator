import {Component, Inject, OnInit, PLATFORM_ID} from '@angular/core';
import {isPlatformBrowser} from '@angular/common';
import {${component.service.nome}} from "./${component.service.nomeArquivo}";

@Component({
  selector: 'app-${component.folder}',
  templateUrl: './${component.folder}.component.html',
  styleUrls: ['./${component.folder}.component.css']
})
export class ${component.nome} implements OnInit {

  constructor(private ${component.service.nomeLower}: ${component.service.nome}) {
  }

  ngOnInit(): void {
  }

}
