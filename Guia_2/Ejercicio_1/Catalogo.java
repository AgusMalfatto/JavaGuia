//package Ejercicios_Resueltos.JavaGuia.Guia_2.Ejercicio_1;

import java.util.*;
import javax.swing.*;

public class Catalogo {
    private ArrayList<DVD> dataBase = new ArrayList<>();


    public void Actions()
    {
        String [] option = {"Añadir DVD", "Modificar DVD", "Eliminar DVD", "Volver"};
        int selection = JOptionPane.showOptionDialog(null, "Seleccione la opción que desee", "Acciones", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        switch(selection)
        {
            case 0:
                ingresarDVD();
                break;
            case 1:
                modificarDVD();
                break;
            case 2:
                deleteFilm();
                break;
        }
    }

    public void ingresarDVD()
    {
        DVD film = new DVD();
        JOptionPane.showMessageDialog(null, "Película añadida con éxito.");
        dataBase.add(film);
    }

    public void ConsultarDVD()
    {
    	String name = JOptionPane.showInputDialog(null, "Ingrese el nombre de la película", 
        "Consulta", JOptionPane.QUESTION_MESSAGE);
        DVD dvd = getDVD(name);

        if(dvd != null)
        {
            dvd.showDVD("Película: " + dvd.getName());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el registro: '" + name + "'");
        }
    }
    
    public void modificarDVD()
    {
        String name = JOptionPane.showInputDialog(null, "Ingrese el nombre de la película a modificar", 
        "Modificar", JOptionPane.QUESTION_MESSAGE);
        DVD dvd = getDVD(name);

        if(dvd != null)
        {
            MenuModificar(dvd);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el registro: '" + name + "'");
        }
    }

    public int getSize(){return dataBase.size();}

    public void deleteFilm()
    {
        if(dataBase.size() > 0)
        {
            String name = JOptionPane.showInputDialog(null, "Ingrese el nombre de la película que desee eliminar.");
            int flag = 0;
    
            for(int i = 0; i < dataBase.size(); i++)
            {
                if(name.equals(dataBase.get(i).getName()))
                {
                    dataBase.remove(i);
                    JOptionPane.showMessageDialog(null, "Película eliminada con éxito.");
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
            {
                JOptionPane.showMessageDialog(null, "No se encontró la película de nombre: '" + name + "'");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Aún no se han cargado películas.");
        }
        
    }

    public void list()
    {
        String [] option = {"Todos los DVDs", "Mi catálogo", "DVDs por tiempo", "DVDs por Director", "DVDs por títulos", "Volver"};
        int selection = JOptionPane.showOptionDialog(null, "¿Qué desea listar?", "Listado", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

        switch(selection)
        {
            case 0:
                showDataBase();
                break;
            case 1:
                showCatalog();
                break;
            case 2:
            	boolean timeAux = false;
                String timestr;
                int time;

                do
                {
                    timestr = JOptionPane.showInputDialog(null, "Ingrese el tiempo a filtrar: ");

                    timeAux = timestr.matches("[+-]?\\d*(\\.\\d+)?");

                }while(!timeAux);
                
                time = Integer.parseInt(timestr);
                showTitleTime(time);
                
            	break;
            case 3:
            	String name = JOptionPane.showInputDialog("Ingrese el nombre del director a filtrar: ");
            	showTitleDirector(name);
            	
            	break;
            case 4:
            	showTitleList();
            	break;
        }
    }

    private void showTitleList()
    {
    	String [] names = new String[getSize()];
    	
    	for(int i = 0; i < getSize(); i++)
    	{
    		names[i] = dataBase.get(i).getName();
    	}
    	
    	for(int i = 1; i < getSize(); i++)
    	{
    		String aux = names[i];
    		int j = i - 1;
    		while(j >= 0 && (aux.compareTo(names[j]) < 0))
			{
    			names[j + 1] = names[j];
    			j--;
			}
    		names[j + 1] = aux;    		
    	}
    	
    	showTitleListSorted(names);
    	
    }
    
    private void showTitleListSorted(String [] names)
    {
    	for(int i = 0; i < getSize(); i++)
    	{
    		DVD film = getDVD(names[i]);
    		JOptionPane.showMessageDialog(null, 
    				"Nombre: " + film.getName() +
    				"\nDirector: " + film.getDirector() +
    				"\nGénero: " + film.getGender() +
    				"\nDuración: " + film.getTime() +
    				"\nEn Stock: " + film.getHave() +
    				"\nComentario: " + film.getComment()
    				);
    	}
    }
    
    private void showTitleTime(int time)
    {
    	for(int i = 0; i < getSize(); i++)
    	{
    		if(dataBase.get(i).getTime() < time)
    		{
    			dataBase.get(i).showDVD("Película: " + dataBase.get(i).getName());
    		}
    	}
    }
    
    private void showTitleDirector(String name)
    {
    	for(int i = 0; i < getSize(); i++)
    	{
    		if(dataBase.get(i).getDirector().equals(name))
    		{
    			dataBase.get(i).showDVD("La película es: " + dataBase.get(i).getName());
    		}
    	}
    }
    
    private static String formatString (String msg)
    {
    	if (msg.length() > 20)
    		return msg.substring(0, 21);
    	else
    	{
    		int espacios = 20 - msg.length();
    		for (int i = 1; i <= espacios; i++)
    			msg = msg + " ";
    	    return msg;
    	}
    }
    
    public void showDataBase()
    {
    	
    	
    	String info = "";
        for(int i = 0; i < dataBase.size(); i++)
        {
        	info += (String.format("%20s | %20s | %-15d | %-15b | %-15s \n", 
        			formatString(dataBase.get(i).getName()), formatString((dataBase.get(i).getGender()).toString()), 
        			dataBase.get(i).getTime(), dataBase.get(i).getHave(), formatString(dataBase.get(i).getComment())));
        }
        JOptionPane.showMessageDialog(null, info);
    }

    public void showCatalog()
    {
        int k = 1;
        for(int i = 0; i < dataBase.size(); i++)
        {
            if(dataBase.get(i).getHave())
            {
                dataBase.get(i).showDVD("Mi catálogo: Película " + (k + 1));
                k++;
            }
            
        }
    }

    public void MenuModificar(DVD film)
    {
        Object selection;
        String selectionStr = "Volver";
        do
        {
            String [] option = {"Nombre", "Director", "Género", "Tiempo", "Adquirido", "Comentario", "Volver"};
            selection = JOptionPane.showInputDialog(null, "¿Qué desea modificar?", "Modificación", JOptionPane.QUESTION_MESSAGE,
            null, option, option[0]);

            if(selection != null)
            {
                selectionStr = selection.toString();
                switch(selectionStr)
                {
                    case "Nombre":
                        film.setName("Ingrese el nuevo Título");
                        break;
                    case "Director":
                        film.setDirector("Ingrese el nuevo nombre del director");
                        break;
                    case "Género":
                        film.setGender("Ingrese el nuevo género");
                        break;
                    case "Tiempo":
                        film.setTime("Ingrese la nueva duración");
                        break;
                    case "Adquirido":
                        film.setHave("¿Posee el DVD?");
                        break;
                    case "Comentario":
                        film.setComment("Seleccione la nueva calificación");
                        break;
                }        
            }

            
        }while(!(selectionStr.equals("Volver")) && selection != null);

    }

    public DVD getDVD(String name)
    {
        for(int i = 0; i < dataBase.size(); i++)
        {
            if((dataBase.get(i).getName()).equals(name))
            {
                return dataBase.get(i);
            }
        }

        return null;
    }
}
