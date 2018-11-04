import org.omg.CORBA.Current;

public class GameStatus {

  protected enum CurrentGameStatus {
    GAME_IN_PROGRESS, GAME_OVER_PLAYER_LOST, GAME_OVER_PLAYER_WON;
  }

 protected static CurrentGameStatus theCurrentGameStatus;


}
