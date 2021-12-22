package modelo;

public class Bin2Decimal
{
  public int bintodecimal(String binario)
  {
    int decimal = Integer.parseInt(binario, 2);
    
    return decimal; 
  }
}