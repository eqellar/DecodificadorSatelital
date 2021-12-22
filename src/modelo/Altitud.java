package modelo;

import java.io.PrintStream;

public class Altitud 
{
  String altitud = "";
  
  public String decodAltitud4000(String trama4000)
  {
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
      indice += 40;
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
      String binario = cnvbin.convert(cadenastr);
      this.altitud = hextodec.convert(cadenastr);
    }
    return this.altitud;
  }
}
