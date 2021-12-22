package controlador;

import java.io.PrintStream;
import modelo.Altitud;
import modelo.ConcatenaTiempo;
import modelo.Fecha;
import modelo.Heading;
import modelo.Hora;
import modelo.Latitud;
import modelo.Longitud;
import modelo.Mensaje;
import modelo.String2UnixTime4000;
import modelo.UnixTime;
import modelo.Velocidad;

public class Prueba {

   static String dato = "0xFA2A4734302E6576656E742E66696E7669616A652324A21184C8CB20111C31BABF189EDF0001660D05F10D0A00";

    public static void main(String[] args) {
        int largotrama = dato.length();
        Fecha fecha = new Fecha();
        Latitud lat = new Latitud();
        Mensaje msj = new Mensaje();
        Hora hr = new Hora();
        Velocidad speed = new Velocidad();
        Longitud lon = new Longitud();
        ConcatenaTiempo concatena = new ConcatenaTiempo();
        String2UnixTime4000 un4 = new String2UnixTime4000();
        UnixTime unix = new UnixTime();
        Altitud alt = new Altitud();
        Heading head = new Heading();
        if (largotrama > 38) {
            System.out.println(head.decodHeading4000(dato));
            System.out.println(alt.decodAltitud4000(dato));
        }
    }
}
