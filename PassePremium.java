import java.util.Random;

public class PassePremium extends Progresso {
    public int nivelAtual;
    public boolean passeCompleto;

    public PassePremium() {
        this.nivelAtual = 0;
        this.passeCompleto = false;
 
}
public void progresso() {
    if(!passeCompleto) {
        nivelAtual = nivelAtual + 2;
    }
}
public void entregarPremiacao() {
    if(!passeCompleto && nivelAtual % 5 == 0) {
        abrirBoosterEspecial();
    }
    else if (!passeCompleto && nivelAtual % 5 != 0) {
        abrirBoosterComum();
    }
    else {
        System.out.println("Fim do passe de batalha");
        
    }
}
public boolean passeCompleto() {
    return passeCompleto;
}
private void abrirBoosterComum() {
    System.out.println("Você ganhou um booster comum");
    for (int i = 1; i <= 12; i++) {
       Carta carta = gerarCartaAleatoria();
       System.out.println("Carta " + carta + " adquirida");
    }
}
private void abrirBoosterEspecial() {
    System.out.println("Você ganhou um booster Especial");
    for (int i = 1; i <= 24; i++) {
       Carta carta = gerarCartaAleatoria();
       System.out.println("Carta " + carta + " adquirida");
    }
}
private Carta gerarCartaAleatoria() {
        Carta[] cartas = new Carta[12];
        Random random = new Random();
        int indice = random.nextInt(cartas.length);
        return cartas[indice];

    }
}