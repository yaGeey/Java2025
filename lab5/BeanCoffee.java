package lab5;

public class BeanCoffee extends Coffee {
   private String roastLevel;

   public BeanCoffee(String name, double pricePerKg, double weight, 
         double packageVolume, int quality, String roastLevel) {
      super(name, pricePerKg, weight, packageVolume, quality);
      
      if (roastLevel == null || roastLevel.trim().isEmpty()) throw new IllegalArgumentException("Roast level cannot be empty");
      
      this.roastLevel = roastLevel;
   }

   @Override
   public String getType() {
      return "Зерно";
   }

   @Override
   public String toString() {
      return super.toString() + ", обсмаження: " + roastLevel;
   }
}
