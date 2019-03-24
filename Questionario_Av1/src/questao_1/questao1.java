package questao_1;

import java.util.Scanner;

public class questao1 {

	/*
	Questão 1 (ArrayObjetos): Faça um programa, utilizando a classe Pessoa, que permita:
	1.	Inserir pessoas em uma lista, com os dados lidos via teclado.
	2.	Listar todas as pessoas armazenadas.
	Observações:
	- Apresente um menu para o usuário de forma que ele possa realizar estas operações (Inserir ou Listar) 
	repetidas vezes, até que deseje sair.
	 */
	
	static final int TOTAL = 100;
	
	static int index = 0;
	 
	static Pessoa2[] lista = new Pessoa2[TOTAL];
	
	//static Conta[] lista = new Conta[MAXCONTA];
	
	static Scanner tecla = new Scanner(System.in);
	
	static class Pessoa2{
		
		private String nome;
		private int idade;
		private double altura;
		
		public Pessoa2() {
			
		}
		
		public Pessoa2(String nome, int idade, double altura) {
			this.nome = nome;
			this.idade = idade;
			this.altura = altura;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public int getIdade() {
			return idade;
		}
		
		public void setIdade(int idade) {
			this.idade = idade;
		}
		
		public double getAltura() {
			return altura;
		}
		
		public void setAltura(double altura) {
			this.altura = altura;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		int op = 0;
		
		do {
			
			System.out.println("Menu");
			System.out.println("1 - para criar um novo usuário.");
			System.out.println("2 - para listar todos os usuários.");
			System.out.println("3 - para encerrar o programa.");
			op = tecla.nextInt();
		
			switch (op) {
			case 1:
				
				incluirUsuario();
				break;
				
			case 2:
				
				mostrarUsuarios();
				break;
				
			case 3:
				System.out.println("Encerrando programa!");
				break;
			
			default:
				System.out.println("Opção não encontrada, tente novamente!");

			}
			
		}while( op != 3 );
	}
	
    public static void incluirUsuario(){
    	tecla.nextLine();
		System.out.println("Digite o nome do novo usuário: ");
		String auxNome = tecla.nextLine();
		
		System.out.println("Digite a idade do novo usuário:");
		int auxIdade = tecla.nextInt();
		
		System.out.println("Digite a altura do novo usuário");
		double auxAltura = tecla.nextDouble();
		
		lista[index++] = new Pessoa2(auxNome,auxIdade,auxAltura);
    }
    
    public static void mostrarUsuarios(){
    	
    	if(index == 0) {
    		System.out.println("Lista vazia!");
    	}else {
    		for( int i = 0 ; i < lista.length - 1 ; i++ ) {
    			if (lista[i] != null)
    				System.out.println("Usuário N°"+(i+1)+" - Nome: "+lista[i].getNome()+" - Idade: "+lista[i].getIdade()+" - Altura: "+lista[i].getAltura());			
    			else
    				break;
    		}
    	}
    }
	
}
