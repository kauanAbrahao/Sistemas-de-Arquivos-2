package main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import controller.FifaController;
import controller.FifaControllerInterface;

public class Principal {
	
	public static void main(String[] args) {
		
		String caminho = "C:\\Users\\Kauan\\Downloads\\home\\leandro\\Downloads\\ExercicioSistemaArquivos";
		String nome = "data.csv";
		FifaControllerInterface ififa = new FifaController();
		Stack<String> jogadores = new Stack<String>();
		List<String> revelacoes = new LinkedList<String>();
		
		try {
			jogadores = ififa.empilhaBrasileiros(caminho, nome);
			ififa.desempilhaBonsBrasileiros(jogadores);
			revelacoes = ififa.listaRevelacoes(caminho, nome);
			ififa.buscaListaBonsJovens(revelacoes);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			
	}
		
}
		


