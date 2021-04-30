import java.util.*;
public class Principal
{
public static void main (String[]args){
Scanner scan = new Scanner(System.in);
System.out.println("Bienvenid@ al sistema de información de parqueadero");
System.out.println("Ingrese la cantidad de pisos del edifico: ");
int cantidadPisos = scan.nextInt();
System.out.println("Ingrese la cantidad de espacios para estacionar en el edifico: ");
int cantidadEspacios = scan.nextInt();

Vehiculo.vehiculos = new Vehiculo[cantidadPisos][cantidadEspacios] ;
Sensor.sensores = new Sensor[cantidadPisos][cantidadEspacios];

Vehiculo.tamano = cantidadPisos * cantidadEspacios;

System.out.println("");
System.out.println("Menú de acciones");

System.out.println("Opción 0 - Salir del sistema");
System.out.println("Opción 1 - Consultar los sensores libres");
System.out.println("Opción 2 - Registrar ingreso de vehículo");
System.out.println("Opción 3 - Registrar ingreso de vehículo (Dato adicional: Valor comercial)");
System.out.println("Opción 4 - Consultar información de los vehículos almacenados actualmente");
System.out.println("Opción 5 - Consultar historial de la cantidad de vehículos parqueados");
System.out.println("Opción 6 - Consultar estado de un sensor en específico");
System.out.println("Opción 7 - Consultar estado de todos los sensores");
System.out.println("Opción 8 - Filtrar los vehiculos por color");
System.out.println("Opción 9 - Sortear los vehiculos por valor comercial");
System.out.println("");

System.out.println("Ingrese el número de la acción que desea realizar: ");
int eleccion = scan.nextInt();

if(eleccion==0){
 System.out.println("Saliendo...");
}

while(eleccion!=0){
switch(eleccion){
case 1:
System.out.println(Sensor.sensorLibre());
break;

case 2:
System.out.println("A continuación ingrese la información del lugar donde desea parquear:");
System.out.println("Piso: ");
int piso = scan.nextInt() -1;
System.out.println("Espacio: ");
int espacio = scan.nextInt() -1;

if((Sensor.sensores[piso][espacio] != null) && (Sensor.sensores[piso][espacio].getEstado() == 1)){
System.out.print("El espacio que seleccionó está ocupado. No se puede realizar la acción.");
}else{
System.out.println("Ingrese la placa del vehiculo: ");
String placa = scan.next();
System.out.println("Ingrese la marca del vehiculo: ");
String marca = scan.next();
System.out.println("Ingrese el color del vehiculo: ");
String color = scan.next();

Sensor.sensores[piso][espacio] = new Sensor(1);
Vehiculo.vehiculos[piso][espacio] = new Vehiculo(placa, marca, color);

System.out.print(Vehiculo.vehiculos[piso][espacio]);
}
break;

case 3:
System.out.println("A continuación ingrese la información del lugar donde desea estacionar el vehiculo: ");
System.out.println("Piso: ");
int piso1 = scan.nextInt() -1;
System.out.println("Espacio: ");
int espacio1 = scan.nextInt() -1;

if((Sensor.sensores[piso1][espacio1] != null) && (Sensor.sensores[piso1][espacio1].getEstado() == 1)){
System.out.print("El espacio que seleccionó está ocupado. No se puede realizar la acción.");
}else{
System.out.println("Ingrese la placa del vehiculo: ");
String placa = scan.next();
System.out.println("Ingrese la marca del vehiculo: ");
String marca = scan.next();
System.out.println("Ingrese el color del vehiculo: ");
String color = scan.next();
System.out.println("Ingrese el valor comercial del vehiculo: ");
int valorComercial = scan.nextInt();

Sensor.sensores[piso1][espacio1] = new Sensor(1);
Vehiculo.vehiculos[piso1][espacio1] = new Vehiculo(placa, marca, color, valorComercial);

System.out.print(Vehiculo.vehiculos[piso1][espacio1].toString());
}
break;

case 4:
System.out.print(Vehiculo.toStringVehiculos());
break;

case 5:
System.out.println("La cantidad de vehiculos que han ingresado hasta el momento es: " + Vehiculo.cantidadVehiculos());
break;

case 6:
System.out.println("Ingrese el piso: ");
int piso2 = scan.nextInt() -1;
System.out.println("Ingrese el espacio: ");                
int espacio2 = scan.nextInt() -1; 
if(Sensor.sensores[piso2][espacio2] == null){
System.out.println("Libre");
break;
}                             
System.out.println(Sensor.sensores[piso2][espacio2]);
break;

case 7:
System.out.println(Sensor.sensoresEstado());              
break;

case 8:
System.out.println("Ingrese el color : ");
String color = scan.next();
String infoVehiculos = Vehiculo.filtrarColor(color);
System.out.println(infoVehiculos);
break;

case 9:
Vehiculo vehiculosSorteados [] = Vehiculo.sortearValorComercial();
System.out.println(Vehiculo.imprimirArregloSorteado(vehiculosSorteados));
break;

default: 
System.out.println("Comando incorrecto");
}
System.out.println("");
eleccion = scan.nextInt();
}

}
}
