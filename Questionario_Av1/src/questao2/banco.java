package questao2;

import java.awt.List;
import java.util.Scanner;

public class banco {

	/*
	Questão 2 (BANCO SIMPLES): Desenvolva um Sistema de Controle Bancário para correntistas de dado banco,
	em Java, com as seguintes funcionalidades:
	1.	Inserir nova conta: entrar com numero e saldo.
	2.	Excluir conta: entrar com seu número da conta.
	3.	Efetuar operações de débito ou crédito em contas: escolher o número da conta e valor.
	4.	Consultar saldo da conta: entrar com o seu número da conta.
	5.	Efetuar operação de transferência entre contas: escolher os números das contas e o valor. 
	
	Observações:
	- Utilizar arrays.
	- Criar um menu de opções para que as funcionalidades acima, incluindo a opção de saída pelo usuário.
	*/
	
	static int index = 0;
	
	static final int TOTAL = 100;
	
	static bancoSimples[] lista = new bancoSimples[TOTAL];
	
	static Scanner tecla = new Scanner(System.in);
	
	static class bancoSimples{
		private int numero;
		private double saldo;
		
		public bancoSimples(int numero , double saldo) {
			this.numero = numero;
			this.saldo = saldo;
		}
		
		public int getNumero() {
			return numero;
		}
		public void setNumero(int numero) {
			this.numero = numero;
		}
		public double getSaldo() {
			return saldo;
		}
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
		
	}
	
	public static void main(String[] args) {
		int op = 0;
		
		do {
		System.out.println("1 - Inserir nova conta");
		System.out.println("2 - Excluir conta");
		System.out.println("3 - Efetuar operações de débito ou crédito em contas");
		System.out.println("4 - Consultar saldo da conta");
		System.out.println("5 - Efetuar operação de transferência entre contas");
		System.out.println("6 - Consultar todas as contas");
		System.out.println("7 - Encerrar programa");
		
		System.out.print(">> ");
		
		op = tecla.nextInt();
			
		switch (op) {
		
		case 1:
			inserirConta();
			break;
			
		case 2:
			excluirConta();
			break;
			
		case 3:
			sacarOuDebitarConta();
			break;
			
		case 4:
			consultarSaldoConta();
			break;
			
		case 5:
			transferenciaConta();
			break;
			
		case 6:
			imprimirTodasContas();
			break;
		
		case 7:
			System.out.println("Encerrando o programa!");
			break;
			
		default:
			System.out.println("Opção inválida, tente novamente!");
			break;
		}
		
		}while( op != 7);
		
		
	}
	
	static public void inserirConta() {
		int auxNum;
		double auxValor;
		System.out.println("Digite o número da conta");
		System.out.print(">> ");
		auxNum = tecla.nextInt();
		
		if( index == 0 ) {
			System.out.println("Digite o valor inicial para a conta: "+ auxNum);
			System.out.print(">> ");
			auxValor = tecla.nextDouble();
		}else {
			
			boolean contaExistente = false;
			
			do {
				for( int i = 0 ; i < index ; i++ ) {
					if( lista[i] != null ) {
						if( auxNum == lista[i].getNumero() ) {
							System.out.println("Essa conta já existe no sistema!");
							contaExistente = true;
							break;
						}
						contaExistente = false;
					}else {
						break;
					}
				}
				
				if( contaExistente == true ) {
					System.out.println("Digite um número para a conta: ");
					auxNum = tecla.nextInt();
				}
				
			}while( contaExistente == true );
			

			
			System.out.println("Digite o valor inicial para a conta: "+ auxNum);
			auxValor = tecla.nextDouble();
			
		}
		
		lista[index++] = new bancoSimples(auxNum,auxValor);
		System.out.println(index);
		
		
	}
	
	static public void excluirConta() {
		int auxNum = 0;
		int indice = 0;
		boolean contaExistente = false;
		
		System.out.println("Digite o número da conta:");
		System.out.print(">> ");
		auxNum = tecla.nextInt();
		
		for( int i = 0 ; i < index ; i++ ) {
			if (lista[i] != null) {
				if( auxNum == lista[i].getNumero() ) {
					indice = i;
					contaExistente = true;
					break;
				}
			}else {
				break;
			}
		}	
		if( contaExistente = false ) {
			System.out.println("Essa conta não existe no sistema!");
		}else {
			
			System.out.println(indice+"+++++++++"+index+" -------");
			
			if( indice == 0 ) {
				index--;
			}else {
				for( int i = indice ; i <= index ; i++ ) {
					//if( lista[i+1] != null )
						lista[i] = lista[i+1];
					//else 
						//break;
					
					
				}
				index--;
			}
		}
		
	}
	
	static public void sacarOuDebitarConta() {
		int op = 0;
		int op2 = 0;
		int auxNum = 0;
		int indice = 0;
		double valorSaque;
		double valorDeposito;
		boolean contaExiste = false;
		
		do {
			System.out.println("1 - para sacar um valor conta");
			System.out.println("2 - para depositar um valor");
			System.out.println("3 - para desistir de realizar a opeação");
			System.out.print(">> ");
			op = tecla.nextInt();
			
			switch (op) {
			
			case 1:
				
				System.out.println("Digite a conta que vamos realizar o saque: ");
				System.out.print(">> ");
				auxNum = tecla.nextInt();
				
				for( int i = 0 ; i < index ; i++ ) {
					if (lista[i] != null) {
						if( auxNum == lista[i].getNumero() ) {
							indice = i;
							contaExiste = true;
							break;
						}
					}else {
						break;
					}
				}
				
				if(contaExiste) {
					
					System.out.println("Digite o valor para saque: ");
					System.out.print(">> ");
					valorSaque = tecla.nextDouble(); 
					
					sacarValor( valorSaque , indice );
					
					System.out.println("Saque realizado com sucesso!");
					
				}else {
					
					System.out.println("Conta não existe no sistema!");
					
				}
				
				contaExiste = false;
				
				break;
				
			case 2:
				
				System.out.println("Digite a conta que vamos realizar o deposito: ");
				System.out.print(">> ");
				auxNum = tecla.nextInt();

					for( int i = 0 ; i < index ; i++ ) {
						if (lista[i] != null) {
							if( auxNum == lista[i].getNumero() ) {
								indice = i;
								contaExiste = true;
								break;
							}
						}else {
							break;
						}
					}
					
					if(contaExiste) {
						
						System.out.println("Digite o valor para deposito: ");
						System.out.print(">> ");
						valorDeposito = tecla.nextDouble(); 
						
						depositarValor( valorDeposito , indice );
						
						System.out.println("Deposito realizado com sucesso!");
						
					}else {
						
						System.out.println("Conta não existe no sistema!");
						
					}
				
				contaExiste = false;
				
				break;
				
			case 3:
				System.out.println("Voltando ao menu principal!");
				break;		
				
			default:
				System.out.println("Opção inválida, tente novamente!");
				break;
				
			}
			
			}while( op != 3);
	}
	
	static public void consultarSaldoConta() {
		
		int auxNum = 0;
		int indice = 0;
		boolean contaExiste = false;
		
		System.out.println("Digite a conta que vamos realizar a consulta de saldo: ");
		System.out.print(">> ");
		auxNum = tecla.nextInt();
		
		if( index == 0 ) {
			System.out.println("Conta não existe no sistema!");
		}else {
			for( int i = 0 ; i < index ; i++ ) {
				if (lista[i] != null) {
					if( auxNum == lista[i].getNumero() ) {
						indice = i;
						contaExiste = true;
						break;
					}
				}else {
					break;
				}
			}
			
			if(contaExiste) {
				
				saldoconta(indice);
				
			}else{
				
				System.out.println("Conta não existe no sistema!");
				
			}
			
		}
		
		
	}
	
	
	static public void transferenciaConta() {
		int auxNum = 0;
		int auxNum2 = 0;
		double valor = 0;
		int indice = 0;
		int indice2 = 0;
		boolean contaExiste = false;
		boolean contaExiste2 = false;
		
		System.out.println("Digite a conta que vai transferir o valor:");
		auxNum = tecla.nextInt();
		

		
		if( index == 0 ) {
			System.out.println("Conta não existe no sistema!");
		}else {
			for( int i = 0 ; i < index ; i++ ) {
				if (lista[i] != null) {
					if( auxNum == lista[i].getNumero() ) {
						indice = i;
						contaExiste = true;
						break;
					}
				}else {
					break;
				}
			}
			
			if(contaExiste) {
				
				System.out.println("Digite o valor ");
				valor = tecla.nextDouble();
				
				if( valor <= lista[indice].getSaldo() ) {
					System.out.println("Digite a conta que vai receber a transferencia:");
					auxNum2 = tecla.nextInt();
					
					for( int i = 0 ; i < index ; i++ ) {
						if (lista[i] != null) {
							if( auxNum2 == lista[i].getNumero() ) {
								indice2 = i;
								contaExiste2 = true;
								break;
							}
						}else {
							break;
						}
					}
					
					if(contaExiste2) {
						sacarValor(valor, indice);
						depositarValor(valor, indice2);
						System.out.println("Transferencia de "+valor+" da conta "+lista[indice].getNumero()+" para a conta "+lista[indice2].getNumero());
					}else {
						System.out.println("Conta não existe no sistema!");
					}
					
				}
				
			}else{
				
				System.out.println("Conta não existe no sistema!");
				
			}
			
		}
		
		
	}
	
	static public void sacarValor(double valor,int indice) {
		lista[indice].saldo -= valor;
	}
	
	static public void depositarValor(double valor,int indice) {
		lista[indice].saldo += valor;
	}
	
	static public void saldoconta(int indice) {
		System.out.println("Número da conta: "+lista[indice].getNumero()+"\nSaldo da conta: "+lista[indice].getSaldo());
	}
	
	static public void imprimirTodasContas() {
		for (int i = 0; i < index; i++) {
			System.out.println("Número da conta: "+lista[i].getNumero());
			System.out.println("Saldo da conta: "+lista[i].getSaldo());
			
		}
	}
	
}
