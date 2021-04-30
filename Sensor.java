public class Sensor
{
public static Sensor[][] sensores;
private int estado;


public Sensor(){
}

public Sensor(int e){
 this.estado = e;
}

public int getEstado(){
 return this.estado;
}

public void setEstado(int estado){
 this.estado = estado;
}

public String toString(){
String state = "Libre";
 if(estado == 1){
 state = "Ocupado";
}else if(estado == 0){
 state = "Libre";
}
return state;
}

public static String sensorLibre(){
String informacionSensoresLibres = "";
for(int i = 0; i<Sensor.sensores.length ; i++ ){
for(int j = 0; j<Sensor.sensores[0].length ; j++){
if((sensores[i][j] == null) || (sensores[i][j].getEstado() == 0)){
 informacionSensoresLibres += "Piso: " +(i+1) +" Espacio: " +(j+1) +"\n";
}
}
}
return informacionSensoresLibres;
}

public static String sensoresEstado(){
String informacionSensores = "";
for(int i = 0; i<Sensor.sensores.length ; i++){
for(int j = 0; j<Sensor.sensores[0].length ; j++){
    if(Sensor.sensores[i][j] == null){
    informacionSensores += "Piso: " +(i+1)+" Espacio: " +(j+1) + " Libre" +"\n";
    continue;
    }
    informacionSensores += "Piso: " +(i+1)+" Espacio: " +(j+1) + Sensor.sensores[i][j].toString() +"\n";
}
}
return informacionSensores;
}
}

