package Ejercicios_Resueltos.JavaGuia.Ejercicio_4;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ventas {
    private ArrayList <String> productos = new ArrayList<>();
    private ArrayList <Float> precios = new ArrayList<>();
    private ArrayList <Integer> cantidad = new ArrayList<>();

    public Ventas()
    {
        setVentas();
    }

    public void setVentas()
    {
        String[] array = {"YES", "NO"};
        int option = 0;
        do
        {
            setProducto();
            setPrecio();
            setCantidad();

            option = Integer.valueOf(JOptionPane.showOptionDialog(null, "¿Desea cargar otra venta?", "Lenovo", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, array, array[0]));

        }while(option != 1);
    }

    public void setProducto()
    {
        String prod = JOptionPane.showInputDialog(null, "Ingrese el producto vendido: ");
        productos.add(prod);
    }
    public void setPrecio()
    {
        float price = 0;
        do
        {
            price = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el precio del producto: "));            
        }while(price <= 0);
        precios.add(price);
    }
    public float getPrecioTotal()
    {
        float cant = 0;
        for(int i = 0; i < precios.size(); i++)
        {
            cant += (precios.get(i) * cantidad.get(i));
        }
        return cant;
    }

    public void setCantidad()
    {
        int amount = 0;
        do
        {
            amount = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese cantidad de productos vendidos: "));
        }while(amount <= 0);
        cantidad.add(amount);
    }
    public int getCantidad()
    {
        int cantTotal = 0;
        for(int i = 0; i < cantidad.size(); i++)
        {
            cantTotal += cantidad.get(i);
        }
        return cantTotal;
    }
}
