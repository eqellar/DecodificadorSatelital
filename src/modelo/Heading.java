package modelo;

import java.io.PrintStream;
import java.text.DecimalFormat;

public class Heading
{
  public String decodHeading4000(String trama4000)
  {
    String heading = "";
    String numero = "4294967295";
    long factor = Long.parseLong(numero);
    
    String latitud = null;
    Bin2Decimal cnvdec = new Bin2Decimal();
    Hexa2Bin32 cnvbin = new Hexa2Bin32();
    Hexa2Bin8 cnvbin8 = new Hexa2Bin8();
    Hexa2Dec hextodec = new Hexa2Dec();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "2324";
    prot.quitarSaltos(trama4000);
    int largo = trama4000.length();
    String corrida = prot.quitarSaltos(trama4000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 36;
      int tope = indice + 4;
      int j = 0;
      char[] extraido = new char[4];
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
      System.out.println(cadenastr);
      
      String decimal = hextodec.convert(cadenastr);
      double numdec = Double.parseDouble(decimal);
      double resolution = numdec * 0.01D;
      DecimalFormat df = new DecimalFormat("#.00");
      heading = df.format(resolution);
    }
    return heading;
  }
}
