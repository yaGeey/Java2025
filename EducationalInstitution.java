// Визначити клас навчальний заклад, який складається як мінімум з 5-и полів. 
public class EducationalInstitution {
   private String name;
   private String city;
   private String type;
   private int numberOfStudents;
   private int foundingYear; 

   public EducationalInstitution(String name, String city, String type, int numberOfStudents, int foundingYear) {
      this.name = name;
      this.city = city;
      this.type = type;
      this.numberOfStudents = numberOfStudents;
      this.foundingYear = foundingYear;
   }
   
   // Getters for all fields
   public String getName() {
      return name;
   }
   public String getCity() {
      return city;
   }
   public String getType() {
      return type;
   }
   public int getNumberOfStudents() {
      return numberOfStudents;
   }
   public int getFoundingYear() {
      return foundingYear;
   }

   @Override
   public String toString() {
      return "EducationalInstitution{" +
            "name='" + name + '\'' +
            ", city='" + city + '\'' +
            ", type='" + type + '\'' +
            ", students=" + numberOfStudents +
            ", year=" + foundingYear +
            '}';
   }
}
