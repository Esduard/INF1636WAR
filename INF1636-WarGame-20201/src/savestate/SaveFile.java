package savestate;

import java.io.Serializable;
import controller.TurnController;
import model.GameExecution;



public class SaveFile implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameExecution singletonGameExecution;
	private TurnController singletonTurnController;
	
	
	public SaveFile(){
			
			singletonGameExecution = GameExecution.getGameExecution();
			singletonTurnController = TurnController.getTurnController();
			
		}
	
	public void loadSaveFile() {
		
		GameExecution.setGameExecution(singletonGameExecution);
		TurnController.setTurnController(singletonTurnController);
		
	}

}
