package lab6;

import java.util.Arrays;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      Coffee coffee1 = new BeanCoffee("Arabica Ethiopia", 450.0, 1.0, 1.2, 9, "Medium");
      Coffee coffee2 = new BeanCoffee("Arabica Ethiopia", 450.0, 1.0, 1.2, 9, "Medium");
      Coffee coffee3 = new GroundCoffee("Lavazza Oro", 520.0, 0.5, 0.6, 8, "Medium");
      Coffee coffee4 = new InstantCoffee("Nescafe Gold", 380.0, 0.2, 0.25, 7, "Jar", true);

      Coffee coffee5 = new BeanCoffee("Colombian Supremo", 600.0, 1.0, 1.2, 10, "Medium");
      Coffee coffee6 = new GroundCoffee("Illy Classico", 580.0, 0.25, 0.3, 9, "Medium");

      // Demonstrate Constructor 1: Empty set
      System.out.println("=== Constructor 1: Empty Set ===");
      CoffeeSet<Coffee> set1 = new CoffeeSet<>();
      System.out.println("Created empty set: " + set1);
      System.out.println("Is empty: " + set1.isEmpty());
      
      // Demonstrate Constructor 2: Single element
      System.out.println("\n=== Constructor 2: Single Element ===");
      CoffeeSet<Coffee> set2 = new CoffeeSet<>(coffee1);
      System.out.println("Created set with one element:");
      System.out.println(set2);
      System.out.println("Size: " + set2.size());
      
      // Demonstrate Constructor 3: From collection
      System.out.println("\n=== Constructor 3: From Collection ===");
      List<Coffee> coffeeList = Arrays.asList(coffee1, coffee2);
      CoffeeSet<Coffee> set = new CoffeeSet<>(coffeeList);
      System.out.println(set);
      
      // Demonstrate add() method
      set.add(coffee3);
      set.add(coffee4);
      
      // Try to add duplicate (Set property - should return false)
      System.out.println("\nTrying to add duplicate (same name and type):");
      System.out.println("Adding duplicate: " + set.add(coffee1));
      
      // Demonstrate contains() method
      System.out.println("\n=== Testing contains() Method ===");
      System.out.println(set.contains(coffee2));
      Coffee notInSet = new BeanCoffee("New Coffee", 300.0, 1.0, 1.0, 5, "Medium");
      System.out.println("Contains new coffee: " + set.contains(notInSet));
      
      // Demonstrate remove() method
      System.out.println("\n=== Testing remove() Method ===");
      System.out.println("Removing coffee2" + set.remove(coffee2));
      System.out.println("Size after removal: " + set.size());
      
      // Demonstrate iterator
      System.out.println("\n=== Testing Iterator ===");
      int counter = 1;
      for (Coffee coffee : set) {
         System.out.println(counter++ + ". " + coffee);
      }
      
      // Demonstrate toArray() method
      System.out.println("\n=== Testing toArray() Method ===");
      Object[] array = set.toArray();
      System.out.println("Array size: " + array.length);
      for (int i = 0; i < array.length; i++) {
         System.out.println((i + 1) + ". " + array[i]);
      }
      
      // Demonstrate addAll() method
      System.out.println("\n=== Testing addAll() Method ===");
      List<Coffee> newCoffees = Arrays.asList(coffee5, coffee6);
      System.out.println("Adding collection of " + newCoffees.size() + " elements");
      set.addAll(newCoffees);
      System.out.println("Size after addAll: " + set.size());
      
      // Demonstrate removeAll() method
      System.out.println("\n=== Testing removeAll() Method ===");
      List<Coffee> toRemove = Arrays.asList(coffee2, coffee3);
      System.out.println("Removing 2 elements");
      set.removeAll(toRemove);
      System.out.println("Size after removeAll: " + set.size());
      
      // Demonstrate containsAll() method
      System.out.println("\n=== Testing containsAll() Method ===");
      List<Coffee> checkList = Arrays.asList(coffee4, coffee5);
      System.out.println("Contains all from check list: " + set.containsAll(checkList));
      
      // Demonstrate retainAll() method
      System.out.println("\n=== Testing retainAll() Method ===");
      CoffeeSet<Coffee> retainSet = new CoffeeSet<>(set);
      List<Coffee> retainList = Arrays.asList(coffee3, coffee4);
      System.out.println("Before retainAll: " + retainSet.size() + " elements");
      retainSet.retainAll(retainList);
      System.out.println("After retainAll (keeping only 2 elements): " + retainSet.size() + " elements");
      
      // Demonstrate clear() method
      System.out.println("\n=== Testing clear() Method ===");
      System.out.println("Size before clear: " + set.size());
      set.clear();
      System.out.println("Is empty: " + set.isEmpty());
   }
}
