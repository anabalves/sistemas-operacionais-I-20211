# Sistemas Operacionais I: Sétimo exercício - Thread Semaphore
> Descrição do exercício proposto:


Um banco deve controlar Saques e Depósitos.

O sistema pode permitir um Saque e um Depósito simultâneos, mas nunca 2 Saques ou 2 Depósitos simultâneos.

Para calcular a transação (Saque ou Depósito), o método deve receber o código da conta, o saldo da conta e o valor a ser transacionado.

Deve-se montar um sistema que deve considerar que 20 transações simultâneas serão enviadas ao sistema (aleatoriamente essas transações podem ser qualquer uma das opções) e tratar todas as transações, de acordo com as regras acima.
