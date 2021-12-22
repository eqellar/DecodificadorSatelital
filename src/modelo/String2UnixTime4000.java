package modelo;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class String2UnixTime4000
{
  public long unix4000(String fecha4000)
  {
    long feclong = 0L;
    Date d2 = null;
    String testDateString2 = fecha4000;
    try
    {
      DateFormat df2 = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
      TimeZone gmtTime = TimeZone.getTimeZone("GMT");
      df2.setTimeZone(gmtTime);
      d2 = df2.parse(testDateString2); 
    }
    catch (ParseException ex)
    {
      Logger.getLogger(String2UnixTime4000.class.getName()).log(Level.SEVERE, null, ex);
    }
    feclong = d2.getTime();
    
    System.out.println("Creo que es este..." + feclong);
    return feclong;
  }
}
