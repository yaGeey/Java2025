package lab4;

/**
 * Клас Punctuation представляє розділовий знак у тексті.
 * Може бути комою, крапкою, знаком оклику, питання тощо.
 */
public class Punctuation {
   private char value;

   public Punctuation(char value) {
      if (".,!?".indexOf(Character.toLowerCase(value)) == -1) return;
      this.value = value;
   }

   public char get() {
      return value;
   }

   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
