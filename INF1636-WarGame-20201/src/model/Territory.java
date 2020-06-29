package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import observer.Observable;

class Territory extends Observable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private GameColor color;
	private int numTroops = 0;
	private ArrayList<String> neighbors;
	private ArrayList<Vertex> frontiers;
	private Vertex center;
	private Continent continent;

	public Territory(String n, ArrayList<String> neighbors, ArrayList<Vertex> fronteirs, Vertex center) {
		name = n;
		this.neighbors = neighbors;
		this.frontiers = fronteirs;
		this.center = center;
	}

	public void setContinent(Continent c) {
		continent = c;
	}
	
	public Continent getContinent()
	{
		return continent;
	}

	public String getName() {
		return name;
	}

	public GameColor getColor() {
		return color;
	}

	public int getTroops() {

		return numTroops;
	}

	public void setTroops(int t) {

		if (t < 0) {
			numTroops = 0;
		}

		numTroops = t;

		notifyObservers();
	}

	// Receives integer that increase or decrease troops
	public void modifyTroops(int t) {
		numTroops += t;

		notifyObservers();
	}

	public ArrayList<String> getNeighbors() {
		return neighbors;
	}

	public void setColor(GameColor c) {
		color = c;

		notifyObservers();
	}

	public Vertex getCenter() {
		return center;
	}

	public List<Vertex> getFrontiers() {
		return Collections.unmodifiableList(frontiers);
	}

	public static ArrayList<Territory> initialize() {
		// initialize neighbor lists

		// NA

		ArrayList<String> alasca_n = new ArrayList<String>(Arrays.asList("Siberia", "Vancouver", "Calgary"));

		ArrayList<String> calgary_n = new ArrayList<String>(Arrays.asList("Alasca", "Vancouver", "Groenlandia"));

		ArrayList<String> california_n = new ArrayList<String>(Arrays.asList("Mexico", "Texas", "Vancouver"));

		ArrayList<String> groenlandia_n = new ArrayList<String>(Arrays.asList("Calgary", "Quebec", "Reino Unido"));

		ArrayList<String> mexico_n = new ArrayList<String>(Arrays.asList("California", "Texas", "Venezuela"));

		ArrayList<String> nova_york_n = new ArrayList<String>(Arrays.asList("Quebec", "Texas"));

		ArrayList<String> quebec_n = new ArrayList<String>(Arrays.asList("Groenlandia", "Nova York"));

		ArrayList<String> texas_n = new ArrayList<String>(
				Arrays.asList("California", "Quebec", "Mexico", "Nova York", "Vancouver"));

		ArrayList<String> vancouver_n = new ArrayList<String>(
				Arrays.asList("Alasca", "Calgary", "California", "Quebec", "Texas"));

		// SA

		ArrayList<String> argentina_n = new ArrayList<String>(Arrays.asList("Peru", "Brasil"));

		ArrayList<String> brasil_n = new ArrayList<String>(Arrays.asList("Venezuela", "Peru", "Argentina"));

		ArrayList<String> peru_n = new ArrayList<String>(Arrays.asList("Argentina", "Venezuela", "Brasil"));

		ArrayList<String> venezuela_n = new ArrayList<String>(Arrays.asList("Mexico", "Peru", "Brasil"));

		// AF

		ArrayList<String> argelia_n = new ArrayList<String>(Arrays.asList("Espanha", "Nigeria", "Egito", "Italia"));

		ArrayList<String> egito_n = new ArrayList<String>(
				Arrays.asList("Romenia", "Jordania", "Somalia", "Nigeria", "Argelia"));

		ArrayList<String> nigeria_n = new ArrayList<String>(
				Arrays.asList("Argelia", "Egito", "Brasil", "Somalia", "Angola"));

		ArrayList<String> somalia_n = new ArrayList<String>(
				Arrays.asList("Arabia Saudita", "Egito", "Nigeria", "Angola", "Africa Do Sul"));

		ArrayList<String> angola_n = new ArrayList<String>(Arrays.asList("Africa Do Sul", "Somalia", "Nigeria"));

		ArrayList<String> africa_do_sul_n = new ArrayList<String>(Arrays.asList("Angola", "Somalia"));

		// EU

		ArrayList<String> espanha_n = new ArrayList<String>(Arrays.asList("Argelia", "Franca"));

		ArrayList<String> franca_n = new ArrayList<String>(Arrays.asList("Espanha", "Italia", "Reino Unido", "Suecia"));

		ArrayList<String> italia_n = new ArrayList<String>(
				Arrays.asList("Romenia", "Polonia", "Suecia", "Franca", "Argelia"));

		ArrayList<String> polonia_n = new ArrayList<String>(Arrays.asList("Letonia", "Ucrania", "Romenia", "Italia"));

		ArrayList<String> reino_unido_n = new ArrayList<String>(Arrays.asList("Groenlandia", "Franca"));

		ArrayList<String> romenia_n = new ArrayList<String>(Arrays.asList("Ucrania", "Polonia", "Italia", "Egito"));

		ArrayList<String> suecia_n = new ArrayList<String>(Arrays.asList("Estonia", "Letonia", "Italia", "Franca"));

		ArrayList<String> ucrania_n = new ArrayList<String>(Arrays.asList("Turquia", "Letonia", "Polonia", "Romenia"));

		// AS

		ArrayList<String> arabia_saudita_n = new ArrayList<String>(Arrays.asList("Somalia", "Iraque", "Jordania"));

		ArrayList<String> bangladesh_n = new ArrayList<String>(
				Arrays.asList("India", "Coreia Do Sul", "Tailandia", "Indonesia"));

		ArrayList<String> cazaquistao_n = new ArrayList<String>(
				Arrays.asList("Siberia", "Russia", "Letonia", "Turquia", "China", "Mongolia", "Japao"));

		ArrayList<String> china_n = new ArrayList<String>(Arrays.asList("Mongolia", "Cazaquistao", "Turquia",
				"Paquistao", "India", "Coreia Do Sul", "Coreia Do Norte"));

		ArrayList<String> coreia_do_norte_n = new ArrayList<String>(Arrays.asList("Japao", "China", "Coreia Do Sul"));

		ArrayList<String> coreia_do_sul_n = new ArrayList<String>(
				Arrays.asList("Coreia Do Norte", "China", "India", "Bangladesh", "Tailandia"));

		ArrayList<String> estonia_n = new ArrayList<String>(Arrays.asList("Letonia", "Suecia", "Russia"));

		ArrayList<String> india_n = new ArrayList<String>(
				Arrays.asList("Coreia Do Sul", "China", "Paquistao", "Indonesia", "Bangladesh"));

		ArrayList<String> ira_n = new ArrayList<String>(Arrays.asList("Paquistao", "Siria", "Iraque"));

		ArrayList<String> iraque_n = new ArrayList<String>(Arrays.asList("Ira", "Siria", "Jordania", "Arabia Saudita"));

		ArrayList<String> japao_n = new ArrayList<String>(Arrays.asList("Cazaquistao", "Mongolia", "Coreia Do Norte"));

		ArrayList<String> jordania_n = new ArrayList<String>(
				Arrays.asList("Arabia Saudita", "Iraque", "Siria", "Egito"));

		ArrayList<String> letonia_n = new ArrayList<String>(
				Arrays.asList("Estonia", "Russia", "Cazaquistao", "Turquia", "Ucrania", "Polonia", "Suecia"));

		ArrayList<String> mongolia_n = new ArrayList<String>(Arrays.asList("Japao", "Cazaquistao", "China"));

		ArrayList<String> paquistao_n = new ArrayList<String>(
				Arrays.asList("China", "India", "Ira", "Siria", "Turquia"));

		ArrayList<String> russia_n = new ArrayList<String>(
				Arrays.asList("Estonia", "Siberia", "Cazaquistao", "Letonia"));

		ArrayList<String> siberia_n = new ArrayList<String>(Arrays.asList("Russia", "Cazaquistao", "Alasca"));

		ArrayList<String> siria_n = new ArrayList<String>(
				Arrays.asList("Turquia", "Paquistao", "Ira", "Iraque", "Jordania"));

		ArrayList<String> tailandia_n = new ArrayList<String>(Arrays.asList("Coreia Do Sul", "Bangladesh"));

		ArrayList<String> turquia_n = new ArrayList<String>(
				Arrays.asList("Letonia", "Ucrania", "Siria", "Paquistao", "China", "Cazaquistao"));

		// OC

		ArrayList<String> australia_n = new ArrayList<String>(Arrays.asList("Perth", "Nova Zelandia", "Indonesia"));

		ArrayList<String> indonesia_n = new ArrayList<String>(
				Arrays.asList("Australia", "Nova Zelandia", "Bangladesh", "India"));

		ArrayList<String> nova_zelandia_n = new ArrayList<String>(Arrays.asList("Australia", "Indonesia"));

		ArrayList<String> perth_n = new ArrayList<String>(Arrays.asList("Australia"));

		ArrayList<Territory> territories = new ArrayList<Territory>();

		// NA

		territories.add(new Territory(
				"Alasca", alasca_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(86, 119), new Vertex(134, 119),
						new Vertex(111, 163), new Vertex(58, 163), new Vertex(71, 137), new Vertex(76, 137))),
				new Vertex(93, 139)));
		territories.add(new Territory("Calgary", calgary_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(134, 119), new Vertex(148, 119), new Vertex(152, 125),
						new Vertex(208, 125), new Vertex(212, 133), new Vertex(230, 133), new Vertex(241, 112),
						new Vertex(270, 112), new Vertex(283, 134), new Vertex(258, 134), new Vertex(246, 158),
						new Vertex(231, 159), new Vertex(223, 171), new Vertex(147, 171), new Vertex(127, 135))),
				new Vertex(182, 145)));
		territories.add(new Territory("California", california_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(107, 216), new Vertex(177, 216), new Vertex(126, 305),
						new Vertex(90, 305), new Vertex(77, 204), new Vertex(90, 266), new Vertex(84, 253))),
				new Vertex(116, 258)));
		territories.add(new Territory("Groenlandia", groenlandia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(270, 112), new Vertex(285, 90), new Vertex(371, 90),
						new Vertex(379, 102), new Vertex(379, 106), new Vertex(372, 117), new Vertex(365, 117),
						new Vertex(351, 145), new Vertex(335, 145), new Vertex(327, 135), new Vertex(285, 135))),
				new Vertex(320, 109)));
		territories.add(new Territory("Mexico", mexico_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(90, 305), new Vertex(126, 305), new Vertex(151, 350),
						new Vertex(161, 350), new Vertex(164, 343), new Vertex(172, 356), new Vertex(166, 366),
						new Vertex(175, 379), new Vertex(173, 383), new Vertex(178, 393), new Vertex(184, 393),
						new Vertex(188, 401), new Vertex(179, 416), new Vertex(172, 403), new Vertex(161, 403),
						new Vertex(146, 373), new Vertex(135, 373))),
				new Vertex(151, 364))); // not every Vertex but its something
		territories.add(new Territory("Nova York", nova_york_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(246, 216), new Vertex(296, 216), new Vertex(203, 346),
						new Vertex(166, 306), new Vertex(202, 246), new Vertex(231, 245))),
				new Vertex(221, 264))); // not every Vertex but its something
		territories.add(new Territory("Quebec", quebec_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(231, 186), new Vertex(262, 186), new Vertex(273, 268),
						new Vertex(272, 167), new Vertex(283, 167), new Vertex(288, 157), new Vertex(319, 157),
						new Vertex(340, 159), new Vertex(325, 211), new Vertex(296, 216), new Vertex(214, 215))),
				new Vertex(276, 189)));
		territories.add(new Territory(
				"Texas", texas_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(177, 216), new Vertex(246, 216),
						new Vertex(231, 245), new Vertex(202, 246), new Vertex(146, 338), new Vertex(126, 305))),
				new Vertex(193, 230)));
		territories.add(new Territory("Vancouver", vancouver_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(127, 134), new Vertex(147, 172), new Vertex(223, 173),
						new Vertex(231, 186), new Vertex(214, 216), new Vertex(107, 216), new Vertex(110, 163))),
				new Vertex(159, 192))); // not every Vertex but its something

		// SA

		territories.add(new Territory(
				"Argentina", argentina_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(275, 500),
						new Vertex(334, 500), new Vertex(295, 645), new Vertex(278, 645), new Vertex(235, 566))),
				new Vertex(277, 563)));
		territories
				.add(new Territory("Brasil", brasil_n,
						new ArrayList<Vertex>(Arrays.asList(new Vertex(255, 394), new Vertex(335, 442),
								new Vertex(334, 500), new Vertex(275, 500), new Vertex(235, 430))),
						new Vertex(291, 445)));
		territories.add(new Territory("Peru", peru_n, new ArrayList<Vertex>(
				Arrays.asList(new Vertex(235, 430), new Vertex(275, 500), new Vertex(241, 559), new Vertex(197, 495))),
				new Vertex(231, 491)));
		territories
				.add(new Territory(
						"Venezuela", venezuela_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(192, 395),
								new Vertex(255, 394), new Vertex(197, 495), new Vertex(163, 452))),
						new Vertex(199, 427)));

		// AF

		territories.add(new Territory(
				"Africa Do Sul", africa_do_sul_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(527, 540),
						new Vertex(618, 542), new Vertex(614, 581), new Vertex(597, 596), new Vertex(559, 596))),
				new Vertex(574, 563)));
		territories.add(new Territory("Angola", angola_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(520, 479), new Vertex(587, 477), new Vertex(600, 498),
						new Vertex(574, 540), new Vertex(528, 541), new Vertex(536, 527), new Vertex(515, 488))),
				new Vertex(553, 504)));
		territories.add(new Territory("Argelia", argelia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(438, 331), new Vertex(474, 331), new Vertex(499, 358),
						new Vertex(538, 358), new Vertex(513, 404), new Vertex(425, 404), new Vertex(409, 378))),
				new Vertex(468, 372)));
		territories.add(new Territory(
				"Egito", egito_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(541, 355), new Vertex(591, 355),
						new Vertex(623, 431), new Vertex(565, 432), new Vertex(549, 405), new Vertex(516, 405))),
				new Vertex(567, 389)));
		territories.add(new Territory(
				"Nigeria", nigeria_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(427, 408), new Vertex(548, 406),
						new Vertex(588, 478), new Vertex(520, 478), new Vertex(502, 448), new Vertex(449, 447))),
				new Vertex(502, 431)));
		territories.add(new Territory("Somalia", somalia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(563, 433), new Vertex(624, 433), new Vertex(640, 459),
						new Vertex(671, 459), new Vertex(653, 498), new Vertex(643, 497), new Vertex(618, 540),
						new Vertex(574, 540), new Vertex(602, 496))),
				new Vertex(625, 481)));

		// EU

		territories
				.add(new Territory("Espanha", espanha_n,
						new ArrayList<Vertex>(Arrays.asList(new Vertex(441, 262), new Vertex(461, 259),
								new Vertex(476, 285), new Vertex(471, 308), new Vertex(417, 304))),
						new Vertex(444, 281)));
		territories.add(new Territory("Franca", franca_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(449, 230), new Vertex(489, 229), new Vertex(498, 214),
						new Vertex(516, 215), new Vertex(527, 183), new Vertex(539, 205), new Vertex(510, 259),
						new Vertex(477, 285), new Vertex(462, 262))),
				new Vertex(483, 241)));
		territories.add(new Territory("Italia", italia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(540, 206), new Vertex(553, 206), new Vertex(568, 233),
						new Vertex(556, 256), new Vertex(562, 296), new Vertex(536, 304), new Vertex(510, 259))),
				new Vertex(531, 258)));
		territories.add(new Territory("Reino Unido", reino_unido_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(461, 141), new Vertex(480, 141), new Vertex(490, 192),
						new Vertex(482, 207), new Vertex(445, 207), new Vertex(422, 193), new Vertex(431, 176))),
				new Vertex(454, 169)));
		territories.add(new Territory(
				"Polonia", polonia_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(574, 172), new Vertex(585, 171),
						new Vertex(600, 200), new Vertex(582, 232), new Vertex(567, 232), new Vertex(552, 205))),
				new Vertex(572, 204)));
		territories.add(new Territory("Suecia", suecia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(551, 91), new Vertex(583, 92), new Vertex(610, 139),
						new Vertex(601, 154), new Vertex(572, 152), new Vertex(548, 179), new Vertex(500, 179),
						new Vertex(491, 161), new Vertex(507, 135), new Vertex(536, 106))),
				new Vertex(529, 141)));
		territories.add(new Territory("Romenia", romenia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(567, 233), new Vertex(582, 233), new Vertex(608, 279),
						new Vertex(593, 304), new Vertex(580, 303), new Vertex(574, 292), new Vertex(557, 259),
						new Vertex(555, 254))),
				new Vertex(584, 283)));
		territories.add(new Territory(
				"Ucrania", ucrania_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(601, 201), new Vertex(620, 234),
						new Vertex(612, 249), new Vertex(619, 260), new Vertex(608, 277), new Vertex(582, 233))),
				new Vertex(612, 254)));

		// AS

		territories.add(new Territory("Arabia Saudita", arabia_saudita_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(653, 338), new Vertex(680, 383), new Vertex(717, 382),
						new Vertex(726, 398), new Vertex(698, 445), new Vertex(649, 445), new Vertex(639, 430),
						new Vertex(646, 419), new Vertex(627, 383))),
				new Vertex(672, 410)));
		territories.add(new Territory("Bangladesh", bangladesh_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(847, 345), new Vertex(884, 346), new Vertex(859, 390),
						new Vertex(879, 427), new Vertex(880, 452), new Vertex(870, 465), new Vertex(855, 435),
						new Vertex(829, 379))),
				new Vertex(849, 392)));
		territories.add(new Territory("Cazaquistao", cazaquistao_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(738, 197), new Vertex(908, 197), new Vertex(920, 217),
						new Vertex(905, 241), new Vertex(784, 241), new Vertex(772, 219), new Vertex(726, 219))),
				new Vertex(838, 217)));
		territories.add(new Territory("China", china_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(784, 242), new Vertex(806, 242), new Vertex(821, 272),
						new Vertex(873, 273), new Vertex(887, 297), new Vertex(838, 297), new Vertex(812, 345),
						new Vertex(785, 345), new Vertex(755, 292))),
				new Vertex(793, 289)));
		territories.add(new Territory("Coreia Do Norte", coreia_do_norte_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(838, 297), new Vertex(887, 297), new Vertex(893, 309),
						new Vertex(908, 309), new Vertex(915, 321), new Vertex(826, 321))),
				new Vertex(866, 310)));
		territories.add(new Territory(
				"Coreia Do Sul", coreia_do_sul_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(826, 321),
						new Vertex(915, 321), new Vertex(921, 332), new Vertex(915, 345), new Vertex(812, 345))),
				new Vertex(864, 335)));
		territories.add(new Territory(
				"Estonia", estonia_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(583, 92), new Vertex(605, 92),
						new Vertex(632, 96), new Vertex(734, 119), new Vertex(706, 168), new Vertex(626, 168))),
				new Vertex(654, 146)));
		territories.add(new Territory(
				"India", india_n, new ArrayList<Vertex>(Arrays.asList(new Vertex(786, 345), new Vertex(846, 346),
						new Vertex(807, 415), new Vertex(812, 422), new Vertex(798, 445), new Vertex(764, 383))),
				new Vertex(793, 394)));
		territories.add(new Territory("Ira", ira_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(701, 306), new Vertex(717, 306), new Vertex(750, 365),
						new Vertex(739, 383), new Vertex(733, 371), new Vertex(715, 370), new Vertex(690, 323))),
				new Vertex(740, 346)));
		territories.add(new Territory("Iraque", iraque_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(671, 306), new Vertex(700, 306), new Vertex(691, 323),
						new Vertex(703, 346), new Vertex(693, 357), new Vertex(706, 382), new Vertex(680, 382),
						new Vertex(654, 338))),
				new Vertex(677, 345)));
		territories.add(new Territory("Japao", japao_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(937, 217), new Vertex(956, 249), new Vertex(965, 271),
						new Vertex(955, 289), new Vertex(947, 289), new Vertex(939, 302), new Vertex(921, 302),
						new Vertex(930, 287), new Vertex(927, 283), new Vertex(934, 275), new Vertex(943, 265),
						new Vertex(927, 235))),
				new Vertex(955, 267)));
		territories.add(new Territory("Jordania", jordania_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(648, 306), new Vertex(671, 306), new Vertex(627, 382),
						new Vertex(612, 373), new Vertex(602, 351), new Vertex(615, 332), new Vertex(633, 333))),
				new Vertex(615, 341)));
		territories.add(new Territory("Letonia", letonia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(610, 140), new Vertex(627, 169), new Vertex(725, 169),
						new Vertex(739, 197), new Vertex(725, 218), new Vertex(612, 219), new Vertex(584, 171),
						new Vertex(592, 171))),
				new Vertex(660, 193)));
		territories.add(new Territory("Mongolia", mongolia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(805, 242), new Vertex(906, 242), new Vertex(910, 249),
						new Vertex(902, 260), new Vertex(916, 282), new Vertex(906, 295), new Vertex(894, 273),
						new Vertex(822, 273))),
				new Vertex(855, 257)));
		territories.add(new Territory("Paquistao", paquistao_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(718, 274), new Vertex(764, 274), new Vertex(754, 291),
						new Vertex(785, 344), new Vertex(763, 382), new Vertex(739, 383), new Vertex(751, 365),
						new Vertex(709, 292))),
				new Vertex(745, 321)));
		territories.add(new Territory("Russia", russia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(744, 119), new Vertex(869, 120), new Vertex(825, 197),
						new Vertex(739, 196), new Vertex(724, 168), new Vertex(707, 168), new Vertex(729, 131))),
				new Vertex(781, 154)));
		territories.add(new Territory("Siberia", siberia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(875, 112), new Vertex(437, 112), new Vertex(952, 139),
						new Vertex(941, 139), new Vertex(946, 150), new Vertex(940, 158), new Vertex(957, 186),
						new Vertex(949, 199), new Vertex(939, 178), new Vertex(930, 177), new Vertex(916, 155),
						new Vertex(907, 170), new Vertex(885, 171), new Vertex(877, 182), new Vertex(888, 196),
						new Vertex(826, 197))),
				new Vertex(903, 140)));
		territories.add(new Territory("Siria", siria_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(628, 271), new Vertex(647, 267), new Vertex(660, 268),
						new Vertex(664, 274), new Vertex(717, 274), new Vertex(708, 291), new Vertex(716, 305),
						new Vertex(636, 305), new Vertex(628, 301), new Vertex(619, 285))),
				new Vertex(664, 287)));
		territories.add(new Territory("Tailandia", tailandia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(885, 346), new Vertex(915, 346), new Vertex(926, 364),
						new Vertex(919, 382), new Vertex(911, 382), new Vertex(908, 390), new Vertex(901, 416),
						new Vertex(901, 427), new Vertex(895, 441), new Vertex(887, 441), new Vertex(859, 391))),
				new Vertex(907, 374)));
		territories.add(new Territory("Turquia", turquia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(612, 220), new Vertex(771, 219), new Vertex(784, 241),
						new Vertex(764, 274), new Vertex(684, 273), new Vertex(691, 263), new Vertex(678, 242),
						new Vertex(667, 242), new Vertex(664, 235), new Vertex(652, 236), new Vertex(646, 245),
						new Vertex(638, 235), new Vertex(620, 234))),
				new Vertex(712, 244)));

		// OC

		territories.add(new Territory("Australia", australia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(874, 535), new Vertex(887, 534), new Vertex(919, 593),
						new Vertex(911, 606), new Vertex(917, 618), new Vertex(901, 645), new Vertex(890, 645),
						new Vertex(877, 668), new Vertex(845, 668), new Vertex(838, 651), new Vertex(823, 651),
						new Vertex(816, 636))),
				new Vertex(871, 610)));
		territories.add(new Territory("Indonesia", indonesia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(851, 476), new Vertex(860, 495), new Vertex(881, 495),
						new Vertex(887, 481), new Vertex(902, 481), new Vertex(907, 493), new Vertex(924, 493),
						new Vertex(935, 513), new Vertex(944, 513), new Vertex(954, 531), new Vertex(927, 531),
						new Vertex(920, 518), new Vertex(907, 517), new Vertex(904, 524), new Vertex(890, 524),
						new Vertex(885, 512), new Vertex(848, 512), new Vertex(834, 485), new Vertex(840, 477))),
				new Vertex(896, 500)));
		territories.add(new Territory("Nova Zelandia", nova_zelandia_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(928, 600), new Vertex(936, 600), new Vertex(943, 612),
						new Vertex(950, 628), new Vertex(932, 660), new Vertex(926, 660), new Vertex(917, 677),
						new Vertex(899, 677), new Vertex(917, 642))),
				new Vertex(934, 644)));
		territories.add(new Territory("Perth", perth_n,
				new ArrayList<Vertex>(Arrays.asList(new Vertex(856, 531), new Vertex(862, 537), new Vertex(855, 545),
						new Vertex(861, 557), new Vertex(816, 636), new Vertex(786, 637), new Vertex(780, 650),
						new Vertex(766, 651), new Vertex(756, 634), new Vertex(763, 625), new Vertex(770, 625),
						new Vertex(782, 605), new Vertex(775, 592), new Vertex(781, 580), new Vertex(789, 578),
						new Vertex(798, 561), new Vertex(822, 561), new Vertex(838, 531))),
				new Vertex(802, 588)));

		return territories;

	}

	@Override
	public Object get(int i) {
		switch (i) {
		case 0:
			return name;
		case 1:
			return color.getColorCode();
		case 2:
			return numTroops;
		}
		return null;
	}
}
