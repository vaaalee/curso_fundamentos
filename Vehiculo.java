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

public Vehiculo(){
}

public Vehiculo(String p, String m, String c){
 this(p, m, c, 30000000);
}

public Vehiculo(String p, String m, String c, int v){
this.placa = p;
this.marca = m;
this.color = c;
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

public String toString(){
 return "Información del vehículo (Placa: " + this.placa + ", Marca: " + this.marca + ", Color: " + this.color + ", Valor Comercial: " + this.valorComercial + ")" +"\n";
}

public static String toStringVehiculos(){
String informacionVehiculo = "";
    for(int i = 0; i<vehiculos.length ; i++){
    for(int j = 0; j<vehiculos[0].length; j++){
    if((vehiculos[i][j] != null)){
        informacionVehiculo += Vehiculo.vehiculos[i][j].toString();
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
int k = 0;
    for(int i = 0; i<vehiculos.length ; i++){
    for(int j = 0; j<vehiculos[0].length; j++){
    if(vehiculos[i][j] != null){
    vehiculosSorteados[k] = vehiculos[i][j];
    k++;
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


