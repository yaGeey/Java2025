package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word представляє слово як послідовність літер.
 * Містить методи для роботи зі словом (отримання довжини, перевірка першої літери).
 */
public class Word {
   private List<Letter> letters;

   public Word(List<Letter> letters) {
      this.letters = new ArrayList<>(letters);
   }
   public Word(String word) {
      this.letters = new ArrayList<>();
      for (char c : word.toCharArray()) {
         letters.add(new Letter(c));
      }
   }

   /**
    * Повертає довжину слова.
    * @return кількість літер у слові
    */
   public int getSize() {
      return letters.size();
   }

   /**
    * Перевіряє, чи починається слово з приголосної літери.
    * @return true, якщо слово починається з приголосної, false - інакше
    */
   public boolean startsWithConsonant() {
      if (letters.isEmpty()) {
         return false;
      }
      return letters.get(0).isConsonant();
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      for (Letter letter : letters) {
         sb.append(letter.toString());
      }
      return sb.toString();
   }
}
