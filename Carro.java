public class Carro extends Vehiculo
{

 public Carro(String p, String m, String c, String t){
  super(p, m, c, 30000000, t);
 }

 public Carro(String p, String m, String c, int v, String t){
  super(p, m, c, v, t);
  cantidad = cantidad + 1;
 }
 
 public Carro(String entrada, String salida){
    super.setFechaHoraEntrada(entrada);
    super.setFechaHoraSalida(salida);
 }
    
    
 @Override
 public String verTipoVehiculo(){
     return super.tipoVehiculo = "Carro";
 }

}