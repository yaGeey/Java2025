package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Van {
   final double maxVolume;
   private List<Coffee> cargo;
   private double currentVolume;
   private double currentPrice;

   public Van(double maxVolume) {
      if (maxVolume <= 0) throw new IllegalArgumentException("Volume must be > 0");
      
      this.maxVolume = maxVolume;
      this.cargo = new ArrayList<>();
      this.currentVolume = 0;
      this.currentPrice = 0;
   }

   /**
    * Додає товар до фургону, якщо є місце та не перевищено бюджет.
    * 
    * @param coffee товар для додавання
    * @return true якщо товар додано, false якщо немає місця
    * @throws IllegalArgumentException якщо товар null
    */
   public boolean addCoffee(Coffee coffee) {
      if (coffee == null) throw new IllegalArgumentException("Goods cant be null");
      
      double newVolume = currentVolume + coffee.packageVolume;
      double newPrice = currentPrice + coffee.getTotalPrice();
      
      if (newVolume > maxVolume) {
         System.out.println("Not enough space for " + coffee.name);
         return false;
      }
      
      cargo.add(coffee);
      currentVolume = newVolume;
      currentPrice = newPrice;
      return true;
   }

   /**
    * Сортує товари за співвідношенням ціни до ваги.
    */
   public void sortByPriceToWeightRatio() {
      Collections.sort(cargo);
   }

   /**
    * Знаходить товари в заданому діапазоні якості.
    * 
    * @param minQuality мінімальна якість
    * @param maxQuality максимальна якість
    * @return список товарів у діапазоні якості
    * @throws IllegalArgumentException якщо діапазон некоректний
    */
   public List<Coffee> findByQualityRange(int minQuality, int maxQuality) {
      if (minQuality < 1 || minQuality > 10 || maxQuality < 1 || maxQuality > 10) {
         throw new IllegalArgumentException("Якість повинна бути від 1 до 10");
      }
      if (minQuality > maxQuality) {
         throw new IllegalArgumentException("Мінімальна якість не може бути більше максимальної");
      }
      
      List<Coffee> result = new ArrayList<>();
      for (Coffee coffee : cargo) {
         if (coffee.quality >= minQuality && coffee.quality <= maxQuality) {
            result.add(coffee);
         }
      }
      return result;
   }

   public double getCurrentVolume() {
      return currentVolume;
   }
   public double getCurrentPrice() {
      return currentPrice;
   }
   public List<Coffee> getCargo() {
      return new ArrayList<>(cargo);
   }

   /**
    * Виводить інформацію про фургон та вантаж.
    */
   public void printInfo() {
      System.out.println("\n=== Інформація про фургон ===");
      System.out.printf("Максимальний обсяг: %.2f л\n", maxVolume);
      System.out.printf("Поточний обсяг: %.2f л (%.1f%%)\n", currentVolume, (currentVolume / maxVolume) * 100);
      System.out.printf("Поточна вартість: %.2f грн\n", currentPrice);
      System.out.println("Кількість товарів: " + cargo.size());
   }

   /**
    * Виводить список всіх товарів у фургоні.
    */
   public void printCargo() {
      System.out.println("\n=== Товари у фургоні ===");
      if (cargo.isEmpty()) {
         System.out.println("Фургон порожній");
         return;
      }
      
      for (int i = 0; i < cargo.size(); i++) {
         System.out.printf("%d. %s\n", i + 1, cargo.get(i));
      }
   }
}
