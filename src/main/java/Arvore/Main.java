package Arvore;

import javax.swing.JOptionPane;

public class Main {
	/**
	 * Menu de execução do Jogo dos Seres.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Passagem de parametros para Classe Node. nodeSim passa de parametro
		 * para Animal dissendo que se animal viver na aguá é um tubarão.
		 * nodeNao passa parametro caso seja negativa a resposta do usuario, ela
		 * não vive na agua então passa para nao o macaco
		 */

		Node nodeSim = new Node();
		nodeSim.setAnimal("Tubarão");

		Node nodeNao = new Node();
		nodeNao.setAnimal("Macaco");

		Node node = new Node();

		node.setSim(nodeSim);
		node.setNao(nodeNao);

		boolean condicao = true;

		/**
		 * While de inicio do jogo.
		 * node.pergunta() -  chama o metódo de perguntas da classe Node;
		 * 
		 * if/ else de comparação se jogador deseja continuar o jogo ou parar.
		 */
		do {

			JOptionPane.showMessageDialog(null, "Pense em um animal !!!",
					"Vamos Começar", 0);
			
			node.teste();
			
			int cond = JOptionPane.showConfirmDialog(null,
					"Deseja jogar novamente ?", "Novo jogo ?", 0);
			
			if (cond == JOptionPane.YES_OPTION) {
				condicao = true;
			} else {
				condicao = false;
			}

		} while (condicao);

	}
}
