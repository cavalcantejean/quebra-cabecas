package imagem;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javax.swing.border.EmptyBorder;

public class Ranking extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static int linha = 0;
	ImageIcon imagemAnterior, imagemAnterior_en_US, imagemProximo,
			imagemProximo_en_US, imagemProximo_ca_ES, imagemMenu;
	Image imgAnterior, imgAnterior_en_US, imgProximo, imgProximo_en_US,
			imgProximo_ca_ES, imgMenu;
	JLabel lblNome, lblNome_1, lblNome_2, lblNome_3, lblNome_4, lblNome_5,
			lblPontuacaonome, lblPontuacaonome_1, lblPontuacaonome_2,
			lblPontuacaonome_3, lblPontuacaonome_4, lblNome_6, lblNome_7,
			lblNome_8, lblNome_9, lblPontuacao, lblPontuacao_1, lblPontuacao_2,
			lblPontuacao_3, lblPontuacao_4, lblDinamico, lblEducativo,
			lblLinha,lblProximo,lblMenu,lblAnterior;
	private JLabel lblPosicao_1;
	private JLabel lblPosicao_2;
	private JLabel lblPosicao_3;
	private JLabel lblPosicao_4;
	private JLabel lblPosicao_5;
	private JLabel lblPosicao_6;
	private JLabel lblPosicao_7;
	private JLabel lblPosicao_8;
	private JLabel lblPosicao_9;
	private JLabel lblPosicao_10;
	String nomeDeUsuario = "";
	private JLabel lblSeuNome;
	private JLabel lblNomeJogador;
	private JLabel lblPontuacaoModoDinmico;
	private JLabel lblPontuacaoJogadorModoDinamico;
	private JLabel lblPontuacaoModoEducativo;
	private JLabel lblPontuacaoJogodorModoEducativo;

	public static void main(String[] args) {
		Conexao.FazConexao();
		new Ranking(Locale.getDefault()).setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 */
	public Ranking(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setTitle(bundle.getString("Ranking.this.title"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel("");
		lblNome.setBounds(48, 45, 46, 14);
		contentPane.add(lblNome);
		lblNome.setVisible(false);

		lblNome_1 = new JLabel("");
		lblNome_1.setBounds(48, 70, 46, 14);
		contentPane.add(lblNome_1);
		lblNome_1.setVisible(false);

		lblPontuacaonome = new JLabel("");
		lblPontuacaonome.setBounds(128, 45, 104, 14);
		contentPane.add(lblPontuacaonome);
		lblPontuacaonome.setVisible(false);

		lblPontuacaonome_1 = new JLabel("");
		lblPontuacaonome_1.setBounds(128, 70, 104, 14);
		contentPane.add(lblPontuacaonome_1);
		lblPontuacaonome_1.setVisible(false);

		lblNome_2 = new JLabel("");
		lblNome_2.setBounds(48, 95, 46, 14);
		contentPane.add(lblNome_2);
		lblNome_2.setVisible(false);

		lblNome_3 = new JLabel("");
		lblNome_3.setBounds(48, 120, 46, 14);
		contentPane.add(lblNome_3);
		lblNome_3.setVisible(false);

		lblNome_4 = new JLabel("");
		lblNome_4.setBounds(48, 145, 46, 14);
		contentPane.add(lblNome_4);
		lblNome_4.setVisible(false);

		lblPontuacaonome_2 = new JLabel("");
		lblPontuacaonome_2.setBounds(128, 95, 104, 14);
		contentPane.add(lblPontuacaonome_2);
		lblPontuacaonome_2.setVisible(false);

		lblPontuacaonome_3 = new JLabel("");
		lblPontuacaonome_3.setBounds(128, 120, 104, 14);
		contentPane.add(lblPontuacaonome_3);
		lblPontuacaonome_3.setVisible(false);

		lblPontuacaonome_4 = new JLabel("");
		lblPontuacaonome_4.setBounds(128, 145, 104, 14);
		contentPane.add(lblPontuacaonome_4);
		lblPontuacaonome_4.setVisible(false);

		lblNome_5 = new JLabel("");
		lblNome_5.setBounds(268, 45, 46, 14);
		contentPane.add(lblNome_5);
		lblNome_5.setVisible(false);

		lblNome_6 = new JLabel("");
		lblNome_6.setBounds(268, 70, 46, 14);
		contentPane.add(lblNome_6);
		lblNome_6.setVisible(false);

		lblNome_7 = new JLabel("");
		lblNome_7.setBounds(268, 95, 46, 14);
		contentPane.add(lblNome_7);
		lblNome_7.setVisible(false);

		lblNome_8 = new JLabel("");
		lblNome_8.setBounds(268, 120, 46, 14);
		contentPane.add(lblNome_8);
		lblNome_8.setVisible(false);

		lblNome_9 = new JLabel("");
		lblNome_9.setBounds(268, 145, 46, 14);
		contentPane.add(lblNome_9);
		lblNome_9.setVisible(false);

		lblPontuacao = new JLabel("");
		lblPontuacao.setBounds(342, 45, 104, 14);
		contentPane.add(lblPontuacao);
		lblPontuacao.setVisible(false);

		lblPontuacao_1 = new JLabel("");
		lblPontuacao_1.setBounds(342, 70, 104, 14);
		contentPane.add(lblPontuacao_1);
		lblPontuacao_1.setVisible(false);

		lblPontuacao_2 = new JLabel("");
		lblPontuacao_2.setBounds(342, 95, 104, 14);
		contentPane.add(lblPontuacao_2);
		lblPontuacao_2.setVisible(false);

		lblPontuacao_3 = new JLabel("");
		lblPontuacao_3.setBounds(342, 120, 104, 14);
		contentPane.add(lblPontuacao_3);
		lblPontuacao_3.setVisible(false);

		lblPontuacao_4 = new JLabel("");
		lblPontuacao_4.setBounds(342, 145, 104, 14);
		contentPane.add(lblPontuacao_4);
		lblPontuacao_4.setVisible(false);

		lblDinamico = new JLabel(bundle.getString("Ranking.lblDinamico.text"));
		lblDinamico.setBounds(48, 11, 61, 14);
		contentPane.add(lblDinamico);
		
		lblAnterior = new JLabel("");
		lblAnterior.setBounds(36, 223, 89, 28);
		contentPane.add(lblAnterior);

		lblEducativo = new JLabel(bundle.getString("Ranking.lblEducativo.text"));
		lblEducativo.setBounds(268, 11, 61, 14);
		contentPane.add(lblEducativo);
		if (linha == 0) {
			lblAnterior.setVisible(false);
		}

		lblLinha = new JLabel("");
		lblLinha.setBounds(557, 45, 46, 14);
		contentPane.add(lblLinha);

		lblPosicao_1 = new JLabel("");
		lblPosicao_1.setBounds(10, 45, 46, 14);
		contentPane.add(lblPosicao_1);
		lblPosicao_1.setText(Integer.toString(linha + 1) + "º");

		lblPosicao_2 = new JLabel("");
		lblPosicao_2.setBounds(10, 70, 46, 14);
		contentPane.add(lblPosicao_2);
		lblPosicao_2.setText(Integer.toString(linha + 2) + "º");

		lblPosicao_3 = new JLabel("");
		lblPosicao_3.setBounds(10, 95, 46, 14);
		contentPane.add(lblPosicao_3);
		lblPosicao_3.setText(Integer.toString(linha + 3) + "º");

		lblPosicao_4 = new JLabel("");
		lblPosicao_4.setBounds(10, 120, 46, 14);
		contentPane.add(lblPosicao_4);
		lblPosicao_4.setText(Integer.toString(linha + 4) + "º");

		lblPosicao_5 = new JLabel("");
		lblPosicao_5.setBounds(10, 145, 46, 14);
		contentPane.add(lblPosicao_5);
		lblPosicao_5.setText(Integer.toString(linha + 5) + "º");

		lblPosicao_6 = new JLabel("");
		lblPosicao_6.setBounds(223, 45, 46, 14);
		contentPane.add(lblPosicao_6);
		lblPosicao_6.setText(Integer.toString(linha + 1) + "º");

		lblPosicao_7 = new JLabel("");
		lblPosicao_7.setBounds(223, 70, 46, 14);
		contentPane.add(lblPosicao_7);
		lblPosicao_7.setText(Integer.toString(linha + 2) + "º");

		lblPosicao_8 = new JLabel("");
		lblPosicao_8.setBounds(223, 95, 46, 14);
		contentPane.add(lblPosicao_8);
		lblPosicao_8.setText(Integer.toString(linha + 3) + "º");

		lblPosicao_9 = new JLabel("");
		lblPosicao_9.setBounds(223, 120, 46, 14);
		contentPane.add(lblPosicao_9);
		lblPosicao_9.setText(Integer.toString(linha + 4) + "º");

		lblPosicao_10 = new JLabel("");
		lblPosicao_10.setBounds(223, 145, 46, 14);
		contentPane.add(lblPosicao_10);
		lblPosicao_10.setText(Integer.toString(linha + 5) + "º");

		lblSeuNome = new JLabel(bundle.getString("Ranking.lblSeuNome.text")); //$NON-NLS-1$
		lblSeuNome.setBounds(479, 82, 205, 14);
		contentPane.add(lblSeuNome);
		lblSeuNome.setVisible(false);

		lblNomeJogador = new JLabel(""); //$NON-NLS-1$
		lblNomeJogador.setBounds(479, 105, 151, 14);
		contentPane.add(lblNomeJogador);
		lblNomeJogador.setVisible(false);

		lblPontuacaoModoDinmico = new JLabel(
				bundle.getString("Ranking.lblPontuacaoModoDinmico.text")); //$NON-NLS-1$
		lblPontuacaoModoDinmico.setBounds(479, 130, 205, 14);
		contentPane.add(lblPontuacaoModoDinmico);
		lblPontuacaoModoDinmico.setVisible(false);

		lblPontuacaoJogadorModoDinamico = new JLabel(""); //$NON-NLS-1$
		lblPontuacaoJogadorModoDinamico.setBounds(479, 155, 151, 14);
		contentPane.add(lblPontuacaoJogadorModoDinamico);
		lblPontuacaoJogadorModoDinamico.setVisible(false);

		lblPontuacaoModoEducativo = new JLabel(
				bundle.getString("Ranking.lblPontuacaoModoEducativo.text")); //$NON-NLS-1$
		lblPontuacaoModoEducativo.setBounds(479, 177, 205, 14);
		contentPane.add(lblPontuacaoModoEducativo);
		lblPontuacaoModoEducativo.setVisible(false);

		lblPontuacaoJogodorModoEducativo = new JLabel(""); //$NON-NLS-1$
		lblPontuacaoJogodorModoEducativo.setBounds(479, 202, 151, 14);
		contentPane.add(lblPontuacaoJogodorModoEducativo);
		
		
		
		lblMenu = new JLabel(""); 
		lblMenu.setBounds(186, 223, 94, 28);
		contentPane.add(lblMenu);
		
		lblProximo = new JLabel(""); 
		lblProximo.setBounds(341, 223, 104, 28);
		contentPane.add(lblProximo);
		lblPontuacaoJogodorModoEducativo.setVisible(false);

		Connection con = Conexao.connection;
		Connection con1 = Conexao.connection;
		Connection con2 = Conexao.connection;
		Connection con3 = Conexao.connection;
		Connection con4 = Conexao.connection;
		Connection con5 = Conexao.connection;
		Connection con6 = Conexao.connection;
		Connection con7 = Conexao.connection;
		Connection con8 = Conexao.connection;
		Connection con9 = Conexao.connection;
		// Connection con10 = connection;
		Connection con11 = Conexao.connection;

		try {
			Conexao.FazConexao();
			Statement st = con.createStatement();
			Statement st1 = con1.createStatement();
			Statement st2 = con2.createStatement();
			Statement st3 = con3.createStatement();
			Statement st4 = con4.createStatement();
			Statement st5 = con5.createStatement();
			Statement st6 = con6.createStatement();
			Statement st7 = con7.createStatement();
			Statement st8 = con8.createStatement();
			Statement st9 = con9.createStatement();
			// Statement st10 = con10.createStatement();
			Statement st11 = con11.createStatement();

			ResultSet res = st
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoDinamico FROM usuario order by PontuacaoModoDinamico desc, DataHoraPontuacaoModoDinamico desc limit "
							+ linha + ",1");
			ResultSet res1 = st1
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoDinamico FROM usuario order by PontuacaoModoDinamico desc, DataHoraPontuacaoModoDinamico desc limit "
							+ (linha + 1) + ",1");
			ResultSet res2 = st2
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoDinamico FROM usuario order by PontuacaoModoDinamico desc, DataHoraPontuacaoModoDinamico desc limit "
							+ (linha + 2) + ",1");
			ResultSet res3 = st3
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoDinamico FROM usuario order by PontuacaoModoDinamico desc, DataHoraPontuacaoModoDinamico desc limit "
							+ (linha + 3) + ",1");
			ResultSet res4 = st4
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoDinamico FROM usuario order by PontuacaoModoDinamico desc, DataHoraPontuacaoModoDinamico desc limit "
							+ (linha + 4) + ",1");

			ResultSet res5 = st5
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoEducativo FROM usuario order by PontuacaoModoEducativo desc, DataHoraPontuacaoModoEducativo desc limit "
							+ linha + ",1");
			ResultSet res6 = st6
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoEducativo FROM usuario order by PontuacaoModoEducativo desc, DataHoraPontuacaoModoEducativo desc limit "
							+ (linha + 1) + ",1");
			ResultSet res7 = st7
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoEducativo FROM usuario order by PontuacaoModoEducativo desc, DataHoraPontuacaoModoEducativo desc limit "
							+ (linha + 2) + ",1");
			ResultSet res8 = st8
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoEducativo FROM usuario order by PontuacaoModoEducativo desc, DataHoraPontuacaoModoEducativo desc limit "
							+ (linha + 3) + ",1");
			ResultSet res9 = st9
					.executeQuery("SELECT NomeDeUsuario, PontuacaoModoEducativo FROM usuario order by PontuacaoModoEducativo desc, DataHoraPontuacaoModoEducativo desc limit "
							+ (linha + 4) + ",1");

			// ResultSet res10 = st10
			// .executeQuery("Select NomeDeUsuario, PontuacaoModoDinamico, PontuacaoModoEducativo FROM usuario where NomeDeUsuario = 'maria'");

			ResultSet res11 = st11
					.executeQuery("select count(*) as total from usuario");

			if (res.next()) {
				lblNome.setText(res.getString("NomeDeUsuario"));
				lblPontuacaonome
						.setText(res.getString("PontuacaoModoDinamico"));
				lblNome.setVisible(true);
				lblPontuacaonome.setVisible(true);
			}

			if (res1.next()) {

				lblNome_1.setText(res1.getString("NomeDeUsuario"));
				lblPontuacaonome_1.setText(res1
						.getString("PontuacaoModoDinamico"));
				lblNome_1.setVisible(true);
				lblPontuacaonome_1.setVisible(true);
			}

			if (res2.next()) {

				lblNome_2.setText(res2.getString("NomeDeUsuario"));
				lblPontuacaonome_2.setText(res2
						.getString("PontuacaoModoDinamico"));
				lblNome_2.setVisible(true);
				lblPontuacaonome_2.setVisible(true);
			}

			if (res3.next()) {

				lblNome_3.setText(res3.getString("NomeDeUsuario"));
				lblPontuacaonome_3.setText(res3
						.getString("PontuacaoModoDinamico"));
				lblNome_3.setVisible(true);
				lblPontuacaonome_3.setVisible(true);
			}

			if (res4.next()) {

				lblNome_4.setText(res4.getString("NomeDeUsuario"));
				lblPontuacaonome_4.setText(res4
						.getString("PontuacaoModoDinamico"));
				lblNome_4.setVisible(true);
				lblPontuacaonome_4.setVisible(true);
			}

			if (res5.next()) {

				lblNome_5.setText(res5.getString("NomeDeUsuario"));
				lblPontuacao.setText(res5.getString("PontuacaoModoEducativo"));
				lblNome_5.setVisible(true);
				lblPontuacao.setVisible(true);
			}

			if (res6.next()) {

				lblNome_6.setText(res6.getString("NomeDeUsuario"));
				lblPontuacao_1
						.setText(res6.getString("PontuacaoModoEducativo"));
				lblNome_6.setVisible(true);
				lblPontuacao_1.setVisible(true);
			}

			if (res7.next()) {

				lblNome_7.setText(res7.getString("NomeDeUsuario"));
				lblPontuacao_2
						.setText(res7.getString("PontuacaoModoEducativo"));
				lblNome_7.setVisible(true);
				lblPontuacao_2.setVisible(true);
			}

			if (res8.next()) {

				lblNome_8.setText(res8.getString("NomeDeUsuario"));
				lblPontuacao_3
						.setText(res8.getString("PontuacaoModoEducativo"));
				lblNome_8.setVisible(true);
				lblPontuacao_3.setVisible(true);
			}

			if (res9.next()) {

				lblNome_9.setText(res9.getString("NomeDeUsuario"));
				lblPontuacao_4
						.setText(res9.getString("PontuacaoModoEducativo"));
				lblNome_9.setVisible(true);
				lblPontuacao_4.setVisible(true);
			}

			/*
			 * if (res10.next()) { lblPosicao.setText("Seu nome é " +
			 * res10.getString("NomeDeUsuario") + " tem " +
			 * res10.getString("PontuacaoModoDinamico") +
			 * " pontos no Modo Dinâmico e " +
			 * res10.getString("PontuacaoModoEducativo") +
			 * " no modo Educativo"); }
			 */

			if (res11.next()) {
				lblLinha.setText(res11.getString("total"));
			}

			int iLinha = Integer.parseInt(lblLinha.getText());
			if (iLinha > (linha + 5)) {
				lblProximo.setVisible(true);
			} else {
				lblProximo.setVisible(false);
			}

			if (lblNome.getText() == "") {
				lblPosicao_1.setVisible(false);
				lblPosicao_6.setVisible(false);
			}

			if (lblNome_1.getText() == "") {
				lblPosicao_2.setVisible(false);
				lblPosicao_7.setVisible(false);
			}

			if (lblNome_2.getText() == "") {
				lblPosicao_3.setVisible(false);
				lblPosicao_8.setVisible(false);
			}

			if (lblNome_3.getText() == "") {
				lblPosicao_4.setVisible(false);
				lblPosicao_9.setVisible(false);
			}

			if (lblNome_4.getText() == "") {
				lblPosicao_5.setVisible(false);
				lblPosicao_10.setVisible(false);
			}
		} catch (SQLException sqlex) {
			System.out.println("erro sql " + sqlex);
			sqlex.printStackTrace();
		}
		
		imagemAnterior=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnAnterior.jpg"));
		imagemAnterior_en_US=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnAnterior_en_US.jpg"));
		
		imagemMenu=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnMenu.jpg"));
		
		imagemProximo=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnProximo.jpg"));
		imagemProximo_en_US=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnProximo_en_US.jpg"));
		imagemProximo_ca_ES=new ImageIcon(
				Ranking.class.getResource("PastaImagens/btnProximo_ca_ES.jpg"));
		
		imgAnterior=imagemAnterior.getImage().getScaledInstance(
				lblAnterior.getWidth(), lblAnterior.getHeight(),
				Image.SCALE_DEFAULT);
		imgAnterior_en_US=imagemAnterior_en_US.getImage().getScaledInstance(
				lblAnterior.getWidth(), lblAnterior.getHeight(),
				Image.SCALE_DEFAULT);
		
		imgMenu=imagemMenu.getImage().getScaledInstance(
				lblMenu.getWidth(), lblMenu.getHeight(),
				Image.SCALE_DEFAULT);
		
		imgProximo=imagemProximo.getImage().getScaledInstance(
				lblProximo.getWidth(), lblProximo.getHeight(),
				Image.SCALE_DEFAULT);
		imgProximo_en_US=imagemProximo_en_US.getImage().getScaledInstance(
				lblProximo.getWidth(), lblProximo.getHeight(),
				Image.SCALE_DEFAULT);
		imgProximo_ca_ES=imagemProximo_ca_ES.getImage().getScaledInstance(
				lblProximo.getWidth(), lblProximo.getHeight(),
				Image.SCALE_DEFAULT);
		
		lblAnterior.setIcon(new ImageIcon(imgAnterior));
		lblMenu.setIcon(new ImageIcon(imgMenu));
		lblProximo.setIcon(new ImageIcon(imgProximo));
		
		lblAnterior.addMouseListener(this);
		lblMenu.addMouseListener(this);
		lblProximo.addMouseListener(this);
	}

	Ranking(Locale locale, String nome) {
		this(locale);
		this.nomeDeUsuario = nome;

		lblSeuNome.setVisible(true);
		lblNomeJogador.setVisible(true);
		lblPontuacaoModoDinmico.setVisible(true);
		lblPontuacaoJogadorModoDinamico.setVisible(true);
		lblPontuacaoModoEducativo.setVisible(true);
		lblPontuacaoJogodorModoEducativo.setVisible(true);

		try {
			Connection con10 = Conexao.connection;
			Statement st10 = con10.createStatement();
			ResultSet res10 = st10
					.executeQuery("Select NomeDeUsuario, PontuacaoModoDinamico, PontuacaoModoEducativo FROM usuario where NomeDeUsuario = '"
							+ nomeDeUsuario + "'");
			if (res10.next()) {
				lblNomeJogador.setText(res10.getString("NomeDeUsuario"));
				lblPontuacaoJogadorModoDinamico.setText(res10
						.getString("PontuacaoModoDinamico"));
				lblPontuacaoJogodorModoEducativo.setText(res10
						.getString("PontuacaoModoEducativo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblAnterior){
			if (nomeDeUsuario == "") {
				linha -= 5;
				new Ranking(new Locale(InformacaoGlobal.localeGlobal))
						.setVisible(true);
				dispose();
			} else {
				linha -= 5;
				new Ranking(new Locale(InformacaoGlobal.localeGlobal),
						nomeDeUsuario).setVisible(true);
				dispose();
			}
		}else{
			if(e.getSource()==lblProximo){
				int iLinha = Integer.parseInt(lblLinha.getText());
				if (nomeDeUsuario == "") {
					if (iLinha > (linha + 5)) {
						linha += 5;
						new Ranking(new Locale(InformacaoGlobal.localeGlobal))
								.setVisible(true);
						dispose();
					} else {
						lblProximo.setVisible(false);
					}
				} else {
					if (iLinha > (linha + 5)) {
						linha += 5;
						new Ranking(new Locale(InformacaoGlobal.localeGlobal),
								nomeDeUsuario).setVisible(true);
						dispose();
					} else {
						lblProximo.setVisible(false);
					}
				}
			}else{
				if(e.getSource()==lblMenu){
					if (nomeDeUsuario == "") {
						try {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal));
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						try {
							TelaInicial tela = new TelaInicial(new Locale(
									InformacaoGlobal.localeGlobal),
									nomeDeUsuario);
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
