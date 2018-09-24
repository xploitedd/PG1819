public class Programa {
    public static void main(String[] args) {
        if (args.length >= 2 && args[0].equalsIgnoreCase("--name")) {
            System.out.println("Hello " + args[1]);
            return;
        }

        System.out.println("Por favor usa o teu nome com --name!");
    }
}