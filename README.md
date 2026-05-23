# Java Final Exam

Project ini berisi kumpulan jawaban ujian akhir Java yang dipisahkan menjadi tiga bagian:

- `answer1.java`
- `answer2/`
- `answer3/`

Sebagian file `.class` sudah ikut tersimpan di repository, tetapi tetap disarankan menjalankan program dari source `.java`.

## Struktur Project

```text
java_final_exam/
├── answer1.java
├── answer2/
│   ├── answer2.java
│   └── answer2_seed.java
└── answer3/
    ├── Main.java
    ├── MLSService.java
    ├── User.java
    ├── Parent.java
    ├── Student.java
    ├── Membership.java
    ├── Payment.java
    ├── Topic.java
    ├── Quiz.java
    └── QuizResult.java
```

## Ringkasan Tiap Bagian

### 1. `answer1.java`

Program sederhana untuk:

- menerima input umur dengan `Scanner`
- membaca input menggunakan `nextLine()`
- mengubah input `String` menjadi `int` dengan `Integer.parseInt()`
- menampilkan umur saat ini dan umur tahun depan

Catatan:

- file ini memiliki `public class InputIntDenganNextLine`
- di Java, nama file seharusnya sama dengan nama `public class`
- agar bisa dikompilasi normal, file ini sebaiknya di-rename menjadi `InputIntDenganNextLine.java`

### 2. `answer2/`

Bagian ini berisi program pengolahan nilai mahasiswa.

Fitur utama:

- menyimpan data 30 mahasiswa
- menerima input `id`, `name`, `assignment`, `midExam`, dan `finalExam`
- menghitung nilai akhir dengan bobot `assignment 20%`, `mid exam 30%`, dan `final exam 50%`
- menentukan grade berdasarkan nilai akhir
- menampilkan tabel hasil akhir seluruh mahasiswa

File penting:

- `answer2.java`: versi interaktif, input manual lewat terminal
- `answer2_seed.java`: versi dengan data contoh otomatis untuk testing/demo

### 3. `answer3/`

Bagian ini adalah aplikasi console berbasis OOP bernama **MathChamp Learning System (MLS)**.

Konsep yang dipakai:

- inheritance (`User`, `Parent`, `Student`)
- composition / aggregation
- encapsulation
- array list
- menu interaktif berbasis terminal

Fitur parent:

- login sebagai parent
- melihat status membership
- membeli atau memperpanjang membership
- menambah dan melihat data anak
- melihat progress pembelajaran anak
- melihat hasil assessment / kuis anak

Fitur student:

- login sebagai student
- melihat daftar topik
- menyelesaikan topik
- mengerjakan kuis
- melihat hasil kuis sendiri

Data awal yang sudah tersedia:

| Role | Username | Password |
| --- | --- | --- |
| Parent | `rafael1` | `password123` |
| Student | `user1` | `user123` |

## Cara Compile dan Run

Pastikan JDK sudah terpasang dan perintah `javac` serta `java` tersedia.

### Menjalankan `answer1`

Rename file terlebih dahulu:

```bash
mv answer1.java InputIntDenganNextLine.java
javac InputIntDenganNextLine.java
java InputIntDenganNextLine
```

### Menjalankan `answer2` versi interaktif

```bash
javac answer2/answer2.java
java -cp answer2 answer2
```

### Menjalankan `answer2_seed` versi data contoh

```bash
javac answer2/answer2_seed.java
java -cp answer2 answer2_seed
```

### Menjalankan `answer3`

```bash
javac answer3/*.java
java -cp answer3 Main
```
