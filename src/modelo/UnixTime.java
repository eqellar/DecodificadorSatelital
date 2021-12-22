package modelo;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.JComboBox;
import vista.Decodificador;

public class UnixTime
{
  public String timepo2000(long unixSeconds)
  {
    String timezone = Decodificador.jCGMT.getSelectedItem().toString();
    
    Date date = new Date(unixSeconds * 1000L);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sdf.setTimeZone(TimeZone.getTimeZone(timezone));
    String formattedDate = sdf.format(date);
    System.out.println(formattedDate);
    return formattedDate;
  }
  
  public String timepo4000(long unixSeconds)
  {
    String timezone = Decodificador.jCGMT.getSelectedItem().toString();
    Date date = new Date(unixSeconds);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
    sdf.setTimeZone(TimeZone.getTimeZone(timezone));
    String formattedDate = sdf.format(date);
    System.out.println(formattedDate);
    return formattedDate;
  }
}
