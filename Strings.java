// Із заданого тексту видалити всі слова визначеної довжини, що починаються з приголосної літери. 
public class Strings {
   private static final char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

   public static void main(String[] args) {
      StringBuffer s = new StringBuffer("Cat dog sun tree bird fox car ant");
      System.out.println("Original string: " + s);

      int targetLength = 3;
      StringBuffer result = removeConsonantWordsOfLength(s, targetLength);
      System.out.println("removeConsonantWordsOfLength " + targetLength + ": " + result);
   }
   
   public static StringBuffer removeConsonantWordsOfLength(StringBuffer s, int length) {
      StringBuffer result = new StringBuffer();
      String[] words = s.toString().split(" ");
      for (String word : words) {
         if (word.length() != length || !isConsonant(word.charAt(0))) {
            result.append(word).append(" ");
         }
      }
      return result;
   }

   public static boolean isConsonant(char c) {
      c = Character.toLowerCase(c);
      for (char consonant : consonants) {
         if (c == consonant) return true;
      }
      return false;
   }
}
