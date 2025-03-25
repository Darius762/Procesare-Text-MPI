# Procesare-Text-MPI
Acest proiect implementează trei versiuni ale algoritmului de numărare a frecvenței cuvintelor într-un fișier text mare
# Procesare Text - Secvențial

Acest proiect implementează **versiunea secvențială** a unui algoritm pentru **numărarea frecvenței cuvintelor** într-un fișier text mare.  
Programul este optimizat pentru a funcționa eficient și pe **fișiere mari (1GB+), citind linie cu linie** pentru a evita erorile de memorie.

---

## 📌 Descriere
Programul:
1. **Citește un fișier text mare** (`DataIN.txt`).
2. **Elimină caracterele speciale** și normalizează textul la litere mici.
3. **Numără aparițiile fiecărui cuvânt** folosind o structură `HashMap<String, Integer>`.
4. **Sortează rezultatele** și afișează **primele 20 de cuvinte** cele mai frecvente.
5. **Măsoară timpul de execuție** și dimensiunea fișierului procesat.

---

## 🛠️ Tehnologii utilizate
- **Limbaj:** Java 17+
- **Framework:** Maven
- **Biblioteci:**
  - `Apache Commons IO` – pentru citirea eficientă a fișierelor mari.
  - `BufferedReader` – pentru citire linie cu linie, optimizată pentru fișiere mari.

---

## 📂 Structura Proiectului
