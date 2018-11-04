/**
 * GameStatus.java
 *
 * Tracks whether the PlayerCharacter has won or lost the battle, and whether the game is over.
 */
public class GameStatus {

  protected enum CurrentGameStatus {
    GAME_IN_PROGRESS,
    GAME_OVER_PLAYER_LOST,
    GAME_OVER_PLAYER_WON
  }

 static CurrentGameStatus theCurrentGameStatus;


}
