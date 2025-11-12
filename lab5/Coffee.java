package lab5;

/**
 * Абстрактний клас Coffee представляє загальні характеристики кави.
 * Є базовим класом для всіх типів кави (зерно, мелена, розчинна).
 */
public abstract class Coffee implements Comparable<Coffee> {
   final String name;
   final double pricePerKg;
   final double weight;
   final double packageVolume;
   final int quality;

   /**
    * @param name назва сорту
    * @param pricePerKg ціна за кілограм
    * @param weight вага кави
    * @param packageVolume обсяг упаковки
    * @param quality якість кави (1-10)
    * @throws IllegalArgumentException якщо параметри некоректні
    */
   public Coffee(String name, double pricePerKg, double weight, double packageVolume, int quality) {
      if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cant be empty");
      if (pricePerKg <= 0 || weight <= 0 || packageVolume <= 0) throw new IllegalArgumentException("Values must be > 0");
      if (quality < 1 || quality > 10) throw new IllegalArgumentException("Quality must be between 1 and 10");
      
      this.name = name;
      this.pricePerKg = pricePerKg;
      this.weight = weight;
      this.packageVolume = packageVolume;
      this.quality = quality;
   }

   /**
    * Обчислює загальну вартість товару.
    * @return вартість = ціна за кг * вага
    */
   public double getTotalPrice() {
      return pricePerKg * weight;
   }

   // for overrides
   public abstract String getType();

   @Override
   public int compareTo(Coffee other) {
      return Double.compare(this.pricePerKg, other.pricePerKg);
   }

   @Override
   public String toString() {
      return String.format("%s (%s) - %.2f грн/кг, вага: %.2f кг, обсяг: %.2f л, якість: %d/10, вартість: %.2f грн",
            name, getType(), pricePerKg, weight, packageVolume, quality, getTotalPrice());
   }
}
