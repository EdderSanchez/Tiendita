import { Component, OnInit ,Input} from '@angular/core';
import { VentaService } from 'src/app/ventas/venta.service';
import { Venta } from 'src/app/ventas/venta';

@Component({
  selector: 'app-encabezado',
  templateUrl: './encabezado.component.html',
  styleUrls: ['./encabezado.component.css']
})
export class EncabezadoComponent implements OnInit {
  @Input() fecha:any;
  constructor(private ventaSrv: VentaService) {
    //this.obtenerFecha(ventaSrv);
   }

  ngOnInit() {
  }

}
