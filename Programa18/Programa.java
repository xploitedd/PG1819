public class Programa {
    public static void main(String[] args) {
        int[] counter = new int['z' - 'a' + 1];
        for (String n : args) {
            for (char s : n.toLowerCase().toCharArray()) {
                if (s >= 'a' && s <= 'z')
                    ++counter[s - 'a'];
            }
        }

        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] == 0)
                continue;

            System.out.print((char) (i + 'a') + " | ");
            for (int j = 0; j < counter[i]; ++j)
                System.out.print("#");

            System.out.println();
        }
    }
}