package textprocessing;

import java.io.*;
import java.util.*;

public class GenerarePropozitii {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        String inputFileName = "src/main/resources/cuvinte.txt";
        String outputFileName = "src/main/resources/test_7.txt";
        int numSentences = 1000000;
        int minWordsPerSentence = 5;
        int maxWordsPerSentence = 15;
        Random random = new Random();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
            return;
        }

        if (words.isEmpty()) {
            System.err.println("Lista de cuvinte este goala. Adauga cuvinte in " + inputFileName);
            return;
        }

        // Generam propozitii si le scriem in fisier
        try (FileWriter writer = new FileWriter(outputFileName)) {
            for (int i = 0; i < numSentences; i++) {
                int sentenceLength = random.nextInt(maxWordsPerSentence - minWordsPerSentence + 1) + minWordsPerSentence;
                StringBuilder sentence = new StringBuilder();

                for (int j = 0; j < sentenceLength; j++) {
                    String word = words.get(random.nextInt(words.size()));
                    if (j == 0) {
                        word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
                    }
                    sentence.append(word).append(" ");
                }

                sentence.append(random.nextBoolean() ? ". " : "! ");
                writer.write(sentence.toString());
            }
            System.out.println("Fisierul " + outputFileName + " a fost generat cu succes!");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea fisierului: " + e.getMessage());
        }
    }
}
