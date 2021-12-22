package modelo;

public class Longitud
{
  public String decodLongitud4000(String trama4000)
  {
    String numero = "4294967295";
    
    long factor = Long.parseLong(numero);
    
    String longitud = null;
    Bin2Decimal cnvdec = new Bin2Decimal();
    Hexa2Bin32 cnvbin32 = new Hexa2Bin32();
    Hexa2Bin8 cnvbin8 = new Hexa2Bin8();
    Hexa2Dec hextodec = new Hexa2Dec();
    Dec2Hexa dectohexa = new Dec2Hexa();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "2324";
    prot.quitarSaltos(trama4000);
    int largo = trama4000.length();
    String corrida = prot.quitarSaltos(trama4000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 24;
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
      
      int entero = Integer.parseInt(compara);
      
      String cadenastr = cadenabuf.toString();
      
      String decimal = hextodec.convert(cadenastr);
      long resultadodec = Long.parseLong(decimal);
      
      double divide = 1.0E7D;
      if (entero == 1)
      {
        long resfinal = factor - resultadodec + 1L;
        
        String hexa = Long.toHexString(resfinal);
        
        double negativo = -resfinal / divide;
        longitud = Double.toString(negativo);
      }
      else
      {
        double positivo = resultadodec / divide;
        longitud = Double.toString(positivo);
      }
    }
    return longitud;
  }
  
  public String decodLongitud2000(String trama2000)
  {
    String numero = "4294967295";
    
    long factor = Long.parseLong(numero);
    
    String longitud = null;
    Bin2Decimal cnvdec = new Bin2Decimal();
    Hexa2Bin32 cnvbin32 = new Hexa2Bin32();
    Hexa2Bin8 cnvbin8 = new Hexa2Bin8();
    Hexa2Dec hextodec = new Hexa2Dec();
    Dec2Hexa dectohexa = new Dec2Hexa();
    
    QuitarSalto prot = new QuitarSalto();
    String buscar = "0xFA";
    prot.quitarSaltos(trama2000);
    int largo = trama2000.length();
    String corrida = prot.quitarSaltos(trama2000);
    
    int indice = corrida.indexOf(buscar);
    if (corrida.contains(buscar))
    {
      indice += 14;
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
      
      int entero = Integer.parseInt(compara);
      
      String cadenastr = cadenabuf.toString();
      
      String decimal = hextodec.convert(cadenastr);
      long resultadodec = Long.parseLong(decimal);
      
      double divide = 1.0E7D;
      if (entero == 1)
      {
        long resfinal = factor - resultadodec + 1L;
        
        String hexa = Long.toHexString(resfinal);
        
        double negativo = -resfinal / divide;
        longitud = Double.toString(negativo);
      }
      else
      {
        double positivo = resultadodec / divide;
        longitud = Double.toString(positivo);
      }
    }
    return longitud;
  }
}
