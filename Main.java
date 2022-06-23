import java.util.*;

/*
Character, Frequency (in thousands), Fixed-length codeword, Variable-length codeword
a 45 000 0
b 13 001 101
c 12 010 100
d 16 011 111
e 9 100 1101
f 5 101 1100
*/

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Pair<Character, Integer>> d = new ArrayList<>();
        d.add(new Pair<Character, Integer>('a', 45));
        d.add(new Pair<Character, Integer>('b', 13));
        d.add(new Pair<Character, Integer>('c', 12));
        d.add(new Pair<Character, Integer>('d', 16));
        d.add(new Pair<Character, Integer>('e', 9));
        d.add(new Pair<Character, Integer>('f', 5));

        String sequence = s.nextLine();
        HuffmanTree tree = new HuffmanTree(d);

        System.out.println(String.format("Coded String: %s\n\nDecoded String: %s\n\n", sequence, tree.decodeSequence(sequence)));
    };
};
