package modelo;

import java.io.PrintStream;

public class Fecha
{
  public String decodFecha4000(String trama4000)
  {
    long dia = 0L;
    long mes = 0L;
    long anio = 0L;
    long anioseg = 31536000L;
    String diaday = null;String mesmonth = null;String anioyear = null;String date = null;
    Bin2Decimal cnvdec = new Bin2Decimal();
    Hexa2Bin cnvbin = new Hexa2Bin();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "2324";
    prot.quitarSaltos(trama4000);
    int largo = trama4000.length();
    String corrida = prot.quitarSaltos(trama4000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 4;
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
      
      String binario = cnvbin.convert(cadenastr);
      if (binario.length() == 16)
      {
        String day = binario.substring(0, 5);
        
        String month = binario.substring(5, 9);
        
        String year = binario.substring(9, 16);
        
        dia = cnvdec.bintodecimal(day);
        mes = cnvdec.bintodecimal(month);
        anio = cnvdec.bintodecimal(year);
        anio += 2000L;
        
        diaday = Long.toString(dia);
        mesmonth = Long.toString(mes);
        anioyear = Long.toString(anio);
        if (diaday.length() == 1) {
          diaday = "0" + diaday;
        }
        if (mesmonth.length() == 1) {
          mesmonth = "0" + mesmonth;
        }
        date = anioyear + "-" + mesmonth + "-" + diaday + " ";
        System.out.println(date);
      }
    }
    return date;
  }
  
  public String decodFecha2000(String trama2000)
  {
    long factorunixtime = 315964800L;
    String date = null;
    Hexa2Dec cnvhexatodec = new Hexa2Dec();
    UnixTime unix = new UnixTime();
    
    QuitarSalto prot = new QuitarSalto();
    String inicio = "0xFA";
    
    prot.quitarSaltos(trama2000);
    
    String corrida = prot.quitarSaltos(trama2000);
    
    int indice = corrida.indexOf(inicio);
    if (corrida.contains(inicio))
    {
      indice += 24;
      int tope = indice + 8;
      int j = 0;
      char[] fecha = new char[8];
      StringBuffer cadenabuf = new StringBuffer();
      for (int i = indice; i < tope; i++)
      {
        fecha[j] = corrida.charAt(i);
        cadenabuf = cadenabuf.append(fecha[j]);
        j = 1 + j;
      }
      String cadenastr = cadenabuf.toString();
      
      String decimal = cnvhexatodec.convert(cadenastr);
      System.out.println("Esto es lo que quiero ver hora: " + decimal);
      long dec = Long.parseLong(decimal);
      long timeunix = dec + factorunixtime;
      date = unix.timepo2000(timeunix);
    }
    return date;
  }
}
