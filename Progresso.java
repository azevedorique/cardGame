public abstract class Progresso {
    public String[] premiacoes;
    public int premiacaoAtual;

    public Progresso() {
        this.premiacoes = new String[60];
        this.premiacaoAtual = 0;
    }
    public abstract void entregarPremiacao();
    public abstract void progresso();
}