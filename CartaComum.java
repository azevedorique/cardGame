import java.util.Random;

public class CartaComum extends Carta implements Ativacao{
    private int ataque;
    private int defesa;
    private Habilidade habilidadePadrao;

    
    public CartaComum() {
        super();
        this.ataque = 1;
        this.defesa = 1;
        this.habilidadePadrao = gerarHabilidadeAleatoria();
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public Habilidade getHabilidadePadrao() {
        return habilidadePadrao;
    }
    public void setHabilidadePadrao(Habilidade habilidadePadrao) {
        this.habilidadePadrao = habilidadePadrao;
    }

      private Habilidade gerarHabilidadeAleatoria() {
        Habilidade[] habilidades = Habilidade.values();
        Random random = new Random();
        int index = random.nextInt(habilidades.length);
        return habilidades[index];
 
    }

    public void ativarHabilidade(Habilidade habilidade){
        if (habilidadePadrao != null) {
            System.out.println("Ativando habilidade padrão: " + habilidadePadrao);
        } else if (habilidade != null) {
            System.out.println("Ativando habilidade: " + habilidade);
        } else {
            System.out.println("Carta não possui habilidades.");
        }
    }
}