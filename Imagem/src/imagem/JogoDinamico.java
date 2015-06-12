package imagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class JogoDinamico extends JFrame implements ActionListener {

	Timer timer;
	private static final long serialVersionUID = 1L;
	private Pontuacao pontuacao = new Pontuacao();
	private Imagens obj1, obj2;
	public static int nivel;
	public int nivelQnt;
	private boolean primeiroClique = true;
	private boolean acertou = true;
	private Object img1 = new Object();
	private Object img2 = new Object();
	ImageIcon imagemPadrao;
	JLabel pontos;
	private JPanel painelCabecalho, painelJogo, painelSub, painelGeral;
	private ArrayList<Icon> imagensArray;
	private GridLayout gridCabecalho, gridJogo, gridSub;
	private ArrayList<Imagens> imagens;
	private final Container container;
	private JLabel timerLabel;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mntnNovoJogo;
	private JMenuItem mntmMenu;
	private JMenuItem mntmVoltar;
	int pontoFinal;
	String nomeDeUsuario = "";
	JLabel lblCronometro;
	ImageIcon imagemCronometro;
	Image imgCronometro;

	void prepararJogo() {
		// nivelQnt recebe o número de cartas do jogo de acordo com nível
		// escolhido
		if (JogoDinamico.nivel == 1)
			nivelQnt = 12;
		else if (JogoDinamico.nivel == 2)
			nivelQnt = 24;
		else
			nivelQnt = 36;

		// temaImg recebe o correspondente ao tema escolhido

	}

	void prepararImagens() {
		// inicializar vetor
		imagensArray = new ArrayList<Icon>();
		int i;
		for (i = 0; i < nivelQnt; i++)
			// inserir as imagens de acordo com o tema
			this.imagensArray.add(new ImageIcon(getClass().getResource(
					"PastaImagens/natureza" + " (" + (i + 1) + ").png")));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public JogoDinamico(int nivel) {		
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		
		setUndecorated(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		setTitle(bundle.getString("JogoDinamico.JFrame.text"));
		int count = 30;

		timerLabel = new JLabel("" + count);
		timerLabel.setSize(105, 60);
		timerLabel.setLocation(10, 10);
		timerLabel.setVisible(false);
		
		TimeClass tc = new TimeClass(count);
		timer = new Timer(1000, tc);
		timer.start();
		JogoDinamico.nivel = nivel;
		prepararJogo();
		prepararImagens();
		new ImageIcon(getClass().getResource("PastaImagens/tema_natureza.png"));
		// gerenciadores de layout
		gridCabecalho = new GridLayout(1, 1, 0, 0);
		gridSub = new GridLayout(1, 2, 0, 0);
		// verificar qual deve ser a disposição de botões de acordo com o nível
		if (JogoDinamico.nivel == 1)
			gridJogo = new GridLayout(3, 4, 0, 0);
		else if (JogoDinamico.nivel == 2)
			gridJogo = new GridLayout(3, 8, 0, 0);
		else
			gridJogo = new GridLayout(4, 9, 0, 0);

		// configurar painelCabecalho
		painelCabecalho = new JPanel();
		painelCabecalho.setBounds(0, 0, 450, 0);
		painelCabecalho.setLayout(gridCabecalho);
		// configurar painelJogo
		painelJogo = new JPanel();
		painelJogo.setBounds(0, 10, 705, 456);
		painelJogo.setLayout(gridJogo);

		int numObj = 0;
		imagens = new ArrayList<Imagens>();
		// preencher todos os botões com a imagem padrão, sua imagem e sua
		// idenficação
		for (Icon imagem : imagensArray) {
			numObj++;
			imagens.add(new Imagens(imagemPadrao, imagem, numObj));
			imagens.get(numObj - 1).addActionListener(this);
		}

		// embaralhar os botões
		Collections.shuffle(imagens);
		for (Imagens imagem : imagens)
			painelJogo.add(imagem);

		// configurar pontos
		pontos = new JLabel(String.valueOf(pontuacao.getPontos()));

		// configurar painelSub
		painelSub = new JPanel();
		painelSub.setBounds(0, 479, 450, 16);
		painelSub.setLayout(gridSub);
		
		JLabel lblPontuacao = new JLabel(bundle.getString("JogoDinamico.lblPontuacao.text"));
		painelSub.add(lblPontuacao);
		painelSub.add(pontos);
		
		JLabel lblTempo = new JLabel(bundle.getString("JogoDinamico.lblTempo.text"));
		painelSub.add(lblTempo);
		lblTempo.setVisible(false);

		timerLabel = new JLabel();
		painelSub.add(timerLabel);
		timerLabel.setVisible(false);

		// configurar painelGeral
		painelGeral = new JPanel();
		painelGeral.setLayout(null);
		painelGeral.add(painelCabecalho);
		painelGeral.add(painelJogo);
		painelGeral.add(painelSub);

		// configurar container
		container = getContentPane();
		container.setLayout(new BorderLayout(5, 5));
		container.add(painelGeral);
		
		lblCronometro = new JLabel("");
		lblCronometro.setBounds(734, 98, 303, 215);
		painelGeral.add(lblCronometro);
		
		imagemCronometro = new ImageIcon(
				JogoDinamico.class.getResource("PastaImagens/cronometrofinal2.gif"));
		
		imgCronometro = imagemCronometro.getImage().getScaledInstance(
				lblCronometro.getWidth(), lblCronometro.getHeight(),
				Image.SCALE_DEFAULT);
		
		lblCronometro.setIcon(new ImageIcon(imgCronometro));
		
		setLocation(50, 50);
		setSize(1171, 564);
		setResizable(false);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnOpcoes = new JMenu(bundle.getString("JogoDinamico.mnOpcoes"));
		menuBar.add(mnOpcoes);

		mntnNovoJogo = new JMenuItem(bundle.getString("JogoDinamico.mntnNovoJogo.text"));
		mnOpcoes.add(mntnNovoJogo);
		mntnNovoJogo.addActionListener(this);

		mntmVoltar = new JMenuItem(bundle.getString("JogoDinamico.mntmVoltar.text"));
		mnOpcoes.add(mntmVoltar);
		mntmVoltar.addActionListener(this);

		mntmMenu = new JMenuItem(bundle.getString("JogoDinamico.mntmMenu.text"));
		mnOpcoes.add(mntmMenu);

		mntmMenu.addActionListener(this);
		setVisible(true);
	}

	JogoDinamico(int nivel, String nome) {
		this(nivel);
		this.nomeDeUsuario = nome;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mntmMenu) {
			try {
				if (nomeDeUsuario == "") {
					timer.stop();
					TelaInicial tela = new TelaInicial(new Locale(InformacaoGlobal.localeGlobal));
					tela.setVisible(true);
					dispose();
				} else {
					timer.stop();
					TelaInicial tela = new TelaInicial(new Locale(InformacaoGlobal.localeGlobal),nomeDeUsuario);
					tela.setVisible(true);
					dispose();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			if (e.getSource() == mntmVoltar) {
				try {
					if (nomeDeUsuario == "") {
						timer.stop();
						SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(new Locale(InformacaoGlobal.localeGlobal),
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
					} else {
						timer.stop();
						SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(new Locale(InformacaoGlobal.localeGlobal),
								"dinamico", nomeDeUsuario);
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
					}

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				if (e.getSource() == mntnNovoJogo) {
					if (JogoDinamico.nivel == 1) {
						if (nomeDeUsuario == "") {
							timer.stop();
							JogoDinamico tela = new JogoDinamico(1);
							tela.setVisible(true);
							dispose();
						} else {
							timer.stop();
							JogoDinamico tela = new JogoDinamico(1,
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						}
					} else {
						if (JogoDinamico.nivel == 2) {
							if (nomeDeUsuario == "") {
								timer.stop();
								JogoDinamico tela = new JogoDinamico(2);
								tela.setVisible(true);
								dispose();
							} else {
								timer.stop();
								JogoDinamico tela = new JogoDinamico(2,
										nomeDeUsuario);
								tela.setVisible(true);
								dispose();
							}
						} else {
							if (JogoDinamico.nivel == 3) {
								if (nomeDeUsuario == "") {
									timer.stop();
									JogoDinamico tela = new JogoDinamico(3);
									tela.setVisible(true);
									dispose();
								} else {
									timer.stop();
									JogoDinamico tela = new JogoDinamico(3,
											nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}
							}
						}
					}
				}
			}
		}
		
		// testa se é o primeiro clique
		if (primeiroClique) {
			// testa se o jogador errou na jogada anterior
			if (!acertou) {
				obj1 = (Imagens) img1;
				obj2 = (Imagens) img2;
				obj1.setImagemPadrao();
				obj2.setImagemPadrao();
			}
			img1 = e.getSource();
			obj1 = (Imagens) img1;
			obj1.setImagemObjeto();

			// indica que este foi o primeiro clique
			primeiroClique = false;
		}

		// se não for o primeiro clique
		else {
			img2 = e.getSource();
			obj2 = (Imagens) img2;

			// verifica se jogador clicou no mesmo objeto
			if (obj1.getID() == obj2.getID()) {
				acertou = false;
			} else {

				// atualiza imagem
				obj2.setImagemObjeto();

				// compara com o primeiro
				if ((obj1.getID() % 2 == 0)
						&& (obj1.getID() - 1 == obj2.getID())
						|| (obj1.getID() % 2 != 0)
						&& (obj1.getID() + 1 == obj2.getID())) {

					acertou = true;
					pontuacao.setAcertos();
					pontuacao.ganharPontos();
					pontos.setText(String.valueOf(pontuacao.getPontos()));

					// Desabilita os botões
					obj1.setEnabled(false);
					obj2.setEnabled(false);

					// se foi o último par encontrado, encerra jogo
					if (pontuacao.getAcertos() == ((nivelQnt) / 2)) {
						timer.stop();
						if (nomeDeUsuario == "") {
							if(InformacaoGlobal.localeGlobal=="pt"){
							FimDeJogo fim = new FimDeJogo("JogoDinamico",
									JogoDinamico.nivel,new Locale("pt"));
							fim.setVisible(true);
							fim.lblVocePerdeu.setText("Você ganhou!");
							dispose();
							fim.lblPontuacao.setText(String.valueOf(pontuacao
									.getPontos()));
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									FimDeJogo fim = new FimDeJogo("JogoDinamico",
											JogoDinamico.nivel,new Locale("ca","ES"));
									fim.setVisible(true);
									fim.lblVocePerdeu.setText("Usted ganó!");
									dispose();
									fim.lblPontuacao.setText(String.valueOf(pontuacao
											.getPontos()));
								}else{
									if(InformacaoGlobal.localeGlobal=="en_US"){
										FimDeJogo fim = new FimDeJogo("JogoDinamico",
												JogoDinamico.nivel,new Locale("en","US"));
										fim.setVisible(true);
										fim.lblVocePerdeu.setText("You won!");
										dispose();
										fim.lblPontuacao.setText(String.valueOf(pontuacao
												.getPontos()));
									}
								}
							}
						} else {
							if(InformacaoGlobal.localeGlobal=="ca_ES"){
								FimDeJogo fim = new FimDeJogo("JogoDinamico",
										JogoDinamico.nivel, nomeDeUsuario,new Locale("ca","ES"));
								fim.setVisible(true);
								dispose();
								fim.lblVocePerdeu.setText("Usted ganó!");
								fim.lblPontuacao.setText(String.valueOf(pontuacao
										.getPontos()));
							}else{
								if(InformacaoGlobal.localeGlobal=="en_US"){
									FimDeJogo fim = new FimDeJogo("JogoDinamico",
											JogoDinamico.nivel, nomeDeUsuario,new Locale("en","US"));
									fim.setVisible(true);
									dispose();
									fim.lblVocePerdeu.setText("You won!");
									fim.lblPontuacao.setText(String.valueOf(pontuacao
											.getPontos()));
								}else{
									FimDeJogo fim = new FimDeJogo("JogoDinamico",
											JogoDinamico.nivel, nomeDeUsuario,new Locale("pt"));
									fim.setVisible(true);
									dispose();
									fim.lblVocePerdeu.setText("Você ganhou!");
									fim.lblPontuacao.setText(String.valueOf(pontuacao
											.getPontos()));
								}
							}
							
							
						}
					}
				} else {
					acertou = false;
					pontuacao.perderPontos();
					pontos.setText(String.valueOf(pontuacao.getPontos()));
				}
				pontuacao.setTentativas();
				// indica que este foi o segundo clique
				primeiroClique = true;
			}
		}

	}

	public class TimeClass implements ActionListener {
		int counter;

		public TimeClass(int counter) {
			this.counter = counter;
		}

		public void actionPerformed(ActionEvent tc) {
			counter--;

			if (counter >= 1) {
				timerLabel.setText("" + counter);
			} else {
				timer.stop();
				if (nomeDeUsuario == "") {
					FimDeJogo fim = new FimDeJogo("JogoDinamico",
							JogoDinamico.nivel);
					if(InformacaoGlobal.localeGlobal=="pt"){
						fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente));
						fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking));
						fim.lblSair.setIcon(new ImageIcon(fim.imgSair));
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente_ca_ES));
							fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking_ca_ES));
							fim.lblSair.setIcon(new ImageIcon(fim.imgSair_ca_ES));
						}else{
							fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente_en_US));
							fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking));
							fim.lblSair.setIcon(new ImageIcon(fim.imgSair_en_US));
						}
					}
					fim.setVisible(true);
					dispose();
					
					if(InformacaoGlobal.localeGlobal=="ca_ES"){
						fim.lblVocePerdeu.setText("que perdió!");
					}else{
						if(InformacaoGlobal.localeGlobal=="en_US"){
							fim.lblVocePerdeu.setText("You lost!");
						}else{
							fim.lblVocePerdeu.setText("Você perdeu!");
						}
					}
					
					fim.lblPontuacao.setText(String.valueOf(pontuacao
							.getPontos()));
				} else {
					FimDeJogo fim = new FimDeJogo("JogoDinamico",
							JogoDinamico.nivel, nomeDeUsuario);
					if(InformacaoGlobal.localeGlobal=="pt"){
						fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente));
						fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking));
						fim.lblSair.setIcon(new ImageIcon(fim.imgSair));
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente_ca_ES));
							fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking_ca_ES));
							fim.lblSair.setIcon(new ImageIcon(fim.imgSair_ca_ES));
						}else{
							fim.lblJogarNovamente.setIcon(new ImageIcon(fim.imgJogarNovamente_en_US));
							fim.lblRanking.setIcon(new ImageIcon(fim.imgRanking));
							fim.lblSair.setIcon(new ImageIcon(fim.imgSair_en_US));
						}
					}
					fim.setVisible(true);
					dispose();
					
					if(InformacaoGlobal.localeGlobal=="ca_ES"){
						fim.lblVocePerdeu.setText("que perdió!");
					}else{
						if(InformacaoGlobal.localeGlobal=="en_US"){
							fim.lblVocePerdeu.setText("You lost!");
						}else{
							fim.lblVocePerdeu.setText("Você perdeu!");
						}
					}
					
					fim.lblPontuacao.setText(String.valueOf(pontuacao
							.getPontos()));
				}
			}
		}
	}
}
