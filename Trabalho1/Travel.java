import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Partida? ");
        int hp = s.nextInt(); // Hora de partida
        int mp = s.nextInt(); // Minuto de partida
        int sp = s.nextInt(); // Segundo de partida
        System.out.print("Chegada? ");
        int hc = s.nextInt(); // Hora de chegada
        int mc = s.nextInt(); // Minuto de chegada
        int sc = s.nextInt(); // Segundo de chegada
        
        // Estas médias não podem ser feitas e portanto devem ser substituidas
        int mh = (hp + hc) / 2;
        int mms = (mp + mc + sp + sc) / 4;
        if (mh >= 0 && mh <= 23 || mms >= 0 && mms <= 59) {
            hc = hc - hp;
            mc = mc - mp;
            sc = sc - sp;

            if (hc < 0 || (hc == 0 && mc < 0) || (hc == 0 && mc == 0 && sc < 0)) {
                System.out.println("Partida > Chegada");
            } else {
                sc = 60 - sc;
                if (hc > 0)
                    mc = 60 - mc;

                if (sc > 0)
                    mc = mc - 1
            }
        } else {
            System.out.println("Os valores apresentados não são válidos!");
        }
    }
}