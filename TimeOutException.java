public class TimeOutException extends Exception {
    public TimeOutException() {
        super();

    }
    @Override
    public String toString() {
        return "Procurando oponente do mesmo nível...";
    }
    
}
