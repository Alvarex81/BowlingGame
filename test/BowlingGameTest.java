import edu.grupo2.Game.Game;
import edu.grupo2.Game.InitiateGame;
import edu.grupo2.Game.InitiateSingleGame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void testInitialGameWithScoreZero() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(0,g.getLines().get(0).getScores()[9]);
    }
    @Test
    public void testOneSpareGame() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan",5,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(16,g.getLines().get(0).getScores()[9]);
    }
    @Test
    public void testOneStrikeGame() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan",10,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(24,g.getLines().get(0).getScores()[9]);
    }
    @Test
    public void testPerfectGame() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan",10,10,10,10,10,10,10,10,10,10,10,10);
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(300,g.getLines().get(0).getScores()[9]);
    }
    @Test
    public void testAllFoulsGameWith() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F","F");
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(0,g.getLines().get(0).getScores()[9]);
    }
    @Test
    public void testNearPerfectGameWithZero() {
        Game g = new Game();
        InitiateGame initiator = new InitiateSingleGame();
        g.addNewPlayer("Juan");
        g.addRolls("Juan",10,10,10,10,10,10,10,10,10,0,0);
        initiator.start(g);
        g.calculatePuntuation();
        assertEquals(240,g.getLines().get(0).getScores()[9]);
    }
}