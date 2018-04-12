import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from './usuario/usuario.component';
import {GrupoComponent} from './grupo/grupo.component';

const routes: Routes = [
  {path: 'usuario', component: UsuarioComponent},
  {path: 'grupo', component: GrupoComponent}
];

export const AppRouting: ModuleWithProviders = RouterModule.forRoot(routes);
