package imagem;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Imagens extends JButton {

	private static final long serialVersionUID = 1L;
	private Icon imagemPadrao;
	private Icon imagemObjeto;
	private int id;

	public Imagens(ImageIcon imagemPadrao2, Icon imagem, int numObj) {
		this.imagemPadrao = imagemPadrao2;
		this.imagemObjeto = imagem;
		this.id = numObj;
	}

	public void setImagemPadrao() {
		this.setIcon(imagemPadrao);
	}

	public void setImagemObjeto() {
		this.setIcon(imagemObjeto);
	}

	public Icon getImagemObjeto() {
		return this.imagemObjeto;
	}

	public int getID() {
		return this.id;
	}

}
