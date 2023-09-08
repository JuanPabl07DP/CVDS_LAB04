package hangman.model;

public class PowerBonusScore implements GameScore {
    /**
     * @pre Inicia con 0 puntos y con un puntaje minimo 0
     * @pos Se bonifica con 10 puntos cada letra correcta, se penaliza con -5 puntos letra incorrecta
     * @param CorrectCount
     * @param IncorrectCount
     * @return Score
     */
    public int CalculateScore(int CorrectCount, int IncorrectCount) throws GameScoreException{
        if(CorrectCount < 0 || IncorrectCount < 0) {throw new GameScoreException(GameScoreException.INVALID_PARAMETERS);}
        int score = 0;
        if(CorrectCount > 0){
            for(int x = 0; x < CorrectCount; x++){
                score += Math.pow(5,x+1);
            }
        }
        if(IncorrectCount > 0 ){
            score -= 8 * IncorrectCount;
        }
        if (score >= 500){ score = 500;}
        if (score < 0){score = 0;}
        return score;
    }
}