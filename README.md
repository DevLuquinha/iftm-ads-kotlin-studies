# 📱 Kotlin Studies and Projects

[![Kotlin](https://img.shields.io/badge/Kotlin-Android-purple.svg?style=flat-square&logo=kotlin)](https://kotlinlang.org/)
[![Android](https://img.shields.io/badge/Android-SDK_36+-green.svg?style=flat-square&logo=android)](https://developer.android.com/)
[![Build](https://img.shields.io/badge/Build-Gradle_9.5-blue.svg?style=flat-square&logo=gradle)](https://gradle.org/)
[![Semester](https://img.shields.io/badge/Semester-4th_Period-blue.svg?style=flat-square)](#)

This repository holds my first steps with **Kotlin and Android development**, as part of the **Computer Systems Analysis and Development** program at the **Federal Institute of Triângulo Mineiro (IFTM)**.

It is a learning repository: the projects here are small, exploratory, and written while I get comfortable with the language and the Android SDK.

> 📌 Studies in other languages live in their own repositories: [`iftm-ads-c-studies`](https://github.com/DevLuquinha/iftm-ads-c-studies) and [`iftm-ads-java-studies`](https://github.com/DevLuquinha/iftm-ads-java-studies).

---

## 📂 Projects

### 🧮 BhaskaraCalculator

An Android app that solves quadratic equations using the **Bhaskara formula**. The user types the coefficients `a`, `b`, and `c`, and the app reports the roots along with the coordinates of the parabola's vertex.

What it covers:

* **Kotlin basics:** `val` / `var`, type annotations, string templates (`"Root 1: $tempRoot1"`), conditionals.
* **Activities & lifecycle:** extending `AppCompatActivity` and setting up the screen in `onCreate`.
* **View binding by ID:** `lateinit var` properties resolved through `findViewById`.
* **Layouts:** a `ConstraintLayout` built in XML with `EditText`, `Button`, and `TextView` widgets.
* **Event handling:** `setOnClickListener` with a lambda to run the calculation.
* **Branching on the discriminant:** two real roots (`Δ > 0`), one root (`Δ = 0`), or none (`Δ < 0`).

---

## 🛠️ Technologies

- **Language:** Kotlin
- **UI Toolkit:** Android Views (XML layouts + ConstraintLayout)
- **Build Tool:** Gradle 9.5 (Kotlin DSL, version catalog)
- **Android Gradle Plugin:** 9.3.1
- **SDK:** compileSdk 37 · minSdk 36 · targetSdk 36
- **Java Compatibility:** 11
- **IDE:** Android Studio

---

## ⚙️ How to Run

```bash
cd BhaskaraCalculator
./gradlew assembleDebug
```

Or open the `BhaskaraCalculator` folder in **Android Studio** and run the `app` configuration on an emulator or a physical device.

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

Este repositório guarda meus primeiros passos com **Kotlin e desenvolvimento Android**, como parte do curso de **Análise e Desenvolvimento de Sistemas (ADS)** no **Instituto Federal do Triângulo Mineiro (IFTM)**.

É um repositório de aprendizado: os projetos aqui são pequenos e exploratórios, escritos enquanto eu me familiarizo com a linguagem e com o SDK do Android.

> 📌 Os estudos em outras linguagens ficam em repositórios próprios: [`iftm-ads-c-studies`](https://github.com/DevLuquinha/iftm-ads-c-studies) e [`iftm-ads-java-studies`](https://github.com/DevLuquinha/iftm-ads-java-studies).

---

## 📂 Projetos

### 🧮 BhaskaraCalculator

Um aplicativo Android que resolve equações do segundo grau usando a **fórmula de Bhaskara**. O usuário digita os coeficientes `a`, `b` e `c`, e o app informa as raízes junto com as coordenadas do vértice da parábola.

O que ele exercita:

* **Fundamentos de Kotlin:** `val` / `var`, anotação de tipos, templates de string (`"Root 1: $tempRoot1"`), condicionais.
* **Activities e ciclo de vida:** herdando de `AppCompatActivity` e montando a tela no `onCreate`.
* **Ligação de views por ID:** propriedades `lateinit var` resolvidas via `findViewById`.
* **Layouts:** um `ConstraintLayout` montado em XML com widgets `EditText`, `Button` e `TextView`.
* **Tratamento de eventos:** `setOnClickListener` com lambda para disparar o cálculo.
* **Decisão pelo discriminante:** duas raízes reais (`Δ > 0`), uma raiz (`Δ = 0`) ou nenhuma (`Δ < 0`).

---

## 🛠️ Tecnologias

- **Linguagem:** Kotlin
- **Toolkit de UI:** Android Views (layouts XML + ConstraintLayout)
- **Ferramenta de Build:** Gradle 9.5 (Kotlin DSL, catálogo de versões)
- **Android Gradle Plugin:** 9.3.1
- **SDK:** compileSdk 37 · minSdk 36 · targetSdk 36
- **Compatibilidade Java:** 11
- **IDE:** Android Studio

---

## ⚙️ Como Executar

```bash
cd BhaskaraCalculator
./gradlew assembleDebug
```

Ou abra a pasta `BhaskaraCalculator` no **Android Studio** e rode a configuração `app` em um emulador ou dispositivo físico.

---

## 👨‍💻 Sobre

**Estudante:** Lucas Emmanuel  
**Instituição:** IFTM - Instituto Federal do Triângulo Mineiro  
**Curso:** Análise e Desenvolvimento de Sistemas  

---

Sinta-se à vontade para explorar os códigos e acompanhar minha evolução! 🎯
</details>
