package textprocessing;

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        String filePath = "src/main/resources/test_7.txt";

        File file = new File(filePath);
        if (!file.exists()) {
            System.err.println("Fisierul nu exista: " + filePath);
            return;
        }

        long fileSizeInBytes = file.length();
        double fileSizeInMB = fileSizeInBytes / (1024.0 * 1024.0);
        System.out.printf("Dimensiunea fisierului: %.2f MB%n", fileSizeInMB);

        // HashMap pentru a stoca frecventa cuvintelor
        Map<String, Integer> wordCount = new HashMap<>();

        // Citirea eficienta bloc cu bloc, nu linie cu linie
        try (BufferedReader reader = new BufferedReader(new FileReader(file), 8192)) {
            char[] buffer = new char[8192]; // Buffer mai mic pentru a gestiona fisiere mari
            int numCharsRead;
            StringBuilder lineBuffer = new StringBuilder();

            while ((numCharsRead = reader.read(buffer)) != -1) {
                lineBuffer.append(buffer, 0, numCharsRead);
                String[] words = lineBuffer.toString().toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

                // Procesam fiecare cuvant
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }

                // Golim buffer-ul dupa procesare
                lineBuffer.setLength(0);
            }
        } catch (IOException e) {
            System.err.println("Eroare la citirea fisierului: " + e.getMessage());
        }

        // Sortam rezultatele dupa frecventa in ordine descrescatoare
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));


        System.out.println("Top 20 cuvinte frecvente:");
        for (int i = 0; i < Math.min(20, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + " - " + sortedWords.get(i).getValue());
        }

        long endTime = System.nanoTime();
        double durationInSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Timp de rulare: " + durationInSeconds + " secunde");
    }
}
