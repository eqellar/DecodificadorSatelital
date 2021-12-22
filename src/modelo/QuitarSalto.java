package modelo;

public class QuitarSalto
{
  public String quitarSaltos(String cadena)
  {
    return cadena.replaceAll("\n", "");
  }
}
