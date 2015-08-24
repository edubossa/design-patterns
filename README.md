# design-patterns
23 Patterns GOF and 10 Patterns Java EE Blueprints

#[Creational Design Patterns]

1- Singleton: cria unica instancia da aplicacao, devemos levar em contra o acesso simultaneo na inicializacao desse objeto,
sincronizando a construcao do mesmo. Esse design pattern nao e recomendado para utilizacao em clauster,
pois ao inicializar a instancia em JVM diferentes ele deixaria de ser singleton.

2- Factory Method: se concentra em fornecer um ponto padrão de criação de objetos de uma mesma hierarquia

3- Abstract Factory: prevê maior flexibilidade no modelo permitindo a troca da classe que implementa Factory Method com dinamismo

4- Builder: Utilizado quando temos que criar um objeto que contem muitas referencias de outros objetos, resolvendo
	de forma mais clara o que nao e possivel resolver com o pattern Factory. Tambem podemos utilizar esse pattern
	em conjunto com a criacao de objetos fluentes.

5- Prototype: Utilizado quando precisamos ter um copia de determinado objeto, para reuso de regras especificas,
	um exemplo do seu uso seria buscar uma grande quantidade de informacoes na base de dados, e fazer uma copia
	para aplicacao das regras, obtendo assim um maior ganho em desempenho de nao ter que buscar novamente essas
	informacoes na base de dados.


#[Structural Design Patterns]

1- Adapter: Podemos dizer que e um design pattern de compatibilizacao da interfaces de objetos distintos, porem com abstracao semelhantes.

2- Composite: e um design de estruturas de objetos onde temos uma arvore que o representa como partes-todo.Tipicamente modelos Composite
trabalham com sistemas de nós que são chamados de árvore. Em uma árvore de objetos podemos ter nós do tipo galho, que poderão conter
outros nós, e nós do tipo folha, que não podem conter outros nós.

3- Proxy: Fornece um objeto susbstituto mediante o proxy, com acesso controlado para essa funcionalidade.

4- Flyweight: é um padrão que propõe a técnica de compartilhamento de objetos para trabalhar com grandes volumes de dados granularizados. E bastante
	utilizado para reaproveitamento de instancias.
	Não é muito usual implementar o padrão Flyweight nos sistemas que ocorrem no dia a dia. Usualmente nos
	elementos em que podemos nos favorecer mais na economia de criação de instâncias, já foi feita uma
	implementação nas próprias APIs do Java. Exemplos de classes que utilizam o padrão são:
	• String
	• Wrapper classes para valores inteiros numéricos até o valor de 127
	• Enums
	• classes da API de Swing como classes que representam bordas (implementações javax.swing.border.Border) e nós de JTrees.

5- Facade: encapsula o acesso a uma determinada funcionalidade, tornando o acesso mais simples e a interface mais amigavel.

7- Bridge: tem como objetivo desacoplar uma abstracao de sua implementacao, permitindo que ambas variem de forma independente.
	 Pode ser usado quando ambos abstração e implementação pode ter hierarquias diferentes de forma independente e queremos esconder a
   implementação do aplicativo cliente.

7- Decorator: e um design muito util quando queremos adicionar comportamento / responsabilidades em classes distintas, sendo usado
	 para modificar a funcionalidade de um objeto em tempo de execucao.

#[Behavioral Design Patterns]

1- Template Method: é uma técnica de modelagem de classes abstratas e sub-classes, que se baseia na seguinte idéia:
	--> Definimos uma classe abstrata com métodos abstratos e métodos concretos.
	--> Nos métodos concretos da classe abstrata, definimos a estrutura dos algoritmos, chamando seus métodos abstratos, mesmo sem saber qual será a implementação.
	--> Definimos sub-classes que implementam os métodos abstratos.

2- Mediator: e usado para proporcionar um meio de comunicacao centralizada entre diferentes objetos do sistema. E muito util em um aplicativo corporativo,
	onde varios objetos estao interagindo uns com os outros proporcionando um baixo acoplamento entre eles.

3- Chain of Responsibility: Promove o desacoplamento entre um objeto solicitante e o objeto solicitado, dando a oportunidade da requisição
	trafegar por uma cadeia de comportamentos que poderão agregar tratamentos.

4- Observer: defini uma dependência um-para-muitos entre objetos, de modo que quando um objeto muda de estado, todos os seus dependentes são notificados
	e atualizados automaticamente.

5- Strategy: É um design pattern bastante voltado para encapsulamento de algoritmos que podem variar com facilidade para
	prover um comportamento mais adequado para um objeto frente a uma situação.

6- Command: Este design pattern é bastante aplicado em diversos frameworks de interfaces gráficas e interfaces Web.
	Aplicamos o Command para encapsular ações que geralmente estão associadas a um objeto de interface gráfica, como por exemplo um botão.

7- State: O design pattern State permite que parte do comportamento de um objeto seja alterado conforme o estado do objeto.

8- Visitor: permite acrescentarmos operações em um objeto sem a necessidade de alterá-lo. Propondo um modelo onde uma classe Visitor, poderá
	representar a operação para todos os seus sub-tipos e esta operação poderá ser acionada pelo objeto sem ele conhecer sua realização concreta.

9- Interpreter: propõe um modelo de objetos para definir uma representação para as sentenças gramaticais de uma linguagem, de forma que a linguagem poderá facilmente
	 ampliar sua gramática e respectivos algoritmos de interpretação.
	 O pattern Interpreter é aplicável em casos como por exemplo:
			• linguagens de Query especializadas como EJB-QL e HQL
			• linguagens utilizadas para descrever protocolos de comunicação
			• linguagens para orquestração de serviços
			• qualquer linguagem de domínio especializada

10- Iterator: propõe a centralização da regra de navegação em objetos em uma classe, de forma que tal regra possa variar e
	  ele não tenha que expor excessivamente sua estrutura interna de correlacionamento com os objetos que serão percorridos.

11- Memento: é o conceito de se capturar o estado de um objeto em um determinado cenário para posteriormente poder restaurar o objeto para tal estado. O uso mais
	  popular deste design pattern vem sendo para sistemas de desfazer, pois esta necessidade vem de encontro com Memento, porém operações de desfazer também são
    necessárias em transações e orquestração de processos, tornando a aplicação deste design pattern bastante atraente para cenários corporativos em geral.


#[Java EE Blueprints]

1- Service Locator

2- Data Acess Object

3- Transfer Object / Value Object

4- Front Controller

5- Model-view-controller

6- Composite View

7- Business Delegate

8- Application Controller

9- Intercepting Filter

10- View Helper
