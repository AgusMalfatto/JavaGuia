package Ejercicios_Resueltos.JavaGuia.Ejercicio_3b;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
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
