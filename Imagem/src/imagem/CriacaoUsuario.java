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
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CriacaoUsuario extends JFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeDeUsuario;
	private JPasswordField txtSenha;
	private JPasswordField txtRepitaSenha;
	private JTextField txtRespostaPerguntaSecreta1;
	private JTextField txtRespostaPerguntaSecreta2;
	JComboBox<Object> cbxPerguntaSecreta1, cbxPerguntaSecreta2;
	JLabel lblSenha, lblNome, lblRepitaASenha, lblPerguntaSecreta,
			lblPerguntaSecreta_1, lblResposta, lblResposta_1;
	JLabel lblCadastrar;
	JLabel lblCancelar;
	ImageIcon imagemCadastrar, imagemCadastrar_en_US, imagemCancelar,
			imagemCancelar_en_US;
	Image imgCadastrar, imgCadastrar_en_US, imgCancelar, imgCancelar_en_US;

	public static void main(String[] args) {
		new CriacaoUsuario(new Locale(InformacaoGlobal.localeGlobal))
				.setVisible(true);
	}

	public CriacaoUsuario(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1 = ResourceBundle.getBundle("imagem.ResBundle");

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel(bundle.getString("CriacaoUsuario.lblNome.text"));
		lblNome.setBounds(12, 13, 162, 16);
		contentPane.add(lblNome);

		setTitle(bundle.getString("CriacaoUsuario.JFrame.text"));

		lblSenha = new JLabel(bundle.getString("CriacaoUsuario.lblSenha.text"));
		lblSenha.setBounds(12, 42, 162, 16);
		contentPane.add(lblSenha);

		lblRepitaASenha = new JLabel(
				bundle.getString("CriacaoUsuario.lblRepitaASenha.text"));
		lblRepitaASenha.setBounds(12, 72, 162, 16);
		contentPane.add(lblRepitaASenha);

		lblPerguntaSecreta = new JLabel(
				bundle.getString("CriacaoUsuario.lblPerguntaSecreta.text"));
		lblPerguntaSecreta.setBounds(12, 101, 162, 16);
		contentPane.add(lblPerguntaSecreta);

		lblPerguntaSecreta_1 = new JLabel(
				bundle.getString("CriacaoUsuario.lblPerguntaSecreta_1.text"));
		lblPerguntaSecreta_1.setBounds(12, 159, 162, 16);
		contentPane.add(lblPerguntaSecreta_1);

		lblResposta = new JLabel(
				bundle.getString("CriacaoUsuario.lblResposta.text"));
		lblResposta.setBounds(12, 130, 162, 16);
		contentPane.add(lblResposta);

		lblResposta_1 = new JLabel(
				bundle.getString("CriacaoUsuario.lblResposta_1.text"));
		lblResposta_1.setBounds(12, 188, 162, 16);
		contentPane.add(lblResposta_1);

		txtNomeDeUsuario = new JTextField();
		txtNomeDeUsuario.setBounds(184, 10, 116, 22);
		contentPane.add(txtNomeDeUsuario);
		txtNomeDeUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(185, 39, 115, 22);
		contentPane.add(txtSenha);

		txtRepitaSenha = new JPasswordField();
		txtRepitaSenha.setBounds(184, 69, 116, 22);
		contentPane.add(txtRepitaSenha);

		cbxPerguntaSecreta1 = new JComboBox<Object>();
		cbxPerguntaSecreta1.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "qual o nome da sua m\u00E3e?",
						"comida favorita", "lugar em que nasci",
						"meu melhor amigo \u00E9", "meu carro predileto",
						"praia que mais gosto", "novela que mais gosto",
						"filme favorito", "livro que mais li " }));
		cbxPerguntaSecreta1.setBounds(184, 98, 213, 22);
		contentPane.add(cbxPerguntaSecreta1);

		cbxPerguntaSecreta2 = new JComboBox<Object>();
		cbxPerguntaSecreta2.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "qual o nome da sua m\u00E3e?",
						"comida favorita", "lugar em que nasci",
						"meu melhor amigo \u00E9", "meu carro predileto",
						"praia que mais gosto", "novela que mais gosto",
						"filme favorito", "livro que mais li " }));
		cbxPerguntaSecreta2.setBounds(184, 156, 213, 22);
		contentPane.add(cbxPerguntaSecreta2);

		txtRespostaPerguntaSecreta1 = new JTextField();
		txtRespostaPerguntaSecreta1.setBounds(184, 127, 116, 22);
		contentPane.add(txtRespostaPerguntaSecreta1);
		txtRespostaPerguntaSecreta1.setColumns(10);

		txtRespostaPerguntaSecreta2 = new JTextField();
		txtRespostaPerguntaSecreta2.setBounds(184, 185, 116, 22);
		contentPane.add(txtRespostaPerguntaSecreta2);
		txtRespostaPerguntaSecreta2.setColumns(10);

		lblCadastrar = new JLabel("");
		lblCadastrar.setBounds(38, 282, 116, 25);
		contentPane.add(lblCadastrar);

		lblCancelar = new JLabel("");
		lblCancelar.setBounds(184, 282, 115, 25);
		contentPane.add(lblCancelar);

		imagemCadastrar = new ImageIcon(
				CriacaoUsuario.class
						.getResource("PastaImagens/btnCadastrar.jpg"));
		imagemCadastrar_en_US = new ImageIcon(
				CriacaoUsuario.class
						.getResource("PastaImagens/btnCadastrar_en_US.jpg"));

		imagemCancelar = new ImageIcon(
				CriacaoUsuario.class
						.getResource("PastaImagens/btnCancelar.jpg"));
		imagemCancelar_en_US = new ImageIcon(
				CriacaoUsuario.class
						.getResource("PastaImagens/btnCancelar_en_US.jpg"));

		imgCadastrar = imagemCadastrar.getImage().getScaledInstance(
				lblCadastrar.getWidth(), lblCadastrar.getHeight(),
				Image.SCALE_DEFAULT);
		imgCadastrar_en_US = imagemCadastrar_en_US.getImage()
				.getScaledInstance(lblCadastrar.getWidth(),
						lblCadastrar.getHeight(), Image.SCALE_DEFAULT);

		imgCancelar = imagemCancelar.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);
		imgCancelar_en_US = imagemCancelar_en_US.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);

		lblCadastrar.setIcon(new ImageIcon((Image) bundle1
				.getObject("CriacaoUsuario.lblCadastrar.image")));
		lblCancelar.setIcon(new ImageIcon((Image) bundle1
				.getObject("CriacaoUsuario.lblCancelar.image")));

		lblCadastrar.addMouseListener(this);
		lblCancelar.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblCadastrar) {
			if (txtNomeDeUsuario.getText().trim() == ""
					|| String.valueOf(txtSenha.getPassword()).trim().equals("")
					|| String.valueOf(txtRepitaSenha.getPassword()).trim()
							.equals("")
					|| cbxPerguntaSecreta1.getSelectedIndex() == 0
					|| txtRespostaPerguntaSecreta1.getText().trim() == ""
					|| cbxPerguntaSecreta2.getSelectedIndex() == 0
					|| txtRespostaPerguntaSecreta2.getText().trim() == "") {
				if (InformacaoGlobal.localeGlobal == "pt") {
					JOptionPane.showMessageDialog(null,
							"Todos os campos devem estar preenchidos");
				} else {
					if (InformacaoGlobal.localeGlobal == "ca_ES") {
						JOptionPane.showMessageDialog(null,
								"Todos los campos son obligatorios");
					} else {
						JOptionPane.showMessageDialog(null,
								"All fields must be filled");
					}
				}
			} else {
				if ((cbxPerguntaSecreta1.getSelectedIndex() == cbxPerguntaSecreta2
						.getSelectedIndex())
						|| (txtRespostaPerguntaSecreta1.getText() == txtRespostaPerguntaSecreta2
								.getText())) {
					if (InformacaoGlobal.localeGlobal == "pt") {
						JOptionPane.showMessageDialog(null,
								"Perguntas / Respostas Devem Ser Diferentes");
					} else {
						if (InformacaoGlobal.localeGlobal == "ca_ES") {
							JOptionPane
									.showMessageDialog(null,
											"Preguntas / Respuestas deben ser diferentes");
						} else {
							JOptionPane.showMessageDialog(null,
									"Questions / Answers Must Be Different");
						}
					}
				} else {
					if ((txtNomeDeUsuario.getText().length() < 5 || txtNomeDeUsuario
							.getText().length() > 15)
							|| (txtSenha.getPassword().length < 10 || txtSenha
									.getPassword().length > 20)) {
						if (InformacaoGlobal.localeGlobal == "pt") {
							JOptionPane
									.showMessageDialog(null,
											"Nome De Usuario deve ter de 5-15 caracteres\ne Senha de 10-20 caracteres");
						} else {
							if (InformacaoGlobal.localeGlobal == "ca_ES") {
								JOptionPane
										.showMessageDialog(
												null,
												"Nombre de usuario debe ser de 5-15 caracteres \ny contraseña de 10-20 caracteres");
							} else {
								JOptionPane
										.showMessageDialog(null,
												"In User Name must be 5-15 characters \nand Password 10-20 characters");
							}
						}
					} else {
						if (Arrays.equals(txtSenha.getPassword(),
								txtRepitaSenha.getPassword())) {
							try {
								Conexao.FazConexao();
								Connection con1 = Conexao.connection;
								Statement st1 = con1.createStatement();
								ResultSet res = st1
										.executeQuery("select * from usuario where NomeDeUsuario='"
												+ txtNomeDeUsuario.getText()
												+ "'");
								if (res.next()) {
									if (InformacaoGlobal.localeGlobal == "pt") {
										JOptionPane.showMessageDialog(null,
												"Usuário já existe");
									} else {
										if (InformacaoGlobal.localeGlobal == "ca_ES") {
											JOptionPane.showMessageDialog(null,
													"El usuario ya existe");
										} else {
											JOptionPane.showMessageDialog(null,
													"User already exists");
										}
									}
								} else {
									try {
										Connection con = Conexao.connection;
										Statement st = con.createStatement();
										st.executeUpdate("Insert into usuario values ('"
												+ txtNomeDeUsuario.getText()
												+ "','"
												+ String.valueOf(txtSenha
														.getPassword())
												+ "',now(),0,now(),0,'"
												+ cbxPerguntaSecreta1
														.getSelectedItem()
												+ "','"
												+ txtRespostaPerguntaSecreta1
														.getText()
												+ "','"
												+ cbxPerguntaSecreta2
														.getSelectedItem()
												+ "','"
												+ txtRespostaPerguntaSecreta2
														.getText() + "')");
										txtNomeDeUsuario.setText("");
										txtSenha.setText("");
										txtRepitaSenha.setText("");
										cbxPerguntaSecreta1.setSelectedIndex(0);
										txtRespostaPerguntaSecreta1.setText("");
										cbxPerguntaSecreta2.setSelectedIndex(0);
										txtRespostaPerguntaSecreta2.setText("");
										if (InformacaoGlobal.localeGlobal == "pt") {
											JOptionPane
													.showMessageDialog(null,
															"Usuário cadastrado com sucesso");
										} else {
											if (InformacaoGlobal.localeGlobal == "ca_ES") {
												JOptionPane
														.showMessageDialog(
																null,
																"Usuario registrado correctamente");
											} else {
												JOptionPane
														.showMessageDialog(
																null,
																"User registered successfully");
											}
										}
										TelaInicial tela = new TelaInicial(
												new Locale(
														InformacaoGlobal.localeGlobal));
										tela.setVisible(true);
										dispose();
									} catch (SQLException | IOException e1) {
										e1.printStackTrace();
									}

								}
							} catch (SQLException e2) {
								e2.printStackTrace();
							}

						} else {
							if (InformacaoGlobal.localeGlobal == "pt") {
								JOptionPane.showMessageDialog(null,
										"Senhas Devem ser iguais");
							} else {
								if (InformacaoGlobal.localeGlobal == "ca_ES") {
									JOptionPane
											.showMessageDialog(null,
													"Las contraseñas deben ser iguales");
								} else {
									JOptionPane.showMessageDialog(null,
											"Passwords must be equal");
								}
							}
						}
					}
				}
			}
		} else {
			if (e.getSource() == lblCancelar) {
				if (InformacaoGlobal.localeGlobal == "pt") {
					try {
						TelaInicial tela = new TelaInicial(new Locale("pt"));
						tela.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					if(InformacaoGlobal.localeGlobal=="ca_ES"){
						try {
							TelaInicial tela = new TelaInicial(new Locale("ca","ES"));
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}else{
						if(InformacaoGlobal.localeGlobal=="en_US"){
							try {
								TelaInicial tela = new TelaInicial(new Locale("en","US"));
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
