package Ejercicios_Resueltos.Guia_2.Ejercicio_1;

import javax.swing.JOptionPane;

public class Main 
{
    public static void main(String[] args) 
    {
        Catalogo miCatalogo = new Catalogo();
        String [] optionMenu = {"Acciones", "Listados", "Consultar DVD", "Salir"};
        int selection;

        do
        {
            selection = JOptionPane.showOptionDialog(null, "Seleccione una opción", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
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
                case 3:
                    JOptionPane.showMessageDialog(null, "Hasta pronto");
            }
        }while(selection != 3);
    }

    
}
