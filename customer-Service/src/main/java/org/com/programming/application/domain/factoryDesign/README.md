# Factory Design

O principal uso dele é: Em vez de usar `new` diretamente em vários lugares do sistema, você delega a criação para uma “fábrica”.

Vale lembrar que o código sempre QUER ALGUMA COISA e não uma instância específica de uma classe concreta usando um X construtor.


Usando o padrão **Factory** você só pede o que quer sem se preocupar com os detalhes.

### O verdadeiro objetivo é:

- Encapsular regras de criação;
- permitir variações;
- desacoplar código;