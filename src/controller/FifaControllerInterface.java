package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public interface FifaControllerInterface {
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws FileNotFoundException, IOException;
	public void desempilhaBonsBrasileiros(Stack<String> pilha);
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(List<String> lista);
	
}
