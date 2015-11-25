package org.alvorada.arvore;

import javax.swing.JOptionPane;

import org.alvorada.arvore.model.Node;

public class MainGame {
    
    public static void main(String[] args) {
	/* Criando o nó inicial */
	
	Node nodeNao = new Node();
	nodeNao.setAnimalASugerir("Macaco");

	Node nodeSim = new Node();
	nodeSim.setAnimalASugerir("Tubarão ");

	Node node = new Node();
	node.setNodeNao(nodeNao);
	node.setNodeSim(nodeSim);
	node.setPergunta(" vive na água? ");
	
	
	
	int continuar = 0;
	do {

		JOptionPane.showMessageDialog(null, "Pense em um animal");
	    	    
	    node.run();
	    
	    continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar jogando?", "Continuar o jogo?", 0);
	} while (continuar == 0);
	
    }

}
