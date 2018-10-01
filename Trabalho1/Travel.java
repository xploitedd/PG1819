import java.util.Scanner;

public class Travel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Partida? ");
        int hp = s.nextInt();
        int mp = s.nextInt();
        int sp = s.nextInt();
        System.out.print("Chegada? ");
        int hc = s.nextInt();
        int mc = s.nextInt();
        int sc = s.nextInt();
        
        int mh = (hp + hc) / 2;
        int mms = (mp + mc + sp + sc) / 4;
        if (mh >= 0 && mh <= 23 || mms >= 0 && mms <= 59) {
            hc = hc - hp;
            mc = mc - mp;
            sc = sc - sp;

            if (hc < 0 || (hc == 0 && mc < 0) || (hc == 0 && mc == 0 && sc < 0)) {
                System.out.println("Partida > Chegada");
            } else {

            }
        } else {
            System.out.println("Os valores apresentados não são válidos!");
        }
    }
}