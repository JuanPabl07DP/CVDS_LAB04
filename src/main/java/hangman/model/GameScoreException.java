package hangman.model;
// Excepciones para test
public class GameScoreException extends Exception{
    public static final String INVALID_PARAMETERS = "Parámetros inválidos (Negativos)";
    public GameScoreException(String mensaje){
        super(mensaje);
    }
}