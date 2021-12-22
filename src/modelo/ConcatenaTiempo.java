package modelo;

import java.io.PrintStream;

public class ConcatenaTiempo 
{
  String dato = "\t0xFA2D4734302E6576656E742E696E6963696F7669616A6523246A\n11803265900F6A14BDC4388C1A0002664501D30D0A000000000000\n00";
  
  public String fechaCompleta(String fecha4000)
  {
    Fecha fecha = new Fecha();
    Hora hora = new Hora();
    
    String timecomplete = fecha4000;
    timecomplete = fecha.decodFecha4000(fecha4000) + hora.codificaHora(fecha4000);
    
    System.out.println("Segun yo este es el tiempo completo: " + timecomplete);
    
    return timecomplete;
  }
}