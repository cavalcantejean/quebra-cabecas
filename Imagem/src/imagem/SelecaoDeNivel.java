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

import java.awt.Font;

public class SelecaoDeNivel extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel foto;
	ImageIcon imagem, imagem2, imagem3, imagem4;
	Image img, img2, img3, img4;
	String nomeDeUsuario = "";
	private JLabel lblModoEducativo;
	private JLabel lblEscolhaOPar;
	private JLabel lblEApareceraUma;
	private JLabel lblInformativaARespeito;
	private JLabel lblDaFigura;
	private JLabel lblModoDinamico;
	private JLabel lblCompleteOsPares;
	private JLabel lblNoMenorTempo;
	JLabel lblDinamico;
	JLabel lblEducativo;

	ImageIcon imagemIniciarEducativo, imagemIniciarEducativo_en_US,
			imagemIniciarEducativo_ca_ES, imagemIniciarDinamico,
			imagemIniciarDinamico_en_US, imagemIniciarDinamico_ca_ES,
			imagemVoltar, imagemVoltar_en_US, imagemVoltar_ca_ES;
	Image imgIniciarEducativo, imgIniciarEducativo_en_US,
			imgIniciarEducativo_ca_ES, imgIniciarDinamico,
			imgIniciarDinamico_en_US, imgIniciarDinamico_ca_ES, imgVoltar,
			imgVoltar_en_US, imgVoltar_ca_ES;
	JLabel lblVoltar;

	public static void main(String[] args) throws IOException {
		new SelecaoDeNivel(new Locale(InformacaoGlobal.localeGlobal))
				.setVisible(true);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public SelecaoDeNivel(Locale locale) throws IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		
		setUndecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 547, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setTitle(bundle.getString("SelecaoDeNivel.JFrame.text"));

		imagem2 = new ImageIcon(
				SelecaoDeNivel.class.getResource("PastaImagens/iniciar4.png"));

		imagem = new ImageIcon(
				SelecaoDeNivel.class
						.getResource("PastaImagens/coleta-seletiva-em-casa-dados-e-dicas-gerais-2.jpg"));

		imagem4 = new ImageIcon(
				SelecaoDeNivel.class.getResource("PastaImagens/voltar.jpg"));

		lblModoEducativo = new JLabel(
				bundle.getString("SelecaoDeNivel.lblModoEducativo.text"));
		lblModoEducativo
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblModoEducativo.setForeground(Color.WHITE);
		lblModoEducativo.setBounds(211, 21, 287, 39);
		contentPane.add(lblModoEducativo);

		lblEscolhaOPar = new JLabel(
				bundle.getString("SelecaoDeNivel.lblEscolhaOPar.text"));
		lblEscolhaOPar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblEscolhaOPar.setForeground(Color.WHITE);
		lblEscolhaOPar.setBounds(22, 60, 303, 28);
		contentPane.add(lblEscolhaOPar);

		lblEApareceraUma = new JLabel(
				bundle.getString("SelecaoDeNivel.lblEApareceraUma.text"));
		lblEApareceraUma
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblEApareceraUma.setForeground(Color.WHITE);
		lblEApareceraUma.setBounds(22, 85, 458, 39);
		contentPane.add(lblEApareceraUma);

		lblInformativaARespeito = new JLabel(
				bundle.getString("SelecaoDeNivel.lblInformativaARespeito.text"));
		lblInformativaARespeito.setForeground(Color.WHITE);
		lblInformativaARespeito.setFont(new Font("Tahoma", Font.BOLD
				| Font.ITALIC, 22));
		lblInformativaARespeito.setBounds(22, 118, 303, 28);
		contentPane.add(lblInformativaARespeito);

		lblDaFigura = new JLabel(bundle.getString("SelecaoDeNivel.lblDaFigura"));
		lblDaFigura.setForeground(Color.WHITE);
		lblDaFigura.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblDaFigura.setBounds(22, 152, 131, 28);
		contentPane.add(lblDaFigura);

		lblModoDinamico = new JLabel(
				bundle.getString("SelecaoDeNivel.lblModoDinamico.text"));
		lblModoDinamico
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblModoDinamico.setForeground(Color.WHITE);
		lblModoDinamico.setBounds(281, 275, 217, 39);
		contentPane.add(lblModoDinamico);

		lblCompleteOsPares = new JLabel(
				bundle.getString("SelecaoDeNivel.lblCompleteOsPares.text"));
		lblCompleteOsPares.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				22));
		lblCompleteOsPares.setForeground(Color.BLACK);
		lblCompleteOsPares.setBounds(22, 344, 217, 28);
		contentPane.add(lblCompleteOsPares);

		lblNoMenorTempo = new JLabel(
				bundle.getString("SelecaoDeNivel.lblNoMenorTempo.text"));
		lblNoMenorTempo
				.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNoMenorTempo.setForeground(new Color(0, 0, 0));
		lblNoMenorTempo.setBounds(22, 378, 217, 39);
		contentPane.add(lblNoMenorTempo);

		lblDinamico = new JLabel("");
		lblDinamico.setBounds(424, 393, 66, 28);
		contentPane.add(lblDinamico);

		lblEducativo = new JLabel("");
		lblEducativo.setBounds(402, 152, 66, 28);
		contentPane.add(lblEducativo);

		lblVoltar = new JLabel("");
		lblVoltar.setBounds(424, 464, 66, 28);
		contentPane.add(lblVoltar);

		foto = new JLabel("");
		foto.setBounds(0, 0, 547, 547);
		contentPane.add(foto);
		img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));

		imagemIniciarDinamico = new ImageIcon(
				SelecaoDeNivel.class.getResource("PastaImagens/btnIniciar.jpg"));
		imagemIniciarDinamico_en_US = new ImageIcon(
				SelecaoDeNivel.class
						.getResource("PastaImagens/btnIniciar_en_US.jpg"));
		imagemIniciarDinamico_ca_ES = new ImageIcon(
				SelecaoDeNivel.class
						.getResource("PastaImagens/btnIniciar_ca_ES.jpg"));

		imagemIniciarEducativo = new ImageIcon(
				SelecaoDeNivel.class.getResource("PastaImagens/btnIniciar.jpg"));
		imagemIniciarEducativo_en_US = new ImageIcon(
				SelecaoDeNivel.class
						.getResource("PastaImagens/btnIniciar_en_US.jpg"));
		imagemIniciarEducativo_ca_ES = new ImageIcon(
				SelecaoDeNivel.class
						.getResource("PastaImagens/btnIniciar_ca_ES.jpg"));
		
		imagemVoltar=new ImageIcon(
				SelecaoDeNivel.class
				.getResource("PastaImagens/btnVoltar.jpg"));
		imagemVoltar_en_US=new ImageIcon(
				SelecaoDeNivel.class
				.getResource("PastaImagens/btnVoltar_en_US.jpg"));
		imagemVoltar_ca_ES=new ImageIcon(
				SelecaoDeNivel.class
				.getResource("PastaImagens/btnVoltar_ca_ES.jpg"));

		imgIniciarDinamico = imagemIniciarDinamico.getImage()
				.getScaledInstance(lblDinamico.getWidth(),
						lblDinamico.getHeight(), Image.SCALE_DEFAULT);
		imgIniciarDinamico_en_US = imagemIniciarDinamico_en_US.getImage()
				.getScaledInstance(lblDinamico.getWidth(),
						lblDinamico.getHeight(), Image.SCALE_DEFAULT);
		imgIniciarDinamico_ca_ES = imagemIniciarDinamico_ca_ES.getImage()
				.getScaledInstance(lblDinamico.getWidth(),
						lblDinamico.getHeight(), Image.SCALE_DEFAULT);

		imgIniciarEducativo = imagemIniciarEducativo.getImage()
				.getScaledInstance(lblEducativo.getWidth(),
						lblEducativo.getHeight(), Image.SCALE_DEFAULT);
		imgIniciarEducativo_en_US = imagemIniciarEducativo_en_US.getImage()
				.getScaledInstance(lblEducativo.getWidth(),
						lblEducativo.getHeight(), Image.SCALE_DEFAULT);
		imgIniciarEducativo_ca_ES = imagemIniciarEducativo_ca_ES.getImage()
				.getScaledInstance(lblEducativo.getWidth(),
						lblEducativo.getHeight(), Image.SCALE_DEFAULT);
		
		imgVoltar=imagemVoltar.getImage()
				.getScaledInstance(lblVoltar.getWidth(),
						lblVoltar.getHeight(), Image.SCALE_DEFAULT);
		imgVoltar_en_US=imagemVoltar_en_US.getImage()
				.getScaledInstance(lblVoltar.getWidth(),
						lblVoltar.getHeight(), Image.SCALE_DEFAULT);
		imgVoltar_ca_ES=imagemVoltar_ca_ES.getImage()
				.getScaledInstance(lblVoltar.getWidth(),
						lblVoltar.getHeight(), Image.SCALE_DEFAULT);

		lblEducativo.setIcon(new ImageIcon(imgIniciarEducativo));
		lblDinamico.setIcon(new ImageIcon(imgIniciarDinamico));
		lblVoltar.setIcon(new ImageIcon(imgVoltar));

		lblEducativo.addMouseListener(this);
		lblDinamico.addMouseListener(this);
		lblVoltar.addMouseListener(this);
	}

	SelecaoDeNivel(Locale locale, String nome) throws IOException {
		this(locale);
		this.nomeDeUsuario = nome;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblEducativo) {
			if (nomeDeUsuario == "") {
				try {
					SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(
							new Locale(InformacaoGlobal.localeGlobal),
							"educativo");
					if(InformacaoGlobal.localeGlobal=="pt"){
						SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar));
						SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar));
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar_ca_ES));
							SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar_ca_ES));
						}else{
							SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar_en_US));
							SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar_en_US));
						}
					}
					SelecaoDeDificuldade.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(
							new Locale(InformacaoGlobal.localeGlobal),
							"educativo", nomeDeUsuario);
					SelecaoDeDificuldade.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}else{
			if(e.getSource()==lblDinamico){
				if (nomeDeUsuario == "") {
					try {
						SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(
								new Locale(InformacaoGlobal.localeGlobal),
								"dinamico");
						if(InformacaoGlobal.localeGlobal=="pt"){
							SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar));
							SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar));
						}else{
							if(InformacaoGlobal.localeGlobal=="ca_ES"){
								SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar_ca_ES));
								SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar_ca_ES));
							}else{
								SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgIniciar_en_US));
								SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(SelecaoDeDificuldade.imgVoltar_en_US));
							}
						}
						SelecaoDeDificuldade.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					try {
						SelecaoDeDificuldade SelecaoDeDificuldade1 = new SelecaoDeDificuldade(
								new Locale(InformacaoGlobal.localeGlobal),
								"dinamico", nomeDeUsuario);
						SelecaoDeDificuldade1.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}else{
				if(e.getSource()==lblVoltar){
					if (nomeDeUsuario != "") {
						try {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal),
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal));
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
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
