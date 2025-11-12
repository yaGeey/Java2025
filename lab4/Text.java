package lab4;

import java.util.ArrayList;
import java.util.List;

public class Text {
   private List<Sentence> sentences;

   public Text() {
      this.sentences = new ArrayList<>();
   }
   public Text(List<Sentence> sentences) {
      this.sentences = new ArrayList<>(sentences);
   }
   public Text(String text) {
      this.sentences = new ArrayList<>();
      
      // Замінюємо послідовність табуляцій та пробілів одним пробілом
      text = text.replaceAll("[ \\t]+", " ").trim();
      
      // Розбиваємо текст на речення за розділовими знаками
      String[] sentenceParts = text.split("(?<=[.!?])\\s*");
      
      for (String sentencePart : sentenceParts) {
         if (sentencePart.isEmpty()) {
            continue;
         }
         Sentence sentence = parseSentence(sentencePart);
         sentences.add(sentence);
      }
   }

   /**
    * Парсить рядок на речення зі словами та розділовими знаками.
    * @param sentenceText текст речення
    * @return об'єкт Sentence
    */
   private Sentence parseSentence(String sentenceText) {
      Sentence sentence = new Sentence();
      StringBuilder wordBuilder = new StringBuilder();
      
      for (char c : sentenceText.toCharArray()) {
         if (Character.isLetterOrDigit(c)) {
            wordBuilder.append(c);
         } else {
            // Якщо зібрано слово, додаємо його до речення
            if (wordBuilder.length() > 0) {
               sentence.addWord(new Word(wordBuilder.toString()));
               wordBuilder.setLength(0);
            }
            
            // Додаємо розділовий знак (крім пробілів)
            if (c != ' ') {
               sentence.addPunctuation(new Punctuation(c));
            }
         }
      }
      
      // Додаємо останнє слово, якщо воно є
      if (wordBuilder.length() > 0) {
         sentence.addWord(new Word(wordBuilder.toString()));
      }
      
      return sentence;
   }

   /**
    * Додає речення до тексту.
    * 
    * @param sentence речення для додавання
    */
   public void addSentence(Sentence sentence) {
      sentences.add(sentence);
   }

   /**
    * Повертає список всіх речень у тексті.
    * 
    * @return список речень
    */
   public List<Sentence> getSentences() {
      return new ArrayList<>(sentences);
   }

   /**
    * Видаляє з усіх речень слова заданої довжини, що починаються з приголосної.
    * 
    * @param length довжина слів для видалення
    */
   public void removeConsonantWordsOfLength(int length) {
      for (Sentence sentence : sentences) {
         sentence.removeConsonantWordsOfLength(length);
      }
   }

   /**
    * Представлення тексту у вигляді рядка.
    * 
    * @return текст як String
    */
   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < sentences.size(); i++) {
         sb.append(sentences.get(i).toString());
         if (i < sentences.size() - 1) {
            sb.append(" ");
         }
      }
      return sb.toString();
   }
}
