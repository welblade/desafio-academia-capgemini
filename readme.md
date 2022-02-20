<h1 align="center">
<img src="https://capgemini.proway.com.br/assets/img/logo-capgemini.png" /><br/>
DESAFIO DE PROGRAMAÇÃO - ACADEMIA CAPGEMINI
</h1>

Terceira etapa do processo de seleção para a Academia Capgemini 2022. 
O objetivo é testar os seus conhecimentos em lógica de programação, 
para isso foram propostos três desafios com diferentes níveis de dificuldade.

### Requisitos:
 - Java JDK 11

### Instruções para execução do programa
Embora não seja o melhor, o modo mais fácil de executar o programa é usando o gradle wrapper que está na pasta do projeto. Ele deve ser executado no terminal (prompt de comando no windows), a partir do diretório raiz do repositório.

    ./gradlew -q <questao>  --args='<argumento>'

no windows o comando é 
    
    ./gradle.bat -q <questao>  --args='<argumento>'

#### Questão 01: 
Mostra na tela uma escada de tamanho N utilizando o caractere * e espaços.
    
    ./gradlew -q questao1  --args='6'

#### Questão 02:
Um programa que informa qual é o número mínimo de caracteres que devem ser adicionados para uma string qualquer ser considerada segura de acordo com a especificação.

    ./gradlew -q questao2  --args='$Shu12'

#### Questão 03:
Um algoritmo que encontra o número de pares de substrings que são anagramas na string fornecida.

    ./gradlew -q questao3  --args='ifailuhkqq'

#### Tecnologia Usada

Os programas basicamentes foram escritas em java usando a jdk 11, as poucas bibliotecas adicionadas ao projeto são apara auxiliar com os testes:

 - [JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
   - Plataforma utilizada para criar os testes unitários.
 - [AssertJ](https://assertj.github.io/doc/)
   - Uma biblioteca para fazer as asserções nos testes, ela foi escolhida por que eu acho que as asserções ficam muito mais legíveis e fluídas do com a biblioteca padrão do JUnit. 
 - [Console Captor](https://github.com/Hakky54/console-captor)
   - Esta biblioteca tem a função de redirecionar a saída padrão dos programas em javas, dessa forma é possível fazer verificações das saídas (System.out) facilmente para testar e conferir o resultado.