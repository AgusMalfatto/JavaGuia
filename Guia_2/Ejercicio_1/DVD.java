//package Ejercicios_Resueltos.JavaGuia.Guia_2.Ejercicio_1;

import javax.swing.JOptionPane;

enum Gender
{
    ACCION, AVENTURA, ROMANCE, ANIMADA, TERROR, COMEDIA, FANTASIA, CIENCIA_FICCION;
}

public class DVD 
{
    private String name;
    private String director;
    private Gender gender;
    private int time;
    private boolean have;
    private String comment;

    public DVD()
    {
        setName("Ingrese el nombre de la película.");
        setDirector("Ingrese el nombre del director.");
        setGender("Seleccione el género");
        setTime("Ingrese la duración de la película (en minutos).");
        setHave("¿Posee el DVD?");
        setComment("Califique la película.");
    }
    
    public void setName(String message){this.name = JOptionPane.showInputDialog(null, message);}
    public String getName(){return this.name;}

    public void setDirector(String message){this.director = JOptionPane.showInputDialog(null, message);}
    public String getDirector(){return this.director;}

    public void setGender(String message)
    {
        String [] array = {"ACCION", "AVENTURA", "ROMANCE", "ANIMADA", "TERROR", "COMEDIA", "FANTASIA", "CIENCIA_FICCION"};
        String gender = (JOptionPane.showInputDialog(null, message, null, JOptionPane.QUESTION_MESSAGE, 
        null, array, array[0])).toString();

        this.gender = Gender.valueOf(gender);
    }
    public Gender getGender(){return this.gender;}

    public void setTime(String message)
    {
        boolean time = false;
        String timestr;

        do
        {
            timestr = JOptionPane.showInputDialog(null, message);

            time = timestr.matches("[+-]?\\d*(\\.\\d+)?");

        }while(!time);
        
        this.time = Integer.parseInt(timestr);
    }
    
    public int getTime(){return this.time;}

    public void setHave(String message)
    {
        String [] array = {"YES", "NO"};
        int have = JOptionPane.showOptionDialog(null, message, null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
        null, array, array[0]);

        switch(have)
        {
            case 0:
                this.have = true;
                break;
            case 1:
                this.have = false;
                break;
        }
    }
    public boolean getHave(){return this.have;}

    public void setComment(String message)
    {
        String [] commentOption = {"EXCELENTE", "MUY BUENA", "BUENA", "REGULAR", "MALA"};

        this.comment = (JOptionPane.showInputDialog(null, message, null, JOptionPane.QUESTION_MESSAGE, null, 
        commentOption, commentOption[0]).toString());

    }
    public String getComment(){return this.comment;}

    public void showDVD(String message)
    {
    	String info = String.format("Nombre %.15s \n Género: %.15s \n Duración: %.15s \n Lo tengo: %.15b \n Comentario: %.15s", 
    			getName(), getGender(), getTime(), getHave(), getComment());
        JOptionPane.showMessageDialog(null, 
        info,
        message, JOptionPane.INFORMATION_MESSAGE
        );
    }

}
