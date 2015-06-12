package imagem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	static Connection connection;
	public static void FazConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/jogodamemoria?user=root");
		} catch (ClassNotFoundException cnfex) {
			if(InformacaoGlobal.localeGlobal=="pt"){
			JOptionPane.showMessageDialog(null,
					"FALHA NA CONEXÃO COM O BANCO DE DADOS");
			}else{
				if(InformacaoGlobal.localeGlobal=="ca_ES"){
					JOptionPane.showMessageDialog(null,
							"FALLA EN RELACIÓN CON LA BASE DE DATOS");
				}else{
					JOptionPane.showMessageDialog(null,
							"FAILURE IN CONNECTION WITH DATABASE");
				}
			}
			cnfex.printStackTrace();
			System.exit(1);
		} catch (SQLException sqlex) {
			if(InformacaoGlobal.localeGlobal=="pt"){
			JOptionPane
					.showMessageDialog(null, "Não foi possível se conectar com o banco de dados");
			}else{
				if(InformacaoGlobal.localeGlobal=="ca_ES"){
					JOptionPane.showMessageDialog(null,
							"No se puede conectar a la base de datos");
				}else{
					JOptionPane.showMessageDialog(null,
							"Unable to connect to database");
				}
			}
			sqlex.printStackTrace();
		}
	}
}
