# Лабораторна робота №4

### 1. `Letter` — Літера

Представляє окрему літеру в тексті.

-  **Поля:**
   -  `char value` — значення літери
-  **Методи:**
   -  `boolean isConsonant()` — перевіряє, чи є літера приголосною
   -  `char getValue()` — повертає значення літери
   -  `String toString()` — представлення літери як рядка

### 2. `Word` — Слово

Представляє слово як масив літер (`List<Letter>`).

-  **Поля:**
   -  `List<Letter> letters` — список літер слова
-  **Методи:**
   -  `int getSize()` — повертає довжину слова
   -  `boolean startsWithConsonant()` — перевіряє, чи починається слово з приголосної
   -  `String toString()` — представлення слова як рядка

### 3. `Punctuation` — Розділовий знак

Представляє розділовий знак (кома, крапка, знак оклику тощо).

-  **Поля:**
   -  `char value` — значення розділового знаку
-  **Методи:**
   -  `char getValue()` — повертає значення знаку
   -  `String toString()` — представлення знаку як рядка

### 4. `Sentence` — Речення

Представляє речення як масив слів та розділових знаків (`List<Object>`).

-  **Поля:**
   -  `List<Object> elements` — список елементів (слова та розділові знаки)
-  **Методи:**
   -  `void addWord(Word word)` — додає слово до речення
   -  `void addPunctuation(Punctuation punctuation)` — додає розділовий знак
   -  `List<Word> getWords()` — повертає список всіх слів
   -  `void removeConsonantWordsOfLength(int length)` — видаляє слова заданої довжини
   -  `String toString()` — представлення речення як рядка

### 5. `Text` — Текст

Представляє текст як масив речень (`List<Sentence>`).

-  **Поля:**
   -  `List<Sentence> sentences` — список речень
-  **Методи:**
   -  `void addSentence(Sentence sentence)` — додає речення
   -  `List<Sentence> getSentences()` — повертає список речень
   -  `void removeConsonantWordsOfLength(int length)` — видаляє слова з усіх речень
   -  `String toString()` — представлення тексту як рядка
