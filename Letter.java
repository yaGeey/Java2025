public class Letter {
   char value;

   Letter(char value) {
      this.value = value;
   }
   
   public boolean isConsonant() {
      return "bcdfghjklmnpqrstvwxyz".indexOf(Character.toLowerCase(value)) != -1;
   }
}
