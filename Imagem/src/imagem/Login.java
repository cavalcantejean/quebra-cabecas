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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class Login extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JPasswordField txtSenha;
	String usuario = "";
	String tela = "";
	JLabel lblNome, lblSenha, lblLogar, lblLimpar, lblCancelar,
			lblEsqueceuSenha;

	ImageIcon imagemLogar, imagemLogar_en_US, imagemLogar_ca_ES, imagemLimpar,
			imagemLimpar_en_US, imagemLimpar_ca_ES, imagemCancelar,
			imagemCancelar_en_US, imagemEsqueceuSenha,
			imagemEsqueceuSenha_en_US, imagemEsqueceuSenha_ca_ES;

	Image imgLogar, imgLogar_en_US, imgLogar_ca_ES, imgLimpar, imgLimpar_en_US,
			imgLimpar_ca_ES, imgCancelar, imgCancelar_en_US, imgEsqueceuSenha,
			imgEsqueceuSenha_en_US, imgEsqueceuSenha_ca_ES;

	public static void main(String[] args) {
		Conexao.FazConexao();
		new Login(Locale.getDefault()).setVisible(true);
	}

	/**
	 * Create the frame.
	 * 
	 * @wbp.parser.constructor
	 */
	public Login(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel(bundle.getString("Login.lblNome.text"));
		lblNome.setBounds(95, 62, 46, 14);
		contentPane.add(lblNome);

		lblSenha = new JLabel(bundle.getString("Login.lblSenha.text"));
		lblSenha.setBounds(95, 87, 69, 14);
		contentPane.add(lblSenha);

		txtNome = new JTextField();
		txtNome.setBounds(174, 59, 109, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(174, 84, 109, 20);
		contentPane.add(txtSenha);

		lblLogar = new JLabel("");
		lblLogar.setBounds(95, 146, 69, 33);
		contentPane.add(lblLogar);

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(205, 146, 59, 33);
		contentPane.add(lblLimpar);

		lblCancelar = new JLabel("");
		lblCancelar.setBounds(95, 190, 69, 26);
		contentPane.add(lblCancelar);

		lblEsqueceuSenha = new JLabel("");
		lblEsqueceuSenha.setBounds(95, 227, 169, 33);
		contentPane.add(lblEsqueceuSenha);

		imagemCancelar = new ImageIcon(
				Login.class.getResource("PastaImagens/btnCancelar.jpg"));
		imagemCancelar_en_US = new ImageIcon(
				Login.class.getResource("PastaImagens/btnCancelar_en_US.jpg"));

		imagemEsqueceuSenha = new ImageIcon(
				Login.class.getResource("PastaImagens/btnEsqueceuSuaSenha.jpg"));
		imagemEsqueceuSenha_en_US = new ImageIcon(
				Login.class
						.getResource("PastaImagens/btnEsqueceuSuaSenha_en_US.jpg"));
		imagemEsqueceuSenha_ca_ES = new ImageIcon(
				Login.class
						.getResource("PastaImagens/btnEsqueceuSuaSenha_ca_ES.jpg"));

		imagemLimpar = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLimpar.jpg"));
		imagemLimpar_en_US = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLimpar_en_US.jpg"));
		imagemLimpar_ca_ES = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLimpar_ca_ES.jpg"));

		imagemLogar = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLogar.jpg"));
		imagemLogar_en_US = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLogar_en_US.jpg"));
		imagemLogar_ca_ES = new ImageIcon(
				Login.class.getResource("PastaImagens/btnLogar_ca_ES.jpg"));

		imgCancelar = imagemCancelar.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);
		imgCancelar_en_US = imagemCancelar_en_US.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);

		imgEsqueceuSenha = imagemEsqueceuSenha.getImage().getScaledInstance(
				lblEsqueceuSenha.getWidth(), lblEsqueceuSenha.getHeight(),
				Image.SCALE_DEFAULT);
		imgEsqueceuSenha_en_US = imagemEsqueceuSenha_en_US.getImage()
				.getScaledInstance(lblEsqueceuSenha.getWidth(),
						lblEsqueceuSenha.getHeight(), Image.SCALE_DEFAULT);
		imgEsqueceuSenha_ca_ES = imagemEsqueceuSenha_ca_ES.getImage()
				.getScaledInstance(lblEsqueceuSenha.getWidth(),
						lblEsqueceuSenha.getHeight(), Image.SCALE_DEFAULT);

		imgLimpar = imagemLimpar.getImage().getScaledInstance(
				lblLimpar.getWidth(), lblLimpar.getHeight(),
				Image.SCALE_DEFAULT);
		imgLimpar_en_US = imagemLimpar_en_US.getImage().getScaledInstance(
				lblLimpar.getWidth(), lblLimpar.getHeight(),
				Image.SCALE_DEFAULT);
		imgLimpar_ca_ES = imagemLimpar_ca_ES.getImage().getScaledInstance(
				lblLimpar.getWidth(), lblLimpar.getHeight(),
				Image.SCALE_DEFAULT);

		imgLogar = imagemLogar.getImage().getScaledInstance(
				lblLogar.getWidth(), lblLogar.getHeight(), Image.SCALE_DEFAULT);
		imgLogar_en_US = imagemLogar_en_US.getImage().getScaledInstance(
				lblLogar.getWidth(), lblLogar.getHeight(), Image.SCALE_DEFAULT);
		imgLogar_ca_ES = imagemLogar_ca_ES.getImage().getScaledInstance(
				lblLogar.getWidth(), lblLogar.getHeight(), Image.SCALE_DEFAULT);

		lblCancelar.setIcon(new ImageIcon(imgCancelar));
		lblEsqueceuSenha.setIcon(new ImageIcon(imgEsqueceuSenha));
		lblLimpar.setIcon(new ImageIcon(imgLimpar));
		lblLogar.setIcon(new ImageIcon(imgLogar));

		lblCancelar.addMouseListener(this);
		lblEsqueceuSenha.addMouseListener(this);
		lblLimpar.addMouseListener(this);
		lblLogar.addMouseListener(this);
	}

	Login(Locale locale, String tela) {
		this(locale);
		this.tela = tela;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCancelar) {
			try {
				TelaInicial tela = new TelaInicial(new Locale(
						InformacaoGlobal.localeGlobal));
				tela.setVisible(true);
				dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			if (e.getSource() == lblEsqueceuSenha) {
				if(InformacaoGlobal.localeGlobal=="pt"){
					EsqueceuSenha esqueceu = new EsqueceuSenha(new Locale("pt"));
					esqueceu.setVisible(true);
					dispose();
				}else{
					if(InformacaoGlobal.localeGlobal=="en_US"){
						EsqueceuSenha esqueceu = new EsqueceuSenha(new Locale("en","US"));
						esqueceu.setVisible(true);
						dispose();
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							EsqueceuSenha esqueceu = new EsqueceuSenha(new Locale("ca","ES"));
							esqueceu.setVisible(true);
							dispose();
						}
					}
				}
			} else {
				if (e.getSource() == lblLimpar) {
					txtNome.setText("");
					txtSenha.setText("");
				} else {
					if (e.getSource() == lblLogar) {
						Conexao.FazConexao();
						try {
							Connection con = Conexao.connection;
							Statement st = con.createStatement();
							@SuppressWarnings("deprecation")
							ResultSet res = st
									.executeQuery("select NomeDeUsuario, PontuacaoModoDinamico, PontuacaoModoEducativo from usuario where NomeDeUsuario='"
											+ txtNome.getText()
											+ "' and Senha='"
											+ txtSenha.getText() + "'");
							if (res.next()) {
								InformacaoGlobal.pontuacaoDinamica=res.getInt("PontuacaoModoDinamico");
								InformacaoGlobal.pontuacaoEducativa=res.getInt("PontuacaoModoEducativo");
								usuario = res.getString("NomeDeUsuario");
								TelaInicial tela = new TelaInicial(new Locale(
										InformacaoGlobal.localeGlobal), usuario);
								InformacaoGlobal.nomeDeUsuario = res
										.getString("NomeDeUsuario");
								tela.setVisible(true);
								dispose();
							} else {
								if (InformacaoGlobal.localeGlobal == "pt") {
									JOptionPane.showMessageDialog(null,
											"Nome ou Senha incorretos");
								} else {
									if (InformacaoGlobal.localeGlobal == "ca_ES") {
										JOptionPane
												.showMessageDialog(null,
														"Nombre o contraseña incorrecta");
									} else {
										JOptionPane.showMessageDialog(null,
												"Name or password incorrect");
									}
								}
								txtSenha.setText("");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
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
