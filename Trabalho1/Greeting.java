import java.util.Scanner;
import java.time.LocalTime;

public class Greeting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Hora (auto)? ");
        String input = s.next();

        char first = input.charAt(0);
        char second = input.charAt(1);
        int hora;
        if (first < '0' || first > '9') {
            System.out.println(((int) first) - 48);
        } else if (first >= '0' && second >= '0') {
            if (first == '2' && second <= '3' || first < '2') {
                hora = LocalTime.now().getHour();
                System.out.println("Hora = " + hora);
            }
        }
    }
}