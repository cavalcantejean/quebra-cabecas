package imagem;

import java.awt.Image;
import java.util.ListResourceBundle;

import javax.swing.ImageIcon;

public class ResBundle_en_US extends ListResourceBundle {
	Object contents[][];
	ImageIcon imagemNovoJogo, imagemLogar, imagemRanking, imagemCriarUsuario,
			imagemDeslogar, imagemTrocarSenha, imagemConfiguracao,
			imagemConquistas, imagemOk, imagemCancelar, imagemVoltar,
			imagemCadastrar, imagemCancelar2, imagemOk2, imagemVoltar2,
			imagemRanking2, imagemMenu, imagemJogarNovamente, imagemSair;
	Image imgNovoJogo, imgLogar, imgRanking, imgCriarUsuario, imgDeslogar,
			imgTrocarSenha, imgConfiguracao, imgConquistas, imgOk, imgCancelar,
			imgCadastrar, imgCancelar2, imgVoltar, imgOk2, imgVoltar2,
			imgRanking2, imgMenu, imgJogarNovamente, imgSair;

	public ResBundle_en_US() {
		contents = new Object[19][2];

		imagemNovoJogo = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnNovoJogo_en_US.png"));
		imgNovoJogo = imagemNovoJogo.getImage().getScaledInstance(
				TelaInicial.lblNovoJogo.getWidth(),
				TelaInicial.lblNovoJogo.getHeight(), Image.SCALE_DEFAULT);
		contents[0] = new Object[] { "TelaInicial.lblNovoJogo.image",
				imgNovoJogo };

		imagemLogar = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnLogar_en_US.jpg"));
		imgLogar = imagemLogar.getImage().getScaledInstance(
				TelaInicial.lblLogar.getWidth(),
				TelaInicial.lblLogar.getHeight(), Image.SCALE_DEFAULT);
		contents[1] = new Object[] { "TelaInicial.lblLogar.image", imgLogar };

		imagemRanking = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnRanking.jpg"));
		imgRanking = imagemRanking.getImage().getScaledInstance(
				TelaInicial.lblRanking.getWidth(),
				TelaInicial.lblRanking.getHeight(), Image.SCALE_DEFAULT);
		contents[2] = new Object[] { "TelaInicial.lblRanking.image", imgRanking };

		imagemCriarUsuario = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnCriarUsuario_en_US.jpg"));
		imgCriarUsuario = imagemCriarUsuario.getImage().getScaledInstance(
				TelaInicial.lblCriarUsuario.getWidth(),
				TelaInicial.lblCriarUsuario.getHeight(), Image.SCALE_DEFAULT);
		contents[3] = new Object[] { "TelaInicial.lblCriarUsuario.image",
				imgCriarUsuario };

		imagemDeslogar = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnDeslogar_en_US.jpg"));
		imgDeslogar = imagemDeslogar.getImage().getScaledInstance(
				TelaInicial.lblDeslogar.getWidth(),
				TelaInicial.lblDeslogar.getHeight(), Image.SCALE_DEFAULT);
		contents[4] = new Object[] { "TelaInicial.lblDeslogar.image",
				imgDeslogar };

		imagemTrocarSenha = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnTrocarSenha_en_US.jpg"));
		imgTrocarSenha = imagemTrocarSenha.getImage().getScaledInstance(
				TelaInicial.lblTrocarSenha.getWidth(),
				TelaInicial.lblTrocarSenha.getHeight(), Image.SCALE_DEFAULT);
		contents[5] = new Object[] { "TelaInicial.lblTrocarSenha.image",
				imgTrocarSenha };

		imagemConfiguracao = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnConfiguracao_en_US.jpg"));
		imgConfiguracao = imagemConfiguracao.getImage().getScaledInstance(
				TelaInicial.lblConfiguracao.getWidth(),
				TelaInicial.lblConfiguracao.getHeight(), Image.SCALE_DEFAULT);
		contents[6] = new Object[] { "TelaInicial.lblConfiguracao.image",
				imgConfiguracao };

		imagemConquistas = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnConquistas_en_US.png"));
		imgConquistas = imagemConquistas.getImage().getScaledInstance(
				TelaInicial.lblConquistas.getWidth(),
				TelaInicial.lblConquistas.getHeight(), Image.SCALE_DEFAULT);
		contents[7] = new Object[] { "TelaInicial.lblConquistas.image",
				imgConquistas };

		imagemOk = new ImageIcon(
				ResBundle_en_US.class.getResource("PastaImagens/btnOk.jpg"));
		imgOk = imagemOk.getImage().getScaledInstance(
				Configuracao.lblOk.getWidth(), Configuracao.lblOk.getHeight(),
				Image.SCALE_DEFAULT);
		contents[8] = new Object[] { "Configuracao.lblOk.image", imgOk };

		imagemCancelar = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnCancelar_en_US.jpg"));
		imgCancelar = imagemCancelar.getImage().getScaledInstance(
				Configuracao.lblCancelar.getWidth(),
				Configuracao.lblCancelar.getHeight(), Image.SCALE_DEFAULT);
		contents[9] = new Object[] { "Configuracao.lblCancelar.image",
				imgCancelar };

		imagemVoltar = new ImageIcon(
				ResBundle_en_US.class
						.getResource("PastaImagens/btnVoltar_en_US.jpg"));
		imgVoltar = imagemVoltar.getImage().getScaledInstance(88, 27,
				Image.SCALE_DEFAULT);
		contents[10] = new Object[] { "Conquistas.lblVoltar.image", imgVoltar };

		imagemCadastrar = new ImageIcon(
				ResBundle.class
						.getResource("PastaImagens/btnCadastrar_en_US.jpg"));
		imgCadastrar = imagemCadastrar.getImage().getScaledInstance(116, 25,
				Image.SCALE_DEFAULT);
		contents[11] = new Object[] { "CriacaoUsuario.lblCadastrar.image",
				imgCadastrar };

		imagemCancelar2 = new ImageIcon(
				ResBundle.class
						.getResource("PastaImagens/btnCancelar_en_US.jpg"));
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
				ResBundle.class.getResource("PastaImagens/btnVoltar_en_US.jpg"));
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
				ResBundle.class
						.getResource("PastaImagens/btnJogarNovamente_en_US.jpg"));
		imgJogarNovamente = imagemJogarNovamente.getImage().getScaledInstance(
				137, 19, Image.SCALE_DEFAULT);
		contents[17] = new Object[] { "FimDeJogo.lblJogarNovamente.image",
				imgJogarNovamente };

		imagemSair = new ImageIcon(
				ResBundle.class.getResource("PastaImagens/btnSair_en_US.jpg"));
		imgSair = imagemSair.getImage().getScaledInstance(79, 19,
				Image.SCALE_DEFAULT);
		contents[18] = new Object[] { "FimDeJogo.lblSair.image", imgSair };
	}

	@Override
	protected Object[][] getContents() {
		return contents;
	}
}
