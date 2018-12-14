import { HttpClient } from '@angular/common/http';
import { Injectable ,Output } from '@angular/core';
import { Articulo } from './articulo';

@Injectable({
  providedIn: 'root'
})
export class VentaService {
  constructor(private http:HttpClient) {
    
  }

  getventas(){

    return this.http.get('/WsVentas/Tiendita/Ventas/ConsultarVentas').toPromise();
  }

  getfolioventa(){
    return this.http.get('/WsVentas/Tiendita/Ventas/ObtenerFolioVenta').toPromise();
  }

  getfecha(){
    console.log("entro");
    return this.http.get('/WsVentas/Tiendita/Ventas/ObtenerFecha').toPromise();
  }

  mostrararticulo(descripcion,cantidad){
    return this.http.get('/WsVentas/Tiendita/Ventas/MostrarArticulo?descripcion='+descripcion+'&cantidad='+cantidad).toPromise();
  }

  calculartotales(importe){
    return this.http.get('/WsVentas/Tiendita/Ventas/CalcularTotales?importe='+importe).toPromise();
  }
  
  buscararticulo(descripcion){
    return this.http.get('/WsVentas/Tiendita/Ventas/ConsultarArticulo?nombrearticulo='+descripcion).toPromise();
  }

  buscarcliente(cliente){
    return this.http.get('/WsVentas/Tiendita/Ventas/ConsultarCliente?nombrecliente='+cliente).toPromise();
  }
  calcularabonos(total){
    return this.http.get('/WsVentas/Tiendita/Ventas/CalcularAbonos?totaladeudo='+total).toPromise();
  }

  grabarventa(folioventa,clave,cliente,totalpagar,fecha,estatus){
    return this.http.get('/WsVentas/Tiendita/Ventas/GrabarVenta?folioventa='+folioventa+'&clave='+clave+'&nombre='+cliente+'&total='+totalpagar+'&fecha='+fecha+'&estatus='+estatus).toPromise();
  }
}
 