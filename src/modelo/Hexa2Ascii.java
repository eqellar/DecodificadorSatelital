package modelo;

public class Hexa2Ascii
{
  public String convertHexatoAscii(String hex)
  {
    String hexa = null;
    
    StringBuilder output = new StringBuilder();
    for (int i = 0; i < hex.length(); i += 2)
    {
      String str = hex.substring(i, i + 2);
      output.append((char)Integer.parseInt(str, 16)); 
      hexa = output.toString();
    }
    return hexa;
  }
}
