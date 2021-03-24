# Sistemas Operacionais I: Segundo exercício - Processos
> Descrição do exercício proposto:

Fazer, em java, uma aplicação que liste os processos ativos, permita ao usuário entrar com o nome ou o PID do processo e o mate.

A aplicação deverá funcionar, minimamente em Windows e Linux (Alunos com Mac podem fazer para os 3 SO).

É notório que cada SO tem comandos diferentes para as ações supracitadas. Pesquisar os comandos para cada SO.

A aplicação deverá ter, no package view, uma classe que tenha um método main que dê ao usuário a possibilidade de ver os processos ativos ou matar os processos (Por Nome ou PID).

No package controller, deverá ter:

1.  Uma classe que tenha um método que identifique o SO;
2.  Um método que, recebendo o SO, no qual está rodando, como parâmetro de entrada, selecione o comando para listar os processos ativos;
3.  Um método que, recebendo o SO, no qual está rodando, e o PID do processo, como parâmetros de entrada, selecione o comando para matar o processo e o finalize;
4.  Um método que, recebendo o SO, no qual está rodando, e o Nome do processo, como parâmetros de entrada, selecione o comando para matar o processo e o finalize.
