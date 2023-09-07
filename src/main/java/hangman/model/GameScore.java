package hangman.model;

public interface GameScore {

    /**
     * @param CorrectCount
     * @param IncorrectCount
     * @return score
     */
    int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException;
}
