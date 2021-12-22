package modelo;

public class Hexa2Bin32
{
  private final int LONG_BITS = 32;
  
  public String convert(String numHex)
  {
    long conHex = Long.parseLong(numHex, 16);
    
    String binary = Long.toBinaryString(conHex);
    
    String nuevo = completeDigits(binary);
    return nuevo;
  }
  
  public String completeDigits(String binNum)
  {
    for (int i = binNum.length(); i < 32; i++) {
      binNum = "0" + binNum;
    }
    return binNum;
  }
}
