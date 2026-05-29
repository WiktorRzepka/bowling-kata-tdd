# Bowling Game Kata (TDD + JUnit 6 + CI + Quality Gates)

![Java CI](https://github.com/iis-io-team/bowling-kata-tdd/actions/workflows/java-ci.yml/badge.svg?branch=main)

A small demo project for **Test-Driven Development (TDD)** based on [Robert C. Martin's Bowling Game Kata](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata) (Uncle Bob), using:
- **JUnit 6** for unit tests
- **Maven** for build
- **GitHub Actions** for [Continuous Integration](https://docs.github.com/en/actions/tutorials/build-and-test-code/java-with-maven)
- **PMD + Checkstyle** for static code analysis

## 🎳 Bowling Rules (original kata)

> The game consists of 10 frames. In each frame the player has two rolls to knock down 10 pins. The score for the frame is the total number of pins knocked down, **plus bonuses for strikes and spares**.
>
> - **Spare**: 10 pins in two rolls → bonus = next roll
> - **Strike**: 10 pins in first roll → bonus = next two rolls
>
> [Original kata by Uncle Bob](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata) | [PDF slides](http://butunclebob.com/files/downloads/Bowling%20Game%20Kata.ppt)

## 🛠️ Requirements

- Java 17+
- Maven 3.8+
- Git

## 🚀 Quick Start

```bash
mvn clean verify  # Tests + Checkstyle + PMD
