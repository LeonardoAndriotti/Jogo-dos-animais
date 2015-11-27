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
     private Node sim;
     private Node nao;
     private String pergunta;
     private String Animal;
     
	public void setSim(Node sim) {
		this.sim = sim;
	}
	public void setNao(Node nao) {
		this.nao = nao;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public void setAnimal(String animal) {
		Animal = animal;
	}
     
	/**
	 * Metodo teste()
	 * 
	 * 1º if - faz a comparação para ve se sim vem diferente de null, caso seja, lança a pergunta.
	 * 2º if - faz o teste quando for possitivo.
	 * else - teste quando for negativo.
	 */
	public void teste(){
		
		 if(this.sim != null){
			 int condicao = JOptionPane.showConfirmDialog(null, "O animal que está pensando ele(a) :"+ this.pergunta);
			 if(condicao == JOptionPane.YES_OPTION){
				 this.sim.teste();
			     }else{
					  this.nao.teste();
				 }
			 }else{
				 int teste = JOptionPane.showConfirmDialog(null, "Animal que você está pensando é um(a): " + this.Animal);
				 
				 if (teste == JOptionPane.YES_OPTION){
					 mensagemMaquina();
				 }else{
					  novoAnimal();
				 }
			 }
		 }
	
	
	public void novoAnimal(){
		String novoBicho = JOptionPane.showInputDialog(null, " Que Animal está pensando?");
			String dica = JOptionPane.showInputDialog(null,
				"O(a) " + novoBicho + " ..................... e o(a) " + this.Animal + " não.",
				"Qual a diferença entre os animais?", 0);
			
			Node novoNodeNao = new Node();
			novoNodeNao.setAnimal(this.Animal);

			Node novoNodeSim = new Node();
			novoNodeSim.setAnimal(novoBicho);
			
			this.pergunta = dica;
			
			this.nao = new Node();
			this.sim = new Node();

			this.nao = novoNodeNao;
			this.sim = novoNodeSim;
	}
	
	 public void mensagemMaquina(){
		 JOptionPane.showMessageDialog(null, "Acertei novamente !!!");
	 }
	 
	 
     
}