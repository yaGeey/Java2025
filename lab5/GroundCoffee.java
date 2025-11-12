package lab5;

public class GroundCoffee extends Coffee {
   final String grindSize;
   public GroundCoffee(String name, double pricePerKg, double weight, 
         double packageVolume, int quality, String grindSize) {
      super(name, pricePerKg, weight, packageVolume, quality);
      
      if (grindSize == null || grindSize.trim().isEmpty()) throw new IllegalArgumentException("Grind size cannot be empty");
      
      this.grindSize = grindSize;
   }

   @Override
   public String getType() {
      return "Мелена";
   }

   @Override
   public String toString() {
      return super.toString() + ", помел: " + grindSize;
   }
}
