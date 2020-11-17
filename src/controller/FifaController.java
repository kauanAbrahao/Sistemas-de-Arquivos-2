package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FifaController implements FifaControllerInterface {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File dir = new File(caminho, nome);
		if(dir.exists() && dir.isFile()) {
			Stack<String> pilha = new Stack<String>();
			FileInputStream fluxo = new FileInputStream(dir);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			
			while(linha!=null) {
				if(linha.contains("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
			
			closeBeforeReturn(fluxo, reader, buffer);
			return pilha;
			
		} else {
			throw new IOException("Arquivo não encontrado");
		}
		
	}


	@Override
	public void desempilhaBonsBrasileiros(Stack<String> pilha) {
		System.out.println("== LISTA DOS MELHORES JOGADORES BRASILEIROS ==" + "\n");
		int tamanho = pilha.size();
		for(int i = 0; i < tamanho; i++) {
			String linha = pilha.pop();
			String parte[] = linha.split("\\,");
			int overall = Integer.parseInt(parte[7]);
			if (overall >= 80) {
				String jogador = "Nome: " + parte[2] + ", Overall: " + parte[7];
				System.out.println(jogador);
			}
		}
		
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File dir = new File(caminho, nome);
		if(dir.exists() && dir.isFile()) {
			List<String> revelacoes = new LinkedList<String>();
			FileInputStream fluxo = new FileInputStream(dir);
			InputStreamReader reader = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(reader);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			
			while(linha!=null) {
				String parte[] = linha.split("\\,");
				int idade = Integer.parseInt(parte[3]);
				if (idade <= 20) {
					revelacoes.add(linha);
				}
				linha = buffer.readLine();
			}
			closeBeforeReturn(fluxo, reader, buffer);
			return revelacoes;
		}
		return null;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) {
		System.out.println("\n" + "== LISTA DE REVELAÇÕES ==" + "\n");
		int tamanho = lista.size();
		for(int i = tamanho - 1; i >= 0; i--) {
			String linha = lista.get(i);
			String parte[] = linha.split("\\,");
			int idade = Integer.parseInt(parte[3]);
			int overall = Integer.parseInt(parte[7]);
			if (idade <= 20 && overall >= 80) {
				System.out.println("Nome: " + parte[2] + " | Idade: " + parte[3] + " | Overall: " + parte[7]);
			}
			
		}
		
	}
	
	private static void closeBeforeReturn(FileInputStream fluxo, InputStreamReader reader, BufferedReader buffer) throws IOException {
		buffer.close();
		fluxo.close();
		reader.close();
	}

}
