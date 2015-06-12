package imagem;

import java.awt.Image;
import java.util.ListResourceBundle;

import javax.swing.ImageIcon;

public class ResBundle extends ListResourceBundle {
	Object contents[][];
	ImageIcon imagemNovoJogo, imagemLogar, imagemRanking, imagemCriarUsuario,
			imagemDeslogar, imagemTrocarSenha, imagemConfiguracao,
			imagemConquistas, imagemOk, imagemCancelar, imagemVoltar,
			imagemCadastrar, imagemCancelar2, imagemOk2, imagemVoltar2,
			imagemRanking2, imagemMenu, imagemJogarNovamente, imagemSair;
	Image imgNovoJogo, imgLogar, imgRanking, imgCriarUsuario, imgDeslogar,
			imgTrocarSenha, imgConfiguracao, imgConquistas, imgOk, imgCancelar,
			imgVoltar, imgCadastrar, imgCancelar2, imgOk2, imgVoltar2,
			imgRanking2, imgMenu, imgJogarNovamente, imgSair;

	public ResBundle() {
		contents = new Object[19][2];

		imagemNovoJogo = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnNovoJogo.jpg"));
		imgNovoJogo = imagemNovoJogo.getImage().getScaledInstance(99, 39,
				Image.SCALE_DEFAULT);
		contents[0] = new Object[] { "TelaInicial.lblNovoJogo.image",
				imgNovoJogo };

		imagemLogar = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnLogar.jpg"));
		imgLogar = imagemLogar.getImage().getScaledInstance(99, 39,
				Image.SCALE_DEFAULT);
		contents[1] = new Object[] { "TelaInicial.lblLogar.image", imgLogar };

		imagemRanking = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnRanking.jpg"));
		imgRanking = imagemRanking.getImage().getScaledInstance(99, 40,
				Image.SCALE_DEFAULT);
		contents[2] = new Object[] { "TelaInicial.lblRanking.image", imgRanking };

		imagemCriarUsuario = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnCriarUsuario.jpg"));
		imgCriarUsuario = imagemCriarUsuario.getImage().getScaledInstance(148,
				41, Image.SCALE_DEFAULT);
		contents[3] = new Object[] { "TelaInicial.lblCriarUsuario.image",
				imgCriarUsuario };

		imagemDeslogar = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnDeslogar.jpg"));
		imgDeslogar = imagemDeslogar.getImage().getScaledInstance(88, 39,
				Image.SCALE_DEFAULT);
		contents[4] = new Object[] { "TelaInicial.lblDeslogar.image",
				imgDeslogar };

		imagemTrocarSenha = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnTrocarSenha.jpg"));
		imgTrocarSenha = imagemTrocarSenha.getImage().getScaledInstance(88, 39,
				Image.SCALE_DEFAULT);
		contents[5] = new Object[] { "TelaInicial.lblTrocarSenha.image",
				imgTrocarSenha };

		imagemConfiguracao = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnConfiguracao.jpg"));
		imgConfiguracao = imagemConfiguracao.getImage().getScaledInstance(138,
				39, Image.SCALE_DEFAULT);
		contents[6] = new Object[] { "TelaInicial.lblConfiguracao.image",
				imgConfiguracao };

		imagemConquistas = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnConquistas.png"));
		imgConquistas = imagemConquistas.getImage().getScaledInstance(150, 39,
				Image.SCALE_DEFAULT);
		contents[7] = new Object[] { "TelaInicial.lblConquistas.image",
				imgConquistas };

		imagemOk = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnOk.jpg"));
		imgOk = imagemOk.getImage().getScaledInstance(71, 38,
				Image.SCALE_DEFAULT);
		contents[8] = new Object[] { "Configuracao.lblOk.image", imgOk };

		imagemCancelar = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnCancelar.jpg"));
		imgCancelar = imagemCancelar.getImage().getScaledInstance(103, 38,
				Image.SCALE_DEFAULT);
		contents[9] = new Object[] { "Configuracao.lblCancelar.image",
				imgCancelar };

		imagemVoltar = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnVoltar.jpg"));
		imgVoltar = imagemVoltar.getImage().getScaledInstance(88, 27,
				Image.SCALE_DEFAULT);
		contents[10] = new Object[] { "Conquistas.lblVoltar.image", imgVoltar };

		imagemCadastrar = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnCadastrar.jpg"));
		imgCadastrar = imagemCadastrar.getImage().getScaledInstance(116, 25,
				Image.SCALE_DEFAULT);
		contents[11] = new Object[] { "CriacaoUsuario.lblCadastrar.image",
				imgCadastrar };

		imagemCancelar2 = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnCancelar.jpg"));
		imgCancelar2 = imagemCancelar2.getImage().getScaledInstance(103, 38,
				Image.SCALE_DEFAULT);
		contents[12] = new Object[] { "CriacaoUsuario.lblCancelar.image",
				imgCancelar2 };

		imagemOk2 = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnOk.jpg"));
		imgOk2 = imagemOk2.getImage().getScaledInstance(97, 25,
				Image.SCALE_DEFAULT);
		contents[13] = new Object[] { "EsqueceuSenha.lblOk.image", imgOk2 };

		imagemVoltar2 = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnVoltar.jpg"));
		imgVoltar2 = imagemVoltar2.getImage().getScaledInstance(97, 25,
				Image.SCALE_DEFAULT);
		contents[14] = new Object[] { "EsqueceuSenha.lblVoltar.image",
				imgCancelar2 };
		
		imagemRanking2 = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnRanking.jpg"));
		imgRanking2 = imagemRanking2.getImage().getScaledInstance(89, 23,
				Image.SCALE_DEFAULT);
		contents[15] = new Object[] { "FimDeJogo.lblRanking.image", imgRanking2 };
		
		imagemMenu = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnMenu.jpg"));
		imgMenu = imagemMenu.getImage().getScaledInstance(89, 23,
				Image.SCALE_DEFAULT);
		contents[16] = new Object[] { "FimDeJogo.lblMenu.image", imgMenu };
		
		imagemJogarNovamente = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnJogarNovamente.jpg"));
		imgJogarNovamente = imagemJogarNovamente.getImage().getScaledInstance(137, 19,
				Image.SCALE_DEFAULT);
		contents[17] = new Object[] { "FimDeJogo.lblJogarNovamente.image", imgJogarNovamente };
		
		imagemSair = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnSair.jpg"));
		imgSair = imagemSair.getImage().getScaledInstance(79, 19,
				Image.SCALE_DEFAULT);
		contents[18] = new Object[] { "FimDeJogo.lblSair.image", imgSair };
	}

	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
