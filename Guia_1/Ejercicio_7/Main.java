package Ejercicios_Resueltos.JavaGuia.Ejercicio_7;

/******************************************************************************

Una biblioteca maneja libros, algunos de ellos son originales y otro son fotocopias. No todos los libros se prestan.
a) Crear la clase libro.
b) Agregar atributos: título, original y prestable.
c) Agregar métodos de instancia: 'getOriginal', 'getTitulo' y 'getPrestable'.
d) Agregar métodos de instancia 'esOriginal' y 'sePresta' que retornen el valor booleano correspondiente.
e) Agregar métodos de instancia 'setTitulo', 'setOriginal' y 'setPrestable'.
f) Crear un método main en una clase para prueba que permita obtener 2 instancias de Libro, uno de ellos es original y no se presta, 
   el otro es fotocopia y se presta. Utilizar los métodos de instancia para realizar estas operaciones. Mostrar los libros creados.

*******************************************************************************/
import java.util.ArrayList;
import javax.swing.*;

public class Main
{
	public static void main(String[] args) {
		//String [] array = {"YES", "NO"};
		String [] opcionesMenu = {"Agregar Libro", "Mostrar Libros", "Salir"};
		//int option = 0;
		int selection = 0;
		ArrayList<Libro> libros = new ArrayList<>();
		
		do
		{
            //unLibro = new Libro();
		    selection = Integer.valueOf(JOptionPane.showOptionDialog(null, "Seleccione opción de menú", "BIBLIOTECA", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, opcionesMenu, opcionesMenu[0]));
		    
		    switch(selection)
		    {
		        case 0:
	                Libro unLibro = new Libro();
		            libros.add(unLibro);
		            break;
		        case 1:
		            if(libros.size() > 0)
		            {
		                for(int i = 0; i < libros.size() ; i++)
		                {
		                    libros.get(i).mostrarLibros("Libro " + (i + 1));
		                }
		            }
		            else
		            {
		                JOptionPane.showMessageDialog(null, "Aún no se han cargado libros");
		            }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Hasta pronto");
		            
		    }
		    
		    
		    
		    
		}while(selection != 2);
	}
}

