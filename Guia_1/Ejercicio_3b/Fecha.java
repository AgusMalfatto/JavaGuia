package Ejercicios_Resueltos.JavaGuia.Ejercicio_3b;
import javax.swing.*;
import java.util.ArrayList;


public class Fecha {
    private int day;
    private int month;
    private int year;
    private String monthStr;
    
    
    public Fecha()
    {
        setDay();
        setMonthStr();
        setYear(); 
    }
    
    public Fecha(int a)
    {
    	setDay();
        setMonth();
        setYear();
    }
    
    public void setDay()
    {
        day = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día: "));
        
        while(day < 1 || day > 31)
        {
            day = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un día correcto: "));
        }
    }
    public void setDay(int value){day = value;}
    public int getDay(){return day;}
    
    public void setMonth()
    {
        month = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes: "));
        
        while(month < 1 || month > 12)
        {
            month = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un mes correcto: "));
        }
    }
    public void setMonth(int value){month = value;}
    public int getMonth(){return month;}
    
    public void setYear(){year = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año: "));}
    public void setYear(int value){year = value;}
    public int getYear(){return year;}
    
    public void setMonthStr()
    {
        String months[] = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        ArrayList<String> monthList = new ArrayList();
        
        for(int i = 0; i < 12; i++)
        {
            monthList.add(months[i]);
        }
        
        monthStr = JOptionPane.showInputDialog(null, "Ingrese el mes (en formato String): ");
        
        while(!(monthList.contains(monthStr)))
        {
            monthStr = JOptionPane.showInputDialog(null, "Ingrese un mes correcto (en formato String): ");
        }
        month = ArrayUtils.indexOf(monthList, monthStr);
    }
    public void setMonthStr(String value){monthStr = value;}
    public String getMonthStr(){return monthStr;}
    
    public void showFechaFormat1()
    {
        JOptionPane.showMessageDialog(null, day + "/" + month + "/" + year);
    }
    
    public void showFechaFormat2()
    {
        JOptionPane.showMessageDialog(null, monthStr + " " + day + ", " + year);
    }
    
    public void showFechaFormat3()
    {
        JOptionPane.showMessageDialog(null, day + " " + monthStr + " " + year);
    }
}
