import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AgGridModule} from "ag-grid-angular";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VentasComponent } from './ventas/ventas.component';
import { HttpClientModule } from '@angular/common/http';
import {RouterModule, Routes} from  '@angular/router';
import { EncabezadoComponent } from './encabezado/encabezado.component';
import { FormsModule } from '@angular/forms';
  

const rutasApp:Routes = [
  {path:'ventas',component:VentasComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    VentasComponent,
    EncabezadoComponent
  ],
  imports: [
    BrowserModule,
    AgGridModule.withComponents([]),
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(rutasApp),
     FormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
