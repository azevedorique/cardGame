import java.util.Random;

public class PasseComum extends Progresso{
    public int nivelAtual;
    public boolean passeCompleto;

    public PasseComum() {
        this.nivelAtual = 0;
        this.passeCompleto = false;
    }
    public void progresso() {
        if (!passeCompleto) {
             nivelAtual++;
        }
       
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
     for (int i = 1; i <= 12; i++) {
        String carta = gerarCartaAleatoria();
        System.out.println("Carta " + carta + " adquirida");
     }
    }
    private String gerarCartaAleatoria() {
        String[] cartas = {"carta1, carta2, carta3, carta4, carta5, carta6, carta7, carta8, carta9, carta10, carta11, carta12"};
        Random random = new Random();
        int indice = random.nextInt(cartas.length);
        return cartas[indice];

    }
}
