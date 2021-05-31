import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.concurrent.TimeUnit;


public class Vehiculo
{
public static Vehiculo [][] vehiculos;
public static int tamano;
public static int cantidad = 0;

private String placa;
private String marca ;
private String color;
private int valorComercial;

public static Vehiculo temp;   

public String tipoVehiculo; 

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
Date date1 = new Date();
String entrada = formatter.format(date1);  
Date date2 = new Date();
String salida = formatter.format(date2);
Date date = new Date();
String salida2 = formatter.format(date);


public Vehiculo(){
}

public Vehiculo(String p, String m, String c, String t){
 this(p, m, c, 30000000, t);
}

public Vehiculo(String p, String m, String c, int v, String t){
this.placa = p;
this.marca = m;
this.color = c;
this.tipoVehiculo = t;
this.valorComercial = v;

cantidad = cantidad + 1;
}

public String getPlaca(){
 return this.placa;
}

public String getMarca(){
 return this.marca;
}

public String getColor(){
 return this.color;
}

public int getValorComercial(){
 return this.valorComercial;
}

public void setPlaca(String placa){
 this.placa = placa;
}

public void setMarca(String marca){
 this.marca = marca;
}

public void setColor(String color){
 this.color = color;
}

public void setValorComercial(int valor){
 this.valorComercial = valor;
}


public String getTipoVehiculo(){
 return this.tipoVehiculo;
}

public void setTipoVehiculo(String tipo){
 this.tipoVehiculo = tipo;
}


public String verTipoVehiculo(){
  return tipoVehiculo;
}
 

public String toString(){
  return "Información del vehículo (Placa: " + this.placa + ", Marca: " + this.marca + ", Color: " + this.color + ", Tipo: " + verTipoVehiculo() + ", Valor Comercial: " + this.valorComercial + ")"+"\r\nHora de ingreso [" +this.entrada+"]" +"\n";
}

public String getFechaHoraEntrada(){
 return this.entrada;
}

public void setFechaHoraEntrada(String entrada){
 this.entrada = entrada;
}


public String getFechaHoraSalida(){ 
 return this.salida;
}


public void setFechaHoraSalida(String salida){
 this.salida = salida;
}

public String getFechaHoraSalida2(){ 
 return this.salida2;
}


public void setFechaHoraSalida2(String salida2){
 this.salida2 = salida2;
}


public String toStringSalida(){
 return "Hora de salida ["+salida2+"]";
}



public long tiempoTotal(){
long tiempo  = date2.getTime() - date1.getTime();
long diferencia = TimeUnit.MILLISECONDS.toHours(tiempo);
return diferencia;
}



public static String toStringVehiculos(){
String informacionVehiculo = "";
for(int i = 0; i<vehiculos.length ; i++){
   for(int j = 0; j<vehiculos[0].length; j++){
      if((vehiculos[i][j] != null)){
          informacionVehiculo += Vehiculo.vehiculos[i][j].toString() + "\n"; 
          
      }
   }
}
    
return !informacionVehiculo.equals("") ? informacionVehiculo: "No hay ningún vehículo estacionado" ;
}


public static int cantidadVehiculos(){
 return Vehiculo.cantidad;
}

public static String filtrarColor(String color){
String informacionVehiculo = "";
    for(int i = 0; i<vehiculos.length ; i++){
    for(int j = 0; j<vehiculos[0].length; j++){
    if((vehiculos[i][j] != null) && (vehiculos[i][j].color.equalsIgnoreCase(color))){
        informacionVehiculo += Vehiculo.vehiculos[i][j].toString();  
    }
    }
  }
return informacionVehiculo;
}

public static Vehiculo[] sortearValorComercial(){
Vehiculo [] vehiculosSorteados = new Vehiculo[cantidad];
int indice = 0;
for(int i = 0; i<vehiculos.length ; i++){
    for(int j = 0; j<vehiculos[0].length; j++){
    if(vehiculos[i][j] != null){
     vehiculosSorteados[indice] = vehiculos[i][j]; 
     indice++;
    }
    }
}
for(int i = 1; i < vehiculosSorteados.length ; i++){ 
        for(int j = 0; j < vehiculosSorteados.length - i; j++){
                if(vehiculosSorteados[j].valorComercial>(vehiculosSorteados[j+1].valorComercial)){
                 Vehiculo temp = vehiculosSorteados[j];
                 vehiculosSorteados[j] = vehiculosSorteados[j+1];
                 vehiculosSorteados[j+1] = temp;
                }            
        }       
} 

return vehiculosSorteados;
}

public static String imprimirArregloSorteado(Vehiculo [] vehiculosSorteados){
String informacionVehiculo = "";
for(Vehiculo veh: vehiculosSorteados){
 informacionVehiculo += veh.toString();
}
return informacionVehiculo;
}

}


