package lab3;
import java.util.Arrays;
import java.util.Comparator;

public class Demo {
   public static void main(String[] args) {
      EducationalInstitution institution[] = {
         new EducationalInstitution("University", "Kyiv", "Higher", 20000, 1834),
         new EducationalInstitution("College", "Lviv", "Secondary", 5000, 1950),
         new EducationalInstitution("School", "Odesa", "Primary", 5000, 2000),
         new EducationalInstitution("Institute", "Kharkiv", "Higher", 15000, 1930),
         new EducationalInstitution("Lyceum", "Dnipro", "Secondary", 3000, 1990)
      };

      System.out.println("\n--- Before sorting ---");
      for (EducationalInstitution edu : institution)
         System.out.println(edu);
      
      Comparator<EducationalInstitution> comp = Comparator
         // Сортуємо за кількістю студентів (за зростанням)
         .comparingInt(EducationalInstitution::getNumberOfStudents)
         // Якщо кількість студентів однакова, сортуємо за роком заснування (за спаданням)
         .thenComparing(EducationalInstitution::getFoundingYear, Comparator.reverseOrder());
      
      Arrays.sort(institution, comp);
      System.out.println("\n--- After sorting ---");
      for (EducationalInstitution edu : institution)
         System.out.println(edu);
   }
}
