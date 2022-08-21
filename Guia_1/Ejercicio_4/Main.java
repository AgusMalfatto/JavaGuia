/*
El sector de ventas online de notebooks Lenovo paga a sus vendedores mediante comisiones. Los
vendedores reciben $2000 por semana, más el 6% de sus ventas brutas durante esa semana. Por
ejemplo, un vendedor que vende $50000 de mercancía en una semana, recibe $2000 más el 6% de
$50000, un total de $5000.
Desarrolle una aplicación en JAVA que reciba como entrada los artículos vendidos por un
vendedor durante cada día de la última semana, y que calcule y muestre los ingresos de ese
vendedor. No hay límite en cuanto al número de artículos que un representante puede vender.
*/

package Ejercicios_Resueltos.JavaGuia.Ejercicio_4;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String [] array = {"YES", "NO"};
        int option = 0;
        do
        {
            Vendedor un_Vendedor = new Vendedor();
            un_Vendedor.mostrarVentas();            

            option = Integer.valueOf(JOptionPane.showOptionDialog(null, "¿Desea cargar otro vendedor?", "Lenovo", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, array, array[0]));

        }while(option != 1);
    }
}
