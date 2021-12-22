package modelo;

public class Hexa2Bin8
{
  private final int LONG_BITS = 8;
  
  public String convert(String numHex)
  {
    int conHex = Integer.parseInt(numHex, 16);
    
    String binary = Integer.toBinaryString(conHex);
    
    String nuevo = completeDigits(binary);
    return nuevo;
  }
  
  public String completeDigits(String binNum)
  {
    for (int i = binNum.length(); i < 8; i++) {
      binNum = "0" + binNum;
    }
    return binNum;
  }
}
