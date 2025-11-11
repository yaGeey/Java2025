package lab2;
/**
 * Клас Strings містить методи для роботи з рядками.
 * Основна функція — видалити всі слова певної довжини, що починаються з приголосної.
 */
public class Strings {
   /** Масив приголосних літер англійського алфавіту (immutable). */
   private static final char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's',
         't', 'v', 'w', 'x', 'y', 'z' };
   
   public static void main(String[] args) {
      StringBuffer s = new StringBuffer("Cat dog sun tree bird fox ant car");
      System.out.println("Original string: " + s);

      int targetLength = 3;
      StringBuffer result = removeConsonantWordsOfLength(s, targetLength);
      System.out.println("removeConsonantWordsOfLength " + targetLength + ": " + result);
   }
   
   /**
     * Видаляє з рядка всі слова заданої довжини, які починаються з приголосної.
     *
     * @param s рядок для обробки у вигляді StringBuffer
     * @param length довжина слів, які потрібно видалити
     * @return новий StringBuffer з обробленим рядком
     */
   public static StringBuffer removeConsonantWordsOfLength(StringBuffer s, int length) {
      StringBuffer result = new StringBuffer(); // result string
      StringBuffer currentWord = new StringBuffer(); // current word temp buffer

      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i); // checking symbol by symbol
         if (c == ' ') {
            // if space - end of the word
            if (currentWord.length() != length || !isConsonant(currentWord.charAt(0))) {
               // adding word to result if satisfies constrains...
               result.append(currentWord).append(" ");
            }
            // ...and cleaning cur word
            currentWord.setLength(0);
         } else {
            // if not space - adding char to cur word
            currentWord.append(c);
         }
      }

      // processing last word if it exists (if there is no space after it)
      if (currentWord.length() > 0) {
         if (currentWord.length() != length || !isConsonant(currentWord.charAt(0))) {
            result.append(currentWord).append(" ");
         }
      }
      return result;
   }

   /**
     * Перевіряє, чи є символ приголосною літерою.
     *
     * @param c символ для перевірки
     * @return true, якщо символ приголосний, false — інакше
     */
   public static boolean isConsonant(char c) {
      c = Character.toLowerCase(c);
      for (char consonant : consonants) {
         if (c == consonant) return true;
      }
      return false;
   }
}
