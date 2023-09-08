package hangman;
import hangman.model.*;
import org.junit.Assert;
import org.junit.Test;
public class GameScoreTest {
    @Test
    public void validateInvalidParameters() {
        GameScore game;
        try {
            game = new OriginalScore();
            game.CalculateScore(-1, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
        try {
            game = new PowerBonusScore();
            game.CalculateScore(-1, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }

        try {
            game = new BonusScore();
            game.CalculateScore(-1, -3);
            Assert.assertTrue(false);
        } catch (GameScoreException e) {
            Assert.assertTrue(true);
        }
    }


    @Test
    public void validOriginScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.CalculateScore(10,0);
        Assert.assertTrue(score == 100);
    }

    @Test
    public void validOriginScorePenalty() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.CalculateScore(3,5);
        Assert.assertTrue(score == 50);
    }
    @Test
    public void validOriginScoreMinScore() throws GameScoreException {
        GameScore game = new OriginalScore();
        int score = game.CalculateScore(8,11);
        Assert.assertTrue(score == 0);
    }

    @Test
    public void validBonusScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.CalculateScore(10,0);
        Assert.assertTrue(score == 100);
    }

    @Test
    public void validBonusScoreCorrectLettersAndPenalty() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.CalculateScore(10,8);
        Assert.assertTrue(score == 60);
    }


    @Test
    public void validBonusScoreCorrectMinScore() throws GameScoreException {
        GameScore game = new BonusScore();
        int score = game.CalculateScore(10,20);
        Assert.assertTrue(score == 0);
    }

    @Test
    public void validPowerScoreOnlyCorrectLetters() throws GameScoreException {
        GameScore game = new PowerBonusScore();
        int score = game.CalculateScore(3,0);
        Assert.assertTrue(score == 155);
    }

    @Test
    public void validPowerScoreCorrectMinScore() throws GameScoreException {
        GameScore game = new PowerBonusScore();
        int score = game.CalculateScore(0,1);
        Assert.assertTrue(score == 0);
    }

    @Test
    public void validPowerScoreCorrectMaxScore() throws GameScoreException {
        GameScore game = new PowerBonusScore();
        int score = game.CalculateScore(4,1);
        Assert.assertTrue(score == 500);
    }

    @Test
    public void validPowerScoreCorrectLettersAndPenalty() throws GameScoreException {
        GameScore game = new PowerBonusScore();
        int score = game.CalculateScore(3,1);
        Assert.assertTrue(score == 147);
    }
}