package Ejercicios_Resueltos.JavaGuia.Ejercicio_7;

import javax.swing.*;

public class Libro
{
    private String titulo;
    private String original;
    private String prestable;
    
    public Libro()
    {
        setTitulo();
        setOriginal();
        setPrestable();
    }
    
    public void setTitulo(){titulo = JOptionPane.showInputDialog(null, "Ingrese el título del libro: ");}
    public String getTitulo(){return titulo;}
    
    public void setOriginal()
    {
        String [] array = {"YES", "NO"};
        int option = Integer.valueOf(JOptionPane.showOptionDialog(null, "¿El libro es original?", "BIBLIOTECA", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, array, array[0]));
        
        if(option == 0)
        {
            original = "Original";
        }
        else
        {
            original = "Fotocopia";
        }
    }
    public boolean getOriginal()
    {
        if(original == "Original")
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public void setPrestable()
    {
        String [] array = {"YES", "NO"};
        int option = Integer.valueOf(JOptionPane.showOptionDialog(null, "¿El libro es prestable?", "BIBLIOTECA", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, array, array[0]));
        
        if(option == 0)
        {
            prestable = "Si";
        }
        else
        {
            prestable = "No";
        }
    }
    public boolean getPrestable()
    {
        if(prestable == "Si")
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    public void mostrarLibros(String mensaje)
    {
        JOptionPane.showMessageDialog(null, 
            "Título: " + getTitulo() + 
            "\nEs original: " + getOriginal() +
            "\nSe presta: " + getPrestable(), 
            mensaje, JOptionPane.INFORMATION_MESSAGE
            );
    }
    
}



















