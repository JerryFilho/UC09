package aula6;
import java.util.Scanner;
public class AmPm {

    public static String timeString(int hora, int minuto){
        String ampm;
        
        if (hora < 12) {
            ampm = "AM";
               if (hora == 0){
                    hora =12;
               }
        } else{
            ampm = "PM";
            hora = hora -12;
        }
        return String.format("%02d:%02d %s", hora, minuto, ampm);
    }

    public static void main(String[] args) {
        
        System.out.println(timeString(8, 16));
    }

}
