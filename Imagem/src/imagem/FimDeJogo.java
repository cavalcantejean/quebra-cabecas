package imagem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class FimDeJogo extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private Pontuacao pontuacao = new Pontuacao();
	JPanel contentPane;
	JLabel lblVocePerdeu, lblSuaPontuacaoFoi, lblPontuacao;
	int nivel;
	int tema;
	String janela;
	String nomeDeUsuario = "";
	static Connection connection;
	Pontuacao pontuacao3 = new Pontuacao();
	JLabel lblRanking;
	JLabel lblMenu;
	JLabel lblJogarNovamente;
	JLabel lblSair;

	ImageIcon imagemRanking, imagemRanking_ca_ES, imagemMenu,
			imagemJogarNovamente, imagemJogarNovamente_en_US,
			imagemJogarNovamente_ca_ES, imagemSair, imagemSair_en_US,
			imagemSair_ca_ES;
	Image imgRanking, imgRanking_ca_ES, imgMenu, imgJogarNovamente,
			imgJogarNovamente_en_US, imgJogarNovamente_ca_ES, imgSair,
			imgSair_en_US, imgSair_ca_ES;

	/**
	 * @wbp.parser.constructor
	 */
	public FimDeJogo(String janela, int nivel) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1= ResourceBundle.getBundle("imagem.ResBundle");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		this.nivel = nivel;
		this.janela = janela;

		setTitle(bundle.getString("FimDeJogo.JFrame.text"));

		getContentPane().setLayout(null);
		setBounds(50, 50, 500, 300);

		lblVocePerdeu = new JLabel("Voce Perdeu!!");
		lblVocePerdeu.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblVocePerdeu.setBounds(95, 34, 294, 62);
		getContentPane().add(lblVocePerdeu);

		lblSuaPontuacaoFoi = new JLabel(
				bundle.getString("FimDeJogo.lblSuaPontuacaoFoi.text"));
		lblSuaPontuacaoFoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSuaPontuacaoFoi.setBounds(67, 128, 131, 23);
		getContentPane().add(lblSuaPontuacaoFoi);

		lblPontuacao = new JLabel("New label");
		lblPontuacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPontuacao.setBounds(257, 130, 217, 18);
		getContentPane().add(lblPontuacao);

		lblRanking = new JLabel("");
		lblRanking.setBounds(10, 228, 89, 23);
		getContentPane().add(lblRanking);

		lblMenu = new JLabel("");
		lblMenu.setBounds(109, 228, 89, 23);
		getContentPane().add(lblMenu);

		lblJogarNovamente = new JLabel("");
		lblJogarNovamente.setBounds(218, 232, 137, 19);
		getContentPane().add(lblJogarNovamente);

		lblSair = new JLabel("");
		lblSair.setBounds(379, 232, 79, 19);
		getContentPane().add(lblSair);

		imagemJogarNovamente = new ImageIcon(
				FimDeJogo.class
						.getResource("PastaImagens/btnJogarNovamente.jpg"));
		imagemJogarNovamente_en_US = new ImageIcon(
				FimDeJogo.class
						.getResource("PastaImagens/btnJogarNovamente_en_US.jpg"));
		imagemJogarNovamente_ca_ES = new ImageIcon(
				FimDeJogo.class
						.getResource("PastaImagens/btnJogarNovamente_ca_ES.jpg"));

		imagemMenu = new ImageIcon(
				FimDeJogo.class.getResource("PastaImagens/btnMenu.jpg"));

		imagemRanking = new ImageIcon(
				FimDeJogo.class.getResource("PastaImagens/btnRanking.jpg"));
		imagemRanking_ca_ES = new ImageIcon(
				FimDeJogo.class
						.getResource("PastaImagens/btnRanking_ca_ES.jpg"));

		imagemSair = new ImageIcon(
				FimDeJogo.class.getResource("PastaImagens/btnSair.jpg"));
		imagemSair_en_US = new ImageIcon(
				FimDeJogo.class.getResource("PastaImagens/btnSair_en_US.jpg"));
		imagemSair_ca_ES = new ImageIcon(
				FimDeJogo.class.getResource("PastaImagens/btnSair_ca_ES.jpg"));

		imgJogarNovamente = imagemJogarNovamente.getImage().getScaledInstance(
				lblJogarNovamente.getWidth(), lblJogarNovamente.getHeight(),
				Image.SCALE_DEFAULT);
		imgJogarNovamente_en_US = imagemJogarNovamente_en_US.getImage()
				.getScaledInstance(lblJogarNovamente.getWidth(),
						lblJogarNovamente.getHeight(), Image.SCALE_DEFAULT);
		imgJogarNovamente_ca_ES = imagemJogarNovamente_ca_ES.getImage()
				.getScaledInstance(lblJogarNovamente.getWidth(),
						lblJogarNovamente.getHeight(), Image.SCALE_DEFAULT);

		imgMenu = imagemMenu.getImage().getScaledInstance(lblMenu.getWidth(),
				lblMenu.getHeight(), Image.SCALE_DEFAULT);

		imgRanking = imagemRanking.getImage().getScaledInstance(
				lblRanking.getWidth(), lblRanking.getHeight(),
				Image.SCALE_DEFAULT);
		imgRanking_ca_ES = imagemRanking_ca_ES.getImage().getScaledInstance(
				lblRanking.getWidth(), lblRanking.getHeight(),
				Image.SCALE_DEFAULT);

		imgSair = imagemSair.getImage().getScaledInstance(lblSair.getWidth(),
				lblSair.getHeight(), Image.SCALE_DEFAULT);
		imgSair_en_US = imagemSair_en_US.getImage().getScaledInstance(
				lblSair.getWidth(), lblSair.getHeight(), Image.SCALE_DEFAULT);
		imgSair_ca_ES = imagemSair_ca_ES.getImage().getScaledInstance(
				lblSair.getWidth(), lblSair.getHeight(), Image.SCALE_DEFAULT);

		lblJogarNovamente.setIcon(new ImageIcon((Image)bundle1.getObject("FimDeJogo.lblJogarNovamente.image")));
		lblMenu.setIcon(new ImageIcon((Image)bundle1.getObject("FimDeJogo.lblMenu.image")));
		lblRanking.setIcon(new ImageIcon((Image)bundle1.getObject("FimDeJogo.lblRanking.image")));
		lblSair.setIcon(new ImageIcon((Image)bundle1.getObject("FimDeJogo.lblSair.image")));

		lblJogarNovamente.addMouseListener(this);
		lblMenu.addMouseListener(this);
		lblRanking.addMouseListener(this);
		lblSair.addMouseListener(this);

	}
	
	public FimDeJogo(String janela, int nivel,Locale locale){
		this(janela,nivel);
		Locale.setDefault(locale);
	}

	FimDeJogo(String janela, int nivel, String usuario) {
		this(janela, nivel);
		this.nomeDeUsuario = usuario;
		Conexao.FazConexao();
		int pontuacao2 = pontuacao.getPontos();
		Connection con = Conexao.connection;
		Connection con1 = Conexao.connection;
		if (janela == "JogoEducativo") {
			try {
				Statement st = con.createStatement();
				Statement st1 = con1.createStatement();
				st.executeUpdate("update usuario set PontuacaoModoEducativo=PontuacaoModoEducativo+"
						+ pontuacao2
						+ " where NomeDeUsuario='"
						+ nomeDeUsuario
						+ "'");
				st1.executeUpdate("update usuario set DataHoraPontuacaoModoEducativo=now() where NomeDeUsuario='"
						+ nomeDeUsuario + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Statement st = con.createStatement();
				Statement st1 = con1.createStatement();

				st.executeUpdate("update usuario set PontuacaoModoDinamico=PontuacaoModoDinamico+"
						+ pontuacao2
						+ " where NomeDeUsuario='"
						+ nomeDeUsuario
						+ "'");
				st1.executeUpdate("update usuario set DataHoraPontuacaoModoDinamico=now() where NomeDeUsuario='"
						+ nomeDeUsuario + "'");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	FimDeJogo(String janela, int nivel, String usuario,Locale locale){
		this(janela,nivel,usuario);
		Locale.setDefault(locale);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblJogarNovamente) {
			if (janela == "JogoDinamico") {
				if (nivel == 1) {
					if (nomeDeUsuario == "") {
						JogoDinamico tela = new JogoDinamico(1);
						tela.setVisible(true);
						dispose();
					} else {
						JogoDinamico tela = new JogoDinamico(1, nomeDeUsuario);
						tela.setVisible(true);
						dispose();
					}
				} else {
					if (nivel == 2) {
						if (nomeDeUsuario == "") {
							JogoDinamico tela = new JogoDinamico(2);
							tela.setVisible(true);
							dispose();
						} else {
							JogoDinamico tela = new JogoDinamico(2,
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						}
					} else {
						if (nivel == 3) {
							if (nomeDeUsuario == "") {
								JogoDinamico tela = new JogoDinamico(3);
								tela.setVisible(true);
								dispose();
							} else {
								JogoDinamico tela = new JogoDinamico(3,
										nomeDeUsuario);
								tela.setVisible(true);
								dispose();
							}
						}
					}
				}
			} else {
				if (janela == "JogoEducativo") {
					if (nivel == 1) {
						if (nomeDeUsuario == "") {
							JogoEducativo tela = new JogoEducativo(1);
							tela.setVisible(true);
							dispose();
						} else {
							JogoEducativo tela = new JogoEducativo(1,
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						}
					} else {
						if (nivel == 2) {
							if (nomeDeUsuario == "") {
								JogoEducativo tela = new JogoEducativo(2);
								tela.setVisible(true);
								dispose();
							} else {
								JogoEducativo tela = new JogoEducativo(2,
										nomeDeUsuario);
								tela.setVisible(true);
								dispose();
							}
						} else {
							if (nivel == 3) {
								if (nomeDeUsuario == "") {
									JogoEducativo tela = new JogoEducativo(3);
									tela.setVisible(true);
									dispose();
								} else {
									JogoEducativo tela = new JogoEducativo(3,
											nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}
							}
						}
					}
				}
			}
		} else {
			if (e.getSource() == lblSair) {
				System.exit(0);
			} else {
				if (e.getSource() == lblMenu) {
					try {
						if (nomeDeUsuario == "") {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal));
							tela.setVisible(true);
							dispose();
						} else {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal),
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					if (e.getSource() == lblRanking) {
						if (nomeDeUsuario == "") {
							Ranking ranking = new Ranking(new Locale(
									InformacaoGlobal.localeGlobal));
							if (InformacaoGlobal.localeGlobal == "pt") {
								ranking.lblAnterior.setIcon(new ImageIcon(
										ranking.imgAnterior));
								ranking.lblProximo.setIcon(new ImageIcon(
										ranking.imgProximo));
							} else {
								if (InformacaoGlobal.localeGlobal == "ca_ES") {
									ranking.lblProximo.setIcon(new ImageIcon(
											ranking.imgProximo_ca_ES));
									ranking.lblAnterior.setIcon(new ImageIcon(
											ranking.imgAnterior));
								} else {
									ranking.lblProximo.setIcon(new ImageIcon(
											ranking.imgProximo_en_US));
									ranking.lblAnterior.setIcon(new ImageIcon(
											ranking.imgAnterior_en_US));
								}
							}
							ranking.setVisible(true);
							dispose();
						} else {
							Ranking ranking = new Ranking(new Locale(
									InformacaoGlobal.localeGlobal),
									nomeDeUsuario);
							if (InformacaoGlobal.localeGlobal == "pt") {
								ranking.lblAnterior.setIcon(new ImageIcon(
										ranking.imgAnterior));
								ranking.lblProximo.setIcon(new ImageIcon(
										ranking.imgProximo));
							} else {
								if (InformacaoGlobal.localeGlobal == "ca_ES") {
									ranking.lblProximo.setIcon(new ImageIcon(
											ranking.imgProximo_ca_ES));
									ranking.lblAnterior.setIcon(new ImageIcon(
											ranking.imgAnterior));
								} else {
									ranking.lblProximo.setIcon(new ImageIcon(
											ranking.imgProximo_en_US));
									ranking.lblAnterior.setIcon(new ImageIcon(
											ranking.imgAnterior_en_US));
								}
							}
							ranking.setVisible(true);
							dispose();
						}
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
