import { Component, OnInit } from '@angular/core';
import {GridOptions, ClientSideNodeManager} from 'ag-grid-community';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { VentaService } from './venta.service';
import { Venta } from './venta';
import { Articulo } from './articulo';
import { Totales } from './totales';
import { Abonos } from './abonos';
import { Cliente } from './cliente';
import {Router} from  '@angular/router';

@Component({
  selector: 'app-ventas',
  templateUrl: './ventas.component.html',
  styleUrls: ['./ventas.component.css']
})
export class VentasComponent implements OnInit {
  private gridOptionsVentas: GridOptions;
  
  valor:boolean = true;
  abono:boolean = false;
  bEncontro:boolean = false;
  bSiguiente:boolean = false;
  encontrocliente:boolean = false;
  folioventa:any;
  validarimporte:String;
  enganche:Number;
  bonificacionenganche:Number;
  total:Number;
  cliente:String;
  modelo:String;
  descripcion:String;
  cantidad:Number = 1;
  importe:Number = 0;
  precio:Number = 0;
  fecha:any;
  estatus:String = "ACTIVA";
  totalpagar:Number;
  radio:any;
  grabo:Number;
  rfc:String;
  clave:Number;
  existencia:Number;
  precioart:Number;
  
  clientes:Cliente[];
  ventas:Venta[];
  articulos:Articulo[];
  totales:Totales[];
  abonos:Abonos[];
  rowData:any[];
  rowDataArticulo:any;
  rowDataAbono:any;

  //abonos
  public mesestres:Number;
    public totalpagartres:Number;
    public importeabonotres:Number;
    public importeahorratres:Number;
    
    public mesesseis:Number;
    public totalpagarseis:Number;
    public importeabonoseis:Number;
    public importeahorraseis:Number;
    
    public mesesnueve:Number;
    public totalpagarnueve:Number;
    public importeabononueve:Number;
    public importeahorranueve:Number;

    public mesesdoce:Number;
    public totalpagardoce:Number;
    public importeabonodoce:Number;
    public importeahorradoce:Number;

    

  constructor(private ventaSrv: VentaService,private router: Router) {
    this.ventasactivas();
    this.obtenerFolioVenta(ventaSrv);
    this.obtenerFecha(ventaSrv);
}

   
  ngOnInit() {
   
  }
  title = 'app'; 

  columnDefs = [
    {headerName: 'Folio Venta',width: 166, field: 'folio' },
    {headerName: 'Clave Cliente',width: 166, field: 'clave' },
    {headerName: 'Nombre' , width: 400 , field: 'nombre'},
    {headerName: 'Total',width: 200, field: 'total'},
    {headerName: 'Fecha',width: 200, field: 'fecha'},
    {headerName: 'Estatus',width: 200, field: 'estatus'}
  ];

  obtenerFolioVenta(ventaSrv){
    ventaSrv.getfolioventa().then((d: Venta[]) =>{
      this.folioventa = d;
    });
  }

  obtenerFecha(ventaSrv){
    ventaSrv.getfecha().then((d: any) =>{
      this.fecha = d;
    });
  }

  buscararticulo(){
    this.descripcion =  this.descripcion.toUpperCase();
    this.ventaSrv.buscararticulo(this.descripcion).then((d: Articulo[]) =>{
      for(let i in d){
        this.descripcion = d[i].descripcion;
        this.modelo = d[i].modelo;
        this.existencia = d[i].existencia;
        this.precioart = d[i].precio;

         this.mostrararticulo();
        }
     });

   
  }

  buscarcliente(){
    this.cliente =  this.cliente.toUpperCase();
    this.encontrocliente = false;
    this.ventaSrv.buscarcliente(this.cliente).then((d: Cliente[]) =>{
      for(let i in d){
        this.encontrocliente = true;

        this.rfc = d[i].rfc;
        this.cliente = d[i].nombre;
        this.clave = d[i].clave;
        }

        console.log(this.encontrocliente);
        if(!this.encontrocliente){
          alert("NO SE ENCONTRO CLIENTE");
          this.cliente = '';
        }
     });
  }

  ventasactivas(){
    this.ventaSrv.getventas().then((d: Venta[]) =>{
      this.rowData = d;
    });
    
    this.gridOptionsVentas = <GridOptions>{
      onGridReady: () => {
        this.gridOptionsVentas.api.sizeColumnsToFit();
      }
    };
  }
    
  mostrararticulo(){
      if(this.descripcion != '' && this.cliente != '' && this.descripcion != null && this.cliente != null){
        this.descripcion =  this.descripcion.toUpperCase();
        if(this.existencia > 0){
          this.ventaSrv.mostrararticulo(this.descripcion,this.cantidad).then((d: Articulo[]) =>{
            for(let i in d){
  
              this.importe = d[i].importe;
              this.descripcion = d[i].descripcion;
              this.modelo = d[i].modelo;
              this.precio = d[i].precio;
  
              if(d[i].descripcion != null)
              {
                this.bEncontro = true;
              }
            }
 
            if(this.bEncontro)
            {
              this.rowDataArticulo= d;
  
             
  
              this.calculartotales(this.importe);
  
              this.bSiguiente = true;
            }
            else{
              alert("NO SE ENCONTRARON DATOS PARA MOSTRAR");
            }
           });
        }
        else{
          alert("NO HAY EXISTENCIA DEL ARTICULO");
        }
      }
      else{
        alert("FAVOR DE CAPTURAR DATOS CORRECTAMENTE");
      }
  }

  calculartotales(importe){
    this.ventaSrv.calculartotales(importe).then((d: Totales) =>{
        this.enganche = d.enganche; 
        this.bonificacionenganche = d.bonificacionEnganche;
        this.total = d.totalAdeudo;
     });
  }

  calcularabonos(){
    this.abono = true; 
    this.ventaSrv.calcularabonos(this.total).then((d: Abonos[]) =>{
      this.mesestres = d[0].meses;
      this.totalpagartres = d[0].totalpagar;
      this.importeabonotres = d[0].importeabono;
      this.importeahorratres = d[0].importeahorra;
      
      this.mesesseis = d[1].meses;
      this.totalpagarseis= d[1].totalpagar;
      this.importeabonoseis= d[1].importeabono;
      this.importeahorraseis = d[1].importeahorra;
      
      this.mesesnueve = d[2].meses;
      this.totalpagarnueve= d[2].totalpagar;
      this.importeabononueve= d[2].importeabono;
      this.importeahorranueve = d[2].importeahorra;
  
      this.mesesdoce = d[3].meses;
      this.totalpagardoce= d[3].totalpagar;
      this.importeabonodoce= d[3].importeabono;
      this.importeahorradoce = d[3].importeahorra;
      
   });
  }

  grabarventa(){
    if(this.radio == 3){
      this.totalpagar = this.totalpagartres;
    }else if(this.radio == 6){
      this.totalpagar = this.totalpagarseis;
    }else if(this.radio == 9){
      this.totalpagar = this.totalpagarnueve;
    }else if(this.radio == 12){
      this.totalpagar = this.totalpagardoce;
    }
    
    if(this.radio == 3 || this.radio == 6 || this.radio == 9 ||  this.radio == 12 ){
      this.ventaSrv.grabarventa(this.folioventa,this.clave,this.cliente,this.totalpagar,this.fecha,this.estatus).then((d: any) =>{
        this.grabo = d;
  
        if(this.grabo == 1)
        {
            alert("SE GRABO CORRECTAMENTE");
            this.router.navigate(['']);
        }
        else
        {
            console.log("no grabo");
        }
     });
    }
    else{
      alert("FAVOR DE SELECCIONAR UN PLAZO");
    }
    
  }

  cancelarventa(){
    this.router.navigate(['']);
  }
}
