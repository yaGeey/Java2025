package lab5;

import java.util.List;

public class Main {
   public static void main(String[] args) {
      try {
         Van van = new Van(5.0);
         
         Coffee coffee1 = new BeanCoffee("Арабіка", 450.0, 1.0, 1.2, 9, "Середнє");
         Coffee coffee2 = new GroundCoffee("Lavazza", 520.0, 0.5, 0.6, 5, "Середній");
         Coffee coffee3 = new InstantCoffee("Nescafe", 380.0, 0.2, 0.25, 7, "Банка", true);
         Coffee coffee4 = new CapsuleCoffee("Nespresso", 800.0, 0.055, 0.15, 9, "Nespresso", 10);
         
         van.addCoffee(coffee1);
         van.addCoffee(coffee2);
         van.addCoffee(coffee3);
         van.addCoffee(coffee4);
         
         // Виводимо інформацію про завантаження
         van.printInfo();
         van.printCargo();
         
         // Сортування за співвідношенням ціни до ваги
         System.out.println("\n=== Сортування за співвідношенням ціна/вага ===");
         van.sortByPriceToWeightRatio();
         van.printCargo();
         
         // Пошук товарів за діапазоном якості
         System.out.println("\n=== Пошук товарів з якістю 7-9 ===");
         List<Coffee> highQuality = van.findByQualityRange(7, 9);
         if (highQuality.isEmpty()) {
            System.out.println("Товари не знайдено");
         } else {
            System.out.println("Знайдено " + highQuality.size() + " товар(ів):");
            for (int i = 0; i < highQuality.size(); i++) {
               System.out.printf("%d. %s\n", i + 1, highQuality.get(i));
            }
         }
         
      } catch (Exception e) {
         System.err.println("error: " + e.getMessage());
         e.printStackTrace();
      }
   }
}
