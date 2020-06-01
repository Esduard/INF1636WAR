package model;

import java.util.ArrayList;

public enum GameColor {
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
}
