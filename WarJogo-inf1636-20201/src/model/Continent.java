package model;

import java.util.*;

class Continent {
	private String name;
	private Territory[] territories;
	private int bonusArmy;
	
	private static ArrayList<Continent> continents = new ArrayList<Continent>(6);
	
	//Index for each continent on Continents List
	public static final int NA = 0;
	public static final int SA = 1;
    public static final int AF = 2;
    public static final int EU = 3;
	public static final int AS = 4;
    public static final int OC = 5;
	
	public Continent (String n, Territory[] t, int b) {
		name = n;
		territories = t;
		bonusArmy = b;
	}
	
	public Territory[] getTerritories()
	{
		return territories;
	}
	
	public String  getName() {
		return name;
	}
	
	public int getBonusArmy() {
		return bonusArmy;
	}
	
	public static List<Continent> getContinentList()
	{
		return Collections.unmodifiableList(continents);
	}
	
	public static void initialize()
	{
		//initialize territories and continents
		
	    List<Territory> territoryList = Territory.getTerritoriesList();
	    
	  //public Territory(String n, Color c, ArrayList<String> neighbors );
		
		//NA
	    Territory[] northAmerica = new Territory[9];
	    int cont_all_territories = 0;
	    
	    for(int i = 0; i < 9; i++)
	    {
	    	 northAmerica[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("América do Norte", northAmerica, 5));
	    
		//SA
	    Territory[] southAmerica = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 southAmerica[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("América do Sul", southAmerica, 2));
	    
	    //AF
	    Territory[] africa = new Territory[6];
	    
	    for(int i = 0; i < 6; i++)
	    {
	    	 africa[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("África", africa, 3));
	    
	    //EU
	    Territory[] europe = new Territory[8];
	    
	    for(int i = 0; i < 8; i++)
	    {
	    	 europe[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("Europa", europe, 5));
	    
	    //AS
	    Territory[] asia = new Territory[20];
	    
	    for(int i = 0; i < 20; i++)
	    {
	    	 asia[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("Asia", asia, 7));
	    
	    //OC
	    Territory[] oceania = new Territory[4];
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	 oceania[i] = territoryList.get(cont_all_territories);
	    	 cont_all_territories++;
	    }
	    
	    continents.add(new Continent("Oceania", oceania, 2));
	}
}
