package modelo;

import java.awt.Color;
import java.io.PrintStream;
import javax.swing.JTextField;
import vista.Decodificador;

public class Hora
{
  public String codificaHora(String dato)
  {
    int gps = 0;
    int hora = 0;
    int minuto = 0;
    int milisegundo = 0;
    String horahr = null;String minutomin = null;String segundoseg = null;String tiempo = null;
    Bin2Decimal cnvdec = new Bin2Decimal();
    Hexa2Bin32 cnvbin32 = new Hexa2Bin32();
    
    Hexa2Bin8 cnvbin8 = new Hexa2Bin8();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "2324";
    prot.quitarSaltos(dato);
    int largo = dato.length();
    String corrida = prot.quitarSaltos(dato);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 8;
      int tope = indice + 8;
      int j = 0;
      char[] extraido = new char[8];
      StringBuffer cadenabuf = new StringBuffer();
      StringBuffer first2by = new StringBuffer();
      for (int i = indice; i < tope; i++)
      {
        extraido[j] = corrida.charAt(i);
        cadenabuf = cadenabuf.append(extraido[j]);
        if (j < 2) {
          first2by = first2by.append(extraido[j]);
        }
        j = 1 + j;
      }
      String firts2bystr = first2by.toString();
      
      String unbyte = cnvbin8.convert(firts2bystr);
      String compara = unbyte.substring(0, 1);
      cnvdec.bintodecimal(compara);
      
      String cadenastr = cadenabuf.toString();
      
      String binario = cnvbin32.convert(cadenastr);
      if (binario.length() == 32)
      {
        String datogps = binario.substring(0, 1);
        
        String hr = binario.substring(4, 10);
        
        String min = binario.substring(10, 16);
        
        String milseg = binario.substring(16, 32);
        
        gps = cnvdec.bintodecimal(datogps);
        hora = cnvdec.bintodecimal(hr);
        minuto = cnvdec.bintodecimal(min);
        milisegundo = cnvdec.bintodecimal(milseg);
        if (gps == 1)
        {
          Decodificador.jTexValido.setForeground(Color.blue);
          Decodificador.jTexValido.setText("¡Valido!");
          System.out.println("El gps es valido..." + gps);
        }
        else
        {
          Decodificador.jTexValido.setForeground(Color.red);
          Decodificador.jTexValido.setText("¡Invalido!");
          System.out.println("El gps no es valido..." + gps);
        }
        int seg = milisegundo / 1000;
        
        horahr = Integer.toString(hora);
        minutomin = Integer.toString(minuto);
        segundoseg = Integer.toString(seg);
        if (horahr.length() == 1) {
          horahr = "0" + horahr;
        }
        tiempo = horahr + ":" + minutomin + ":" + seg;
      }
    }
    return tiempo;
  }
}
