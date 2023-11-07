import java.util.Random;

public class CartaUnica extends Carta implements Ativacao{
    private int ataque;
    private int defesa;
    private String habilidadePadrao;


    public CartaUnica() {
        super();
        this.ataque += 1;
        this.defesa += 1;
        this.habilidadePadrao += ", " + gerarHabilidadeAleatoria();
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
    public String getHabilidadePadrao() {
        return habilidadePadrao;
    }
    public void setHabilidadePadrao(String habilidadePadrao) {
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
            String[] habilidades = habilidadePadrao.split(", ");
            for (String hab : habilidades) {
                System.out.println("Ativando habilidade: " + hab);
            }
        } else if (habilidade != null) {
            System.out.println("Ativando habilidade: " + habilidade);
        } else {
            System.out.println("Carta não possui habilidades.");
        }
    }
}