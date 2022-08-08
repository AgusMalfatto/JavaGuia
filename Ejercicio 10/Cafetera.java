import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Cafetera {
    private long capacidadMaxima;
    private long cantidadActual;
    private int cups = 0;

    public Cafetera()
    {
        capacidadMaxima = 1000;
        cantidadActual = 0;
    }

    public Cafetera(long cantidad)
    {
        capacidadMaxima = cantidadActual = cantidad;
    }

    public Cafetera(long cantidad, long capacidad)
    {
        capacidadMaxima = capacidad;
        cantidadActual = cantidad;
        if(cantidad > capacidad)
        {
            cantidadActual = capacidad;
        }
    }

    public long getCapacidad(){return capacidadMaxima;}
    public long getCantidad(){return cantidadActual;}
    public void setCantidad(long value){cantidadActual = value;}

    public void llenarCafetera(){cantidadActual = capacidadMaxima;}
    public void agregarCafe()
    {
        if(cantidadActual == capacidadMaxima)
        {
            JOptionPane.showMessageDialog(null, "La máquina se encuentra llena");
        }
        else
        {    
            long newValue = Integer.valueOf(JOptionPane.showInputDialog("Cantidad de café que desee agregar: "));

            if(capacidadMaxima < newValue)
            {
                newValue = capacidadMaxima;
            }
            setCantidad(newValue);
        }
    }
    public void vaciarCafetera(){cantidadActual = 0;}
    public void servirTaza()
        {
            if(cantidadActual > 0)
            {    
                long cup = Integer.valueOf(JOptionPane.showInputDialog("Cantidad de café en la taza: "));
                
                if(cantidadActual < cup)
                {
                    cantidadActual = 0;   
                }
                else
                {
                    cantidadActual -= cup;
                }
                cups++;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No hay café en la máquina");
            }

        }
    public void mostrarCafetera()
    {
        JOptionPane.showMessageDialog(null, "Capacidad máxima: " + capacidadMaxima + "\nCantidad Actual: " + cantidadActual +
        "\nTazas serivdas: " + cups);
    }
    public Icon getIcono()
    {
        Icon icono = new ImageIcon(getClass().getResource("cafe.png"));
        return icono;
    }
}
