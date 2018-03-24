import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsuarioComponent} from "./usuario/usuario.component";

const routes: Routes = [
  {path: 'usuario', component: UsuarioComponent}
];

export const AppRouting: ModuleWithProviders = RouterModule.forRoot(routes);
