# Sistemas Operacionais I: Terceiro exercício - Thread Semaphore
> Descrição do exercício proposto:

Um grande show acontecerá no Brasil, em uma casa com capacidade para 100 pessoas.

A venda será feita exclusivamente pelo sistema.

Simultaneamente, 300 pessoas, no primeiro instante acessam o sistema de compra.

As pessoas podem comprar de 1 a 4 ingressos por compra, sendo que isso é uma condição aleatória.

Os passos para a compra são:

1) Login no sistema: Processo que pode demorar de 50 ms a 2 s, sendo que, se o tempo passar de 1s, ao final do tempo de espera de login, o comprador recebe uma mensagem de timeout e, por não conseguir fazer o login, não poderá fazer a compra.

2) Processo de compra: processo que pode demorar de 1 s a 3 s, sendo que, se o tempo passar de 2,5s, ao final do tempo de espera da compra, o comprador recebe uma mensagem de final de tempo de sessão e, por estourar o tempo de sessão, não poderá fazer a compra.

3) Validação da compra: O sistema deve verificar se há ingressos suficientes para finalizar a compra. Se houver, faz a compra e subtrai do total de ingressos disponíveis. O sistema comunica a venda da quantidade de ingressos para o usuário e a quantidade de ingressos ainda disponíveis. Se não houver a totalidade dos ingressos disponibilizados, o comprador recebe mensagem sobre a indisponibilidade dos ingressos e, como não é possível fracionar a quantidade pedida, este perde a possibilidade de compra na sessão.

Simular em Java essa situação

* O processo de validação da compra, apenas 1 comprador por vez,
pois a finalização do processo depende da disponibilidade de
ingressos.

* Os processos de Login e escolha da quantidade de ingressos, por
não depender de mais nada, devem ser feito simultaneamente
entre todos os compradores.
