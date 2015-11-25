package Arvore;

import javax.swing.JOptionPane;

/**
 * Classe Node responsavel, por toda parte jogavel do jogo. Node sim - pergunta
 * positiva. Node nao - pergunta negativa. String animal - recebe animais
 * 
 * @author Andriotti
 *
 */
public class Node {

	private Node sim = null;
	private Node nao = null;
	private String animal;
	private String pergunta;

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public Node getSim() {
		return sim;
	}

	public void setSim(Node sim) {
		this.sim = sim;
	}

	public Node getNao() {
		return nao;
	}

	public void setNao(Node nao) {
		this.nao = nao;
	}

	/**
	 *  Metodo teste () -  ele ve se sim.getAnimal está vazio, caso não esteja ele executa o Pane fazendo a pergunta.
	 *  se positiva, chama o Metodo pergunta e passa como parametro o animal dentro de sim.getAnimal
	 *  se negativo, passa o animal dentro do nao.
	 */
	public void teste() {

		if (sim.getAnimal() != null) {
			int viveNaAgua = JOptionPane.showConfirmDialog(null,
					"Animal que pensou vive na água ?",
					" Será, tenho uma idéia.", 0);
			if (viveNaAgua == JOptionPane.YES_OPTION) {
				pergunta(sim.getAnimal());
			} else {
				pergunta(nao.getAnimal());
			}
		}else{
			novoTeste();
		}
	}

	/**
	 * faz as comparações para saber se o animal esta correto
	 * @param animal  - animal que está vindo.
	 */
	public void pergunta(String animal) {

		int animalPensado = JOptionPane.showConfirmDialog(null,
				"Animal que pensou é um " + animal, " Acertei", 0);

		if (animalPensado == JOptionPane.YES_OPTION) {
			mensagemAcerto();

		} else {

			novoAnimal(animal);
		}

	}

	/**
	 * caso a resposta seja negativa, o computador pede para que o usuario informe o animal que está pensando, tirando o animal sim colocando no não e colocando o novo no lugar
	 * @param animal
	 * @return
	 */
	public String novoAnimal(String animal) {

		String novoAnimal = JOptionPane
				.showInputDialog("Qual animal está pensando ?");

		String dica = JOptionPane.showInputDialog(null, "O(a) " + novoAnimal
				+ " ..................... e o(a) " + animal + " não.",
				"Qual a diferença entre os animais?", 0);

		
		System.out.println("anima"+ novoAnimal);
		System.out.println("dica"+ dica);
		
		Node novoNao = new Node();
		novoNao.setAnimal(novoAnimal);

		Node novoSim = new Node();
		novoSim.setAnimal(novoAnimal);

		this.pergunta = dica;

		this.nao = new Node();
		this.sim = new Node();

		this.nao = novoNao;
		this.sim = novoSim;

		return animal;
	}

/**
 * 
 */
	public void novoTeste() {
		/*
		 * Testa se existem nós baixo e executa um deles, caso contrário entra
		 * no else e sugere esse animal
		 */
		if (this.sim != null) {
			int questao = JOptionPane.showConfirmDialog(null,
					"O animal que você pensou " + this.pergunta,
					"Por acaso...", 0);
			if (questao == 0) {
				sim.novoTeste();
			} else {
				nao.novoTeste();
			}

		} else {
			boolean acerteiOAnimal = sugerirAnimal();
			if (acerteiOAnimal) {
				JOptionPane.showConfirmDialog(null, "Animal que pensou é um "
						+ nao.getAnimal(), "Acertei", 0);
			} else {
				novoAnimal(getAnimal());
			}
		}

	}

	private boolean sugerirAnimal() {

		int animalSugerido = JOptionPane.showConfirmDialog(null,
				"O animal que você pensou é " + this.animal, "Sei o animal", 0);
		return (animalSugerido == 0);
	}

	/**
	 * Metodo da mensagem quando o computador acerta !!!
	 */
	private void mensagemAcerto() {

		JOptionPane.showMessageDialog(null, "Opa, Acertei  <Ô>",
				"Estou Com sorte", 0);

	}
}
