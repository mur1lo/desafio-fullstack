# desafio-involves-fullstack


# Alguns problemas que eu encontrei durante o desafio 

	1) Refactory das estruturas e nomeclatura para a convenção java
	2) Foi removido o alto nivel de acoplamentos e refatorado a classe ProcessadorAlertas, tambem foi renomeada para AlertaRest, 
	   em resumo irei definir Refatoração como reescrita e melhora no código
	3) Refatordo com:
	# Padrão Strategy
	 Padrão Strategy tem como Intenção:
         "Definir uma família de algoritmos, encapsular cada uma delas e torná-las intercambiáveis. 
	 Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam"(como definido no livro do GoF)
	 Ou seja, o padrão sugere que algoritmos parecidos (método processarAlerta) nos permite configurar uma classe com um de vários 
	 comportamentos, utilizando o conceito de OO chamado de composição.

	4) Aplicação Testes Unitarios
		
	
	**Atenção: Você precisa do Mongo DB instalado e rodando para prosseguir e node js instalado**

	1. Para o backend entre na pasta desafio-fullstack-backend
	```
	gradlew bootRun
	```
	
	
	2. Para o front entre na pasta desafio-fullstack-frontend
	```
	npm install
	npm run dev
	```
