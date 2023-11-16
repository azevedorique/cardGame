public class IrregularDeckException extends Exception {
    public IrregularDeckException() {
        super();
    }
    @Override
    public String toString(){
        return "Este deck não é válido!";
    }
    
}
