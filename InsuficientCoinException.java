public class InsuficientCoinException extends Exception{
    private int saldoAtual;
    public InsuficientCoinException(int saldoAtual) {
        super();
        this.saldoAtual = saldoAtual;
    }
    @Override
    public String toString() {
        return "Seu saldo de " + saldoAtual + "card coins não é suficiente para comprar este booster!";
    }
}
