# Sistemas Operacionais I: Terceiro exercício - Processos
> Descrição do exercício proposto:

Utilizando o Framework Window Builder, criar, em Eclipse, um projeto Java que simula o Executar (Run) do Windows.

No package view, deve ser criado, com auxílio do framework, conforme figura abaixo, uma tela com um JTextField e 3 botões (OK, Cancelar e Procurar).

No package controller, devemos ter:
1) Uma classe que receba o JTextField pelo construtor, implementa um ActionListener para executar a ação do botão Procurar. No método ActionPerformed, deve ter uma busca de arquivos executáveis Windows, via JFileChooser, e seleciona o arquivo a ser executado e escreve seu caminho completo no JTextField.
2) Uma classe que receba o JTextField e o próprio JFrame da tela pelo construtor, implementa um ActionListener para executar a ação do botão OK. No método ActionPerformed, deve tentar executar o que está escrito no JTextField (O usuário pode digitar o caminho por conta própria, ao invés de procurar). Caso o arquivo seja inválido, dar uma mensagem de erro. Uma vez executado, sem erro, a tela deverá ser finalizado pelo método dispose().
3) Uma classe que receba o próprio JFrame da tela pelo construtor, implementa um ActionListener para executar a ação do botão Cancelar. O método actionPerformed deve proceder um dispose() da tela.

![Exemplo](https://i.imgur.com/w2X0LQJ.png)
```
Assistir, no site do Professor, os vídeos:
1) Eclipse Window Builder Aplicação com ActionListener implementado
2) Introdução ao JFileChooser
```
Resultado:

![Resultado do exercício](https://i.imgur.com/N3VB8VX.png)
