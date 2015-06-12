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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class SelecaoDeDificuldade extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel foto;
	ImageIcon imagem, imagem2, imagem3;
	Image img, img2, img3;
	JRadioButton rdbtnFacil, rdbtnMdio, rdbtnDificil;
	ButtonGroup btng;
	String modo;
	String nomeDeUsuario = "";
	private JLabel lblDificuldade;
	private JLabel lblFacil;
	private JLabel lblMedio;
	private JLabel lblDificil;
	JLabel lblIniciar;
	JLabel lblVoltar;

	ImageIcon imagemIniciar, imagemIniciar_en_US, imagemIniciar_ca_ES,
			imagemVoltar, imagemVoltar_en_US, imagemVoltar_ca_ES;
	Image imgIniciar, imgIniciar_en_US, imgIniciar_ca_ES, imgVoltar,
			imgVoltar_en_US, imgVoltar_ca_ES;

	/**
	 * @wbp.parser.constructor
	 */
	public SelecaoDeDificuldade(Locale locale, String modo) throws IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		
		setResizable(false);
		setUndecorated(true);
		this.modo = modo;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(bundle.getString("SelecaoDeDificuldade.JFrame.text"));
		setBounds(50, 50, 547, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btng = new ButtonGroup();
		imagem3 = new ImageIcon(
				SelecaoDeDificuldade.class
						.getResource("PastaImagens/voltar.jpg"));

		rdbtnFacil = new JRadioButton("");
		rdbtnFacil.setBackground(Color.LIGHT_GRAY);
		rdbtnFacil.setBounds(93, 170, 21, 23);
		contentPane.add(rdbtnFacil);

		rdbtnMdio = new JRadioButton("");
		rdbtnMdio.setBackground(Color.LIGHT_GRAY);
		rdbtnMdio.setBounds(93, 248, 21, 23);
		contentPane.add(rdbtnMdio);

		rdbtnDificil = new JRadioButton("");
		rdbtnDificil.setBackground(Color.LIGHT_GRAY);
		rdbtnDificil.setBounds(93, 315, 21, 23);
		contentPane.add(rdbtnDificil);

		btng.add(rdbtnDificil);
		btng.add(rdbtnFacil);
		btng.add(rdbtnMdio);

		imagem = new ImageIcon(
				SelecaoDeDificuldade.class
						.getResource("PastaImagens/rio-citarum-1.jpg"));
		imagem2 = new ImageIcon(
				SelecaoDeDificuldade.class
						.getResource("PastaImagens/iniciar4.png"));

		lblDificuldade = new JLabel(
				bundle.getString("SelecaoDeDificuldade.lblDificuldade.text"));
		lblDificuldade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblDificuldade.setForeground(Color.RED);
		lblDificuldade.setBounds(128, 51, 255, 45);
		contentPane.add(lblDificuldade);

		lblFacil = new JLabel(
				bundle.getString("SelecaoDeDificuldade.lblFacil.text"));
		lblFacil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblFacil.setForeground(Color.GREEN);
		lblFacil.setBounds(136, 160, 165, 45);
		contentPane.add(lblFacil);

		lblMedio = new JLabel(
				bundle.getString("SelecaoDeDificuldade.lblMedio.text"));
		lblMedio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblMedio.setForeground(Color.GREEN);
		lblMedio.setBounds(136, 235, 117, 51);
		contentPane.add(lblMedio);

		lblDificil = new JLabel(
				bundle.getString("SelecaoDeDificuldade.lblDificil.text"));
		lblDificil.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDificil.setForeground(Color.GREEN);
		lblDificil.setBounds(136, 299, 117, 55);
		contentPane.add(lblDificil);

		lblIniciar = new JLabel("");
		lblIniciar.setBounds(154, 433, 123, 45);
		contentPane.add(lblIniciar);

		lblVoltar = new JLabel("");
		lblVoltar.setBounds(408, 433, 90, 45);
		contentPane.add(lblVoltar);

		foto = new JLabel("");
		foto.setBounds(0, 0, 547, 547);
		contentPane.add(foto);
		img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));
		
		imagemIniciar=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnIniciar.jpg"));
		imagemIniciar_en_US=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnIniciar_en_US.jpg"));
		imagemIniciar_ca_ES=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnIniciar_ca_ES.jpg"));
		
		imagemVoltar=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnVoltar.jpg"));
		imagemVoltar_en_US=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnVoltar_en_US.jpg"));
		imagemVoltar_ca_ES=new ImageIcon(
				SelecaoDeDificuldade.class.getResource("PastaImagens/btnVoltar_ca_ES.jpg"));
		
		imgIniciar=imagemIniciar.getImage().getScaledInstance(
				lblIniciar.getWidth(), lblIniciar.getHeight(),
				Image.SCALE_DEFAULT);
		imgIniciar_en_US=imagemIniciar_en_US.getImage().getScaledInstance(
				lblIniciar.getWidth(), lblIniciar.getHeight(),
				Image.SCALE_DEFAULT);
		imgIniciar_ca_ES=imagemIniciar_ca_ES.getImage().getScaledInstance(
				lblIniciar.getWidth(), lblIniciar.getHeight(),
				Image.SCALE_DEFAULT);
		
		imgVoltar=imagemVoltar.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		imgVoltar_en_US=imagemVoltar_en_US.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		imgVoltar_ca_ES=imagemVoltar_ca_ES.getImage().getScaledInstance(
				lblVoltar.getWidth(), lblVoltar.getHeight(),
				Image.SCALE_DEFAULT);
		
		lblIniciar.setIcon(new ImageIcon(imgIniciar));
		lblVoltar.setIcon(new ImageIcon(imgVoltar));
		
		lblIniciar.addMouseListener(this);
		lblVoltar.addMouseListener(this);
	}

	SelecaoDeDificuldade(Locale locale, String modo, String nome)
			throws IOException {
		this(locale, modo);
		this.nomeDeUsuario = nome;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblIniciar){
			if (rdbtnDificil.isSelected() && modo == "dinamico") {
				if (nomeDeUsuario == "") {
					JogoDinamico facil_edu = new JogoDinamico(3);
					facil_edu.setVisible(true);
					facil_edu.prepararJogo();
					facil_edu.prepararImagens();
					dispose();
				} else {
					JogoDinamico facil_edu = new JogoDinamico(3, nomeDeUsuario);
					facil_edu.setVisible(true);
					facil_edu.prepararJogo();
					facil_edu.prepararImagens();
					dispose();
				}
			} else {
				if (rdbtnMdio.isSelected() && modo == "dinamico") {
					if (nomeDeUsuario == "") {
						JogoDinamico facil_edu = new JogoDinamico(2);
						facil_edu.setVisible(true);
						facil_edu.prepararJogo();
						facil_edu.prepararImagens();
						dispose();
					} else {
						JogoDinamico facil_edu = new JogoDinamico(2,
								nomeDeUsuario);
						facil_edu.setVisible(true);
						facil_edu.prepararJogo();
						facil_edu.prepararImagens();
						dispose();
					}
				} else {
					if (rdbtnFacil.isSelected() && modo == "dinamico") {
						if (nomeDeUsuario == "") {
							JogoDinamico facil_edu = new JogoDinamico(1);
							facil_edu.setVisible(true);
							facil_edu.prepararJogo();
							facil_edu.prepararImagens();
							dispose();
						} else {
							JogoDinamico facil_edu = new JogoDinamico(1,
									nomeDeUsuario);
							facil_edu.setVisible(true);
							facil_edu.prepararJogo();
							facil_edu.prepararImagens();
							dispose();
						}
					} else {
						if (rdbtnFacil.isSelected() && modo == "educativo") {
							if (nomeDeUsuario == "") {
								JogoEducativo facil_edu = new JogoEducativo(1);
								facil_edu.setVisible(true);
								facil_edu.prepararJogo();
								facil_edu.prepararImagens();
								dispose();
							} else {
								JogoEducativo facil_edu = new JogoEducativo(1,
										nomeDeUsuario);
								facil_edu.setVisible(true);
								facil_edu.prepararJogo();
								facil_edu.prepararImagens();
								dispose();
							}
						} else {
							if (rdbtnMdio.isSelected() && modo == "educativo") {
								if (nomeDeUsuario == "") {
									JogoEducativo medio_edu = new JogoEducativo(
											2);
									medio_edu.setVisible(true);
									medio_edu.prepararJogo();
									medio_edu.prepararImagens();
									dispose();
								} else {
									JogoEducativo medio_edu = new JogoEducativo(
											2, nomeDeUsuario);
									medio_edu.setVisible(true);
									medio_edu.prepararJogo();
									medio_edu.prepararImagens();
									dispose();
								}
							} else {
								if (rdbtnDificil.isSelected()
										&& modo == "educativo") {
									if (nomeDeUsuario == "") {
										JogoEducativo dificil_edu = new JogoEducativo(
												3);
										dificil_edu.setVisible(true);
										dificil_edu.prepararJogo();
										dificil_edu.prepararImagens();
										dispose();
									} else {
										JogoEducativo dificil_edu = new JogoEducativo(
												3, nomeDeUsuario);
										dificil_edu.setVisible(true);
										dificil_edu.prepararJogo();
										dificil_edu.prepararImagens();
										dispose();
									}
								} else {
									if (InformacaoGlobal.localeGlobal == "pt") {
										JOptionPane.showMessageDialog(null,
												"Selecione a dificuldade");
									} else {
										if (InformacaoGlobal.localeGlobal == "ca_ES") {
											JOptionPane.showMessageDialog(null,
													"Seleccione la dificultad");
										} else {
											JOptionPane.showMessageDialog(null,
													"Select the difficulty");
										}
									}
								}
							}
						}
					}
				}
			}
		}else{
			if(e.getSource()==lblVoltar){
				if (nomeDeUsuario != "") {
					try {
						SelecaoDeNivel SelecaoDeNivel = new SelecaoDeNivel(
								new Locale(InformacaoGlobal.localeGlobal),
								nomeDeUsuario);
						if(InformacaoGlobal.localeGlobal=="pt"){
							SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico));
							SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo));
							SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar));
						}else{
							if(e.getSource()=="ca_ES"){
								SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico_ca_ES));
								SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo_ca_ES));
								SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar_ca_ES));
							}else{
								SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico_en_US));
								SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo_en_US));
								SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar_en_US));
							}
						}
						SelecaoDeNivel.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						SelecaoDeNivel SelecaoDeNivel = new SelecaoDeNivel(
								new Locale(InformacaoGlobal.localeGlobal));
						if(InformacaoGlobal.localeGlobal=="pt"){
							SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico));
							SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo));
							SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar));
						}else{
							if(e.getSource()=="ca_ES"){
								SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico_ca_ES));
								SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo_ca_ES));
								SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar_ca_ES));
							}else{
								SelecaoDeNivel.lblDinamico.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarDinamico_en_US));
								SelecaoDeNivel.lblEducativo.setIcon(new ImageIcon(SelecaoDeNivel.imgIniciarEducativo_en_US));
								SelecaoDeNivel.lblVoltar.setIcon(new ImageIcon(SelecaoDeNivel.imgVoltar_en_US));
							}
						}
						SelecaoDeNivel.setVisible(true);
						dispose();
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
