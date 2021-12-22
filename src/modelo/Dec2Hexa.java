package modelo;

public class Dec2Hexa
{
  public String convert(String strDec)
  {
    long numdec = Long.parseLong(strDec);
    String hexanum = Long.toHexString(numdec);
    
    return hexanum;
  }
}
