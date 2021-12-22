package modelo;

public class Hexa2Dec
{
  public String convert(String numHex)
  {
    long numdec = Long.parseLong(numHex, 16);
    String decimal = Long.toString(numdec);
    
    return decimal;
  }
}
