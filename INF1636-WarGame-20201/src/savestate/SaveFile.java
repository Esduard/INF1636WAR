package savestate;

import controller.GameController;
import controller.TurnController;
import model.GameExecution;

public class SaveFile {
	
private GameExecution singletonGameExecution;
	
	private GameController singletonGameController;
	
	private TurnController singletonTurnController;
	
	
	public SaveFile(){
			
			singletonGameExecution = GameExecution.getGameExecution();
			
			singletonGameController = GameController.getGameController();
			
			singletonTurnController = TurnController.getTurnController();
			
		}
	
	public void loadSaveFile() {
		
		GameExecution.setGameExecution(singletonGameExecution);
		GameController.setGameController(singletonGameController);
		TurnController.setTurnController(singletonTurnController);
		
	}

}
