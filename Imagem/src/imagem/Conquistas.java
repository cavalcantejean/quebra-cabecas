package imagem;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Conquistas extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ImageIcon imagemVoltar,imagemVoltar_ca_ES,imagemVoltar_en_US, imagemPossibilidade1, imagemPossibilidade2,
			imagemPossibilidade3, imagemPossibilidade4, imagemPossibilidade5,
			imagemPossibilidade6, imagemPossibilidade7, imagemPossibilidade8,
			imagemPossibilidade9,imagemPossibilidade10;
	Image imgVoltar,imgVoltar_ca_ES,imgVoltar_en_US, imgPossibilidade1, imgPossibilidade2,
			imgPossibilidade3, imgPossibilidade4, imgPossibilidade5,
			imgPossibilidade6, imgPossibilidade7, imgPossibilidade8,
			imgPossibilidade9,imgPossibilidade10;
	static JLabel lblVoltar;
	JLabel foto;
	String nomeDeUsuario="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Conquistas(new Locale(InformacaoGlobal.localeGlobal)).setVisible(true);
	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public Conquistas(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1= ResourceBundle.getBundle("imagem.ResBundle");
		
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 547, 547);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle(bundle.getString("Conquistas.JFrame.text"));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		JLabel lblModoDinamico = new JLabel(bundle.getString("Conquistas.lblModoDinamico.text"));
		lblModoDinamico.setBounds(137, 104, 175, 14);
		contentPane.add(lblModoDinamico);

		JLabel lblModoEducativo = new JLabel(bundle.getString("Conquistas.lblModoEducativo.text"));
		lblModoEducativo.setBounds(137, 230, 175, 14);
		contentPane.add(lblModoEducativo);

		lblVoltar = new JLabel("Voltar");
		lblVoltar.setBounds(346, 298, 88, 27);
		contentPane.add(lblVoltar);
		lblVoltar.addMouseListener(this);

		foto = new JLabel("");
		foto.setBounds(0, 0, 434, 262);
		contentPane.add(foto);
		
		imagemVoltar = new ImageIcon(
				Conquistas.class.getResource("PastaImagens/btnVoltar.jpg"));
		imagemVoltar_ca_ES=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/btnVoltar_ca_ES.jpg"));
		imagemVoltar_en_US=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/btnVoltar_en_US.jpg"));
		
		imagemPossibilidade1=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade1.png"));
		imagemPossibilidade2=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade2.png"));
		imagemPossibilidade3=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade3.png"));
		imagemPossibilidade4=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade4.png"));
		imagemPossibilidade5=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade5.png"));
		imagemPossibilidade6=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade6.png"));
		imagemPossibilidade7=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade7.png"));
		imagemPossibilidade8=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade8.png"));
		imagemPossibilidade9=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade9.png"));
		imagemPossibilidade10=new ImageIcon(
				Conquistas.class.getResource("PastaImagens/possibilidade10.png"));
		
		imgVoltar = imagemVoltar.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		imgVoltar_ca_ES = imagemVoltar_ca_ES.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		imgVoltar_en_US = imagemVoltar_en_US.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		
		imgPossibilidade1 = imagemPossibilidade1.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade2 = imagemPossibilidade2.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade3 = imagemPossibilidade3.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade4 = imagemPossibilidade4.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade5 = imagemPossibilidade5.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade6 = imagemPossibilidade6.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade7 = imagemPossibilidade7.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade8 = imagemPossibilidade8.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade9 = imagemPossibilidade9.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		imgPossibilidade10 = imagemPossibilidade10.getImage().getScaledInstance(
				foto.getWidth(), foto.getHeight(),
				Image.SCALE_DEFAULT);
		
		foto.setIcon(new ImageIcon(imgPossibilidade10));
		lblVoltar.setIcon(new ImageIcon((Image)bundle1.getObject("Conquistas.lblVoltar.image")));
	}
	
	Conquistas(Locale locale,String nomeDeUsuario){
		this(locale);
		this.nomeDeUsuario=nomeDeUsuario;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblVoltar){
			if(nomeDeUsuario==""){
				try {					
					if(InformacaoGlobal.localeGlobal=="pt"){
						TelaInicial tela = new TelaInicial(new Locale("pt"));
						tela.setVisible(true);
						dispose();
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							TelaInicial tela = new TelaInicial(new Locale("ca","ES"));
							tela.setVisible(true);
							dispose();
						}else{
							TelaInicial tela = new TelaInicial(new Locale("en","US"));
							tela.setVisible(true);
							dispose();
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
				}else{
					if(nomeDeUsuario!=""){
						try {
							
							if(InformacaoGlobal.localeGlobal=="pt"){
								TelaInicial tela = new TelaInicial(new Locale("pt"),nomeDeUsuario);
								tela.setVisible(true);
								dispose();
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									TelaInicial tela = new TelaInicial(new Locale("ca","ES"),nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}else{
									TelaInicial tela = new TelaInicial(new Locale("en","US"),nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}
							}							
						} catch (IOException e1) {
							e1.printStackTrace();
						}		
					}
				}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
