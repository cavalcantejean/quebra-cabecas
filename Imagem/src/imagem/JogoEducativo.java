package imagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;

public class JogoEducativo extends JFrame implements ActionListener {

	static int i = 0;

	private static final long serialVersionUID = 1L;
	private Pontuacao pontuacao = new Pontuacao();
	private Imagens obj1, obj2;
	private static int nivel;

	ImageIcon imagem, imagemAtumAzul, imagemBaleiaAzul, imagemBorboletaMonarca,
			imagemChipanze, imagemChiru, imagemElefanteAfricano,
			imagemGorilaDasMontanhas, imagemGuigoDaCaatinga, imagemLeopardo,
			imagemLoboGuara, imagemMacacoPregoDourado, imagemMorsa,
			imagemPanda, imagemPinguimDeMagalhaes, imagemRinoceronteDeJava,
			imagemTartarugaGigante, imagemTigre, imagemUrsoPolar;

	Image img, imgAtumAzul, imgBaleiaAzul, imgBorboletaMonarca, imgChipanze,
			imgChiru, imgElefanteAfricano, imgGorilaDasMontanhas,
			imgGuigoDaCaatinga, imgLeopardo, imgLoboGuara,
			imgMacacoPregoDourado, imgMorsa, imgPanda, imgPinguimDeMagalhaes,
			imgRinoceronteDeJava, imgTartarugaGigante, imgTigre, imgUrsoPolar;

	String[] nome = { "Ailuropoda melanoleuca", "Spheniscus magellanicus",
			"Rhinoceros sondaicus", "Geochelone gigantia", "Panthera tigres",
			"Ursus maritimus", "Thunnus thynnus", "Balaenoptera musculus",
			"Danaus plexippus", "Pan troglodytes", "Pantholops hodgsonii",
			"Loxodonta spp", "Gorilla gorila", "Callicebus barbarabrownae",
			"Panthera pardus", "Chrysocyon brachyurus", "Cebus flavius",
			"Odobenus rosmarus" };
	String[] curiosidade = {
			"O panda \u00E9 uma esp\u00E9cie encontrada \r\nem cativeiros.\r\nAnimais que est\u00E3o sendo extintos pela \r\ndificuldade de procria\u00E7\u00E3o e tamb\u00E9m \r\npela destrui\u00E7\u00E3o de seu habitat.\r\n",
			"Existem 17 esp\u00E9cies de pinguins, e dessas,\r\n12 est\u00E3o amea\u00E7adas de extin\u00E7\u00E3o. Os pinguins, \r\nem virtude do aquecimento das correntes \r\nmar\u00EDtimas, est\u00E3o tendo que nadar cada vez \r\nmais longe para achar comida, por isso alguns \r\nv\u00EAm sendo encontrados em praias brasileiras.\r\n",
			"O chifre desses animais \u00E9 considerado \r\nmedicinal pela popula\u00E7\u00E3o asi\u00E1tica, e em \r\nraz\u00E3o disso, a ca\u00E7a predat\u00F3ria \u00E9 o principal \r\nmotivo para que esses animais sejam \r\nexterminados. Al\u00E9m da ca\u00E7a, o habitat \r\ndesses animais tamb\u00E9m est\u00E1 sendo destru\u00EDdo.\r\n",
			"A procria\u00E7\u00E3o desse r\u00E9ptil vem sendo \r\nprejudicada pelo aumento da temperatura \r\ndas \u00E1guas, pela pesca e pela polui\u00E7\u00E3o. Como \r\no animal n\u00E3o est\u00E1 conseguindo se reproduzir, \r\nautomaticamente poder\u00E1 entrar em extin\u00E7\u00E3o.\r\nA tartaruga gigante \u00E9 um dos maiores repteis.",
			"Al\u00E9m de terem a maior parte de seu \r\nambiente degradado, na \u00C1sia, muitas \r\npessoas ca\u00E7am esse animal por considerarem \r\nalgumas partes do seu corpo medicinais.\r\nExistem poucos tigres que ainda vivem livres na natureza\r\n",
			"Em raz\u00E3o do aquecimento global, \r\nesses animais est\u00E3o perdendo \r\nseu habitat natural.\r\n",
			"Esse animal est\u00E1 sendo extinto em face da pesca predat\u00F3ria.\r\nO atum azul \u00E9 um dos principais ingredientes do sushi de\r\nqualidade, por isso ele \u00E9 t\u00E3o ca\u00E7ado\r\n",
			"A matan\u00E7a de baleias-azuis espalhou-se rapidamente,\r\ne em 1925, os Estados Unidos, o Reino Unido e o Jap\u00E3o \r\ntinham se juntado, \u00E0 Noruega, na ca\u00E7a \u00E0s baleias-azuis, \r\ncapturando-as, matando-as e processando-as em grandes \r\nnavios-f\u00E1bricas.",
			"A floresta de pinheiros \u00E9 o habitat dessas \r\nborboletas que v\u00EAm sendo amea\u00E7adas pelo \r\ncrescimento urbano e tamb\u00E9m pelo aquecimento global.\r\nTemperaturas altas s\u00E3o as principais amea\u00E7as para essas \r\nborboletas\r\n",
			"A esp\u00E9cie encontra-se em perigo de extin\u00E7\u00E3o. \r\nApesar do vasto territ\u00F3rio que ocupam, estes \r\nanimais t\u00EAm sido dizimados pelos humanos \r\ncom a ca\u00E7a ilegal, quer para alimenta\u00E7\u00E3o, \r\nquer para a produ\u00E7\u00E3o de amuletos para a \r\nmedicina tradicional.\r\n",
			"Eles est\u00E3o amea\u00E7ados de extin\u00E7\u00E3o, devido \u00E0 ca\u00E7a, \r\nsua l\u00E3 \u00E9 extremamente cara e de alta qualidade.\r\n\u00C9 tamb\u00E9m um dos 5 mascotes oficiais das \r\nOlimp\u00EDadas de 2008 de Pequim, China.\r\n",
			"O elefante-africano (Loxodonta spp.) \u00E9 o maior \r\ndos dois tipos de elefante. Por compara\u00E7\u00E3o com \r\no elefante-asi\u00E1tico, distingue-se pelas orelhas \r\nmaiores, uma adapta\u00E7\u00E3o \u00E0s temperaturas mais \r\nelevadas, e pela presen\u00E7a de presas de marfim \r\nnas f\u00EAmeas, com cerca de 70 kg cada uma.\r\n",
			"Em muitas regi\u00F5es da \u00C1frica, esses \r\nanimais s\u00E3o ca\u00E7ados porque algumas \r\npartes de seu corpo s\u00E3o consideradas medicinais.\r\n",
			"Callicebus barbarabrownae \u00E9 uma esp\u00E9cie de \r\nMacaco do Novo Mundoda fam\u00EDlia Pitheciidae\r\n e subfam\u00EDlia Callicebinae. Ocorre nas \u00E1reas\r\nmais altas da costa da Bahia, no Brasil, entre o \r\nrio Paragua\u00E7u e o rio Itapicuru.",
			"Leopardo (Panthera pardus), tamb\u00E9m chamado \r\non\u00E7a-do-cabo-verde em Angola, \u00E9, com o le\u00E3o, \r\ntigre e on\u00E7a pintada, um dos quatro grandes \r\nfelinos do g\u00EAnero Panthera. Medem de 1,25 m \r\na 1,65 m de comprimento, e pesam entre 30 e \r\n90kg.",
			"Embora o atual estado de conserva\u00E7\u00E3o da esp\u00E9cie, \r\nde acordo com a IUCN, seja pouco preocupante, \r\na m\u00E9dio prazo o lobo-guar\u00E1 corre risco de extin\u00E7\u00E3o \r\nna natureza, em fun\u00E7\u00E3o do decl\u00EDnio populacional \r\ne da extrema fragmenta\u00E7\u00E3o da \u00E1rea de ocupa\u00E7\u00E3o.",
			"\u00C9 classificado como \"criticamente em perigo\" \r\npela IUCN,  e j\u00E1 foi considerado um dos 25 \r\nprimatas mais amea\u00E7ados do mundo, na lista \r\nde 2010 a 2012.\r\n",
			"Tamb\u00E9m afetados pelo aquecimento \r\nglobal, esses animais, al\u00E9m de estarem \r\nperdendo seus habitats, est\u00E3o ficado \r\nsem comida, em raz\u00E3o do derretimento das \r\ngeleiras; em consequ\u00EAncia, morrem de fome." };
	String[] fonte = {
			"Fonte: http://www.escolakids.com/animais-ameacados-de-extincao.htm",
			"Fonte: http://pt.wikipedia.org/wiki/Baleia-azul",
			"Fonte: http://pt.wikipedia.org/wiki/Chipanze",
			"Fonte: http://pt.wikipedia.org/wiki/Ant%C3%ADlope-tibetano",
			"Fonte: http://pt.wikipedia.org/wiki/Elefante-africano",
			"Fonte: http://pt.wikipedia.org/wiki/Guig%C3%B3-da-caatinga",
			"Fonte: http://pt.wikipedia.org/wiki/Leopardo",
			"Fonte: http://pt.wikipedia.org/wiki/Lobo-Guar%C3%A1",
			"Fonte: http://pt.wikipedia.org/wiki/Macaco-prego-galego" };

	String[] curiosidade_ca_ES = {
			"El panda es una especie que se encuentra\r\nen cautiverio.\r\nLos animales extinguidos por\r\ndificultad de procreación y también\r\nla destrucción de su hábitat.",
			"Hay 17 especies de pingüinos, y de éstos,\r\n12 están en peligro de extinción. Pingüinos,\r\ndebido a la corriente de calentamiento\r\nmar, están teniendo que nadar nunca\r\nmás lejos para encontrar comida, por lo que algunos\r\nse han encontrado en las playas brasileñas",
			"El cuerno de estos animales se considera\r\nla población asiática medicinal, y\r\nDebido a esto, la caza furtiva es la principal\r\nrazón por la que estos animales son\r\nexterminados. Además de la caza, el hábitat\r\nestos animales también se está destruyendo, ",
			"La procreación este reptil ha sido\r\nobstaculizado por el aumento de la temperatura\r\naguas de la pesca y la contaminación. como\r\ne animal no es capaz de reproducir,\r\npasará automáticamente a la extinción.\r\nLa tortuga gigante es uno de los más grandes de reptiles ",
			"Tener Además de la mayor parte de su\r\ndegradación del medio ambiente en el `Asia, muchos\r\nla gente caza este animal para considerar\r\nalgunas partes de su cuerpo medicinal.\r\nHay pocos tigres que todavía viven libres en la naturaleza ",
			"Debido al calentamiento global,\r\nestos animales están perdiendo\r\nsu hábitat natural ",
			"Este animal se extinguió en la cara de la sobrepesca.\r\nEl atún rojo es uno de los principales ingredientes del sushi\r\ncalidad, por lo que es tan perseguido ",
			"La matanza de las ballenas azules se extendió rápidamente,\r\ny en 1925, los Estados Unidos, el Reino Unido y Japón\r\nse había unido, Noruega, las ballenas azules caza,\r\nla captura de ellos, matándolos y procesamiento a granel\r\nbuques factoría ",
			"El bosque de pinos es el hábitat de estos\r\nmariposas que están siendo amenazados por\r\ncrecimiento urbano y también por el calentamiento global.\r\nLas altas temperaturas son las principales amenazas para estos\r\nMariposas",
			"La especie se encuentra en peligro.\r\nA pesar del vasto territorio que ocupan, estos\r\nanimales han sido diezmadas por el ser humano\r\ncon la caza ilegal, ya sea para alimento,\r\no para la producción de encantos para\r\nmedicina tradicional",
			"Ellos están en peligro de extinción debido a la caza,\r\nsu lana es extremadamente caro y de alta calidad.\r\nTambién es una de las mascotas oficiales de 5\r\nJuegos Olímpicos de 2008 en Beijing, China. ",
			"El elefante africano (Loxodonta spp.) Es la mayor\r\nlos dos tipos de elefante. En comparación con\r\nelefante asiático, se distingue por las orejas\r\nmás grande, la adaptación a temperaturas más altas\r\nde altura, y la presencia de los colmillos\r\nen las mujeres, con cerca de 70 kg cada uno. ",
			"En muchas partes de África, estos\r\nlos animales son cazados porque algunas\r\npartes de su cuerpo son considerados medicamento ",
			"Callicebus barbarabrownae es una especie de\r\nLa familia del mono Nueva Mundoda Pitheciidae\r\ny la subfamilia Callicebinae. Ocurre en áreas\r\nsuperior de la costa de Bahía, en Brasil, entre\r\nRío Paraguassu y Itapicuru. ",
			"Leopardo (Panthera pardus), también llamado\r\nOz-el-cable verde en Angola, es un león,\r\nel tigre y el jaguar, uno de los cuatro grandes\r\nfelinos en el género Panthera. Miden 1,25 m\r\n1,65 m de longitud y pesan entre 30 y\r\n90kg ",
			"A pesar de que el estado de conservación actual de la especie,\r\nsegún la UICN, es algo preocupante,\r\naguará guazú en el riesgo a medio plazo de la extinción\r\nen la naturaleza, debido a la disminución de la población\r\ny la extrema fragmentación del área de ocupación ",
			"Está clasificada como  \"en peligro crítico\"\r\nUICN, y que una vez fue considerado uno de los 25\r\nprimates más amenazados del mundo, la lista\r\n2010-2012.",
			"También afectados por el calentamiento\r\nEn general, estos animales, además de ser\r\nperdiendo sus hábitats se quedado\r\nsin alimentos, debido a la fusión de\r\nglaciares; en consecuencia, a morir de hambre " };

	String[] curiosidade_en_US = {
			"The panda is a species found\r\nin captivity\r\nAnimals being extinguished by\r\ndifficulty of procreation and also\r\nthe destruction of their habitat. ",
			"There are 17 species of penguins, and of these,\r\n12 are threatened with extinction. Penguins,\r\ndue to the heating current\r\nsea​​, are having to swim ever\r\nfarther to find food, so some\r\nhave been found in Brazilian beaches. ",
			"The horn of these animals is considered\r\nthe medicinal Asian population, and\r\nBecause of this, poaching is the main\r\nreason why these animals are\r\nexterminated. Besides hunting, habitat\r\nthese animals is also being destroyed, ",
			"Procreation this reptile has been\r\nhindered by increasing the temperature\r\nwaters by fishing and pollution. as\r\nthe animal is not able to reproduce,\r\nwill automatically go into extinction.\r\nThe giant tortoise is one of the largest reptile. ",
			"Besides having most of its\r\ndegraded environment in the `Asia, many\r\npeople hunt this animal for considering\r\nsome parts of your body medicinal.\r\nThere are few tigers still living free in nature, ",
			"Because of global warming,\r\nthese animals are losing\r\ntheir natural habitat. ",
			"This animal has been extinct in the face of overfishing.\r\nThe bluefin tuna is one of the main ingredients of sushi\r\nquality, so it is as hunted ",
			"The killing of blue whales spread rapidly,\r\nand in 1925, the United States, the United Kingdom and Japan\r\nhad joined, Norway, the hunt blue whales,\r\ncapturing them, killing them and processing them in bulk\r\nfactory ships. ",
			"The pine forest is the habitat of these\r\nbutterflies that are being threatened by\r\nurban growth and also by global warming.\r\nHigh temperatures are the main threats to these\r\nButterflies",
			"The species is endangered.\r\nDespite the vast territory they occupy, these\r\nanimals have been decimated by human\r\nwith illegal hunting, whether for food,\r\nor for the production of charms to\r\ntraditional medicine.",
			"They are threatened with extinction due to hunting,\r\ntheir wool is extremely expensive and high quality.\r\nIt is also one of the official mascots of 5\r\n2008 Olympics in Beijing, China. ",
			"The African elephant (Loxodonta spp.) Is the largest\r\nthe two types of elephant. By comparison with\r\nAsian elephant, is distinguished by the ears\r\nlarger, adaptation to higher temperatures\r\nhigh, and the presence of tusks\r\nin females, with about 70 kg each. ",
			"In many parts of Africa, these\r\nanimals are hunted because some\r\nparts of their body are considered medicinal. ",
			"Callicebus barbarabrownae is a kind of\r\nMonkey New Mundoda Pitheciidae family\r\nand subfamily Callicebinae. Occurs in areas\r\nhigher the coast of Bahia, in Brazil, between\r\nRiver Paraguassu and Itapicuru. ",
			"Leopard (Panthera pardus), also called\r\nOz-the-cable-green in Angola, is a lion,\r\ntiger and jaguar, one of the four major\r\ncats in the genus Panthera. They measure 1.25 m\r\n1.65 m in length and weigh between 30 and\r\n90kg. ",
			"Although the current conservation status of the species,\r\naccording to IUCN, is somewhat troubling,\r\nmaned wolf in the medium-term risk of extinction\r\nin nature, due to the population decline\r\nand the extreme fragmentation of the area of ​​occupancy. ",
			"It is classified as \" critically endangered \" \r\nIUCN, and was once considered one of the 25\r\nmost endangered primates in the world, the list\r\nfrom 2010 to 2012.",
			"Also affected by warming\r\nOverall, these animals, in addition to being\r\nlosing their habitats, are stayed\r\nwithout food, due to the melting of\r\nglaciers; consequently, die of hunger." };

	private JLabel lblFoto;
	private int nivelQnt;
	private boolean primeiroClique = true;
	private boolean acertou = true;
	private Object img1 = new Object();
	private Object img2 = new Object();
	ImageIcon imagemPadrao;
	private JLabel pontos;
	private JPanel painelCabecalho, painelJogo, painelSub, painelGeral;
	private ArrayList<Icon> imagensArray;
	private GridLayout gridCabecalho, gridJogo, gridSub;
	private ArrayList<Imagens> imagens;
	private final Container container;
	private JMenuBar menuBar;
	private JMenu mnOpcoes;
	private JMenuItem mntmNovoJogo;
	private JMenuItem mntmMenu;
	private JMenuItem mntmVoltar;
	JTextArea txtCuriosidade;

	private JLabel lblNome;
	private JLabel lblFonte;
	String nomeDeUsuario = "";
	private JLabel lblPontuacao;

	void prepararJogo() {
		// nivelQnt recebe o número de cartas do jogo de acordo com nível
		// escolhido
		if (JogoEducativo.nivel == 1)
			nivelQnt = 12;
		else if (JogoEducativo.nivel == 2)
			nivelQnt = 24;
		else
			nivelQnt = 36;
	}

	void prepararImagens() {
		// inicializar vetor
		imagensArray = new ArrayList<Icon>();
		int i;
		for (i = 0; i < nivelQnt; i++)
			// inserir as imagens de acordo com o tema
			this.imagensArray.add(new ImageIcon(getClass().getResource(
					"PastaImagens/natureza" + " (" + (i + 1) + ").png")));
	}

	/**
	 * @wbp.parser.constructor
	 */
	public JogoEducativo(int nivel) {
		ResourceBundle bundle = ResourceBundle.getBundle("imagem.Bundle");

		setUndecorated(true);

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));

		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("PastaImagens/natureza.jpg")));
		setTitle(bundle.getString("JogoEducativo.JFrame.text"));
		JogoEducativo.nivel = nivel;
		prepararJogo();
		prepararImagens();
		new ImageIcon(getClass().getResource("PastaImagens/tema_natureza.png"));
		// gerenciadores de layout
		gridCabecalho = new GridLayout(1, 1, 0, 0);
		gridSub = new GridLayout(1, 2, 0, 0);
		// verificar qual deve ser a disposição de botões de acordo com o nível
		if (JogoEducativo.nivel == 1)
			gridJogo = new GridLayout(3, 4, 0, 0);
		else if (JogoEducativo.nivel == 2)
			gridJogo = new GridLayout(3, 8, 0, 0);
		else
			gridJogo = new GridLayout(4, 9, 0, 0);
		// configurar painelCabecalho
		painelCabecalho = new JPanel();
		painelCabecalho.setBounds(0, 0, 450, 0);
		painelCabecalho.setLayout(gridCabecalho);
		// configurar painelJogo
		painelJogo = new JPanel();
		painelJogo.setBounds(0, 10, 705, 456);
		painelJogo.setLayout(gridJogo);

		int numObj = 0;
		imagens = new ArrayList<Imagens>();
		// preencher todos os botões com a imagem padrão, sua imagem e sua
		// idenficação
		for (Icon imagem : imagensArray) {
			numObj++;
			imagens.add(new Imagens(imagemPadrao, imagem, numObj));
			imagens.get(numObj - 1).addActionListener(this);
		}

		// embaralhar os botões
		Collections.shuffle(imagens);
		for (Imagens imagem : imagens)
			painelJogo.add(imagem);

		// configurar painelSub
		painelSub = new JPanel();
		painelSub.setBounds(10, 495, 499, 15);
		painelSub.setLayout(gridSub);

		// configurar painelGeral
		painelGeral = new JPanel();
		painelGeral.setLayout(null);
		painelGeral.add(painelCabecalho);
		painelGeral.add(painelJogo);

		painelGeral.add(painelSub);

		// configurar container
		container = getContentPane();
		container.setLayout(new BorderLayout(5, 5));
		container.add(painelGeral);

		// configurar pontos
		pontos = new JLabel(String.valueOf(pontuacao.getPontos()));
		pontos.setBounds(143, 470, 307, 14);
		painelGeral.add(pontos);

		lblFoto = new JLabel("");
		lblFoto.setBounds(715, 11, 74, 69);
		painelGeral.add(lblFoto);

		imagem = new ImageIcon(
				JogoEducativo.class.getResource("PastaImagens/natureza.jpg"));
		img = imagem.getImage().getScaledInstance(lblFoto.getWidth(),
				lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemAtumAzul = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (13).png"));
		imgAtumAzul = imagemAtumAzul.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemAtumAzul = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (13).png"));
		imgAtumAzul = imagemAtumAzul.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemBaleiaAzul = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (15).png"));
		imgBaleiaAzul = imagemBaleiaAzul.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemBorboletaMonarca = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (17).png"));
		imgBorboletaMonarca = imagemBorboletaMonarca.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemChipanze = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (19).png"));
		imgChipanze = imagemChipanze.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemChiru = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (21).png"));
		imgChiru = imagemChiru.getImage().getScaledInstance(lblFoto.getWidth(),
				lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemElefanteAfricano = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (23).png"));
		imgElefanteAfricano = imagemElefanteAfricano.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemGorilaDasMontanhas = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (25).png"));
		imgGorilaDasMontanhas = imagemGorilaDasMontanhas.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemGuigoDaCaatinga = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (27).png"));
		imgGuigoDaCaatinga = imagemGuigoDaCaatinga.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemLeopardo = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (29).png"));
		imgLeopardo = imagemLeopardo.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemLoboGuara = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (31).png"));
		imgLoboGuara = imagemLoboGuara.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemMacacoPregoDourado = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (33).png"));
		imgMacacoPregoDourado = imagemMacacoPregoDourado.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemMorsa = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (35).png"));
		imgMorsa = imagemMorsa.getImage().getScaledInstance(lblFoto.getWidth(),
				lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemPanda = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (1).png"));
		imgPanda = imagemPanda.getImage().getScaledInstance(lblFoto.getWidth(),
				lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemPinguimDeMagalhaes = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (3).png"));
		imgPinguimDeMagalhaes = imagemPinguimDeMagalhaes.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemRinoceronteDeJava = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (5).png"));
		imgRinoceronteDeJava = imagemRinoceronteDeJava.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemTartarugaGigante = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (7).png"));
		imgTartarugaGigante = imagemTartarugaGigante.getImage()
				.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(),
						Image.SCALE_DEFAULT);

		imagemTigre = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (9).png"));
		imgTigre = imagemTigre.getImage().getScaledInstance(lblFoto.getWidth(),
				lblFoto.getHeight(), Image.SCALE_DEFAULT);

		imagemUrsoPolar = new ImageIcon(
				JogoEducativo.class
						.getResource("PastaImagens/natureza (11).png"));
		imgUrsoPolar = imagemUrsoPolar.getImage().getScaledInstance(
				lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT);

		// lblFoto.setIcon(new ImageIcon(img));

		lblNome = new JLabel("");
		lblNome.setBounds(715, 91, 378, 14);
		painelGeral.add(lblNome);

		txtCuriosidade = new JTextArea();
		txtCuriosidade.setBackground(Color.DARK_GRAY);
		txtCuriosidade.setForeground(Color.DARK_GRAY);
		txtCuriosidade.setBounds(715, 116, 426, 119);
		painelGeral.add(txtCuriosidade);
		txtCuriosidade.setEnabled(false);

		lblFonte = new JLabel("");
		lblFonte.setBounds(715, 246, 426, 14);
		painelGeral.add(lblFonte);

		lblPontuacao = new JLabel(
				bundle.getString("JogoEducativo.lblPontuacao.text"));
		lblPontuacao.setBounds(10, 470, 99, 14);
		painelGeral.add(lblPontuacao);

		setLocation(50, 50);
		setSize(1171, 564);
		setResizable(false);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnOpcoes = new JMenu(bundle.getString("JogoEducativo.mnOpcoes.text"));
		menuBar.add(mnOpcoes);

		mntmNovoJogo = new JMenuItem(
				bundle.getString("JogoEducativo.mntmNovoJogo.text"));
		mnOpcoes.add(mntmNovoJogo);
		mntmNovoJogo.addActionListener(this);

		mntmVoltar = new JMenuItem(
				bundle.getString("JogoEducativo.mntmVoltar.text"));
		mnOpcoes.add(mntmVoltar);
		mntmVoltar.addActionListener(this);

		mntmMenu = new JMenuItem(bundle.getString("JogoEducativo.mntmMenu"));
		mnOpcoes.add(mntmMenu);
		mntmMenu.addActionListener(this);
		setVisible(true);

		txtCuriosidade.setVisible(false);
	}

	JogoEducativo(int nivel, String nome) {
		this(nivel);
		this.nomeDeUsuario = nome;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == mntmMenu) {
			try {
				if (nomeDeUsuario == "") {
					TelaInicial tela = new TelaInicial(new Locale(
							InformacaoGlobal.localeGlobal));
					tela.setVisible(true);
					dispose();
				} else {
					TelaInicial tela = new TelaInicial(new Locale(
							InformacaoGlobal.localeGlobal), nomeDeUsuario);
					tela.setVisible(true);
					dispose();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

		if (e.getSource() == mntmVoltar) {
			try {
				if (nomeDeUsuario == "") {
					SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(
							new Locale(InformacaoGlobal.localeGlobal),
							"educativo");
					if (InformacaoGlobal.localeGlobal == "pt") {
						SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(
								SelecaoDeDificuldade.imgIniciar));
						SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(
								SelecaoDeDificuldade.imgVoltar));
					} else {
						if (InformacaoGlobal.localeGlobal == "ca_ES") {
							SelecaoDeDificuldade.lblIniciar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgIniciar_ca_ES));
							SelecaoDeDificuldade.lblVoltar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgVoltar_ca_ES));
						} else {
							SelecaoDeDificuldade.lblIniciar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgIniciar_en_US));
							SelecaoDeDificuldade.lblVoltar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgVoltar_en_US));
						}
					}
					SelecaoDeDificuldade.setVisible(true);
					dispose();
				} else {
					SelecaoDeDificuldade SelecaoDeDificuldade = new SelecaoDeDificuldade(
							new Locale(InformacaoGlobal.localeGlobal),
							"educativo", nomeDeUsuario);
					if (InformacaoGlobal.localeGlobal == "pt") {
						SelecaoDeDificuldade.lblIniciar.setIcon(new ImageIcon(
								SelecaoDeDificuldade.imgIniciar));
						SelecaoDeDificuldade.lblVoltar.setIcon(new ImageIcon(
								SelecaoDeDificuldade.imgVoltar));
					} else {
						if (InformacaoGlobal.localeGlobal == "ca_ES") {
							SelecaoDeDificuldade.lblIniciar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgIniciar_ca_ES));
							SelecaoDeDificuldade.lblVoltar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgVoltar_ca_ES));
						} else {
							SelecaoDeDificuldade.lblIniciar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgIniciar_en_US));
							SelecaoDeDificuldade.lblVoltar
									.setIcon(new ImageIcon(
											SelecaoDeDificuldade.imgVoltar_en_US));
						}
					}
					SelecaoDeDificuldade.setVisible(true);
					dispose();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource() == mntmNovoJogo) {
			if (JogoEducativo.nivel == 1) {
				if (nomeDeUsuario == "") {
					JogoEducativo tela = new JogoEducativo(1);
					tela.setVisible(true);
					dispose();
				} else {
					JogoEducativo tela = new JogoEducativo(1, nomeDeUsuario);
					tela.setVisible(true);
					dispose();
				}
			} else {
				if (JogoEducativo.nivel == 2) {
					if (nomeDeUsuario == "") {
						JogoEducativo tela = new JogoEducativo(2);
						tela.setVisible(true);
						dispose();
					} else {
						JogoEducativo tela = new JogoEducativo(2, nomeDeUsuario);
						tela.setVisible(true);
						dispose();
					}
				} else {
					if (JogoEducativo.nivel == 3) {
						if (nomeDeUsuario == "") {
							JogoEducativo tela = new JogoEducativo(3);
							tela.setVisible(true);
							dispose();
						} else {
							JogoEducativo tela = new JogoEducativo(3,
									nomeDeUsuario);
							tela.setVisible(true);
							dispose();
						}
					}
				}
			}
		}

		else {
			// testa se é o primeiro clique
			if (primeiroClique) {
				// testa se o jogador errou na jogada anterior
				if (!acertou) {
					obj1 = (Imagens) img1;
					obj2 = (Imagens) img2;
					obj1.setImagemPadrao();
					obj2.setImagemPadrao();
				}
				img1 = e.getSource();
				obj1 = (Imagens) img1;
				obj1.setImagemObjeto();

				// indica que este foi o primeiro clique
				primeiroClique = false;
			}

			// se não for o primeiro clique
			else {
				img2 = e.getSource();
				obj2 = (Imagens) img2;

				// verifica se jogador clicou no mesmo objeto
				if (obj1.getID() == obj2.getID()) {
					acertou = false;
				} else {

					// atualiza imagem
					obj2.setImagemObjeto();

					// compara com o primeiro
					if ((obj1.getID() % 2 == 0)
							&& (obj1.getID() - 1 == obj2.getID())
							|| (obj1.getID() % 2 != 0)
							&& (obj1.getID() + 1 == obj2.getID())) {

						if ((obj1.getID() == 1 && obj2.getID() == 2)
								|| (obj1.getID() == 2 && obj2.getID() == 1)) {

							lblFoto.setIcon(new ImageIcon(imgPanda));
							lblNome.setText(nome[0]);

							if (InformacaoGlobal.localeGlobal == "en_US") {
								txtCuriosidade.setText(curiosidade_en_US[0]);
							} else {
								if (InformacaoGlobal.localeGlobal == "ca_ES") {
									txtCuriosidade
											.setText(curiosidade_ca_ES[0]);
								} else {
									txtCuriosidade.setText(curiosidade[0]);
								}
							}

							lblFonte.setText(fonte[0]);
							txtCuriosidade.setVisible(true);
						} else {
							if ((obj1.getID() == 3 && obj2.getID() == 4)
									|| (obj1.getID() == 4 && obj2.getID() == 3)) {
								lblFoto.setIcon(new ImageIcon(
										imgPinguimDeMagalhaes));
								lblNome.setText(nome[1]);

								if (InformacaoGlobal.localeGlobal == "en_US") {
									txtCuriosidade
											.setText(curiosidade_en_US[1]);
								} else {
									if (InformacaoGlobal.localeGlobal == "ca_ES") {
										txtCuriosidade
												.setText(curiosidade_ca_ES[1]);
									} else {
										txtCuriosidade.setText(curiosidade[1]);
									}
								}

								lblFonte.setText(fonte[0]);
								txtCuriosidade.setVisible(true);
							} else {
								if ((obj1.getID() == 5 && obj2.getID() == 6)
										|| (obj1.getID() == 6 && obj2.getID() == 5)) {
									lblFoto.setIcon(new ImageIcon(
											imgRinoceronteDeJava));
									lblNome.setText(nome[2]);

									if (InformacaoGlobal.localeGlobal == "en_US") {
										txtCuriosidade
												.setText(curiosidade_en_US[2]);
									} else {
										if (InformacaoGlobal.localeGlobal == "ca_ES") {
											txtCuriosidade
													.setText(curiosidade_ca_ES[2]);
										} else {
											txtCuriosidade
													.setText(curiosidade[2]);
										}
									}

									lblFonte.setText(fonte[0]);
									txtCuriosidade.setVisible(true);
								} else {
									if ((obj1.getID() == 7 && obj2.getID() == 8)
											|| (obj1.getID() == 8 && obj2
													.getID() == 7)) {
										lblFoto.setIcon(new ImageIcon(
												imgTartarugaGigante));
										lblNome.setText(nome[3]);

										if (InformacaoGlobal.localeGlobal == "en_US") {
											txtCuriosidade
													.setText(curiosidade_en_US[3]);
										} else {
											if (InformacaoGlobal.localeGlobal == "ca_ES") {
												txtCuriosidade
														.setText(curiosidade_ca_ES[3]);
											} else {
												txtCuriosidade
														.setText(curiosidade[3]);
											}
										}

										lblFonte.setText(fonte[0]);
										txtCuriosidade.setVisible(true);
									} else {
										if ((obj1.getID() == 9 && obj2.getID() == 10)
												|| (obj1.getID() == 10 && obj2
														.getID() == 9)) {
											lblFoto.setIcon(new ImageIcon(
													imgTigre));
											lblNome.setText(nome[4]);

											if (InformacaoGlobal.localeGlobal == "en_US") {
												txtCuriosidade
														.setText(curiosidade_en_US[4]);
											} else {
												if (InformacaoGlobal.localeGlobal == "ca_ES") {
													txtCuriosidade
															.setText(curiosidade_ca_ES[4]);
												} else {
													txtCuriosidade
															.setText(curiosidade[4]);
												}
											}

											lblFonte.setText(fonte[0]);
											txtCuriosidade.setVisible(true);
										} else {
											if ((obj1.getID() == 11 && obj2
													.getID() == 12)
													|| (obj1.getID() == 12 && obj2
															.getID() == 11)) {
												lblFoto.setIcon(new ImageIcon(
														imgUrsoPolar));
												lblNome.setText(nome[5]);

												if (InformacaoGlobal.localeGlobal == "en_US") {
													txtCuriosidade
															.setText(curiosidade_en_US[5]);
												} else {
													if (InformacaoGlobal.localeGlobal == "ca_ES") {
														txtCuriosidade
																.setText(curiosidade_ca_ES[5]);
													} else {
														txtCuriosidade
																.setText(curiosidade[5]);
													}
												}

												lblFonte.setText(fonte[0]);
												txtCuriosidade.setVisible(true);
											} else {
												if ((obj1.getID() == 13 && obj2
														.getID() == 14)
														|| (obj1.getID() == 14 && obj2
																.getID() == 13)) {
													lblFoto.setIcon(new ImageIcon(
															imgAtumAzul));
													lblNome.setText(nome[6]);

													if (InformacaoGlobal.localeGlobal == "en_US") {
														txtCuriosidade
																.setText(curiosidade_en_US[6]);
													} else {
														if (InformacaoGlobal.localeGlobal == "ca_ES") {
															txtCuriosidade
																	.setText(curiosidade_ca_ES[6]);
														} else {
															txtCuriosidade
																	.setText(curiosidade[6]);
														}
													}

													lblFonte.setText(fonte[0]);
													txtCuriosidade
															.setVisible(true);
												} else {
													if ((obj1.getID() == 15 && obj2
															.getID() == 16)
															|| (obj1.getID() == 16 && obj2
																	.getID() == 15)) {
														lblFoto.setIcon(new ImageIcon(
																imgBaleiaAzul));
														lblNome.setText(nome[7]);

														if (InformacaoGlobal.localeGlobal == "en_US") {
															txtCuriosidade
																	.setText(curiosidade_en_US[7]);
														} else {
															if (InformacaoGlobal.localeGlobal == "ca_ES") {
																txtCuriosidade
																		.setText(curiosidade_ca_ES[7]);
															} else {
																txtCuriosidade
																		.setText(curiosidade[7]);
															}
														}

														lblFonte.setText(fonte[1]);
														txtCuriosidade
																.setVisible(true);
													} else {
														if ((obj1.getID() == 17 && obj2
																.getID() == 18)
																|| (obj1.getID() == 18 && obj2
																		.getID() == 17)) {
															lblFoto.setIcon(new ImageIcon(
																	imgBorboletaMonarca));
															lblNome.setText(nome[8]);

															if (InformacaoGlobal.localeGlobal == "en_US") {
																txtCuriosidade
																		.setText(curiosidade_en_US[8]);
															} else {
																if (InformacaoGlobal.localeGlobal == "ca_ES") {
																	txtCuriosidade
																			.setText(curiosidade_ca_ES[8]);
																} else {
																	txtCuriosidade
																			.setText(curiosidade[8]);
																}
															}

															lblFonte.setText(fonte[0]);
															txtCuriosidade
																	.setVisible(true);
														} else {
															if ((obj1.getID() == 19 && obj2
																	.getID() == 20)
																	|| (obj1.getID() == 20 && obj2
																			.getID() == 19)) {
																lblFoto.setIcon(new ImageIcon(
																		imgChipanze));
																lblNome.setText(nome[9]);

																if (InformacaoGlobal.localeGlobal == "en_US") {
																	txtCuriosidade
																			.setText(curiosidade_en_US[9]);
																} else {
																	if (InformacaoGlobal.localeGlobal == "ca_ES") {
																		txtCuriosidade
																				.setText(curiosidade_ca_ES[9]);
																	} else {
																		txtCuriosidade
																				.setText(curiosidade[9]);
																	}
																}

																lblFonte.setText(fonte[2]);
																txtCuriosidade
																		.setVisible(true);
															} else {
																if ((obj1
																		.getID() == 21 && obj2
																		.getID() == 22)
																		|| (obj1.getID() == 22 && obj2
																				.getID() == 21)) {
																	lblFoto.setIcon(new ImageIcon(
																			imgChiru));
																	lblNome.setText(nome[10]);

																	if (InformacaoGlobal.localeGlobal == "en_US") {
																		txtCuriosidade
																				.setText(curiosidade_en_US[10]);
																	} else {
																		if (InformacaoGlobal.localeGlobal == "ca_ES") {
																			txtCuriosidade
																					.setText(curiosidade_ca_ES[10]);
																		} else {
																			txtCuriosidade
																					.setText(curiosidade[10]);
																		}
																	}

																	lblFonte.setText(fonte[3]);
																	txtCuriosidade
																			.setVisible(true);
																} else {
																	if ((obj1
																			.getID() == 23 && obj2
																			.getID() == 24)
																			|| (obj1.getID() == 24 && obj2
																					.getID() == 23)) {
																		lblFoto.setIcon(new ImageIcon(
																				imgElefanteAfricano));
																		lblNome.setText(nome[11]);

																		if (InformacaoGlobal.localeGlobal == "en_US") {
																			txtCuriosidade
																					.setText(curiosidade_en_US[1]);
																		} else {
																			if (InformacaoGlobal.localeGlobal == "ca_ES") {
																				txtCuriosidade
																						.setText(curiosidade_ca_ES[11]);
																			} else {
																				txtCuriosidade
																						.setText(curiosidade[11]);
																			}
																		}

																		lblFonte.setText(fonte[4]);
																		txtCuriosidade
																				.setVisible(true);
																	} else {
																		if ((obj1
																				.getID() == 25 && obj2
																				.getID() == 26)
																				|| (obj1.getID() == 26 && obj2
																						.getID() == 25)) {
																			lblFoto.setIcon(new ImageIcon(
																					imgGorilaDasMontanhas));
																			lblNome.setText(nome[12]);

																			if (InformacaoGlobal.localeGlobal == "en_US") {
																				txtCuriosidade
																						.setText(curiosidade_en_US[12]);
																			} else {
																				if (InformacaoGlobal.localeGlobal == "ca_ES") {
																					txtCuriosidade
																							.setText(curiosidade_ca_ES[12]);
																				} else {
																					txtCuriosidade
																							.setText(curiosidade[12]);
																				}
																			}

																			lblFonte.setText(fonte[0]);
																			txtCuriosidade
																					.setVisible(true);
																		} else {
																			if ((obj1
																					.getID() == 27 && obj2
																					.getID() == 28)
																					|| (obj1.getID() == 28 && obj2
																							.getID() == 27)) {
																				lblFoto.setIcon(new ImageIcon(
																						imgGuigoDaCaatinga));
																				lblNome.setText(nome[13]);

																				if (InformacaoGlobal.localeGlobal == "en_US") {
																					txtCuriosidade
																							.setText(curiosidade_en_US[13]);
																				} else {
																					if (InformacaoGlobal.localeGlobal == "ca_ES") {
																						txtCuriosidade
																								.setText(curiosidade_ca_ES[13]);
																					} else {
																						txtCuriosidade
																								.setText(curiosidade[13]);
																					}
																				}

																				lblFonte.setText(fonte[5]);
																				txtCuriosidade
																						.setVisible(true);
																			} else {
																				if ((obj1
																						.getID() == 29 && obj2
																						.getID() == 30)
																						|| (obj1.getID() == 30 && obj2
																								.getID() == 29)) {
																					lblFoto.setIcon(new ImageIcon(
																							imgLeopardo));
																					lblNome.setText(nome[14]);

																					if (InformacaoGlobal.localeGlobal == "en_US") {
																						txtCuriosidade
																								.setText(curiosidade_en_US[14]);
																					} else {
																						if (InformacaoGlobal.localeGlobal == "ca_ES") {
																							txtCuriosidade
																									.setText(curiosidade_ca_ES[14]);
																						} else {
																							txtCuriosidade
																									.setText(curiosidade[14]);
																						}
																					}

																					lblFonte.setText(fonte[6]);
																					txtCuriosidade
																							.setVisible(true);
																				} else {
																					if ((obj1
																							.getID() == 31 && obj2
																							.getID() == 32)
																							|| (obj1.getID() == 32 && obj2
																									.getID() == 31)) {

																						lblFoto.setIcon(new ImageIcon(
																								imgLoboGuara));
																						lblNome.setText(nome[15]);

																						if (InformacaoGlobal.localeGlobal == "en_US") {
																							txtCuriosidade
																									.setText(curiosidade_en_US[15]);
																						} else {
																							if (InformacaoGlobal.localeGlobal == "ca_ES") {
																								txtCuriosidade
																										.setText(curiosidade_ca_ES[15]);
																							} else {
																								txtCuriosidade
																										.setText(curiosidade[15]);
																							}
																						}

																						lblFonte.setText(fonte[7]);
																						txtCuriosidade
																								.setVisible(true);
																					} else {
																						if ((obj1
																								.getID() == 33 && obj2
																								.getID() == 34)
																								|| (obj1.getID() == 34 && obj2
																										.getID() == 33)) {
																							lblFoto.setIcon(new ImageIcon(
																									imgMacacoPregoDourado));
																							lblNome.setText(nome[16]);

																							if (InformacaoGlobal.localeGlobal == "en_US") {
																								txtCuriosidade
																										.setText(curiosidade_en_US[16]);
																							} else {
																								if (InformacaoGlobal.localeGlobal == "ca_ES") {
																									txtCuriosidade
																											.setText(curiosidade_ca_ES[16]);
																								} else {
																									txtCuriosidade
																											.setText(curiosidade[16]);
																								}
																							}

																							lblFonte.setText(fonte[8]);
																							txtCuriosidade
																									.setVisible(true);
																						} else {
																							if ((obj1
																									.getID() == 35 && obj2
																									.getID() == 36)
																									|| (obj1.getID() == 36 && obj2
																											.getID() == 35)) {
																								lblFoto.setIcon(new ImageIcon(
																										imgMorsa));
																								lblNome.setText(nome[17]);

																								if (InformacaoGlobal.localeGlobal == "en_US") {
																									txtCuriosidade
																											.setText(curiosidade_en_US[17]);
																								} else {
																									if (InformacaoGlobal.localeGlobal == "ca_ES") {
																										txtCuriosidade
																												.setText(curiosidade_ca_ES[17]);
																									} else {
																										txtCuriosidade
																												.setText(curiosidade[17]);
																									}
																								}

																								lblFonte.setText(fonte[0]);
																								txtCuriosidade
																										.setVisible(true);
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

						acertou = true;
						pontuacao.setAcertos();
						pontuacao.ganharPontos();
						pontos.setText(String.valueOf(pontuacao.getPontos()));

						// Desabilita os botões
						obj1.setEnabled(false);
						obj2.setEnabled(false);

						// se foi o último par encontrado, encerra jogo
						if (pontuacao.getAcertos() == ((nivelQnt) / 2)) {
							if (nomeDeUsuario == "") {
								if (InformacaoGlobal.localeGlobal == "pt") {
									FimDeJogo fim = new FimDeJogo(
											"JogoEducativo",
											JogoEducativo.nivel,new Locale("pt"));
									fim.setVisible(true);
									fim.lblVocePerdeu.setText("Você terminou!");
									fim.lblPontuacao.setText(String
											.valueOf(pontuacao.getPontos()));
									dispose();
								} else {
									if (InformacaoGlobal.localeGlobal == "ca_ES") {
										FimDeJogo fim = new FimDeJogo(
												"JogoEducativo",
												JogoEducativo.nivel,new Locale("ca","ES"));
										fim.setVisible(true);
										fim.lblVocePerdeu
												.setText("Has terminado!");
										fim.lblPontuacao
												.setText(String
														.valueOf(pontuacao
																.getPontos()));
										dispose();
									} else {
										FimDeJogo fim = new FimDeJogo(
												"JogoEducativo",
												JogoEducativo.nivel,new Locale("en","US"));
										fim.setVisible(true);
										fim.lblVocePerdeu
												.setText("You finished!");
										fim.lblPontuacao
												.setText(String
														.valueOf(pontuacao
																.getPontos()));
										dispose();
									}
								}

							} else {
								
								if (InformacaoGlobal.localeGlobal == "pt") {
									FimDeJogo fim = new FimDeJogo("JogoEducativo",
											JogoEducativo.nivel, nomeDeUsuario,new Locale("pt"));
									fim.setVisible(true);
									fim.lblVocePerdeu.setText("Você terminou!");
									fim.lblPontuacao.setText(String
											.valueOf(pontuacao.getPontos()));
									dispose();
								} else {
									if (InformacaoGlobal.localeGlobal == "ca_ES") {
										FimDeJogo fim = new FimDeJogo("JogoEducativo",
												JogoEducativo.nivel, nomeDeUsuario,new Locale("ca","ES"));
										fim.setVisible(true);
										fim.lblVocePerdeu
												.setText("Has terminado!");
										fim.lblPontuacao
												.setText(String
														.valueOf(pontuacao
																.getPontos()));
										dispose();
									} else {
										FimDeJogo fim = new FimDeJogo("JogoEducativo",
												JogoEducativo.nivel, nomeDeUsuario,new Locale("en","US"));
										fim.setVisible(true);
										fim.lblVocePerdeu
												.setText("You finished!");
										fim.lblPontuacao
												.setText(String
														.valueOf(pontuacao
																.getPontos()));
										dispose();
									}
								}

							}
						}
					} else {
						acertou = false;
						pontuacao.perderPontos();
						pontos.setText(String.valueOf(pontuacao.getPontos()));
					}
					pontuacao.setTentativas();
					// indica que este foi o segundo clique
					primeiroClique = true;
				}
			}
		}

	}
}
