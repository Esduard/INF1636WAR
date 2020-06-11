import java.util.*;

import controller.GameController;
import model.*;
import view.GameScreen;

class Program {
	
	public static void main(String[] args) {
//		System.out.println("-------------TEST MODEL INTIALIZE---------------");
//		
//		TEST.testCreatePlayerList();
//		TEST.testAddPlayers();
//		TEST.testValidateCardTrade();
//		TEST.testValidateAttack();
//		TEST.testAttackResult();
//		TEST.testMoveTroops();
//		TEST.testObjectiveValidation();
		
		GameController gC = GameController.getGameController();
		GameScreen gS = GameScreen.getGameScreen();
		gC.addObserver(gS);
		}
	
}
