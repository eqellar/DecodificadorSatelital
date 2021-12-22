package modelo;

public class Mensaje
{
  public String decoMensaje(String dato)
  {
    String mensaje = null;
    Hexa2Ascii msj = new Hexa2Ascii();
    
    QuitarSalto prot = new QuitarSalto();
    String inicio = "0xFA";
    String fin = "2324";
    prot.quitarSaltos(dato);
    int largo = dato.length();
    String corrida = prot.quitarSaltos(dato);
    
    int indice = corrida.indexOf(inicio);
    int indiceend = corrida.indexOf(fin);
    
    int contar = indiceend - indice;
    if (corrida.contains(inicio))
    {
      indice += 6;
      int tope = indiceend + 4;
      
      int j = 0;
      char[] extraido = new char[contar];
      
      StringBuffer cadenabuf = new StringBuffer();
      for (int i = indice; i < tope; i++)
      {
        extraido[j] = corrida.charAt(i);
        cadenabuf = cadenabuf.append(extraido[j]);
        j = 1 + j;
      }
      String cadenastr = cadenabuf.toString();
      
      mensaje = msj.convertHexatoAscii(cadenastr);
    }
    return mensaje;
  }
}
