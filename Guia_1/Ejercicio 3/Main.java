/******************************************************************************

Cree una clase llamada Fecha, que incluya 3 variables de instancia: un mes (int), un dia (int) y un año (int).
Su clase debe tener un constructor que inicialice las tres variables de instancia, y debe verificar que los vlaores que se proporcionan 
son correctos. Proporcione los métodos get y set para cada variable de instancia. Proporcione un método mostrarFecha, para imprimir la fecha en varios 
formatos, como:
    - 05/21/2010
    - Junio 14, 2012
    - 20 Agosto 11
Usar constructores sobrecargados para crear objetos Fecha inicializados con fechas de los formatos solicitados para imprimir. En el primer caso, el constructor
debe recibir tres valores enteros. En el segundo caso, debe recibir un objeto String y dos valores enteros. En el tercero debe recibir un valor entero, String 
y otro entero. Escribir una aplicación de prueba llamada PruebaFecha, que demuestre las capacidades de la clase Fecha.

*******************************************************************************/
import javax.swing.JOptionPane;

public class Main
{
	public static void main(String[] args) 
	{
		Fecha fecha1 = new Fecha();
		String arreglo[] = {"dd/mm/aaaa", "MES dd, aaaa", "dd MES aaaa", "Salir"};
		int option = 0;

        while(option != 3)
        {    
            option = Integer.valueOf(JOptionPane.showOptionDialog(null, "Elija un formato de fecha", "FECHAS", 
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, arreglo, arreglo[0]));
            
            switch(option)
            {
                case 0:
                    fecha1.showFechaFormat1();
                    break;
                case 1:
                    fecha1.showFechaFormat2();
                    break;
                case 2:
                    fecha1.showFechaFormat3();
                    break;
            }
        }
	}
}
