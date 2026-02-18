# Queens Game Solver

## Problem Set Definition / Penjelasan Sederhana
<hr>
Queens Solver is a program that solves the LinkedIn game Queens. The goal of Queens is to place queens on a colored square board so that there is only one queen in each row, column, and color region.

Simply put:
1. No queens can be in the same row or column.
2. They cannot touch diagonally or orthogonally (8 squares around them).
3. Each color region defined on the board can only contain exactly one queen.

\

Queens Solver merupakan program yang menyelesaikan permasalahan dari permainan LinkedIn, yakni Queens. Tujuan dari gim Queens adalah menempatkan queen pada sebuah papan persegi berwarna sehingga terdapat hanya satu queen pada tiap baris, kolom, dan daerah warna.

Secara sederhana:
1. Tidak boleh ada ratu yang berada pada baris atau kolom yang sama.
2. Tidak boleh bersentuhan secara diagonal maupun ortogonal (8 kotak disekitarnya).
3. Setiap wilayah warna yang didefinisikan pada papan hanya boleh memiliki tepat satu ratu.

## Program's Installation and Requirements / Requirement Program dan Instalasi
<hr>

### Software

### Main Library / Library Utama
- util

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

## Author
<hr>
Created By / Dibuat Oleh: Jennifer Khang
Topic: **Brute Force Algorithm**