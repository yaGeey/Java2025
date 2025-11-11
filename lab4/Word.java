package lab4;
import java.util.ArrayList;
import java.util.List;

public class Word {
   private List<Letter> letters;

   Word(List<Letter> letters) {
      this.letters = new ArrayList<>(letters);
   }

   public int getSize() {
      return letters.size();
   }
}
