package helpers;

public class StringHelper {

    public static boolean areWordsEqual(String firstWord, String secondWord, boolean isCaseSensitive) {
        if (firstWord.contains(" ") || secondWord.contains(" "))
            throw new RuntimeException("Parameters contain whitespaces.");
        return isCaseSensitive ? firstWord.equals(secondWord) : firstWord.equalsIgnoreCase(secondWord);
    }

    public static boolean areSentencesEqual(String firstSentence, String secondSentence, boolean isCaseSensitive) {
        return isCaseSensitive ? firstSentence.equals(secondSentence) : firstSentence.equalsIgnoreCase(secondSentence);
    }

    public static int getWordsCountFromText(String text) {
        return text.split(" ").length;
    }

    public static int getCharsCount(String text) {
        return text.length();
    }

    public static String removeCharFirst(String word, char charToBeRemoved) {
        String regex = "\\" + charToBeRemoved;
        return word.replaceFirst(regex, "");
    }
    public static String removeNormalCharFirst(String word, char charToBeRemoved) {
        return word.replaceFirst(Character.toString(charToBeRemoved), "");
    }
    public static String removeAll(String word, char charToBeRemoved) {
        String regex = "\\" + charToBeRemoved;
        return word.replaceAll(regex, "");
    }
    public static String removeNormalAll(String word, char charToBeRemoved) {
        return word.replaceAll(Character.toString(charToBeRemoved), "");
    }

}

