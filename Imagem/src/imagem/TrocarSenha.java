package imagem;

import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JPasswordField;
import javax.swing.JRootPane;

public class TrocarSenha extends JFrame implements MouseListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String nomeDeUsuario;
	private JPasswordField txtSenhaAntiga;
	private JPasswordField txtNovaSenha;
	private JPasswordField txtRepitaSenhaNovamente;
	JLabel lblRepitaNovamente,lblAntigaSenha,lblNovaSenha;
	 JLabel lblOk;
	 JLabel lblCancelar;
	 ImageIcon imagemCancelar,imagemCancelar_en_US,imagemOk;
	 Image imgCancelar,imgCancelar_en_US,imgOk;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrocarSenha frame = new TrocarSenha(Locale.getDefault(),"");
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
	public TrocarSenha(Locale locale,String nomeDeUsuario) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		
		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		setTitle(bundle.getString("TrocarSenha.this.title")); //$NON-NLS-1$
		
		this.nomeDeUsuario=nomeDeUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAntigaSenha = new JLabel(bundle.getString("TrocarSenha.lblAntigaSenha.text"));
		lblAntigaSenha.setBounds(24, 13, 110, 16);
		contentPane.add(lblAntigaSenha);
		
		lblNovaSenha = new JLabel(bundle.getString("TrocarSenha.lblNovaSenha.text"));
		lblNovaSenha.setBounds(24, 42, 110, 16);
		contentPane.add(lblNovaSenha);
		
		lblRepitaNovamente = new JLabel(bundle.getString("TrocarSenha.lblRepitaNovamente.text"));
		lblRepitaNovamente.setBounds(24, 71, 110, 16);
		contentPane.add(lblRepitaNovamente);
		
		txtSenhaAntiga = new JPasswordField();
		txtSenhaAntiga.setBounds(163, 10, 101, 22);
		contentPane.add(txtSenhaAntiga);
		
		txtNovaSenha = new JPasswordField();
		txtNovaSenha.setBounds(163, 39, 101, 22);
		contentPane.add(txtNovaSenha);
		
		txtRepitaSenhaNovamente = new JPasswordField();
		txtRepitaSenhaNovamente.setBounds(163, 68, 101, 22);
		contentPane.add(txtRepitaSenhaNovamente);
		
		lblOk = new JLabel(""); 
		lblOk.setBounds(24, 173, 86, 25);
		contentPane.add(lblOk);
		
		lblCancelar = new JLabel(""); 
		lblCancelar.setBounds(167, 173, 97, 25);
		contentPane.add(lblCancelar);
		
		imagemCancelar=new ImageIcon(
				TrocarSenha.class.getResource("PastaImagens/btnCancelar.jpg"));
		imagemCancelar_en_US=new ImageIcon(
				TrocarSenha.class.getResource("PastaImagens/btnCancelar_en_US.jpg"));
		
		imagemOk=new ImageIcon(
				TrocarSenha.class.getResource("PastaImagens/btnOk.jpg"));
		
		imgCancelar=imagemCancelar.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);
		imgCancelar_en_US=imagemCancelar_en_US.getImage().getScaledInstance(
				lblCancelar.getWidth(), lblCancelar.getHeight(),
				Image.SCALE_DEFAULT);
		
		imgOk=imagemOk.getImage().getScaledInstance(
				lblOk.getWidth(), lblOk.getHeight(),
				Image.SCALE_DEFAULT);
		
		lblCancelar.setIcon(new ImageIcon(imgCancelar));
		lblOk.setIcon(new ImageIcon(imgOk));
		
		lblCancelar.addMouseListener(this);
		lblOk.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblOk){
			if(String.valueOf(txtSenhaAntiga.getPassword()).equals("")||String.valueOf(txtNovaSenha.getPassword()).equals("")||String.valueOf(txtRepitaSenhaNovamente.getPassword()).equals("")){
				if(InformacaoGlobal.localeGlobal=="pt"){
				JOptionPane.showMessageDialog(null, "Todos os campos devem estar preenchidos");
				}else{
					if(InformacaoGlobal.localeGlobal=="ca_ES"){
						JOptionPane.showMessageDialog(null,
								"Todos los campos son obligatorios");
					}else{
						JOptionPane.showMessageDialog(null,
								"All fields must be filled");
					}
				}
			}else{
				if(!Arrays.equals(txtNovaSenha.getPassword(), txtRepitaSenhaNovamente.getPassword())){
					if(InformacaoGlobal.localeGlobal=="pt"){
					JOptionPane.showMessageDialog(null, "Os campos nova senha e Repita senha novamente devem ter o mesmo texto");
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							JOptionPane.showMessageDialog(null,
									"Los campos nueva contraseña y Repetir contraseña deben tener el mismo texto");
						}else{
							JOptionPane.showMessageDialog(null,
									"The fields new password and Repeat password must have the same text");
						}
					}
					}else{
					if(txtNovaSenha.getPassword().length<10 ||txtNovaSenha.getPassword().length>20){
						if(InformacaoGlobal.localeGlobal=="pt"){
						JOptionPane.showMessageDialog(null, "Nova Senha deve ter entre 10 e 20 caracteres");
						}else{
							if(InformacaoGlobal.localeGlobal=="ca_ES"){
								JOptionPane.showMessageDialog(null,
										"Nueva contraseña debe tener entre 10 y 20 caracteres");
							}else{
								JOptionPane.showMessageDialog(null,
										"New Password must be between 10 and 20 characters");
							}
						}
						}else{
						if(Arrays.equals(txtSenhaAntiga.getPassword(), txtNovaSenha.getPassword())){
							if(InformacaoGlobal.localeGlobal=="pt"){
							JOptionPane.showMessageDialog(null, "Senhas antiga e nova senha devem ser diferentes");
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									JOptionPane.showMessageDialog(null,
											"Contraseña antigua y la nueva contraseña debe ser diferente");
								}else{
									JOptionPane.showMessageDialog(null,
											"Old password and new password must be different");
								}
							}
						}else{
							try{
								Conexao.FazConexao();
								Connection con = Conexao.connection;
								Statement stm = con.createStatement();
								ResultSet res = stm.executeQuery("select * from usuario where NomeDeUsuario='" + nomeDeUsuario + "' and Senha='" + String.valueOf(txtSenhaAntiga.getPassword()) + "'");
								if(res.next()){					
									Connection con1 = Conexao.connection;
									Statement stm1 = con1.createStatement();
									stm1.executeUpdate("update usuario set senha='" + String.valueOf(txtNovaSenha.getPassword()) + "' where NomeDeUsuario='" + nomeDeUsuario + "'");
									if(InformacaoGlobal.localeGlobal=="pt"){
									JOptionPane.showMessageDialog(null, "Senha Alterada com Sucesso!");	
									}else{
										if(InformacaoGlobal.localeGlobal=="ca_ES"){
											JOptionPane.showMessageDialog(null,
													"Contraseña cambió con éxito!");
										}else{
											JOptionPane.showMessageDialog(null,
													"Password Changed Successfully!");
										}
									}
								}else{
									JOptionPane.showMessageDialog(null, "Não foi possível alterar senha");
								}
								TelaInicial tela = new TelaInicial(new Locale(InformacaoGlobal.localeGlobal));
								tela.setVisible(true);
								dispose();
							}catch(SQLException | IOException sql){
								sql.printStackTrace();
							}
						}							
					}
				}
			}			
		}else{
			if(e.getSource()==lblCancelar){
				if(nomeDeUsuario==""){
					try {
						TelaInicial tela = new TelaInicial(new Locale(InformacaoGlobal.localeGlobal));
						tela.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					}else{
						try {
							TelaInicial tela = new TelaInicial(new Locale(InformacaoGlobal.localeGlobal),nomeDeUsuario);
							tela.setVisible(true);
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
