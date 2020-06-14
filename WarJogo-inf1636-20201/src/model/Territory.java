package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Territory {
	private String name;
	private GameColor color;
	private int numTroops = 0;
	private ArrayList<String> neighbors;
	private ArrayList<Point> fronteirs;
	private static ArrayList<Territory> territories = new ArrayList<Territory>(51);
	
	public Territory(String n, ArrayList<String> neighbors, ArrayList<Point> fronteirs) {
		name = n;
		this.neighbors = neighbors;
		this.fronteirs = fronteirs;
	}
	
	public static Territory getTerritory(String name)
	{
		for(Territory t : territories)
		{
			if(t.name == name)
				return t;
		}
		
		return null;
	}
	
	public static Territory getTerritory(int i_turf)
	{
		if(i_turf > -1 && i_turf < territories.size()){
			return territories.get(i_turf);
		}
		
		return null;
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
		
		if(t < 0) {
			numTroops = 0;
		}
		
		numTroops = t;
	}
	
	//Receives integer that increase or decrease troops
	public void modifyTroops(int t) {
		numTroops += t;
	}
	
	public ArrayList<String> getNeighbors(){
		return neighbors;
	}
	
	public void setColor(GameColor c)
	{
		color = c;
	}
	
	public static List<Territory> getTerritoriesList()
	{
		return Collections.unmodifiableList(territories);
	}
	
	public static void resetTerritories() {
		territories.clear();
	}
	
	public static void initialize()
	{
		//initialize neighbor lists
		Territory.resetTerritories();

		//NA

		ArrayList<String> alasca_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Vancouver","Calgary"));

		ArrayList<String> calgary_n = new ArrayList<String>(
	    	      Arrays.asList("Alasca","Vancouver","Groenlandia"));

		ArrayList<String> california_n = new ArrayList<String>(
	    	      Arrays.asList("Mexico","Texas","Vancouver"));

		ArrayList<String> groenlandia_n = new ArrayList<String>(
	    	      Arrays.asList("Calgary","Quebec","Reino Unido"));

		ArrayList<String> mexico_n = new ArrayList<String>(
	    	      Arrays.asList("California","Texas","Venezuela"));

		ArrayList<String> nova_york_n = new ArrayList<String>(
	    	      Arrays.asList("Quebec","Texas"));

		ArrayList<String> quebec_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Nova York"));

		ArrayList<String> texas_n = new ArrayList<String>(
	    	      Arrays.asList("California","Quebec","Mexico","Nova York","Vancouver"));

		ArrayList<String> vancouver_n = new ArrayList<String>(
	    	      Arrays.asList("Alasca","Calgary","California","Quebec","Texas"));

		//SA

		ArrayList<String> argentina_n = new ArrayList<String>(
	    	      Arrays.asList("Peru","Brasil"));

		ArrayList<String> brasil_n = new ArrayList<String>(
	    	      Arrays.asList("Venezuela","Peru","Argentina"));

		ArrayList<String> peru_n = new ArrayList<String>(
	    	    Arrays.asList("Argentina","Venezuela","Brasil"));

	    ArrayList<String> venezuela_n = new ArrayList<String>(
	    		Arrays.asList("Mexico","Peru","Brasil"));


	    //AF

	    ArrayList<String> argelia_n = new ArrayList<String>(
	    	      Arrays.asList("Espanha","Nigeria","Egito","Italia"));

	    ArrayList<String> egito_n = new ArrayList<String>(
	    	      Arrays.asList("Romenia","Jordania","Somalia","Nigeria","Argelia"));

	    ArrayList<String> nigeria_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Egito","Brasil","Somalia","Angola"));

	    ArrayList<String> somalia_n = new ArrayList<String>(
	    	      Arrays.asList("Arabia Saudita","Egito","Nigeria","Angola","Africa Do Sul"));

	    ArrayList<String> angola_n = new ArrayList<String>(
	    	      Arrays.asList("Africa Do Sul","Somalia","Nigeria"));

	    ArrayList<String> africa_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Angola","Somalia"));


	    //EU

	    ArrayList<String> espanha_n = new ArrayList<String>(
	    	      Arrays.asList("Argelia","Franca"));

	    ArrayList<String> franca_n = new ArrayList<String>(
	    	      Arrays.asList("Espanha","Italia","Reino Unido"));

	    ArrayList<String> italia_n = new ArrayList<String>(
	    	      Arrays.asList("Romenia","Polonia","Suecia","Franca","Argelia"));

	    ArrayList<String> polonia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Ucrania","Romenia","Italia"));

	    ArrayList<String> reino_unido_n = new ArrayList<String>(
	    	      Arrays.asList("Groenlandia","Franca"));

	    ArrayList<String> romenia_n = new ArrayList<String>(
	    	      Arrays.asList("Ucrania","Polonia","Italia","Egito"));

	    ArrayList<String> suecia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia", "Letonia" ,"Italia","Franca"));

	    ArrayList<String> ucrania_n = new ArrayList<String>(
	    	      Arrays.asList("Turquia","Letonia","Polonia","Romenia"));


	    //AS

	    ArrayList<String> arabia_saudita_n = new ArrayList<String>(
	    	      Arrays.asList("Somalia","Iraque","Jordania"));

	    ArrayList<String> bangladesh_n = new ArrayList<String>(
	    	      Arrays.asList("India","Coreia Do Sul","Tailandia","Indonesia"));

	    ArrayList<String> cazaquistao_n = new ArrayList<String>(
	    	      Arrays.asList("Siberia","Russia","Letonia","Turquia","China","Mongolia","Japao"));

	    ArrayList<String> china_n = new ArrayList<String>(
	    	      Arrays.asList("Mongolia","Cazaquistao","Turquia","Paquistao","India","Coreia Do Sul","Coreia Do Norte"));

	    ArrayList<String> coreia_do_norte_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","China","Coreia Do Sul"));

	    ArrayList<String> coreia_do_sul_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Norte","China","India","Bangladesh","Tailandia"));

	    ArrayList<String> estonia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Suecia","Russia"));

	    ArrayList<String> india_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Sul","China","Paquistao","Indonesia","Bangladesh"));

	    ArrayList<String> ira_n = new ArrayList<String>(
	    	      Arrays.asList("Paquistao","Siria","Iraque"));

	    ArrayList<String> iraque_n = new ArrayList<String>(
	    	      Arrays.asList("Ira","Siria","Jordania","Arabia Saudita"));

	    ArrayList<String> japao_n = new ArrayList<String>(
	    	      Arrays.asList("Cazaquistao","Mongolia","Coreia Do Norte"));

	    ArrayList<String> jordania_n = new ArrayList<String>(
	    	      Arrays.asList("Arabia Saudita","Iraque","Siria","Egito"));

	    ArrayList<String> letonia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia","Russia","Cazaquistao","Turquia","Ucrania","Polonia","Suecia"));

	    ArrayList<String> mongolia_n = new ArrayList<String>(
	    	      Arrays.asList("Japao","Cazaquistao","China"));

	    ArrayList<String> paquistao_n = new ArrayList<String>(
	    	      Arrays.asList("China","India","Ira","Siria","Turquia"));

	    ArrayList<String> russia_n = new ArrayList<String>(
	    	      Arrays.asList("Estonia","Siberia","Cazaquistao","Letonia"));

	    ArrayList<String> siberia_n = new ArrayList<String>(
	    	      Arrays.asList("Russia","Cazaquistao","Alasca"));

	    ArrayList<String> siria_n = new ArrayList<String>(
	    	      Arrays.asList("Turquia","Paquistao","Ira","Iraque","Jordania"));

	    ArrayList<String> tailandia_n = new ArrayList<String>(
	    	      Arrays.asList("Coreia Do Sul","Bangladesh"));

	    ArrayList<String> turquia_n = new ArrayList<String>(
	    	      Arrays.asList("Letonia","Ucrania","Siria","Paquistao","China","Cazaquistao"));


	    //OC

	    ArrayList<String> australia_n = new ArrayList<String>(
	    	      Arrays.asList("Perth","Nova Zelandia","Indonesia"));

	    ArrayList<String> indonesia_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Nova Zelandia","Bangladesh","India"));

	    ArrayList<String> nova_zelandia_n = new ArrayList<String>(
	    	      Arrays.asList("Australia","Indonesia"));

	    ArrayList<String> perth_n = new ArrayList<String>(
	    	      Arrays.asList("Australia"));
		    
		  //public Territory(String n, ArrayList<String> neighbors );
			
			//NA
		    
		    territories.add(new Territory("Alasca"			, alasca_n, new ArrayList<Point>(Arrays.asList(
                    new Point(86, 119),
                    new Point(134, 119),
                    new Point(111, 163),
                    new Point(58, 163),
                    new Point(71, 137),
                    new Point(76, 137)))));
		    territories.add(new Territory("Calgary"			, calgary_n, new ArrayList<Point>(Arrays.asList(
                    new Point(134, 119),
                    new Point(148, 119),
                    new Point(152, 125),
                    new Point(208, 125),
                    new Point(212, 133),
                    new Point(230, 133),
                    new Point(241, 112),
                    new Point(270, 112),
                    new Point(283, 134),
                    new Point(258, 134),
                    new Point(246, 158),
                    new Point(231, 159),
                    new Point(223, 171),
                    new Point(147, 171),
                    new Point(127, 135)))));
		    territories.add(new Territory("California"		, california_n, new ArrayList<Point>(Arrays.asList(
                    new Point(107, 216),
                    new Point(177, 216),
                    new Point(126, 305),
                    new Point(90, 305),
                    new Point(77, 204),
                    new Point(90, 266),
                    new Point(84, 253)))));
		    territories.add(new Territory("Groenlandia"		, groenlandia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(270, 112),
                    new Point(285, 90),
                    new Point(371, 90),
                    new Point(379, 102),
                    new Point(379, 106),
                    new Point(372, 117),
                    new Point(365, 117),
                    new Point(351, 145),
                    new Point(335, 145),
                    new Point(327, 135),
                    new Point(285, 135)))));
		    territories.add(new Territory("Mexico"			, mexico_n,new ArrayList<Point>(Arrays.asList(
		    		new Point(90, 305),
                    new Point(126, 305),
                    new Point(151, 350),
                    new Point(161, 350),
                    new Point(164, 343),
                    new Point(172, 356),
                    new Point(166, 366),
                    new Point(175, 379),
                    new Point(173, 383),
                    new Point(178, 393),
                    new Point(184, 393),
                    new Point(188, 401),
                    new Point(179, 416),
                    new Point(172, 403),
                    new Point(161, 403),
                    new Point(146, 373),
                    new Point(135, 373))))); //not every point but its something
		    territories.add(new Territory("Nova York"		, nova_york_n, new ArrayList<Point>(Arrays.asList(
                    new Point(246, 216),
                    new Point(296, 216),
                    new Point(203, 346),
                    new Point(166, 306),
                    new Point(202, 246),
                    new Point(231, 245))))); //not every point but its something
		    territories.add(new Territory("Quebec"			, quebec_n, new ArrayList<Point>(Arrays.asList(
                    new Point(231, 186),
                    new Point(262, 186),
                    new Point(273, 268),
                    new Point(272, 167),
                    new Point(283, 167),
                    new Point(288, 157),
                    new Point(319, 157),
                    new Point(340, 159),
                    new Point(325, 211),
                    new Point(296, 216),
                    new Point(214, 215)))));
		    territories.add(new Territory("Texas"			, texas_n, new ArrayList<Point>(Arrays.asList(
                    new Point(177, 216),
                    new Point(246, 216),
                    new Point(231, 245),
                    new Point(202, 246),
                    new Point(146, 338),
                    new Point(126, 305)))));
		    territories.add(new Territory("Vancouver"		, vancouver_n, new ArrayList<Point>(Arrays.asList(
                    new Point(127,134),
                    new Point(147, 172),
                    new Point(223,173),
                    new Point(231, 186),
                    new Point(214, 216),
                    new Point(107, 216),
                    new Point(110, 163))))); //not every point but its something
		    
		    
			//SA
		    
		    territories.add(new Territory("Argentina"		, argentina_n, new ArrayList<Point>(Arrays.asList(
                    new Point(333.8, 505.0),
                    new Point(302.4, 558.8),
                    new Point(311.2, 573.0),
                    new Point(281.6, 624.5),
                    new Point(295.7, 650.2),
                    new Point(278.1, 650.2),
                    new Point(235.0, 572.4),
                    new Point(239.7, 564.8),
                    new Point(274.9, 505.0)))));
		    territories.add(new Territory("Brasil"			, brasil_n, new ArrayList<Point>(Arrays.asList(
                    new Point(259.6, 407.2),
                    new Point(285.3, 407.2),
                    new Point(293.4, 423.9),
                    new Point(305.7, 423.9),
                    new Point(316.1, 445.2),
                    new Point(335.4, 445.2),
                    new Point(343.3, 461.0),
                    new Point(343.3, 463.1),
                    new Point(325.9, 491.3),
                    new Point(333.8, 505.0),
                    new Point(274.9, 505.0),
                    new Point(233.8, 433.8),
                    new Point(254.3, 398.2)))));
		    territories.add(new Territory("Peru"			, peru_n, new ArrayList<Point>(Arrays.asList(
                    new Point(196.8, 498.1),
                    new Point(202.3, 507.9),
                    new Point(216.1, 507.9),
                    new Point(232.2, 538.5),
                    new Point(226.8, 545.4),
                    new Point(239.7, 564.8),
                    new Point(274.9, 505.0),
                    new Point(233.8, 433.8)))));
		    territories.add(new Territory("Venezuela"		, venezuela_n, new ArrayList<Point>(Arrays.asList(
                    new Point(193.5, 398.2),
                    new Point(254.3, 398.2),
                    new Point(196.8, 498.1),
                    new Point(188.8, 482.2),
                    new Point(176.2, 482.2),
                    new Point(161.2, 455.8),
                    new Point(179.8, 421.9),
                    new Point(188.8, 406.2)))));
		    
		    //AF
		    
		    territories.add(new Territory("Africa Do Sul"	, africa_do_sul_n, new ArrayList<Point>(Arrays.asList(
                    new Point(333.8, 505.0),
                    new Point(302.4, 558.8),
                    new Point(311.2, 573.0),
                    new Point(281.6, 624.5),
                    new Point(295.7, 650.2),
                    new Point(278.1, 650.2),
                    new Point(235.0, 572.4),
                    new Point(239.7, 564.8),
                    new Point(274.9, 505.0)))));
		    territories.add(new Territory("Angola"			, angola_n, new ArrayList<Point>(Arrays.asList(
                    new Point(333.8, 505.0),
                    new Point(302.4, 558.8),
                    new Point(311.2, 573.0),
                    new Point(281.6, 624.5),
                    new Point(295.7, 650.2),
                    new Point(278.1, 650.2),
                    new Point(235.0, 572.4),
                    new Point(239.7, 564.8),
                    new Point(274.9, 505.0)))));
		    territories.add(new Territory("Argelia"			, argelia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(436.7, 337.5),
                    new Point(473.2, 337.5),
                    new Point(479.6, 350.3),
                    new Point(492.5, 350.3),
                    new Point(499.1, 364.1),
                    new Point(539.8, 364.1),
                    new Point(513.0, 410.1),
                    new Point(425.3, 410.1),
                    new Point(409.3, 384.5)))));
		    territories.add(new Territory("Egito"			, egito_n, new ArrayList<Point>(Arrays.asList(
                    new Point(588.6, 360.3),
                    new Point(542.0, 360.3),
                    new Point(539.8, 364.1),
                    new Point(513.0, 410.1),
                    new Point(547.6, 410.1),
                    new Point(562.4, 436.6),
                    new Point(623.6, 436.6),
                    new Point(594.0, 385.3),
                    new Point(597.8, 378.5)))));
		    territories.add(new Territory("Nigeria"			, nigeria_n, new ArrayList<Point>(Arrays.asList(
                    new Point(588.6, 360.3),
                    new Point(542.0, 360.3),
                    new Point(539.8, 364.1),
                    new Point(513.0, 410.1),
                    new Point(547.6, 410.1),
                    new Point(562.4, 436.6),
                    new Point(623.6, 436.6),
                    new Point(594.0, 385.3),
                    new Point(597.8, 378.5)))));
		    territories.add(new Territory("Somalia"			, somalia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(588.6, 360.3),
                    new Point(542.0, 360.3),
                    new Point(539.8, 364.1),
                    new Point(513.0, 410.1),
                    new Point(547.6, 410.1),
                    new Point(562.4, 436.6),
                    new Point(623.6, 436.6),
                    new Point(594.0, 385.3),
                    new Point(597.8, 378.5)))));
		    
		    //EU
		    
		    territories.add(new Territory("Espanha"		, espanha_n, new ArrayList<Point>(Arrays.asList(
                    new Point(442.3, 266.0),
                    new Point(461.0, 266.0),
                    new Point(476.9, 292.5),
                    new Point(475.0, 296.6),
                    new Point(480.0, 296.6),
                    new Point(470.7, 312.3),
                    new Point(452.3, 312.3),
                    new Point(456.4, 304.0),
                    new Point(443.2, 304.0),
                    new Point(440.2, 309.2),
                    new Point(415.9, 309.2)))));
		    territories.add(new Territory("Franca"		, franca_n, new ArrayList<Point>(Arrays.asList(
                    new Point(526.8, 186.6),
                    new Point(538.7, 210.4),
                    new Point(508.1, 263.1),
                    new Point(502.1, 263.1),
                    new Point(494.4, 279.1),
                    new Point(483.7, 279.1),
                    new Point(476.9, 292.5),
                    new Point(461.0, 266.0),
                    new Point(466.7, 255.2),
                    new Point(459.9, 244.7),
                    new Point(452.3, 244.7),
                    new Point(448.2, 235.7),
                    new Point(488.6, 235.7),
                    new Point(499.3, 219.1),
                    new Point(516.2, 219.1),
                    new Point(521.8, 207.7),
                    new Point(517.8, 200.4)))));
		    territories.add(new Territory("Italia"		, italia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(552.4, 210.4),
                    new Point(538.7, 210.4),
                    new Point(508.1, 263.1),
                    new Point(516.6, 263.1),
                    new Point(526.7, 281.8),
                    new Point(533.7, 281.8),
                    new Point(542.5, 298.2),
                    new Point(542.5, 300.2),
                    new Point(537.1, 308.2),
                    new Point(549.2, 308.2),
                    new Point(554.8, 297.3),
                    new Point(556.1, 297.3),
                    new Point(557.4, 299.5),
                    new Point(563.9, 299.5),
                    new Point(563.9, 297.7),
                    new Point(552.8, 277.8),
                    new Point(547.0, 277.8),
                    new Point(539.1, 261.1),
                    new Point(543.5, 253.4),
                    new Point(552.8, 253.4),
                    new Point(555.8, 259.4),
                    new Point(567.5, 237.9)))));
		    territories.add(new Territory("Reino Unido"	, reino_unido_n, new ArrayList<Point>(Arrays.asList(
                    new Point(462.0, 146.2),
                    new Point(481.6, 146.2),
                    new Point(473.7, 156.6),
                    new Point(480.8, 156.6),
                    new Point(470.3, 174.2),
                    new Point(482.7, 198.4),
                    new Point(490.8, 198.4),
                    new Point(484.0, 210.4),
                    new Point(445.5, 210.4),
                    new Point(451.3, 196.1),
                    new Point(458.1, 196.1),
                    new Point(463.2, 188.5),
                    new Point(454.0, 174.2),
                    new Point(459.4, 165.3),
                    new Point(459.4, 163.2),
                    new Point(450.8, 163.2)))));
		    territories.add(new Territory("Polonia"		, polonia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(575.6, 176.1),
                    new Point(583.6, 176.0),
                    new Point(600.8, 205.9),
                    new Point(581.8, 237.9),
                    new Point(567.5, 237.9),
                    new Point(552.4, 210.4),
                    new Point(564.1, 189.0),
                    new Point(569.8, 189.0)))));
		    territories.add(new Territory("Suecia"		, suecia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(551.0, 96.6),
                    new Point(582.5, 96.6),
                    new Point(610.2, 144.5),
                    new Point(602.0, 158.0),
                    new Point(571.5, 158.0),
                    new Point(578.7, 145.7),
                    new Point(569.6, 145.7),
                    new Point(579.6, 127.8),
                    new Point(562.9, 127.8),
                    new Point(552.1, 145.8),
                    new Point(558.1, 156.3),
                    new Point(552.0, 167.3),
                    new Point(555.4, 172.1),
                    new Point(548.3, 183.7),
                    new Point(535.8, 183.7),
                    new Point(530.4, 171.1),
                    new Point(521.7, 171.1),
                    new Point(514.0, 183.7),
                    new Point(501.4, 183.7),
                    new Point(492.1, 166.6),
                    new Point(507.0, 140.6),
                    new Point(522.0, 140.6),
                    new Point(537.1, 111.5),
                    new Point(543.0, 111.5)))));
		    territories.add(new Territory("Romenia"		, romenia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(567.5, 237.9),
                    new Point(555.8, 259.4),
                    new Point(555.8, 262.4),
                    new Point(557.6, 264.2),
                    new Point(566.1, 264.2),
                    new Point(579.8, 288.6),
                    new Point(574.4, 297.5),
                    new Point(581.4, 308.2),
                    new Point(593.2, 308.2),
                    new Point(601.4, 297.4),
                    new Point(595.1, 289.5),
                    new Point(598.3, 283.7),
                    new Point(607.9, 283.7),
                    new Point(581.8, 237.9)))));
		    territories.add(new Territory("Ucrania"		, ucrania_n, new ArrayList<Point>(Arrays.asList(
                    new Point(611.6, 254.4),
                    new Point(620.1, 239.5),
                    new Point(600.8, 205.9),
                    new Point(581.8, 237.9),
                    new Point(607.9, 283.7),
                    new Point(619.0, 264.9)))));
		    
		    //AS
		    
		    territories.add(new Territory("Arabia Saudita"	, arabia_saudita_n, new ArrayList<Point>(Arrays.asList(
                    new Point(646.2, 423.6),
                    new Point(639.1, 434.7),
                    new Point(649.1, 450.3),
                    new Point(699.0, 450.3),
                    new Point(726.6, 403.0),
                    new Point(716.8, 387.3),
                    new Point(680.5, 387.3),
                    new Point(654.0, 342.4),
                    new Point(627.4, 388.2)))));
		    territories.add(new Territory("Bangladesh"		, bangladesh_n, new ArrayList<Point>(Arrays.asList(
                    new Point(885.3, 350.0),
                    new Point(847.8, 350.0),
                    new Point(828.7, 383.5),
                    new Point(842.1, 410.9),
                    new Point(848.1, 410.9),
                    new Point(859.7, 432.6),
                    new Point(854.7, 441.3),
                    new Point(870.5, 470.8),
                    new Point(879.3, 458.8),
                    new Point(879.3, 456.0),
                    new Point(872.2, 444.6),
                    new Point(879.9, 432.5),
                    new Point(859.2, 396.3)))));
		    territories.add(new Territory("Cazaquistao"		, cazaquistao_n, new ArrayList<Point>(Arrays.asList(
                    new Point(907.9, 201.9),
                    new Point(920.4, 222.6),
                    new Point(906.1, 246.4),
                    new Point(784.1, 246.5),
                    new Point(772.1, 224.1),
                    new Point(724.7, 224.1),
                    new Point(739.0, 201.9)))));
		    territories.add(new Territory("China"			, china_n, new ArrayList<Point>(Arrays.asList(
                    new Point(873.9, 278.5),
                    new Point(822.0, 278.5),
                    new Point(804.9, 246.5),
                    new Point(784.1, 246.5),
                    new Point(773.5, 264.0),
                    new Point(764.7, 278.9),
                    new Point(754.8, 297.2),
                    new Point(785.5, 348.8),
                    new Point(785.5, 350.5),
                    new Point(811.9, 350.5),
                    new Point(838.9, 302.5),
                    new Point(887.9, 302.5)))));
		    territories.add(new Territory("Coreia Do Norte"	, coreia_do_norte_n, new ArrayList<Point>(Arrays.asList( 
                    new Point(839.0, 302.2),
                    new Point(825.3, 326.1),
                    new Point(914.9, 326.1),
                    new Point(908.2, 314.2),
                    new Point(894.1, 314.2),
                    new Point(888.0, 302.2)))));
		    territories.add(new Territory("Coreia Do Sul"	, coreia_do_sul_n, new ArrayList<Point>(Arrays.asList(
                    new Point(914.9, 326.1),
                    new Point(922.1, 337.2),
                    new Point(915.5, 350.0),
                    new Point(811.9, 350.0),
                    new Point(825.3, 326.1)))));
		    territories.add(new Territory("Estonia"			, estonia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(735.3, 123.8),
                    new Point(659.5, 123.8),
                    new Point(650.1, 144.1),
                    new Point(630.0, 144.1),
                    new Point(614.8, 117.0),
                    new Point(628.2, 117.0),
                    new Point(632.0, 124.2),
                    new Point(644.4, 124.2),
                    new Point(632.6, 101.5),
                    new Point(607.8, 101.5),
                    new Point(604.9, 96.6),
                    new Point(582.5, 96.6),
                    new Point(626.8, 173.1),
                    new Point(706.8, 173.1)))));
		    territories.add(new Territory("India"			, india_n, new ArrayList<Point>(Arrays.asList(
                    new Point(798.0, 450.3),
                    new Point(763.8, 387.8),
                    new Point(785.5, 351.2),
                    new Point(785.5, 350.0),
                    new Point(847.8, 350.0),
                    new Point(808.0, 420.0),
                    new Point(812.3, 427.5)))));
		    territories.add(new Territory("Ira"				, ira_n, new ArrayList<Point>(Arrays.asList(
                    new Point(716.8, 310.2),
                    new Point(701.1, 310.2),
                    new Point(691.0, 329.0),
                    new Point(703.0, 351.2),
                    new Point(716.5, 375.9),
                    new Point(733.6, 375.9),
                    new Point(739.9, 387.8),
                    new Point(751.3, 370.1)))));
		    territories.add(new Territory("Iraque"			, iraque_n, new ArrayList<Point>(Arrays.asList(
                    new Point(703.0, 351.2),
                    new Point(694.0, 362.7),
                    new Point(694.0, 364.8),
                    new Point(706.5, 387.3),
                    new Point(680.5, 387.3),
                    new Point(654.0, 342.4),
                    new Point(671.9, 310.2),
                    new Point(701.1, 310.2),
                    new Point(691.0, 329.0)))));
		    territories.add(new Territory("Japao"			, japao_n, new ArrayList<Point>(Arrays.asList(
                    new Point(937.3, 222.4),
                    new Point(956.3, 254.3),
                    new Point(953.7, 257.5),
                    new Point(965.5, 276.8),
                    new Point(955.4, 293.3),
                    new Point(947.6, 293.3),
                    new Point(940.0, 307.4),
                    new Point(921.9, 307.4),
                    new Point(930.2, 293.0),
                    new Point(927.9, 288.6),
                    new Point(933.8, 279.7),
                    new Point(939.4, 279.7),
                    new Point(943.7, 269.9),
                    new Point(927.1, 239.4)))));
		    territories.add(new Territory("Jordania"		, jordania_n, new ArrayList<Point>(Arrays.asList(
                    new Point(621.9, 378.5),
                    new Point(612.8, 378.5),
                    new Point(602.1, 357.1),
                    new Point(615.7, 337.6),
                    new Point(633.6, 337.6),
                    new Point(649.1, 310.2),
                    new Point(671.9, 310.2),
                    new Point(654.0, 342.4),
                    new Point(627.4, 388.2)))));
		    territories.add(new Territory("Letonia"			, letonia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(610.2, 144.5),
                    new Point(591.0, 176.0),
                    new Point(583.6, 176.0),
                    new Point(611.2, 224.1),
                    new Point(724.7, 224.1),
                    new Point(739.0, 201.9),
                    new Point(724.7, 173.1),
                    new Point(626.8, 173.1)))));
		    territories.add(new Territory("Mongolia"		, mongolia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(906.1, 246.4),
                    new Point(804.9, 246.4),
                    new Point(822.0, 278.5),
                    new Point(873.9, 278.5),
                    new Point(894.6, 278.5),
                    new Point(906.1, 300.4),
                    new Point(916.3, 287.4),
                    new Point(902.8, 264.5),
                    new Point(910.3, 254.7)))));
		    territories.add(new Territory("Paquistao"		, paquistao_n, new ArrayList<Point>(Arrays.asList(
                    new Point(763.8, 387.8),
                    new Point(739.9, 387.8),
                    new Point(751.3, 370.1),
                    new Point(708.9, 296.4),
                    new Point(718.3, 278.9),
                    new Point(764.7, 278.9),
                    new Point(754.8, 297.2),
                    new Point(785.5, 348.8),
                    new Point(785.5, 351.2)))));
		    territories.add(new Territory("Russia"			, russia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(744.4, 125.0),
                    new Point(742.5, 129.9),
                    new Point(748.2, 129.9),
                    new Point(744.1, 136.7),
                    new Point(728.4, 136.7),
                    new Point(706.7, 173.1),
                    new Point(724.7, 173.1),
                    new Point(739.0, 201.9),
                    new Point(825.0, 201.9),
                    new Point(869.9, 125.0)))));
		    territories.add(new Territory("Siberia"			, siberia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(949.4, 204.5),
                    new Point(956.8, 191.1),
                    new Point(940.9, 162.5),
                    new Point(947.1, 155.2),
                    new Point(940.9, 144.4),
                    new Point(954.0, 144.4),
                    new Point(937.8, 117.0),
                    new Point(875.3, 117.0),
                    new Point(870.6, 124.9),
                    new Point(825.0, 201.9),
                    new Point(888.4, 201.9),
                    new Point(877.3, 187.8),
                    new Point(885.4, 176.1),
                    new Point(907.5, 176.1),
                    new Point(916.3, 159.9),
                    new Point(930.5, 183.1),
                    new Point(938.0, 183.1)))));
		    territories.add(new Territory("Siria"			, siria_n, new ArrayList<Point>(Arrays.asList(
                    new Point(660.8, 272.8),
                    new Point(664.6, 278.9),
                    new Point(718.3, 278.9),
                    new Point(708.9, 296.4),
                    new Point(716.8, 310.2),
                    new Point(637.0, 310.2),
                    new Point(637.0, 306.2),
                    new Point(628.7, 306.6),
                    new Point(619.6, 291.5),
                    new Point(628.7, 275.8),
                    new Point(646.1, 275.8),
                    new Point(647.3, 272.8)))));
		    territories.add(new Territory("Tailandia"		, tailandia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(915.5, 350.0),
                    new Point(885.3, 350.0),
                    new Point(859.2, 396.3),
                    new Point(879.9, 432.5),
                    new Point(887.3, 446.2),
                    new Point(895.1, 446.2),
                    new Point(901.8, 432.5),
                    new Point(897.5, 426.0),
                    new Point(901.8, 420.7),
                    new Point(887.0, 398.1),
                    new Point(892.9, 389.8),
                    new Point(895.9, 395.1),
                    new Point(908.7, 395.1),
                    new Point(911.4, 387.6),
                    new Point(919.1, 387.6),
                    new Point(927.4, 370.3)))));
		    territories.add(new Territory("Turquia"			, turquia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(683.6, 278.9),
                    new Point(691.0, 268.9),
                    new Point(678.5, 247.4),
                    new Point(668.1, 247.4),
                    new Point(664.5, 240.9),
                    new Point(651.9, 240.9),
                    new Point(646.3, 251.2),
                    new Point(639.4, 239.5),
                    new Point(620.1, 239.5),
                    new Point(611.2, 224.1),
                    new Point(772.1, 224.1),
                    new Point(784.1, 246.4),
                    new Point(764.7, 278.9)))));
		    
		    //OC
		    
		    territories.add(new Territory("Australia"		, australia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(875.1, 539.4),
                    new Point(885.9, 539.4),
                    new Point(919.7, 598.0),
                    new Point(911.5, 611.8),
                    new Point(917.6, 623.4),
                    new Point(901.8, 650.0),
                    new Point(891.1, 650.0),
                    new Point(877.6, 673.5),
                    new Point(846.1, 673.5),
                    new Point(837.9, 655.8),
                    new Point(823.4, 655.8),
                    new Point(816.7, 641.9)))));
		    territories.add(new Territory("Indonesia"		, indonesia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(850.9, 480.7),
                    new Point(861.3, 500.4),
                    new Point(880.7, 500.4),
                    new Point(887.7, 486.3),
                    new Point(902.5, 486.3),
                    new Point(907.6, 498.3),
                    new Point(925.2, 498.3),
                    new Point(935.6, 517.9),
                    new Point(943.8, 517.9),
                    new Point(954.3, 536.6),
                    new Point(928.3, 536.6),
                    new Point(920.3, 522.0),
                    new Point(907.2, 522.0),
                    new Point(904.7, 528.9),
                    new Point(890.3, 528.9),
                    new Point(885.3, 517.5),
                    new Point(849.0, 517.5),
                    new Point(835.2, 490.0),
                    new Point(841.0, 480.7)))));
		    territories.add(new Territory("Nova Zelandia"	, nova_zelandia_n, new ArrayList<Point>(Arrays.asList(
                    new Point(928.8, 601.5),
                    new Point(936.9, 601.5),
                    new Point(943.0, 613.7),
                    new Point(939.8, 616.5),
                    new Point(944.2, 616.5),
                    new Point(950.3, 628.6),
                    new Point(931.9, 661.5),
                    new Point(926.6, 661.5),
                    new Point(917.6, 678.5),
                    new Point(900.1, 678.5),
                    new Point(917.6, 644.5),
                    new Point(922.9, 644.5),
                    new Point(932.3, 627.8),
                    new Point(928.0, 619.1),
                    new Point(934.1, 610.0)))));
		    territories.add(new Territory("Perth"			, perth_n, new ArrayList<Point>(Arrays.asList(
                    new Point(856.7, 535.5),
                    new Point(839.2, 535.5),
                    new Point(822.3, 565.8),
                    new Point(799.1, 565.8),
                    new Point(789.6, 584.3),
                    new Point(781.3, 584.3),
                    new Point(775.3, 595.7),
                    new Point(775.3, 598.3),
                    new Point(782.3, 608.6),
                    new Point(782.3, 610.7),
                    new Point(770.9, 630.1),
                    new Point(763.5, 630.1),
                    new Point(756.7, 639.9),
                    new Point(766.4, 655.8),
                    new Point(780.3, 655.8),
                    new Point(787.3, 641.9),
                    new Point(816.7, 641.9),
                    new Point(861.6, 562.1),
                    new Point(855.6, 550.2),
                    new Point(862.4, 542.3)))));
		    
	}
}
