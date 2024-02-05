package alphabet;

import java.util.ArrayList;
import java.util.Arrays;

public class EnglishAlphabet extends Alphabet {
    public final ArrayList<Character> ARRAY_LIST = new ArrayList<>(Arrays.asList(
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    ));
    public final ArrayList<String> FREQUENTLY_USED_WORDS = new ArrayList<>(Arrays.asList(
            "the", "and", "to", "of", "in", "is", "it", "you", "that",
            "he", "was", "for", "on", "are", "with", "as", "his", "they", "be",
            "at", "one", "have", "this", "from", "or", "had", "by", "but", "some",
            "what", "there", "we", "can", "out", "other", "were", "all", "your",
            "when", "up", "use", "how", "said", "an", "each", "she", "which", "do"
    ));

    public ArrayList<Character> getARRAY_LIST() {
        return ARRAY_LIST;
    }

    public ArrayList<String> getFREQUENTLY_USED_WORDS() {
        return FREQUENTLY_USED_WORDS;
    }
}
