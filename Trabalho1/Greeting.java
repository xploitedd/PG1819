import java.time.LocalTime;
import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Hora (auto)? ");
        int hora;
        if (s.hasNextInt()) {
            hora = s.nextInt();
        } else {
            hora = LocalTime.now().getHour();
            System.out.println("Hora = " + hora);
        }

        s.nextLine();
        System.out.print("Nome? ");
        String var = s.nextLine();

        // (0 - 6) || (18 - 23) -> Boa noite, 
        // (7 - 12) -> Bom dia,
        // (12 - 17) -> Boa tarde

        if (hora >= 7 && hora <= 12)
            var = "Bom dia " + var;
        else if (hora >= 13 && hora <= 17)
            var = "Boa tarde " + var;
        else
            var = "Boa noite " + var;

        System.out.println(var);
    }
}