package model;

import java.util.ArrayList;

enum GameColor {
	Branco,
	Preto,
	Azul,
	Amarelo,
	Verde,
	Vermelho,
	Count;
	
	public static ArrayList<String> getColorNames()
    {
    	ArrayList<String> s = new ArrayList<String>();
    	
    	GameColor[] c = GameColor.values();
    	
    	for(int i = 0; i < GameColor.Count.ordinal(); i++)
    	{
    		s.add(c[i].toString());
    	}
    	
    	return s;
    }
	
	public String getColorCode()
	{
		switch(this)
		{
		case Amarelo:
			return "#ffff00";
		case Azul:
			return "#0080ff";
		case Branco:
			return "#ffffff";
		case Preto:
			return "#000000";
		case Verde:
			return "#00ff00";
		case Vermelho:
			return "#b30505";
		default:
			return null;
		}
	}
}
