package imagem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRootPane;

public class Configuracao extends JFrame implements MouseListener{
static final long serialVersionUID = 1L;
	 JPanel contentPane;
	JComboBox<Object> cbxIdioma;
	JLabel lblIdioma;
	String nomeDeUsuario="";
	
	static JLabel lblOk,lblCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracao frame = new Configuracao(new Locale(InformacaoGlobal.localeGlobal));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public Configuracao(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");
		ResourceBundle bundle1= ResourceBundle.getBundle("imagem.ResBundle");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		
		setUndecorated(true);
		setResizable(false);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle(bundle.getString("Configuracao.JFrame.text"));
				
		lblIdioma = new JLabel(bundle.getString("Configuracao.lblIdioma.text"));
		lblIdioma.setBounds(12, 13, 56, 16);
		contentPane.add(lblIdioma);
		
		cbxIdioma = new JComboBox<Object>();
		cbxIdioma.setModel(new DefaultComboBoxModel<Object>(new String[] {"Portugu\u00EAs - BR", "English", "Español"}));
		cbxIdioma.setBounds(80, 10, 159, 22);
		contentPane.add(cbxIdioma);
		
		lblOk = new JLabel(""); 
		lblOk.setBounds(21, 102, 71, 38);
		contentPane.add(lblOk);
		lblOk.addMouseListener(this);
		
		lblCancelar = new JLabel(""); 
		lblCancelar.setBounds(136, 102, 103, 38);
		contentPane.add(lblCancelar);
		lblCancelar.addMouseListener(this);
		
		lblOk.setIcon(new ImageIcon((Image)bundle1.getObject("Configuracao.lblOk.image")));
		lblCancelar.setIcon(new ImageIcon((Image)bundle1.getObject("Configuracao.lblCancelar.image")));
	}
	
	Configuracao(Locale locale,String nomeDeUsuario){
		this(locale);
		this.nomeDeUsuario=nomeDeUsuario;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==lblOk){
			if(nomeDeUsuario==""){
				if(cbxIdioma.getSelectedIndex()==1){
					try {
						TelaInicial tela = new TelaInicial(new Locale("en","US"));
						InformacaoGlobal.localeGlobal="en_US";
						tela.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}				
				}
				else{
					if(cbxIdioma.getSelectedIndex()==2){
						try {
							TelaInicial tela = new TelaInicial(new Locale("ca","ES"));
							InformacaoGlobal.localeGlobal="ca_ES";
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}				
					}else{
						if(cbxIdioma.getSelectedIndex()==0){
							try {
								TelaInicial tela = new TelaInicial(new Locale("pt"));
								InformacaoGlobal.localeGlobal="pt";
								tela.setVisible(true);
								dispose();
							} catch (IOException e1) {
								e1.printStackTrace();
							}				
						}
					}
				}
			}else{
				if(cbxIdioma.getSelectedIndex()==1){
					try {
						TelaInicial tela = new TelaInicial(new Locale("en","US"),nomeDeUsuario);
						InformacaoGlobal.localeGlobal="en_US";
						tela.setVisible(true);
						dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}				
				}
				else{
					if(cbxIdioma.getSelectedIndex()==2){
						try {
							TelaInicial tela = new TelaInicial(new Locale("ca","ES"),nomeDeUsuario);
							InformacaoGlobal.localeGlobal="ca_ES";
							tela.setVisible(true);
							dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}				
					}else{
						if(cbxIdioma.getSelectedIndex()==0){
							try {
								TelaInicial tela = new TelaInicial(new Locale("pt"),nomeDeUsuario);
								InformacaoGlobal.localeGlobal="pt";
								tela.setVisible(true);
								dispose();
							} catch (IOException e1) {
								e1.printStackTrace();
							}				
						}
					}
				}
			}
		}else{
			if(e.getSource()==lblCancelar){
				if(nomeDeUsuario==""){
				try {					
					if(InformacaoGlobal.localeGlobal=="pt"){
						TelaInicial tela = new TelaInicial(new Locale("pt"));
						tela.setVisible(true);
						dispose();
					}else{
						if(InformacaoGlobal.localeGlobal=="ca_ES"){
							TelaInicial tela = new TelaInicial(new Locale("ca","ES"));
							tela.setVisible(true);
							dispose();
						}else{
							TelaInicial tela = new TelaInicial(new Locale("en","US"));
							tela.setVisible(true);
							dispose();
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
				}else{
					if(nomeDeUsuario!=""){
						try {
							
							if(InformacaoGlobal.localeGlobal=="pt"){
								TelaInicial tela = new TelaInicial(new Locale("pt"),nomeDeUsuario);
								tela.setVisible(true);
								dispose();
							}else{
								if(InformacaoGlobal.localeGlobal=="ca_ES"){
									TelaInicial tela = new TelaInicial(new Locale("ca_ES"),nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}else{
									TelaInicial tela = new TelaInicial(new Locale("en_US"),nomeDeUsuario);
									tela.setVisible(true);
									dispose();
								}
							}							
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
