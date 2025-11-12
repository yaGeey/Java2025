package lab4;

public class Entry {
   public static void main(String[] args) {
      String inputText = "свег    чіназес   респект  няшно\t\tшмаа чувак\tкоштовно  абоба. " +
            "еее  ну\t\tда йоу! ";
      System.out.println(inputText);
      
      Text text = new Text(inputText);
      System.out.println("\n\tText obj:");
      System.out.println(text);
      
      text.removeConsonantWordsOfLength(2);
      System.out.println("\n\tВидалення слів довжини 2, що починаються з приголосної:");
      System.out.println(text);
   }
}
