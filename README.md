# Queens Game Solver

## Problem Set Definition / Penjelasan Sederhana
<hr>
Queens Solver is a program that solves the LinkedIn game Queens. The goal of Queens is to place queens on a colored square board so that there is only one queen in each row, column, and color region.

Simply put:
1. No queens can be in the same row or column.
2. They cannot touch diagonally or orthogonally (8 squares around them).
3. Each color region defined on the board can only contain exactly one queen.

<br>

Queens Solver merupakan program yang menyelesaikan permasalahan dari permainan LinkedIn, yakni Queens. Tujuan dari gim Queens adalah menempatkan queen pada sebuah papan persegi berwarna sehingga terdapat hanya satu queen pada tiap baris, kolom, dan daerah warna.

Secara sederhana:
1. Tidak boleh ada ratu yang berada pada baris atau kolom yang sama.
2. Tidak boleh bersentuhan secara diagonal maupun ortogonal (8 kotak disekitarnya).
3. Setiap wilayah warna yang didefinisikan pada papan hanya boleh memiliki tepat satu ratu.

## Folder Structure
<hr>

```
Tucil1_13524110/
│   README.md
│
├── bin/
│   ├── boardMatrix.class
│   ├── cell.class
│   ├── item.class
│   ├── main.class
│   ├── method.class
│   └── outPath/
│
├── doc/
│   └── Tucil1_13524110.pdf
│
├── src/
│   └── java/
│       ├── boardMatrix.java
│       ├── cell.java
│       ├── item.java
│       ├── main.java
│       └── method.java
│
├── test/
│   ├── 1.txt
│   ├── 2.txt
│   ├── 3.txt
│   ├── 4.txt
│   └── 5.txt
```

## Program's Installation and Requirements / Requirement Program dan Instalasi
<hr>

To compile and run this program, you need:

1. **Java Development Kit (JDK)** – Download and install JDK 8 or newer (JDK 17 recommended).
2. **Text Editor or IDE** (optional, but recommended)
3. **Command Line Tool** – Terminal, Command Prompt, or PowerShell (for compiling and running Java programs)

## How To Run / Cara Menjalankan Program
<hr>

Windows:
```bash
# Move to java folder
cd src/java

# Compile
javac -d bin src/java/cell.java src/java/item.java src/java/boardMatrix.java src/java/method.java src/java/main.java

# Run Program
java -cp bin main
```

The following are detailed steps for users to follow.
1. Run the program
2. Select the puzzle input: Load Path TXT or Manual Input
3. Set the search animation speed (optional)
4. Once the process is complete, the solution can be saved as a TXT file (Save as TXT).

<br>
Beirkut merupakan detail langkah-langkah yang bisa diikuti oleh User.
1. Jalankan program
2. Pilih input puzzle: Load Path TXT atau Input Manual
3. Atur kecepatan animasi pencarian (opsional)
4. Jika proses sudah selesai, solusi dapat disimpan dalam bentuk TXT (Save as TXT)

## Author
<hr>
Created By / Dibuat Oleh: Jennifer Khang <br>
Topic: **Brute Force Algorithm**