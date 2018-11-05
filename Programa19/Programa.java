public class Programa {
    public static void main(String[] args) {
        int[] counter = new int['z' - 'a' + 1];
        for (String n : args) {
            for (char s : n.toLowerCase().toCharArray()) {
                if (s >= 'a' && s <= 'z')
                    ++counter[s - 'a'];
            }
        }

        int max = 0;
        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] > max)
                max = counter[i];
        }

        for (; max > 0; --max) {
            for (int i = 0; i < counter.length; ++i) {
                if (counter[i] == 0)
                    continue;

                System.out.print(counter[i] >= max ? "# " : "  ");
            }

            System.out.println();
        }

        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] == 0)
                continue;

            System.out.print("= ");
        }

        System.out.println();

        for (int i = 0; i < counter.length; ++i) {
            if (counter[i] == 0)
                continue;

            System.out.print((char) (i + 'a') + " ");
        }
    }
}