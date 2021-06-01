import java.util.*;
import java.io.*;

public class Principal
{
public static void main (String[]args) throws IOException{
Scanner scan = new Scanner(System.in);
System.out.println("Bienvenid@ al sistema de información de parqueadero");
System.out.println("Ingrese la cantidad de pisos del edifico: ");
int cantidadPisos = scan.nextInt();
System.out.println("Ingrese la cantidad de espacios para estacionar en el edifico: ");
int cantidadEspacios = scan.nextInt();
System.out.println("Ingrese la tarifa a cobrar para los carros: ");
long tarifaCarros = scan.nextInt();
System.out.println("Ingrese la tarifa a cobrar para las motos: ");
long tarifaMotos = scan.nextInt();



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
System.out.println("Opción 10 - Desactivar manualmente un sensor en específico");
System.out.println("Opción 11 - Exportar información de los vehículos estacionados actualmente");
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
System.out.println("Ingrese el tipo de vehiculo: ");
String tipo = scan.next();

Sensor.sensores[piso][espacio] = new Sensor(1);
Vehiculo.vehiculos[piso][espacio] = new Vehiculo(placa, marca, color, tipo);

if(tipo.equalsIgnoreCase("Carro")){
Vehiculo carro;
carro = new Carro(placa, marca, color, tipo);
System.out.println("----------------------------------------------------------------------------------------------------------------");
System.out.println(carro.verTipoVehiculo());
}else if(tipo.equalsIgnoreCase("Moto")){
Vehiculo moto;
moto = new Moto(placa, marca, color, tipo);
System.out.println("----------------------------------------------------------------------------------------------------------------");
System.out.println(moto.verTipoVehiculo());
}

System.out.print(Vehiculo.vehiculos[piso][espacio]);
System.out.println("----------------------------------------------------------------------------------------------------------------");
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
System.out.println("Ingrese el tipo de vehiculo: ");
String tipo = scan.next();
System.out.println("Ingrese el valor comercial del vehiculo: ");
int valorComercial = scan.nextInt();

Sensor.sensores[piso1][espacio1] = new Sensor(1);
Vehiculo.vehiculos[piso1][espacio1] = new Vehiculo(placa, marca, color, valorComercial, tipo);

if(tipo.equalsIgnoreCase("Carro")){
Vehiculo carro;
carro = new Carro(placa, marca, color, valorComercial, tipo);
System.out.println("----------------------------------------------------------------------------------------------------------------");
System.out.println(carro.verTipoVehiculo());
}else if(tipo.equalsIgnoreCase("Moto")){
Vehiculo moto;
moto = new Moto(placa, marca, color, valorComercial, tipo);
System.out.println("----------------------------------------------------------------------------------------------------------------");
System.out.println(moto.verTipoVehiculo());
}

System.out.print(Vehiculo.vehiculos[piso1][espacio1].toString());
System.out.println("----------------------------------------------------------------------------------------------------------------");
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

case 10:
System.out.println("Ingrese la información del lugar donde se encuentra el sensor que desea desactivar: ");
System.out.println("Piso: ");
int piso3 = scan.nextInt() -1;
System.out.println("Espacio: ");
int espacio3 = scan.nextInt() -1;

if((Sensor.sensores[piso3][espacio3] == null) || (Sensor.sensores[piso3][espacio3].getEstado() == 0)){
System.out.print("El espacio que seleccionó ya está libre.");
break;
}else{
System.out.println("El espacio que seleccionó está ocupado, para desactivarlo escriba Continuar o para cancelar la operación, Cancelar");
String eleccion2 = scan.next();
     if(eleccion2.equalsIgnoreCase("Continuar")){
      Sensor.sensores[piso3][espacio3] = new Sensor(0);
      System.out.println("Operación realizada con éxito. El sensor seleccionado está libre ahora.");
      System.out.println(Sensor.sensores[piso3][espacio3].toStringSalida());
         
             if(Vehiculo.vehiculos[piso3][espacio3].verTipoVehiculo().equalsIgnoreCase("Carro")){ 
                 Vehiculo carro;
                 carro = new Carro(Vehiculo.vehiculos[piso3][espacio3].getFechaHoraEntrada(),Vehiculo.vehiculos[piso3][espacio3].getFechaHoraSalida());
                 
                 long tiempo = carro.tiempoTotal();
                 long tarifafinalcarro = 0;
                 
                 try{
                 tarifafinalcarro = (tarifaCarros / tiempo) * 60;
                }
                catch(ArithmeticException e){
                 System.out.print("Se cobra: " + tarifaCarros/2);
                 break;
                }
                 
                System.out.println("Se cobra:  " +tarifafinalcarro);
             }else if(Vehiculo.vehiculos[piso3][espacio3].verTipoVehiculo().equalsIgnoreCase("Moto")){ 
                 Vehiculo moto;
                 moto = new Moto(Vehiculo.vehiculos[piso3][espacio3].getFechaHoraEntrada(),Vehiculo.vehiculos[piso3][espacio3].getFechaHoraSalida());
                 
                 long tiempo = moto.tiempoTotal();
                 long tarifafinalmoto = 0;
                 
                 try{
                 tarifafinalmoto = (tarifaMotos / tiempo) * 60;
                }
                catch(ArithmeticException e){
                 System.out.print("Se cobra: " + tarifaMotos/2);
                 break;
                }
                 
                System.out.println("Se cobra: " +tarifafinalmoto);
             }
            
            
                  
                 break;
      }else if(eleccion2.equalsIgnoreCase("Cancelar")){
      break;
  }
}

case 11:
String titulo = "Vehiculos estacionados: " + "\n";
String infovehiculos = Vehiculo.toStringVehiculos();
PrintWriter impresora = new PrintWriter (new FileWriter("C:\\Users\\Vale\\OneDrive\\Desktop\\InformacionVehiculos.txt"),true);
impresora.println(titulo);
impresora.println(infovehiculos);
impresora.close();
System.out.println("La información de los vehiculos ha sido exportada correctamente. (Nombre archivo: InformacionVehiculos.txt) ");
break;

default: 
System.out.println("Comando incorrecto. Ingrese otra opción.");
}
System.out.println("");
eleccion = scan.nextInt();
}

}
}
