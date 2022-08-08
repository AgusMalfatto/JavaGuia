/* 
Desarrolla una clase Cafetera con atributos _capacidadMaxima (la cantidad máxima de café que
puede contener la cafetera) y _cantidadActual (la cantidad actual de café que hay en la cafetera).
Implementa, al menos, los siguientes métodos:
 Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.) y la actual en cero
(cafetera vacía).
 Constructor con la capacidad máxima de la cafetera; inicializa la cantidad actual de café igual a
la capacidad máxima.
 Constructor con la capacidad máxima y la cantidad actual. Si la cantidad actual es mayor que la
capacidad máxima de la cafetera, la ajustará al máximo.
 analizadores y modificadores.
 llenarCafetera():hace que la cantidad actual sea igual a la capacidad.
 servirTaza(int): simula la acción de servir una taza con la capacidad indicada. Si la cantidad
actual de café “no alcanza” para llenar la taza, se sirve lo que quede.
 vaciarCafetera(): pone la cantidad de café actual en cero.
 agregarCafe(int): añade a la cafetera la cantidad de café indicada.
*/

import javax.swing.JOptionPane;
import javax.swing.Icon;


public class Ejercicio10
{
    
    public static void main(String[] args) {
        long capacity = Long.parseLong(JOptionPane.showInputDialog("Ingrese la capacidad: "));
        long amount = Long.parseLong(JOptionPane.showInputDialog("Ingrese la cantidad de café: "));
        Cafetera cafe = new Cafetera(amount, capacity);         
        Icon newIcon = cafe.getIcono();
        String [] arreglo = {"\nLlenar cafetera", "\nServir taza", 
        "\nVaciar cafetera", "\nAgregar café", "Estado de cafetera", "Salir"};
        int option = 0;

        while(option != 5)
        {    
            option = Integer.valueOf(JOptionPane.showOptionDialog(null, "\tElija una opción", "CAFETERÍA PININI MOLINO", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, newIcon, arreglo, arreglo[0]));


            switch(option)
            {
                case 0:
                    cafe.llenarCafetera();
                    break;
                case 1:
                    cafe.servirTaza();
                    break;
                case 2:
                    cafe.vaciarCafetera();
                    break;
                case 3:
                    cafe.agregarCafe();
                    break;
                case 4:
                    cafe.mostrarCafetera();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Hasta pronto!");
                    break;
            }

        }
    }
}
