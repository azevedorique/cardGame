public enum Raridade {
    COMUM(0.75),
    INCOMUM(0.10),
    RARA(0.08),
    MUITO_RARA(0.05),
    EPICA(0.02);

    private double probabilidade;

    private Raridade(double probabilidade) {
        this.probabilidade = probabilidade;
    }
    public double getProbabilidade() {
        return probabilidade;
    }

}
