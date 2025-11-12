package lab5;

public class CapsuleCoffee extends Coffee {
   final String capsuleSystem;
   final int capsulesCount;

   public CapsuleCoffee(String name, double pricePerKg, double weight, double packageVolume,
         int quality, String capsuleSystem, int capsulesCount) {
      super(name, pricePerKg, weight, packageVolume, quality);
      
      if (capsuleSystem == null || capsuleSystem.trim().isEmpty()) throw new IllegalArgumentException("Capsule system type cannot be empty");
      if (capsulesCount <= 0) throw new IllegalArgumentException("Capsules amount must be > 0");
      
      this.capsuleSystem = capsuleSystem;
      this.capsulesCount = capsulesCount;
   }

   @Override
   public String getType() {
      return "Капсули";
   }

   @Override
   public String toString() {
      return super.toString() + ", система: " + capsuleSystem + ", капсул: " + capsulesCount;
   }
}
