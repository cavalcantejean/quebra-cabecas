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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class TelaInicial extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel foto;
	ImageIcon imagem;
	Image img;
	static JLabel lblUsuario, lblJogoDa, lblMemoria, lblSaudacao, lblNovoJogo,
			lblLogar, lblRanking, lblCriarUsuario, lblTrocarSenha,
			lblConfiguracao,lblDeslogar,lblConquistas;
	String nomeDeUsuario = "";

	public static void main(String[] args) {
		try {
			new TelaInicial(new Locale(InformacaoGlobal.localeGlobal))
			.setVisible(true);
		} catch (IOException e) {
			System.out.println("Imagem não existe");
		}
	}

	/**
	 * @wbp.parser.constructor
	 */
	public TelaInicial(Locale locale) throws IOException {
		Locale.setDefault(locale);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1= ResourceBundle.getBundle("imagem.ResBundle");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		setResizable(false);
		setTitle(bundle.getString("TelaInicial.JFrame.text"));
		setBounds(50, 50, 547, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSaudacao = new JLabel(
				bundle.getString("TelaInicial.lblSaudacao.text"));
		lblSaudacao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblSaudacao.setForeground(Color.WHITE);
		lblSaudacao.setBounds(36, 11, 150, 30);
		lblSaudacao.setVisible(false);
		contentPane.add(lblSaudacao);

		imagem = new ImageIcon(
				TelaInicial.class.getResource("PastaImagens/natureza.jpg"));

		lblUsuario = new JLabel();
		lblUsuario.setText(bundle.getString("TelaInicial.lblUsuario.text"));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(36, 52, 253, 48);
		contentPane.add(lblUsuario);
		lblUsuario.setVisible(false);

		lblJogoDa = new JLabel();
		lblJogoDa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblJogoDa.setText(bundle.getString("TelaInicial.lblJogoDa.text"));
		lblJogoDa.setForeground(Color.WHITE);
		lblJogoDa.setBounds(203, 94, 119, 39);
		contentPane.add(lblJogoDa);

		lblMemoria = new JLabel();
		lblMemoria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblMemoria.setText(bundle.getString("TelaInicial.lblMemoria.text"));
		lblMemoria.setForeground(Color.ORANGE);
		lblMemoria.setBounds(200, 133, 138, 48);
		contentPane.add(lblMemoria);

		lblNovoJogo = new JLabel("");
		lblNovoJogo.setBounds(190, 327, 99, 39);
		contentPane.add(lblNovoJogo);
		lblNovoJogo.addMouseListener(this);

		lblLogar = new JLabel("");
		lblLogar.setBounds(190, 381, 99, 39);
		contentPane.add(lblLogar);
		lblLogar.addMouseListener(this);

		lblRanking = new JLabel("");
		lblRanking.setBounds(190, 431, 99, 40);
		contentPane.add(lblRanking);
		lblRanking.addMouseListener(this);

		lblCriarUsuario = new JLabel("");
		lblCriarUsuario.setBounds(190, 482, 148, 41);
		contentPane.add(lblCriarUsuario);
		lblCriarUsuario.addMouseListener(this);

		lblDeslogar = new JLabel("");
		lblDeslogar.setBounds(360, 327, 88, 39);
		contentPane.add(lblDeslogar);
		lblDeslogar.addMouseListener(this);

		lblTrocarSenha = new JLabel("");
		lblTrocarSenha.setBounds(360, 381, 88, 39);
		contentPane.add(lblTrocarSenha);
		lblTrocarSenha.addMouseListener(this);

		lblConfiguracao = new JLabel("");
		lblConfiguracao.setBounds(360, 431, 138, 39);
		contentPane.add(lblConfiguracao);
		lblConfiguracao.addMouseListener(this);

		lblConquistas = new JLabel("");
		lblConquistas.setBounds(360, 482, 150, 39);
		contentPane.add(lblConquistas);
		lblConquistas.addMouseListener(this);
		
		lblNovoJogo.setIcon(new ImageIcon((Image) bundle1.getObject("TelaInicial.lblNovoJogo.image")));
		lblLogar.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblLogar.image")));
		lblRanking.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblRanking.image")));
		lblCriarUsuario.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblCriarUsuario.image")));
		lblDeslogar.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblDeslogar.image")));
		lblTrocarSenha.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblTrocarSenha.image")));
		lblConfiguracao.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblConfiguracao.image")));
		lblConquistas.setIcon(new ImageIcon((Image)bundle1.getObject("TelaInicial.lblConquistas.image")));

		foto = new JLabel("");
		foto.setBounds(0, 0, 547, 547);
		contentPane.add(foto);
		img = imagem.getImage().getScaledInstance(foto.getWidth(),
				foto.getHeight(), Image.SCALE_DEFAULT);
		foto.setIcon(new ImageIcon(img));

		lblDeslogar.setVisible(false);
		lblLogar.setVisible(true);
		lblUsuario.setVisible(false);
		lblTrocarSenha.setVisible(false);
		lblCriarUsuario.setVisible(true);
		lblSaudacao.setVisible(false);
		lblConquistas.setVisible(false);
	}

	TelaInicial(Locale locale, String nome) throws IOException {
		this(locale);
		this.nomeDeUsuario = nome;
		lblDeslogar.setVisible(true);
		lblLogar.setVisible(false);
		lblCriarUsuario.setVisible(false);
		lblUsuario.setVisible(true);
		lblUsuario.setText(nome);
		lblTrocarSenha.setVisible(true);
		lblSaudacao.setVisible(true);
		lblConquistas.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNovoJogo) {
			if (nomeDeUsuario == "") {
				try {
					SelecaoDeNivel nivel = new SelecaoDeNivel(new Locale(
							InformacaoGlobal.localeGlobal));
					if (InformacaoGlobal.localeGlobal == "pt") {
						nivel.lblDinamico.setIcon(new ImageIcon(
								nivel.imgIniciarDinamico));
						nivel.lblEducativo.setIcon(new ImageIcon(
								nivel.imgIniciarEducativo));
						nivel.lblVoltar.setIcon(new ImageIcon(nivel.imgVoltar));
					} else {
						if (e.getSource() == "ca_ES") {
							nivel.lblDinamico.setIcon(new ImageIcon(
									nivel.imgIniciarDinamico_ca_ES));
							nivel.lblEducativo.setIcon(new ImageIcon(
									nivel.imgIniciarEducativo_ca_ES));
							nivel.lblVoltar.setIcon(new ImageIcon(
									nivel.imgVoltar_ca_ES));
						} else {
							nivel.lblDinamico.setIcon(new ImageIcon(
									nivel.imgIniciarDinamico_en_US));
							nivel.lblEducativo.setIcon(new ImageIcon(
									nivel.imgIniciarEducativo_en_US));
							nivel.lblVoltar.setIcon(new ImageIcon(
									nivel.imgVoltar_en_US));
						}
					}
					nivel.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				try {
					SelecaoDeNivel nivel = new SelecaoDeNivel(new Locale(
							InformacaoGlobal.localeGlobal), nomeDeUsuario);
					if (InformacaoGlobal.localeGlobal == "pt") {
						nivel.lblDinamico.setIcon(new ImageIcon(
								nivel.imgIniciarDinamico));
						nivel.lblEducativo.setIcon(new ImageIcon(
								nivel.imgIniciarEducativo));
						nivel.lblVoltar.setIcon(new ImageIcon(nivel.imgVoltar));
					} else {
						if (e.getSource() == "ca_ES") {
							nivel.lblDinamico.setIcon(new ImageIcon(
									nivel.imgIniciarDinamico_ca_ES));
							nivel.lblEducativo.setIcon(new ImageIcon(
									nivel.imgIniciarEducativo_ca_ES));
							nivel.lblVoltar.setIcon(new ImageIcon(
									nivel.imgVoltar_ca_ES));
						} else {
							nivel.lblDinamico.setIcon(new ImageIcon(
									nivel.imgIniciarDinamico_en_US));
							nivel.lblEducativo.setIcon(new ImageIcon(
									nivel.imgIniciarEducativo_en_US));
							nivel.lblVoltar.setIcon(new ImageIcon(
									nivel.imgVoltar_en_US));
						}
					}
					nivel.setVisible(true);
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else {
			if (e.getSource() == lblLogar) {
				Login login = new Login(new Locale(
						InformacaoGlobal.localeGlobal));
				if (InformacaoGlobal.localeGlobal == "pt") {
					login.lblCancelar.setIcon(new ImageIcon(login.imgCancelar));
					login.lblEsqueceuSenha.setIcon(new ImageIcon(
							login.imgEsqueceuSenha));
					login.lblLimpar.setIcon(new ImageIcon(login.imgLimpar));
					login.lblLogar.setIcon(new ImageIcon(login.imgLogar));
				} else {
					if (InformacaoGlobal.localeGlobal == "ca_ES") {
						login.lblCancelar.setIcon(new ImageIcon(
								login.imgCancelar));
						login.lblEsqueceuSenha.setIcon(new ImageIcon(
								login.imgEsqueceuSenha_ca_ES));
						login.lblLimpar.setIcon(new ImageIcon(
								login.imgLimpar_ca_ES));
						login.lblLogar.setIcon(new ImageIcon(
								login.imgLogar_ca_ES));
					} else {
						login.lblCancelar.setIcon(new ImageIcon(
								login.imgCancelar_en_US));
						login.lblEsqueceuSenha.setIcon(new ImageIcon(
								login.imgEsqueceuSenha_en_US));
						login.lblLimpar.setIcon(new ImageIcon(
								login.imgLimpar_en_US));
						login.lblLogar.setIcon(new ImageIcon(
								login.imgLogar_en_US));
					}
				}
				login.setVisible(true);
				dispose();
			} else {
				if (e.getSource() == lblRanking) {
					Conexao.FazConexao();
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
						Conexao.FazConexao();
						Ranking ranking = new Ranking(new Locale(
								InformacaoGlobal.localeGlobal), nomeDeUsuario);
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
				} else {
					if (e.getSource() == lblCriarUsuario) {
						CriacaoUsuario criacao = new CriacaoUsuario(new Locale(
								InformacaoGlobal.localeGlobal));
						if (InformacaoGlobal.localeGlobal == "pt") {
							criacao.lblCadastrar.setIcon(new ImageIcon(
									criacao.imgCadastrar));
							criacao.lblCancelar.setIcon(new ImageIcon(
									criacao.imgCancelar));
						} else {
							if (InformacaoGlobal.localeGlobal == "ca_ES") {
								criacao.lblCadastrar.setIcon(new ImageIcon(
										criacao.imgCadastrar));
								criacao.lblCancelar.setIcon(new ImageIcon(
										criacao.imgCancelar));
							} else {
								criacao.lblCadastrar.setIcon(new ImageIcon(
										criacao.imgCadastrar_en_US));
								criacao.lblCancelar.setIcon(new ImageIcon(
										criacao.imgCancelar_en_US));
							}
						}
						criacao.setVisible(true);
						dispose();
					} else {
						if (e.getSource() == lblDeslogar) {
							nomeDeUsuario = "";
							lblDeslogar.setVisible(false);
							lblLogar.setVisible(true);
							lblUsuario.setVisible(false);
							lblTrocarSenha.setVisible(false);
							lblCriarUsuario.setVisible(true);
							lblSaudacao.setVisible(false);
							lblConquistas.setVisible(false);
							InformacaoGlobal.nomeDeUsuario = "";
						} else {
							if (e.getSource() == lblTrocarSenha) {
								TrocarSenha trocar = new TrocarSenha(
										new Locale(
												InformacaoGlobal.localeGlobal),
										nomeDeUsuario);
								if (InformacaoGlobal.localeGlobal == "pt") {
									trocar.lblCancelar.setIcon(new ImageIcon(
											trocar.imgCancelar));
								} else {
									if (InformacaoGlobal.localeGlobal == "ca_ES") {
										trocar.lblCancelar
												.setIcon(new ImageIcon(
														trocar.imgCancelar));
									} else {
										trocar.lblCancelar
												.setIcon(new ImageIcon(
														trocar.imgCancelar_en_US));
									}
								}
								trocar.setVisible(true);
								dispose();
							} else {
								if (e.getSource() == lblConfiguracao) {
									if (nomeDeUsuario == "") {
										// ESTÁ DANDO PROBLEMA NO LOCALE PT
										if (InformacaoGlobal.localeGlobal == "pt") {
											Configuracao conf = new Configuracao(
													new Locale("pt"));
											InformacaoGlobal.localeGlobal = "pt";
											conf.setVisible(true);
											conf.cbxIdioma.setSelectedIndex(0);
											dispose();
										} else {
											if (InformacaoGlobal.localeGlobal == "en_US") {
												Configuracao conf = new Configuracao(
														new Locale("en_US"));
												InformacaoGlobal.localeGlobal = "en_US";
												conf.setVisible(true);
												conf.cbxIdioma
														.setSelectedIndex(1);
												dispose();
											} else {
												Configuracao conf = new Configuracao(
														new Locale("ca_ES"));
												InformacaoGlobal.localeGlobal = "ca_ES";
												conf.setVisible(true);
												conf.cbxIdioma
														.setSelectedIndex(2);
												dispose();
											}
										}
									} else {
										if (nomeDeUsuario != "") {
											if (InformacaoGlobal.localeGlobal == "pt") {
												Configuracao conf = new Configuracao(
														new Locale("pt"),
														nomeDeUsuario);
												InformacaoGlobal.localeGlobal = "pt";
												conf.setVisible(true);
												conf.cbxIdioma
														.setSelectedIndex(0);
												dispose();
											} else {
												if (InformacaoGlobal.localeGlobal == "en_US") {
													Configuracao conf = new Configuracao(
															new Locale("en_US"),
															nomeDeUsuario);
													InformacaoGlobal.localeGlobal = "en_US";
													conf.setVisible(true);
													conf.cbxIdioma
															.setSelectedIndex(1);
													dispose();
												} else {
													Configuracao conf = new Configuracao(
															new Locale("ca_ES"),
															nomeDeUsuario);
													InformacaoGlobal.localeGlobal = "ca_ES";
													conf.setVisible(true);
													conf.cbxIdioma
															.setSelectedIndex(2);
													dispose();
												}
											}
										}
									}
								} else {
									if (e.getSource() == lblConquistas) {
										if (InformacaoGlobal.localeGlobal == "pt") {
											if (InformacaoGlobal.pontuacaoDinamica < 1000
													&& InformacaoGlobal.pontuacaoEducativa < 1000) {
												Conquistas conq = new Conquistas(
														new Locale("pt"),
														nomeDeUsuario);
												InformacaoGlobal.localeGlobal = "pt";
												conq.foto
														.setIcon(new ImageIcon(
																conq.imgPossibilidade1));
												conq.setVisible(true);
												dispose();
											} else {
												if (InformacaoGlobal.pontuacaoDinamica >= 1000
														&& InformacaoGlobal.pontuacaoDinamica < 2000
														&& InformacaoGlobal.pontuacaoEducativa < 1000) {
													Conquistas conq = new Conquistas(
															new Locale("pt"),
															nomeDeUsuario);
													InformacaoGlobal.localeGlobal = "pt";
													conq.foto
															.setIcon(new ImageIcon(
																	conq.imgPossibilidade2));
													conq.setVisible(true);
													dispose();
												}else{
													if(InformacaoGlobal.pontuacaoDinamica < 1000
														&& InformacaoGlobal.pontuacaoEducativa >= 1000
														&& InformacaoGlobal.pontuacaoEducativa < 2000){
														Conquistas conq = new Conquistas(
																new Locale("pt"),
																nomeDeUsuario);
														InformacaoGlobal.localeGlobal = "pt";
														conq.foto
																.setIcon(new ImageIcon(
																		conq.imgPossibilidade3));
														conq.setVisible(true);
														dispose();
													}
													else{
														if(InformacaoGlobal.pontuacaoDinamica >= 1000
																&& InformacaoGlobal.pontuacaoDinamica < 2000
																&& InformacaoGlobal.pontuacaoEducativa >= 1000
																&& InformacaoGlobal.pontuacaoEducativa < 2000){															
															Conquistas conq = new Conquistas(
																	new Locale("pt"),
																	nomeDeUsuario);
															InformacaoGlobal.localeGlobal = "pt";
															conq.foto
																	.setIcon(new ImageIcon(
																			conq.imgPossibilidade4));
															conq.setVisible(true);
															dispose();
														}else{
															if(InformacaoGlobal.pontuacaoDinamica >= 1000
																	&& InformacaoGlobal.pontuacaoDinamica < 2000
																	&& InformacaoGlobal.pontuacaoEducativa >= 2000
																	&& InformacaoGlobal.pontuacaoEducativa < 3000){
																Conquistas conq = new Conquistas(
																		new Locale("pt"),
																		nomeDeUsuario);
																InformacaoGlobal.localeGlobal = "pt";
																conq.foto
																		.setIcon(new ImageIcon(
																				conq.imgPossibilidade5));
																conq.setVisible(true);
																dispose();
															}else{
																if(InformacaoGlobal.pontuacaoDinamica >= 2000
																		&& InformacaoGlobal.pontuacaoDinamica < 3000
																		&& InformacaoGlobal.pontuacaoEducativa >= 1000
																		&& InformacaoGlobal.pontuacaoEducativa < 2000){
																	Conquistas conq = new Conquistas(
																			new Locale("pt"),
																			nomeDeUsuario);
																	InformacaoGlobal.localeGlobal = "pt";
																	conq.foto
																			.setIcon(new ImageIcon(
																					conq.imgPossibilidade6));
																	conq.setVisible(true);
																	dispose();
																}else{
																	if(InformacaoGlobal.pontuacaoDinamica >= 2000
																			&& InformacaoGlobal.pontuacaoDinamica < 3000
																			&& InformacaoGlobal.pontuacaoEducativa >= 2000
																			&& InformacaoGlobal.pontuacaoEducativa < 3000){
																		Conquistas conq = new Conquistas(
																				new Locale("pt"),
																				nomeDeUsuario);
																		InformacaoGlobal.localeGlobal = "pt";
																		conq.foto
																				.setIcon(new ImageIcon(
																						conq.imgPossibilidade7));
																		conq.setVisible(true);
																		dispose();
																	}else{
																		if(InformacaoGlobal.pontuacaoDinamica >= 2000
																				&& InformacaoGlobal.pontuacaoDinamica < 3000
																				&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																			Conquistas conq = new Conquistas(
																					new Locale("pt"),
																					nomeDeUsuario);
																			InformacaoGlobal.localeGlobal = "pt";
																			conq.foto
																					.setIcon(new ImageIcon(
																							conq.imgPossibilidade8));
																			conq.setVisible(true);
																			dispose();
																		}else{
																			if(InformacaoGlobal.pontuacaoDinamica >= 3000
																					&& InformacaoGlobal.pontuacaoEducativa >= 2000
																					&& InformacaoGlobal.pontuacaoEducativa < 3000){
																				Conquistas conq = new Conquistas(
																						new Locale("pt"),
																						nomeDeUsuario);
																				InformacaoGlobal.localeGlobal = "pt";
																				conq.foto
																						.setIcon(new ImageIcon(
																								conq.imgPossibilidade9));
																				conq.setVisible(true);
																				dispose();
																			}else{
																				if(InformacaoGlobal.pontuacaoDinamica >= 3000
																						&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																					Conquistas conq = new Conquistas(
																							new Locale("pt"),
																							nomeDeUsuario);
																					InformacaoGlobal.localeGlobal = "pt";
																					conq.foto
																							.setIcon(new ImageIcon(
																									conq.imgPossibilidade10));
																					conq.setVisible(true);
																					dispose();
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										} else {
											if (InformacaoGlobal.localeGlobal == "en_US") {
												if (InformacaoGlobal.pontuacaoDinamica < 1000
														&& InformacaoGlobal.pontuacaoEducativa < 1000) {
													Conquistas conq = new Conquistas(
															new Locale("en_US"),
															nomeDeUsuario);
													InformacaoGlobal.localeGlobal = "en_US";
													conq.foto
															.setIcon(new ImageIcon(
																	conq.imgPossibilidade1));
													conq.setVisible(true);
													dispose();
												} else {
													if (InformacaoGlobal.pontuacaoDinamica >= 1000
															&& InformacaoGlobal.pontuacaoDinamica < 2000
															&& InformacaoGlobal.pontuacaoEducativa < 1000) {
														Conquistas conq = new Conquistas(
																new Locale("en_US"),
																nomeDeUsuario);
														InformacaoGlobal.localeGlobal = "en_US";
														conq.foto
																.setIcon(new ImageIcon(
																		conq.imgPossibilidade2));
														conq.setVisible(true);
														dispose();
													}else{
														if(InformacaoGlobal.pontuacaoDinamica < 1000
															&& InformacaoGlobal.pontuacaoEducativa >= 1000
															&& InformacaoGlobal.pontuacaoEducativa < 2000){
															Conquistas conq = new Conquistas(
																	new Locale("en_US"),
																	nomeDeUsuario);
															InformacaoGlobal.localeGlobal = "en_US";
															conq.foto
																	.setIcon(new ImageIcon(
																			conq.imgPossibilidade3));
															conq.setVisible(true);
															dispose();
														}
														else{
															if(InformacaoGlobal.pontuacaoDinamica >= 1000
																	&& InformacaoGlobal.pontuacaoDinamica < 2000
																	&& InformacaoGlobal.pontuacaoEducativa >= 1000
																	&& InformacaoGlobal.pontuacaoEducativa < 2000){															
																Conquistas conq = new Conquistas(
																		new Locale("en_US"),
																		nomeDeUsuario);
																InformacaoGlobal.localeGlobal = "en_US";
																conq.foto
																		.setIcon(new ImageIcon(
																				conq.imgPossibilidade4));
																conq.setVisible(true);
																dispose();
															}else{
																if(InformacaoGlobal.pontuacaoDinamica >= 1000
																		&& InformacaoGlobal.pontuacaoDinamica < 2000
																		&& InformacaoGlobal.pontuacaoEducativa >= 2000
																		&& InformacaoGlobal.pontuacaoEducativa < 3000){
																	Conquistas conq = new Conquistas(
																			new Locale("en_US"),
																			nomeDeUsuario);
																	InformacaoGlobal.localeGlobal = "en_US";
																	conq.foto
																			.setIcon(new ImageIcon(
																					conq.imgPossibilidade5));
																	conq.setVisible(true);
																	dispose();
																}else{
																	if(InformacaoGlobal.pontuacaoDinamica >= 2000
																			&& InformacaoGlobal.pontuacaoDinamica < 3000
																			&& InformacaoGlobal.pontuacaoEducativa >= 1000
																			&& InformacaoGlobal.pontuacaoEducativa < 2000){
																		Conquistas conq = new Conquistas(
																				new Locale("en_US"),
																				nomeDeUsuario);
																		InformacaoGlobal.localeGlobal = "en_US";
																		conq.foto
																				.setIcon(new ImageIcon(
																						conq.imgPossibilidade6));
																		conq.setVisible(true);
																		dispose();
																	}else{
																		if(InformacaoGlobal.pontuacaoDinamica >= 2000
																				&& InformacaoGlobal.pontuacaoDinamica < 3000
																				&& InformacaoGlobal.pontuacaoEducativa >= 2000
																				&& InformacaoGlobal.pontuacaoEducativa < 3000){
																			Conquistas conq = new Conquistas(
																					new Locale("en_US"),
																					nomeDeUsuario);
																			InformacaoGlobal.localeGlobal = "en_US";
																			conq.foto
																					.setIcon(new ImageIcon(
																							conq.imgPossibilidade7));
																			conq.setVisible(true);
																			dispose();
																		}else{
																			if(InformacaoGlobal.pontuacaoDinamica >= 2000
																					&& InformacaoGlobal.pontuacaoDinamica < 3000
																					&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																				Conquistas conq = new Conquistas(
																						new Locale("en_US"),
																						nomeDeUsuario);
																				InformacaoGlobal.localeGlobal = "en_US";
																				conq.foto
																						.setIcon(new ImageIcon(
																								conq.imgPossibilidade8));
																				conq.setVisible(true);
																				dispose();
																			}else{
																				if(InformacaoGlobal.pontuacaoDinamica >= 3000
																						&& InformacaoGlobal.pontuacaoEducativa >= 2000
																						&& InformacaoGlobal.pontuacaoEducativa < 3000){
																					Conquistas conq = new Conquistas(
																							new Locale("en_US"),
																							nomeDeUsuario);
																					InformacaoGlobal.localeGlobal = "en_US";
																					conq.foto
																							.setIcon(new ImageIcon(
																									conq.imgPossibilidade9));
																					conq.setVisible(true);
																					dispose();
																				}else{
																					if(InformacaoGlobal.pontuacaoDinamica >= 3000
																							&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																						Conquistas conq = new Conquistas(
																								new Locale("en_US"),
																								nomeDeUsuario);
																						InformacaoGlobal.localeGlobal = "en_US";
																						conq.foto
																								.setIcon(new ImageIcon(
																										conq.imgPossibilidade10));
																						conq.setVisible(true);
																						dispose();
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											} else {
												if (InformacaoGlobal.pontuacaoDinamica < 1000
														&& InformacaoGlobal.pontuacaoEducativa < 1000) {
													Conquistas conq = new Conquistas(
															new Locale("ca_ES"),
															nomeDeUsuario);
													InformacaoGlobal.localeGlobal = "ca_ES";
													conq.foto
															.setIcon(new ImageIcon(
																	conq.imgPossibilidade1));
													conq.setVisible(true);
													dispose();
												} else {
													if (InformacaoGlobal.pontuacaoDinamica >= 1000
															&& InformacaoGlobal.pontuacaoDinamica < 2000
															&& InformacaoGlobal.pontuacaoEducativa < 1000) {
														Conquistas conq = new Conquistas(
																new Locale("ca_ES"),
																nomeDeUsuario);
														InformacaoGlobal.localeGlobal = "ca_ES";
														conq.foto
																.setIcon(new ImageIcon(
																		conq.imgPossibilidade2));
														conq.setVisible(true);
														dispose();
													}else{
														if(InformacaoGlobal.pontuacaoDinamica < 1000
															&& InformacaoGlobal.pontuacaoEducativa >= 1000
															&& InformacaoGlobal.pontuacaoEducativa < 2000){
															Conquistas conq = new Conquistas(
																	new Locale("ca_ES"),
																	nomeDeUsuario);
															InformacaoGlobal.localeGlobal = "ca_ES";
															conq.foto
																	.setIcon(new ImageIcon(
																			conq.imgPossibilidade3));
															conq.setVisible(true);
															dispose();
														}
														else{
															if(InformacaoGlobal.pontuacaoDinamica >= 1000
																	&& InformacaoGlobal.pontuacaoDinamica < 2000
																	&& InformacaoGlobal.pontuacaoEducativa >= 1000
																	&& InformacaoGlobal.pontuacaoEducativa < 2000){															
																Conquistas conq = new Conquistas(
																		new Locale("ca_ES"),
																		nomeDeUsuario);
																InformacaoGlobal.localeGlobal = "ca_ES";
																conq.foto
																		.setIcon(new ImageIcon(
																				conq.imgPossibilidade4));
																conq.setVisible(true);
																dispose();
															}else{
																if(InformacaoGlobal.pontuacaoDinamica >= 1000
																		&& InformacaoGlobal.pontuacaoDinamica < 2000
																		&& InformacaoGlobal.pontuacaoEducativa >= 2000
																		&& InformacaoGlobal.pontuacaoEducativa < 3000){
																	Conquistas conq = new Conquistas(
																			new Locale("ca_ES"),
																			nomeDeUsuario);
																	InformacaoGlobal.localeGlobal = "ca_ES";
																	conq.foto
																			.setIcon(new ImageIcon(
																					conq.imgPossibilidade5));
																	conq.setVisible(true);
																	dispose();
																}else{
																	if(InformacaoGlobal.pontuacaoDinamica >= 2000
																			&& InformacaoGlobal.pontuacaoDinamica < 3000
																			&& InformacaoGlobal.pontuacaoEducativa >= 1000
																			&& InformacaoGlobal.pontuacaoEducativa < 2000){
																		Conquistas conq = new Conquistas(
																				new Locale("ca_ES"),
																				nomeDeUsuario);
																		InformacaoGlobal.localeGlobal = "ca_ES";
																		conq.foto
																				.setIcon(new ImageIcon(
																						conq.imgPossibilidade6));
																		conq.setVisible(true);
																		dispose();
																	}else{
																		if(InformacaoGlobal.pontuacaoDinamica >= 2000
																				&& InformacaoGlobal.pontuacaoDinamica < 3000
																				&& InformacaoGlobal.pontuacaoEducativa >= 2000
																				&& InformacaoGlobal.pontuacaoEducativa < 3000){
																			Conquistas conq = new Conquistas(
																					new Locale("ca_ES"),
																					nomeDeUsuario);
																			InformacaoGlobal.localeGlobal = "ca_ES";
																			conq.foto
																					.setIcon(new ImageIcon(
																							conq.imgPossibilidade7));
																			conq.setVisible(true);
																			dispose();
																		}else{
																			if(InformacaoGlobal.pontuacaoDinamica >= 2000
																					&& InformacaoGlobal.pontuacaoDinamica < 3000
																					&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																				Conquistas conq = new Conquistas(
																						new Locale("ca_ES"),
																						nomeDeUsuario);
																				InformacaoGlobal.localeGlobal = "ca_ES";
																				conq.foto
																						.setIcon(new ImageIcon(
																								conq.imgPossibilidade8));
																				conq.setVisible(true);
																				dispose();
																			}else{
																				if(InformacaoGlobal.pontuacaoDinamica >= 3000
																						&& InformacaoGlobal.pontuacaoEducativa >= 2000
																						&& InformacaoGlobal.pontuacaoEducativa < 3000){
																					Conquistas conq = new Conquistas(
																							new Locale("ca_ES"),
																							nomeDeUsuario);
																					InformacaoGlobal.localeGlobal = "ca_ES";
																					conq.foto
																							.setIcon(new ImageIcon(
																									conq.imgPossibilidade9));
																					conq.setVisible(true);
																					dispose();
																				}else{
																					if(InformacaoGlobal.pontuacaoDinamica >= 3000
																							&& InformacaoGlobal.pontuacaoEducativa >= 3000){
																						Conquistas conq = new Conquistas(
																								new Locale("ca_ES"),
																								nomeDeUsuario);
																						InformacaoGlobal.localeGlobal = "ca_ES";
																						conq.foto
																								.setIcon(new ImageIcon(
																										conq.imgPossibilidade10));
																						conq.setVisible(true);
																						dispose();
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
