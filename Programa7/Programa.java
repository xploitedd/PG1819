public class Programa {
    public static void main(String[] args) {
        if (args.length % 2 != 0) {
            System.out.println("Os parametros estao errados!");
            return;
        }
        
        String name = null;
        String localidade = null;
        
        for (int i = 0; i < args.length; ++i) {
            if (i % 2 == 0) {
                String param = args[i + 1];
                switch (args[i]) {
                    case "--name":
                        name = param;
                        break;
                    case "--loc":
                        localidade = param;
                        break;
                    default:
                        break;
                }
            } else {
                continue;
            }
        }

        if (name == null || localidade == null) {
            System.out.println("You signup form isn't complete!");
            return;
        }

        System.out.println("Hey " + name + " from " + localidade);
    }
}