# 📱 Kotlin Studies and Projects

[![Kotlin](https://img.shields.io/badge/Kotlin-Android-purple.svg?style=flat-square&logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-SDK_36+-green.svg?style=flat-square&logo=android)](https://developer.android.com/)
[![Build](https://img.shields.io/badge/Build-Gradle_9-blue.svg?style=flat-square&logo=gradle)](https://gradle.org/)
[![Semester](https://img.shields.io/badge/Semester-4th_Period-blue.svg?style=flat-square)](#)

This repository is dedicated to my learning journey with **Kotlin and Android development**, as part of the **Computer Systems Analysis and Development** program at the **Federal Institute of Triângulo Mineiro (IFTM)**.

It serves as a portfolio to version and store classroom projects, assignments, and exams, showcasing my progress and the skills acquired throughout the semesters.

---

## 📂 Repository Structure

The `main` branch contains the **current semester's work in progress**, while completed semesters are preserved in dedicated branches for reference.

### 🎓 Completed Semesters (Archived Branches)

No archived branches yet — the 4th semester is the first one taught in Kotlin. It will be archived once the semester is over.

> Semesters taught in other languages are archived in the [`iftm-ads-c-studies`](https://github.com/DevLuquinha/iftm-ads-c-studies) and [`iftm-ads-java-studies`](https://github.com/DevLuquinha/iftm-ads-java-studies) repositories.

---

## 🚧 Current Semester - 4th Period (2026.2)

**Subject:** Mobile Device Programming (PDM). Native Android apps built with Kotlin and XML layouts, moving from single-screen apps to multi-screen CRUDs backed by SQLite.

Each folder is an independent Android Studio project with its own Gradle wrapper.

```text
iftm-ads-kotlin-studies/
├── 01-classroom-projects/                 # Projects built during class
│   ├── 01-bhaskara-calculator/            # Quadratic equation solver
│   ├── 02-list-exercises/                 # ListView fed by an ArrayAdapter
│   ├── 03-learning-components/            # Form widgets and screen switching
│   ├── 04-miscellany-project/             # Passing data between screens with Bundle
│   └── 05-passing-data-between-screens/   # Parcelable objects and the first SQLite table
├── 02-assignments/                        # Graded assignments
│   ├── 01-calculator/                     # Assignment 01 - Calculator app
│   └── 02-beautiful-matrix/               # Assignment 02 - Matrix exercises
│       └── resources/                     # Assignment statement, board (Excalidraw + PNG)
└── 03-exams/                              # Exams and exam studies
    └── 01-exam/                           # Exam 01 - SQLite CRUD
        ├── 01-computer-management-study/  # Study project for the exam
        ├── 02-chocolate-storage/          # Exam project
        └── resources/                     # Exam statement
```

### 📘 01 - Classroom Projects

#### 🧮 01-bhaskara-calculator

Solves quadratic equations using the **Bhaskara formula**. The user types the coefficients `a`, `b`, and `c`, and the app reports the roots along with the coordinates of the parabola's vertex.

* **Kotlin basics:** `val` / `var`, type annotations, string templates, conditionals.
* **Activities & lifecycle:** extending `AppCompatActivity` and setting up the screen in `onCreate`.
* **View binding by ID:** `lateinit var` properties resolved through `findViewById`.
* **Event handling:** `setOnClickListener` with a lambda to run the calculation.
* **Branching on the discriminant:** two real roots (`Δ > 0`), one root (`Δ = 0`), or none (`Δ < 0`).

#### 📋 02-list-exercises

Registers people (CPF, name, and age) and shows them in a list.

* **Classes in Kotlin:** a `Person` class with an `init` block and an overridden `toString()`.
* **Named arguments** when building objects.
* **Lists on screen:** `ListView` backed by an `ArrayList` through an `ArrayAdapter`.

#### 🧳 03-learning-components

A trip booking form that adds each reservation to a list.

* **Form widgets:** `Spinner`, `RadioGroup` / `RadioButton`, `CheckBox`, and `ListView`.
* **`when` expressions** to read the selected radio button.
* **Switching screens:** `Intent` + `startActivity` between two activities.

#### 🔀 04-miscellany-project

Sends a student's data from one screen to another and shows it in a list.

* **Passing data with `Bundle`:** `putString`, `putInt`, `putDouble` and `intent.extras` on the receiving screen.
* **Going back** with `finish()` instead of opening a new activity.

#### 🎓 05-passing-data-between-screens

Registers students and lists them on a second screen, first through the intent and then through the database.

* **`@Parcelize`:** passing a whole `Student` object through a `Bundle` with `putParcelable`.
* **SQLite:** a `SQLiteOpenHelper` creating the `students` table.
* **Inserting:** `ContentValues` + `insert`.
* **Reading:** `rawQuery` and iterating a `Cursor` with `moveToNext()` and `getColumnIndexOrThrow`.

### 📝 02 - Assignments

#### 🧮 01-calculator

A calculator app with a preview of the current operation.

* Sum, subtraction, multiplication, and division, plus `1/x`, `x²`, and `√x`.
* Decimal point, backspace, and leading-zero handling.
* State kept in local variables captured by the click listeners.

#### 🔢 02-beautiful-matrix

Seven matrix exercises from the assignment statement, chosen through an `exerciseNumber` constant. Results are printed with `Log.i`, except exercise 3, which uses the UI.

* **Matrices in Kotlin:** `Array<IntArray>` / `Array<DoubleArray>` and helper functions to create, fill, and print them.
* Sums of rows, columns, and diagonals; sum and difference of matrices; matrix multiplication.
* Searching a value in a matrix with no duplicated values.
* Dividing each row by its largest element; standard deviation of an array.
* Showing or hiding views with `isVisible`.

### 🧪 03 - Exams

#### 💻 01-exam / 01-computer-management-study

A study project for Exam 01: a customer CRUD (with the computer model and price) on SQLite.

* Navigation from a home screen driven by a `RadioGroup`.
* `insert`, `update` with `whereArgs`, and search by CPF.
* A `Customer` class with private fields and getters / setters ("Java pattern").

#### 🍫 01-exam / 02-chocolate-storage

**Exam 01:** an Android app for on-demand chocolate production, with two related tables (`customer` and `chocolate`) on SQLite.

* **Full CRUD** for customers and chocolates across multiple screens.
* **Foreign key:** `chocolate.customer_cpf` references `customer.cpf` with `ON DELETE CASCADE`, enabled by `PRAGMA foreign_keys = ON` in `onConfigure`.
* **Database helpers:** `CustomerDbUtils` / `ChocolateDbUtils` with `companion object` functions that map a `Cursor` into objects.
* **Reports:** number of customers and chocolates, the most expensive chocolate (`maxByOrNull`), the average price (`sumOf`), and chocolates with more than 50% cocoa.
* **Search** for customers by CPF and chocolates by ID (`find`).
* **Validation:** amount of cocoa between 20% and 90%.

---

## 🛠️ Technologies

- **Language:** Kotlin
- **UI Toolkit:** Android Views (XML layouts + ConstraintLayout)
- **Database:** SQLite (`SQLiteOpenHelper`)
- **Build Tool:** Gradle 9.5 – 9.6 (Kotlin DSL, version catalog)
- **Android Gradle Plugin:** 9.3 – 9.4
- **SDK:** compileSdk 37 · minSdk 36
- **Java Compatibility:** 11
- **IDE:** Android Studio

---

## ⚙️ How to Run

Each project is opened and built on its own. Open the project folder (for example, `02-assignments/01-calculator`) in **Android Studio** and run the `app` configuration on an emulator or a physical device.

From the terminal:

```bash
cd 03-exams/01-exam/02-chocolate-storage
./gradlew assembleDebug
```

The APK is generated in `app/build/outputs/apk/debug/`.

---

## 👨‍💻 About

**Student:** Lucas Emmanuel  
**Institution:** IFTM - Federal Institute of Triângulo Mineiro  
**Program:** Computer Systems Analysis and Development  

---

Feel free to explore the code and follow my progress! 🎯

---

<details>
  <summary>🇧🇷 Versão em Português</summary>

# 📱 Estudos e Projetos em Kotlin

Este repositório é dedicado à minha jornada de aprendizado com **Kotlin e desenvolvimento Android**, como parte do curso de **Análise e Desenvolvimento de Sistemas (ADS)** no **Instituto Federal do Triângulo Mineiro (IFTM)**.

Ele serve como portfólio para versionar e armazenar projetos de aula, trabalhos e provas, registrando minha evolução e as habilidades adquiridas ao longo dos períodos.

---

## 📂 Estrutura do Repositório

A branch `main` contém o **trabalho em andamento do semestre atual**, enquanto os semestres concluídos são preservados em branches dedicadas para referência.

### 🎓 Semestres Concluídos (Branches Arquivadas)

Ainda não há branches arquivadas — o 4º período é o primeiro cursado em Kotlin. Ele será arquivado quando o semestre terminar.

> Os semestres cursados em outras linguagens estão arquivados nos repositórios [`iftm-ads-c-studies`](https://github.com/DevLuquinha/iftm-ads-c-studies) e [`iftm-ads-java-studies`](https://github.com/DevLuquinha/iftm-ads-java-studies).

---

## 🚧 Semestre Atual - 4º Período (2026.2)

**Disciplina:** Programação para Dispositivos Móveis (PDM). Aplicativos Android nativos feitos com Kotlin e layouts XML, saindo de apps de uma tela só para CRUDs com várias telas e banco SQLite.

Cada pasta é um projeto independente do Android Studio, com o seu próprio wrapper do Gradle.

```text
iftm-ads-kotlin-studies/
├── 01-classroom-projects/                 # Projetos desenvolvidos em aula
│   ├── 01-bhaskara-calculator/            # Calculadora de equação do 2º grau
│   ├── 02-list-exercises/                 # ListView alimentada por um ArrayAdapter
│   ├── 03-learning-components/            # Componentes de formulário e troca de telas
│   ├── 04-miscellany-project/             # Passagem de dados entre telas com Bundle
│   └── 05-passing-data-between-screens/   # Objetos Parcelable e a primeira tabela SQLite
├── 02-assignments/                        # Trabalhos avaliativos
│   ├── 01-calculator/                     # Trabalho 01 - Calculadora
│   └── 02-beautiful-matrix/               # Trabalho 02 - Exercícios de matrizes
│       └── resources/                     # Enunciado e quadro do trabalho (Excalidraw + PNG)
└── 03-exams/                              # Provas e estudos para provas
    └── 01-exam/                           # Prova 01 - CRUD com SQLite
        ├── 01-computer-management-study/  # Projeto de estudo para a prova
        ├── 02-chocolate-storage/          # Projeto da prova
        └── resources/                     # Enunciado da prova
```

### 📘 01 - Projetos de Aula

#### 🧮 01-bhaskara-calculator

Resolve equações do segundo grau usando a **fórmula de Bhaskara**. O usuário digita os coeficientes `a`, `b` e `c`, e o app informa as raízes junto com as coordenadas do vértice da parábola.

* **Fundamentos de Kotlin:** `val` / `var`, anotação de tipos, templates de string, condicionais.
* **Activities e ciclo de vida:** herdando de `AppCompatActivity` e montando a tela no `onCreate`.
* **Ligação de views por ID:** propriedades `lateinit var` resolvidas via `findViewById`.
* **Tratamento de eventos:** `setOnClickListener` com lambda para disparar o cálculo.
* **Decisão pelo discriminante:** duas raízes reais (`Δ > 0`), uma raiz (`Δ = 0`) ou nenhuma (`Δ < 0`).

#### 📋 02-list-exercises

Cadastra pessoas (CPF, nome e idade) e as exibe em uma lista.

* **Classes em Kotlin:** uma classe `Person` com bloco `init` e `toString()` sobrescrito.
* **Argumentos nomeados** na criação de objetos.
* **Listas na tela:** `ListView` ligada a um `ArrayList` por meio de um `ArrayAdapter`.

#### 🧳 03-learning-components

Um formulário de reserva de viagens que adiciona cada reserva a uma lista.

* **Componentes de formulário:** `Spinner`, `RadioGroup` / `RadioButton`, `CheckBox` e `ListView`.
* **Expressões `when`** para ler o radio button selecionado.
* **Troca de telas:** `Intent` + `startActivity` entre duas activities.

#### 🔀 04-miscellany-project

Envia os dados de um estudante de uma tela para outra e os exibe em uma lista.

* **Passagem de dados com `Bundle`:** `putString`, `putInt`, `putDouble` e `intent.extras` na tela que recebe.
* **Voltar de tela** com `finish()`, em vez de abrir uma nova activity.

#### 🎓 05-passing-data-between-screens

Cadastra estudantes e os lista em uma segunda tela, primeiro pela intent e depois pelo banco de dados.

* **`@Parcelize`:** passando um objeto `Student` inteiro por um `Bundle` com `putParcelable`.
* **SQLite:** um `SQLiteOpenHelper` criando a tabela `students`.
* **Inserção:** `ContentValues` + `insert`.
* **Leitura:** `rawQuery` e iteração de um `Cursor` com `moveToNext()` e `getColumnIndexOrThrow`.

### 📝 02 - Trabalhos

#### 🧮 01-calculator

Uma calculadora com prévia da operação em andamento.

* Soma, subtração, multiplicação e divisão, além de `1/x`, `x²` e `√x`.
* Ponto decimal, apagar dígito e tratamento do zero à esquerda.
* Estado guardado em variáveis locais capturadas pelos listeners de clique.

#### 🔢 02-beautiful-matrix

Os sete exercícios de matrizes do enunciado, escolhidos por uma constante `exerciseNumber`. Os resultados saem no `Log.i`, exceto o exercício 3, que usa a interface.

* **Matrizes em Kotlin:** `Array<IntArray>` / `Array<DoubleArray>` e funções auxiliares para criar, preencher e imprimir.
* Somas de linhas, colunas e diagonais; soma e diferença de matrizes; multiplicação de matrizes.
* Busca de um valor em uma matriz sem valores repetidos.
* Divisão de cada linha pelo seu maior elemento; desvio padrão de um vetor.
* Exibir ou esconder views com `isVisible`.

### 🧪 03 - Provas

#### 💻 01-exam / 01-computer-management-study

Projeto de estudo para a Prova 01: um CRUD de clientes (com o modelo e o preço do computador) em SQLite.

* Navegação a partir de uma tela inicial controlada por um `RadioGroup`.
* `insert`, `update` com `whereArgs` e busca por CPF.
* Uma classe `Customer` com campos privados e getters / setters ("padrão Java").

#### 🍫 01-exam / 02-chocolate-storage

**Prova 01:** um aplicativo Android para a confecção de chocolates sob demanda, com duas tabelas relacionadas (`customer` e `chocolate`) em SQLite.

* **CRUD completo** de clientes e chocolates em várias telas.
* **Chave estrangeira:** `chocolate.customer_cpf` referencia `customer.cpf` com `ON DELETE CASCADE`, habilitada por `PRAGMA foreign_keys = ON` no `onConfigure`.
* **Utilitários de banco:** `CustomerDbUtils` / `ChocolateDbUtils` com funções em `companion object` que convertem um `Cursor` em objetos.
* **Relatórios:** número de clientes e de chocolates, o chocolate mais caro (`maxByOrNull`), o preço médio (`sumOf`) e os chocolates com mais de 50% de cacau.
* **Busca** de clientes por CPF e de chocolates por ID (`find`).
* **Validação:** quantidade de cacau entre 20% e 90%.

---

## 🛠️ Tecnologias

- **Linguagem:** Kotlin
- **Toolkit de UI:** Android Views (layouts XML + ConstraintLayout)
- **Banco de Dados:** SQLite (`SQLiteOpenHelper`)
- **Ferramenta de Build:** Gradle 9.5 – 9.6 (Kotlin DSL, catálogo de versões)
- **Android Gradle Plugin:** 9.3 – 9.4
- **SDK:** compileSdk 37 · minSdk 36
- **Compatibilidade Java:** 11
- **IDE:** Android Studio

---

## ⚙️ Como Executar

Cada projeto é aberto e compilado separadamente. Abra a pasta do projeto (por exemplo, `02-assignments/01-calculator`) no **Android Studio** e rode a configuração `app` em um emulador ou dispositivo físico.

Pelo terminal:

```bash
cd 03-exams/01-exam/02-chocolate-storage
./gradlew assembleDebug
```

O APK é gerado em `app/build/outputs/apk/debug/`.

---

## 👨‍💻 Sobre

**Estudante:** Lucas Emmanuel  
**Instituição:** IFTM - Instituto Federal do Triângulo Mineiro  
**Curso:** Análise e Desenvolvimento de Sistemas  

---

Sinta-se à vontade para explorar os códigos e acompanhar minha evolução! 🎯
</details>
