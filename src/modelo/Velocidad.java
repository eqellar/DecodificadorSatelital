package modelo;

import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.JTextField;
import vista.Decodificador;

public class Velocidad
{
  public String decodSpedd4000(String trama4000)
  {
    String speed = null;
    Hexa2Dec cnvdec = new Hexa2Dec();
    Hexa2Bin cnvbin = new Hexa2Bin();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "2324";
    prot.quitarSaltos(trama4000);
    int largo = trama4000.length();
    String corrida = prot.quitarSaltos(trama4000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 32;
      int tope = indice + 4;
      int j = 0;
      char[] fecha = new char[4];
      StringBuffer cadenabuf = new StringBuffer();
      for (int i = indice; i < tope; i++)
      {
        fecha[j] = corrida.charAt(i);
        cadenabuf = cadenabuf.append(fecha[j]);
        j = 1 + j;
      }
      String cadenastr = cadenabuf.toString();
      String decimal = cnvdec.convert(cadenastr);
      double vel = Double.parseDouble(decimal);
      double resolution = 0.01D;
      double ms = vel * resolution;
      double constante = 3.6D;
      double kmh = ms * constante;
      DecimalFormat df = new DecimalFormat("#.0");
      
      speed = df.format(kmh);
    }
    return speed;
  }
  
  public String decodSpedd2000(String trama2000)
  {
    int gps = 0;
    String speed = null;
    Hexa2Dec cnvdec = new Hexa2Dec();
    Hexa2Bin8 cnvbin8 = new Hexa2Bin8();
    Bin2Decimal cnbbintodec = new Bin2Decimal();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "0xFA";
    prot.quitarSaltos(trama2000);
    int largo = trama2000.length();
    String corrida = prot.quitarSaltos(trama2000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 22;
      int tope = indice + 2;
      int j = 0;
      char[] fecha = new char[2];
      StringBuffer cadenabuf = new StringBuffer();
      for (int i = indice; i < tope; i++)
      {
        fecha[j] = corrida.charAt(i);
        cadenabuf = cadenabuf.append(fecha[j]);
        j = 1 + j;
      }
      String cadenastr = cadenabuf.toString();
      String binario = cnvbin8.convert(cadenastr);
      if (binario.length() == 8)
      {
        String datogps = binario.substring(0, 1);
        gps = cnbbintodec.bintodecimal(datogps);
        if (gps == 1)
        {
          Decodificador.jTexValido.setForeground(Color.blue);
          Decodificador.jTexValido.setText("¡Valido!");
        }
        else
        {
          Decodificador.jTexValido.setForeground(Color.red);
          Decodificador.jTexValido.setText("¡Invalido!");
        }
        String datovel = binario.substring(1, 8);
        
        int vel = cnbbintodec.bintodecimal(datovel);
        
        double resolution = 2.0D;
        double ms = vel * resolution;
        double constante = 3.6D;
        double kmh = ms * constante;
        
        speed = Double.toString(kmh);
      }
    }
    return speed;
  }
}
