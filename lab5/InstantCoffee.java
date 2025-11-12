package lab5;

public class InstantCoffee extends Coffee {
   final String packagingType;
   final boolean isFreezeDried;

   public InstantCoffee(String name, double pricePerKg, double weight, double packageVolume,
         int quality, String packagingType,boolean isFreezeDried) {
      super(name, pricePerKg, weight, packageVolume, quality);
      
      if (packagingType == null || packagingType.trim().isEmpty()) throw new IllegalArgumentException("Packaging type cannot be empty");
      
      this.packagingType = packagingType;
      this.isFreezeDried = isFreezeDried;
   }

   @Override
   public String getType() {
      return "Розчинна";
   }

   @Override
   public String toString() {
      String freezeDriedInfo = isFreezeDried ? "сублімована" : "звичайна";
      return super.toString() + ", упаковка: " + packagingType + ", тип: " + freezeDriedInfo;
   }
}
