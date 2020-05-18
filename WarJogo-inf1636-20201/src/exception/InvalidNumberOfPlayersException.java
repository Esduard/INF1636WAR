package exception;

public class InvalidNumberOfPlayersException extends Exception {
	
	public InvalidNumberOfPlayersException(int n)
	{
		System.out.print("The number of players is invalid, it must be between 3 and 6 (inclusive)");
	}
	
}
