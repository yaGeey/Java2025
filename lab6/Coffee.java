package lab6;

/**
 * Abstract class Coffee represents common characteristics of coffee.
 * Base class for all coffee types (bean, ground, instant).
 * 
 * @author yaGeey
 * @version 1.0
 */
public abstract class Coffee implements Comparable<Coffee> {
   /** Coffee variety name */
   protected final String name;
   
   /** Price per kilogram */
   protected final double pricePerKg;
   
   /** Coffee weight */
   protected final double weight;
   
   /** Package volume */
   protected final double packageVolume;
   
   /** Coffee quality (1-10) */
   protected final int quality;

   /**
    * Constructor creates coffee with given parameters.
    * 
    * @param name variety name
    * @param pricePerKg price per kilogram
    * @param weight coffee weight
    * @param packageVolume package volume
    * @param quality coffee quality (1-10)
    * @throws IllegalArgumentException if parameters are invalid
    */
   public Coffee(String name, double pricePerKg, double weight, double packageVolume, int quality) {
      if (name == null || name.trim().isEmpty()) {
         throw new IllegalArgumentException("Name cannot be empty");
      }
      if (pricePerKg <= 0 || weight <= 0 || packageVolume <= 0) {
         throw new IllegalArgumentException("Values must be > 0");
      }
      if (quality < 1 || quality > 10) {
         throw new IllegalArgumentException("Quality must be between 1 and 10");
      }
      
      this.name = name;
      this.pricePerKg = pricePerKg;
      this.weight = weight;
      this.packageVolume = packageVolume;
      this.quality = quality;
   }

   /**
    * Calculates total price.
    * 
    * @return price = pricePerKg * weight
    */
   public double getTotalPrice() {
      return pricePerKg * weight;
   }

   /**
    * Abstract method to get coffee type.
    * 
    * @return coffee type (bean, ground, instant)
    */
   public abstract String getType();

   /**
    * Compares coffee by price per kg.
    * 
    * @param other another coffee object
    * @return comparison result
    */
   @Override
   public int compareTo(Coffee other) {
      return Double.compare(this.pricePerKg, other.pricePerKg);
   }

   /**
    * Checks if two coffee objects are equal.
    * Coffee objects are equal if they have the same name and type.
    * 
    * @param obj object to compare
    * @return true if objects are equal
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      
      Coffee coffee = (Coffee) obj;
      return name.equals(coffee.name) && getType().equals(coffee.getType());
   }

   /**
    * Returns hash code for this coffee object.
    * 
    * @return hash code
    */
   @Override
   public int hashCode() {
      return name.hashCode() + getType().hashCode();
   }

   /**
    * Returns string representation of coffee.
    * 
    * @return string representation
    */
   @Override
   public String toString() {
      return String.format("%s (%s) - %.2f UAH/kg, weight: %.2f kg, volume: %.2f L, quality: %d/10",
            name, getType(), pricePerKg, weight, packageVolume, quality);
   }
}
