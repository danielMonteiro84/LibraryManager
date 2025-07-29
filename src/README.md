# 📚 Sistema de Locadora de Livros em Java

Este é um projeto simples de console desenvolvido em Java que simula uma locadora de livros. Ele permite o cadastro de livros e autores, a realização de empréstimos e devoluções, bem como o controle de disponibilidade de cada item.

---

## 🚀 Funcionalidades

- Cadastro de livros com título, autor e data de registro
- Registro de autores
- Listagem de livros disponíveis e todos os livros cadastrados
- Empréstimo de livros a usuários, com controle de status
- Devolução de livros com verificação por ID do empréstimo
- Registro de datas de criação e atualização dos livros (ainda será implementado)
- Menu dinâmico via console com interação do usuário

---

## 🧠 Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento e modularização
- Uso de coleções (`ArrayList`)
- Datas com `java.util.Date`
- Controle de estado de objetos (`available`, `active`)
- Menu interativo no console
- Boas práticas com classes e métodos coesos

---

## 🏗️ Estrutura de Classes

- `Book`: representa um livro
- `Author`: representa um autor
- `Lend`: representa um empréstimo de livro
- `Library`: gerencia o catálogo e os empréstimos
- `Main`: ponto de entrada da aplicação com menu interativo

---

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/locadora-livros-java.git
