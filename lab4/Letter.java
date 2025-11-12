package lab4;
/**
 * Клас Letter представляє одну літеру в тексті.
 * Містить методи для перевірки типу символу (приголосна, голосна).
 */
public class Letter {
   private char value;
   public Letter(char value) {
      this.value = value;
   }
   
   /**
    * Перевіряє, чи є літера приголосною.
    * Підтримує англійські та українські приголосні літери.
    * @return true, якщо літера приголосна, false - інакше
    */
   public boolean isConsonant() {
      return ("bcdfghjklmnpqrstvwxyz" + "бвгґджзклмнпрстфхцчшщ").indexOf(Character.toLowerCase(value)) != -1;
   }

   /**
    * Повертає значення літери.
    * @return символ літери
    */
   public char get() {
      return value;
   }

   /**
    * Представлення літери у вигляді рядка.
    * @return літера як String
    */
   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
