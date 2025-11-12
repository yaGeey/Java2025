package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Представляє речення як послідовність слів і розділових знаків.
 * Містить методи для роботи з реченням (додавання елементів, фільтрація слів).
 */
public class Sentence {
   private List<Object> elements;

   public Sentence() {
      this.elements = new ArrayList<>();
   }
   public Sentence(List<Object> elements) {
      this.elements = new ArrayList<>(elements);
   }

   /**
    * Додає слово до речення.
    * @param word слово для додавання
    */
   public void addWord(Word word) {
      elements.add(word);
   }

   /**
    * Додає розділовий знак до речення.
    * @param punctuation розділовий знак для додавання
    */
   public void addPunctuation(Punctuation punctuation) {
      elements.add(punctuation);
   }

   /**
    * Повертає список всіх слів у реченні.
    * @return список слів
    */
   public List<Word> getWords() {
      List<Word> words = new ArrayList<>();
      for (Object element : elements) {
         if (element instanceof Word) {
            words.add((Word) element);
         }
      }
      return words;
   }

   /**
    * Видаляє зі речення всі слова заданої довжини, що починаються з приголосної.
    * @param length довжина слів для видалення
    */
   public void removeConsonantWordsOfLength(int length) {
      elements.removeIf(element -> 
         element instanceof Word && 
         ((Word) element).getSize() == length && 
         ((Word) element).startsWithConsonant()
      );
   }

   /**
    * Представлення речення у вигляді рядка.
    * Додає пробіли між словами та розділовими знаками.
    * @return речення як String
    */
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < elements.size(); i++) {
         Object element = elements.get(i);
         sb.append(element.toString());
         
         // Додаємо пробіл після слова, якщо наступний елемент не розділовий знак
         if (element instanceof Word && i < elements.size() - 1) {
            Object next = elements.get(i + 1);
            if (next instanceof Word) {
               sb.append(" ");
            }
         } else if (element instanceof Punctuation && i < elements.size() - 1) {
            sb.append(" ");
         }
      }
      return sb.toString();
   }
}
