public class PasseComum extends Progresso{
    public int nivelAtual;
    public boolean passeCompleto;

    public PasseComum() {
        this.nivelAtual = 0;
        this.passeCompleto = false;
    }
    public void progresso() {
        nivelAtual++;
    }

    public void entregarPremiacao() {
        if (!passeCompleto) {
            abrirBooster();
        }
        else {
            System.out.println("Fim do passe de batalha");
        }
    }
    public boolean passeCompleto() {
        return passeCompleto;
    }
    private void abrirBooster() {
     System.out.println("Você ganhou um booster comum");
    }
}
