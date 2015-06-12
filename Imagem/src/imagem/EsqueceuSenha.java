package imagem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class EsqueceuSenha extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtNomeDeUsuario, txtResposta1, txtResposta2;
	JLabel lblNome, lblPergunta11, lblPergunta1, lblResposta, lblPergunta22,
			lblPergunta2, lblResposta_1,lblVoltar,lblVoltar2,lblOk,lblOk2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsqueceuSenha frame = new EsqueceuSenha(Locale.getDefault());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EsqueceuSenha(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1= ResourceBundle.getBundle("imagem.ResBundle");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		
		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 300);
		
		setTitle(bundle.getString("EsqueceuSenha.JFrame.text"));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNome = new JLabel(bundle.getString("EsqueceuSenha.lblNome.text"));
		lblNome.setBounds(12, 13, 56, 16);
		contentPane.add(lblNome);

		txtNomeDeUsuario = new JTextField();
		txtNomeDeUsuario.setBounds(101, 10, 116, 22);
		contentPane.add(txtNomeDeUsuario);
		txtNomeDeUsuario.setColumns(10);

		lblPergunta11 = new JLabel(bundle.getString("EsqueceuSenha.lblPergunta11.text"));
		lblPergunta11.setBounds(12, 54, 67, 16);
		contentPane.add(lblPergunta11);
		lblPergunta11.setVisible(false);

		lblPergunta1 = new JLabel("New label");
		lblPergunta1.setBounds(101, 54, 319, 16);
		contentPane.add(lblPergunta1);

		lblResposta = new JLabel(bundle.getString("EsqueceuSenha.lblResposta.text"));
		lblResposta.setBounds(12, 83, 67, 16);
		contentPane.add(lblResposta);
		lblResposta.setVisible(false);

		txtResposta1 = new JTextField();
		txtResposta1.setBounds(101, 80, 116, 22);
		contentPane.add(txtResposta1);
		txtResposta1.setColumns(10);
		txtResposta1.setVisible(false);

		lblPergunta22 = new JLabel(bundle.getString("EsqueceuSenha.lblPergunta22.text"));
		lblPergunta22.setBounds(12, 112, 67, 16);
		contentPane.add(lblPergunta22);
		lblPergunta22.setVisible(false);

		lblPergunta2 = new JLabel("New label");
		lblPergunta2.setBounds(101, 115, 319, 16);
		contentPane.add(lblPergunta2);
		lblPergunta1.setVisible(false);
		lblPergunta2.setVisible(false);

		lblResposta_1 = new JLabel(bundle.getString("EsqueceuSenha.lblResposta_1.text"));
		lblResposta_1.setBounds(12, 141, 67, 16);
		contentPane.add(lblResposta_1);
		lblResposta_1.setVisible(false);

		txtResposta2 = new JTextField();
		txtResposta2.setBounds(101, 138, 116, 22);
		contentPane.add(txtResposta2);
		txtResposta2.setColumns(10);
		txtResposta2.setVisible(false);
		
		lblVoltar = new JLabel();
		lblVoltar.setBounds(311, 13, 97, 25);
		lblVoltar.addMouseListener(this);
		lblVoltar.setIcon(new ImageIcon((Image)bundle1.getObject("EsqueceuSenha.lblVoltar.image")));
		contentPane.add(lblVoltar);
		
		lblOk = new JLabel(); 
		lblOk.setBounds(441, 13, 97, 25);
		lblOk.addMouseListener(this);
		lblOk.setIcon(new ImageIcon((Image)bundle1.getObject("EsqueceuSenha.lblOk.image")));
		contentPane.add(lblOk);
		
		lblVoltar2 = new JLabel(); 
		lblVoltar2.setBounds(311, 164, 97, 25);
		lblVoltar2.addMouseListener(this);
		lblVoltar2.setVisible(false);
		lblVoltar2.setIcon(new ImageIcon((Image)bundle1.getObject("EsqueceuSenha.lblVoltar.image")));
		contentPane.add(lblVoltar2);
		
		lblOk2 = new JLabel();
		lblOk2.setBounds(441, 164, 97, 25);
		lblOk2.addMouseListener(this);
		lblOk2.setVisible(false);
		lblOk2.setIcon(new ImageIcon((Image)bundle1.getObject("EsqueceuSenha.lblOk.image")));
		contentPane.add(lblOk2);
		
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblOk){
			if(txtNomeDeUsuario.getText().trim().equals("")){
				if(InformacaoGlobal.localeGlobal=="pt"){
				JOptionPane.showMessageDialog(null, "Campo não pode estar vazio");
				}else{
					if(InformacaoGlobal.localeGlobal=="ca_ES"){
						JOptionPane.showMessageDialog(null,
								"El campo no puede estar vacío");
					}else{
						JOptionPane.showMessageDialog(null,
								"Field can not be empty");
					}
				}
			}else{
				try {
					Conexao.FazConexao();
					Connection con = Conexao.connection;
					Statement st = con.createStatement();
					ResultSet res = st
							.executeQuery("select PerguntaSecreta1,PerguntaSecreta2 from usuario where NomeDeUsuario='"
									+ txtNomeDeUsuario.getText() + "'");
					if (res.next()) {
						lblPergunta1.setText(res.getString("PerguntaSecreta1"));
						lblPergunta2.setText(res.getString("PerguntaSecreta2"));
						txtNomeDeUsuario.setVisible(false);
						lblNome.setVisible(false);
						lblPergunta1.setVisible(true);
						lblPergunta2.setVisible(true);
						txtResposta1.setVisible(true);
						txtResposta2.setVisible(true);
						lblPergunta22.setVisible(true);
						lblPergunta22.setVisible(true);
						lblResposta.setVisible(true);
						lblResposta_1.setVisible(true);
						lblVoltar2.setVisible(true);
						lblOk2.setVisible(true);
						lblOk.setVisible(false);
						lblVoltar.setVisible(false);
					} else {
						if(InformacaoGlobal.localeGlobal=="pt"){
						JOptionPane.showMessageDialog(null, "Usuário Inexistente!");
						}else{
							if(InformacaoGlobal.localeGlobal=="ca_ES"){
								JOptionPane.showMessageDialog(null,
										"Usuario Nadie!");
							}else{
								JOptionPane.showMessageDialog(null,
										"User None!");
							}
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}	
		}else{
			if(e.getSource()==lblOk2){
				if(txtResposta1.getText().trim().equals("")||txtResposta2.getText().trim().equals("")){
					if(InformacaoGlobal.localeGlobal=="pt"){
					JOptionPane.showMessageDialog(null, "Campos não podem estar vazios");
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							JOptionPane.showMessageDialog(null,
									"Los campos no pueden estar vacíos");
						}else{
							JOptionPane.showMessageDialog(null,
									"Fields can not be empty");
						}
					}
				}else{
					try {
						Conexao.FazConexao();
						Connection con = Conexao.connection;
						Statement st = con.createStatement();
						ResultSet res = st
								.executeQuery("select senha from usuario where NomeDeUsuario='"
										+ txtNomeDeUsuario.getText()
										+ "' and PerguntaSecreta1='"
										+ lblPergunta1.getText()
										+ "' and RespostaPerguntaSecreta1='"
										+ txtResposta1.getText()
										+ "' and PerguntaSecreta2='"
										+ lblPergunta2.getText()
										+ "' and RespostaPerguntaSecreta2='"
										+ txtResposta2.getText() + "'");
						if (res.next()) {
							if(InformacaoGlobal.localeGlobal=="pt"){
							JOptionPane.showMessageDialog(null,
									"Sua senha é: " + res.getString("senha"));
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									JOptionPane.showMessageDialog(null,
											"Su contraseña: " + res.getString("senha"));
								}else{
									JOptionPane.showMessageDialog(null,
											"Your password is: "+ res.getString("senha"));
								}
							}
							Login login = new Login(new Locale(InformacaoGlobal.localeGlobal));
							login.setVisible(true);
							dispose();
						} else {
							if(InformacaoGlobal.localeGlobal=="pt"){
							JOptionPane.showMessageDialog(null, "Usuário Inexistente!");
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									JOptionPane.showMessageDialog(null,
											"Usuario Nadie!");
								}else{
									JOptionPane.showMessageDialog(null,
											"User None!");
								}
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}	
			}else{
				if(e.getSource()==lblVoltar){
					Login login = new Login(new Locale(InformacaoGlobal.localeGlobal));
					login.setVisible(true);
					dispose();
				}else{
					if(e.getSource()==lblVoltar2){
						txtNomeDeUsuario.setVisible(true);
						lblNome.setVisible(true);
						lblPergunta1.setVisible(false);
						lblPergunta2.setVisible(false);
						txtResposta1.setVisible(false);
						txtResposta2.setVisible(false);
						lblPergunta22.setVisible(false);
						lblPergunta22.setVisible(false);
						lblResposta.setVisible(false);
						lblResposta_1.setVisible(false);
						lblVoltar2.setVisible(false);
						lblOk2.setVisible(false);
						lblOk.setVisible(true);
						lblVoltar.setVisible(true);
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
