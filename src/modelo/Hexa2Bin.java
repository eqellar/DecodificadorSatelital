package modelo;

public class Hexa2Bin {

    //private final int LONG_BITS = 16;

    public String convert(String numHex) {
        int conHex = Integer.parseInt(numHex, 16);

        String binary = Integer.toBinaryString(conHex);

        String nuevo = completeDigits(binary);
        return nuevo;
    }

    public String completeDigits(String binNum) {
        for (int i = binNum.length(); i < 16; i++) {
            binNum = "0" + binNum;
        }
        return binNum;
    }
}
