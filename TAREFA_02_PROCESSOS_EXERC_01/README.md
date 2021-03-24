# Sistemas Operacionais I: Primeiro exercício - Processos
> Descrição do exercício proposto:

Criar em Eclipse, um novo Java Project com uma classe chamada RedesController.java no package controller e uma classe Main.java no package view.

A classe RedesController.java deve ter 2 métodos.

O primeiro, chamado ip, que recebe o nome do Sistema Operacional como parâmetro e, de acordo com o S.O., faz a chamada de configuração de IP e filtra a saída do processo, retornando um String com o nome do Adaptador Ethernet e o IPv4 apenas (Não importa o número de adaptadores ethernet, devem aparecer todos). Os adaptadores que não tiverem IPv4 não devem ser mostrados.

O segundo, chamado ping, que recebe o nome do Sistema Operacional como parâmetro e, de acordo com o S.O., faz a chamada de ping com 10 iterações, filtra a saída, pegando apenas o tempo e dá a saída, em ms, do tempo médio do ping. (O endereço para ping, pode ser o www.google.com.br)

A Classe Main.java deve ter a possibilidade de o usuário escolher a ação que quer fazer e, dependendo da escolha, instanciar a ClasseRedesController.java e chamar o método escolhido. A opção de finalizar a aplicação também deve estar disponível.
* Para filtrar a saída String, considere utilizar contains, Split, substring, lastIndexOf, trim;
