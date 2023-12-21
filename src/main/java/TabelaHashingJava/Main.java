package TabelaHashingJava;

import java.util.List;
import java.util.Scanner;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);

	public static void line() {
		System.out.println("============================================");
	}

	public static void subMenuArquivo() {

		line();
		System.out.println("\nOpções:");
		System.out.println("\t1 - Recuperar");
		System.out.println("\t2 - Imprimir Histograma");
		System.out.println("\t0 - Sair");
		System.out.print(" >>> ");
	}

	public static void subMenuManual() {

		line();
		System.out.println("\nOpções:");
		System.out.println("\t1 - Inserir");
		System.out.println("\t2 - Recuperar");
		System.out.println("\t3 - Imprimir Histograma");
		System.out.println("\t0 - Sair");
		System.out.print(" >>> ");
	}

	public static void menu() {

		line();
		System.out.println("\n             Menu Principal");
		System.out.println("\nSelecione a opção de entrada:");
		System.out.println("\t1 - Leitura do arquivo: Chaves.txt");
		System.out.println("\t2 - Inserir Manualmente");
		System.out.println("\t0 - Sair");
		System.out.print(" >>> ");
	}

	public static void menuTipoHash() {

		line();
		System.out.println("\nSelecione o tipo de Hash:");
		System.out.println("\t1 - Hash por Módulo");
		System.out.println("\t2 - Hash por Multiplicação");
		System.out.println("\t3 - Hash por Enlaçamento Deslocado");
		System.out.println("\t4 - Hash por Enlaçamento Limite");
		System.out.println("\t5 - Hash por Meio-Quadrado");
		System.out.println("\t6 - Hash por Extração");
		System.out.println("\t7 - Hash por Transformação");
		System.out.println("\t0 - Sair");
		System.out.print(" >>> ");
	}

	private static void processInputType(String option) {
		boolean choice;
		if (option.equals("1")) {
			choice = true;
			handleFileInput(choice);
		} else if (option.equals("2")) {
			choice = false;
			handleManualInput(choice);
		} else {
			System.out.println("\nOpção inválida! Tente novamente!");
		}
	}

	private static void handleManualInput(boolean choice) {
		chooseHashMethod(null, choice);
	}

	private static void handleFileInput(boolean choice) {
		Data data = new Data(); // Cria uma instância de Data
		List<String> chaves = data.getDados(); // Obtém todas as chaves
		data.printData();
		chooseHashMethod(chaves, choice);
	}

	private static void chooseHashMethod(List<String> chaves, boolean isFromFile) {

		while (true) {
			menuTipoHash();
			String option = scanner.nextLine();

			if (option.equals("0")) {
				System.out.println("\n\nVoltando ao menu principal...\n");
				return;
			}
			
			switch (option) {
				case "1":				
					handleHashPorModulo(chaves, isFromFile);
					break;
				case "2":
					handleHashPorMultiplicacao(chaves, isFromFile);
					break;
				case "3":
					handleHashPorEnlaçamentoDes(chaves, isFromFile);
					break;
				case "4":
					handleHashPorEnlaçamentoLim(chaves, isFromFile);
					break;
				case "5":
					handleHashPorMeioQuadrado(chaves, isFromFile);
					break;
				case "6":
					handleHashPorExtracao(chaves, isFromFile);
					break;
				case "7":
					handleHashPorTransformacao(chaves, isFromFile);
					break;
				default:
					System.out.println("\nOpção inválida! Tente novamente!");
			}
		}
	}

	private static void handleHashPorModulo(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorModulo();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorMultiplicacao(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorMultiplicacao();

		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorEnlaçamentoDes(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorEnlacamentoDeslocado();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorEnlaçamentoLim(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorEnlacamentoLimite();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorMeioQuadrado(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorMeioQuadrado();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorExtracao(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorExtracao();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleHashPorTransformacao(List<String> chaves, boolean isFromFile) {
		HashMethod hashMethod = new HashPorTransformacao();
		if (isFromFile) {
			hashMethod.inserirchaves(chaves);
			handleSubMenuArquivo(hashMethod);
		} else {
			handleSubMenuManual(hashMethod);
		}
	}

	private static void handleSubMenuArquivo(HashMethod hashMethod) {

		while (true) {
			subMenuArquivo();
			String option = scanner.nextLine();
			if (option.equals("0")) {
				System.out.println("\n\nRetornando ao menu anterior...\n");
				break;
			}
			switch (option) {
				case "1":
					System.out.print("Digite a chave a ser Recuperada: ");
					String keyToS = scanner.nextLine();

					boolean found = hashMethod.recuperar(keyToS);
					if (found)
						System.out.println("Chave \"" + keyToS + "\" encontrada!");
					else
						System.out.println("Chave \"" + keyToS + "\" não encontrada!");
					break;
				case "2":
					System.out.println("Imprimindo...");
					hashMethod.imprimirHistograma();
					break;
				default:
					System.out.println("\nOpção inválida! Tente novamente!");
			}
		}
	}

	private static void handleSubMenuManual(HashMethod hashMethod) {

		while (true) {
			subMenuManual();
			String option = scanner.nextLine();
			if (option.equals("0")) {
				System.out.println("\n\nRetornando ao menu anterior...\n");
				break;
			}
			switch (option) {
				case "1":
					System.out.print("Digite a chave que deseja inserir: ");
					String key = scanner.nextLine();
					hashMethod.inserir(key);
					System.out.println("Chave \"" + key + "\" Adicionada!");
					break;

				case "2":
					System.out.println("Digite a chave a ser Recuperada: ");
					String keyToS = scanner.nextLine();

					boolean found = hashMethod.recuperar(keyToS);
					if (found) {
						System.out.println("Chave \"" + keyToS + "\" encontrada!");
					} else {
						System.out.println("Chave \"" + keyToS + "\" não encontrada!");
					}
					break;
				case "3":
					System.out.println("Imprimindo...");
					hashMethod.imprimirHistograma();
					break;
				default:
					System.out.println("\nOpção inválida! Tente novamente!");
			}
		}
	}

	public static void main(String[] args) {
		String option;
		line();
		System.out.println("              Projeto Hashing");
		System.out.println("         Professor: Marcos Canejo");
		System.out.println("      Disciplina: Estrutura de Dados 2");
		line();

		System.out.println("Aluno: Lucas Felinto Vieira de França");
		System.out.println("RA: 2019203545");
		line();

		System.out.println("\nBem-vindo ao programa do Projeto Hashing!\n");

		while (true) {
			menu();
			option = scanner.nextLine();

			if (option.equals("0")) {
				line();
				System.out.println("\nAdeus!");
				break;
			}
			processInputType(option);
		}
	}
}