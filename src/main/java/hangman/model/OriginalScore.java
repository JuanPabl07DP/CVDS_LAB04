package hangman.model;

public class OriginalScore implements GameScore {
    /**
     * @pre
     * @pos
     * @param CorrectCount
     * @param IncorrectCount
     * @return score
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException{
        if(CorrectCount < 0 || IncorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 100;
        if(IncorrectCount > 0 ){
            score -= IncorrectCount * 10;
        }
        if(score < 0 ){ score = 0;}

        return score;
    }

}
