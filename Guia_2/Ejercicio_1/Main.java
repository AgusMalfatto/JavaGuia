//package Ejercicios_Resueltos.Guia_2.Ejercicio_1;

import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args) 
    {
        Catalogo miCatalogo = new Catalogo();
        int selection;       
        String [] optionMenu = {"Acciones", "Listados", "Consultar DVD", "Salir"};
        
        do
        {
        	int DVDs = miCatalogo.getSize();
            selection = JOptionPane.showOptionDialog(null, "DVDs: " + DVDs + "\nSeleccione una opción", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
            null, optionMenu, optionMenu[0]);

            switch(selection)
            {
                case 0:
                    miCatalogo.Actions();
                    break;
                case 1:
                    if(miCatalogo.getSize() > 0)
                    {
                        miCatalogo.list();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Aún no se han cargado DVDs.");
                    }
                    break;
                case 2:
                	miCatalogo.ConsultarDVD();
                	break;
            }
        }while(selection != 3 && selection != -1);
        
        JOptionPane.showMessageDialog(null, "Hasta pronto");
    }

  
}
