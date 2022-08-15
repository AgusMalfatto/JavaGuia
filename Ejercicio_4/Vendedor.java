package Ejercicios_Resueltos.JavaGuia.Ejercicio_4;

import javax.swing.JOptionPane;

public class Vendedor {
    private String nombre;
    private Ventas[] ventasTotales = new Ventas[5];
    private float ganancias = 0;
    private float ganaciasTotales = 0;
    private String [] dias = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};

    public Vendedor()
    {
        setName();
        setVentas();
        setGanancia();
        setGananciasTotales();
    }

    public void setName(){nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del vendedor: ");}
    public String getName(){return this.nombre;}

    public Ventas setUnaVenta(int pos)
    {
        Ventas sell = new Ventas();
        return sell;
    }

    public void setVentas()
    {   String[] array = {"YES", "NO"};
        for(int i = 0; i < dias.length; i++)
        {
            String mensaje = "Ventas del día " + dias[i];
            int option = Integer.valueOf(JOptionPane.showOptionDialog(null, mensaje, "Lenovo", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, array, array[0]));
            
            if(option == 0)
            {
                ventasTotales[i] = new Ventas();
            }
            else
            {
                ventasTotales[i] = null;
            }
        }
        
    }
    

    public void setGanancia()
    {
        for(int i = 0; i < ventasTotales.length; i++) 
        {
            if(ventasTotales[i] != null)
            {
                ganancias += ventasTotales[i].getPrecioTotal();
            }
        }
    }
    public float getGanancia(){return ganancias;}

    public void setGananciasTotales(){ganaciasTotales = (6 * getGanancia() / 100) + 2000;}
    public float getGananciasTotales(){return ganaciasTotales;}

    public int getCantidadDias()
    {
        int amount = 0;
        for(int i = 0; i < ventasTotales.length; i++) 
        {
            if(ventasTotales[i] != null)
            {
                amount += ventasTotales[i].getCantidad();
            }
        }
        return amount;
    }

    public void mostrarVentas()
    {
        JOptionPane.showMessageDialog(null, "Nombre: " + getName() +
        "\nCantidad Total: " + getCantidadDias() +
        "\nGenerado en Ventas: " + getGanancia() + "$" +
        "\nGanancias del vendedor: " + getGananciasTotales() + "$");
    }

}
