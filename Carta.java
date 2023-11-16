 import java.util.Random;

public class Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private Raridade raridade;
    protected int ataque;
    protected int defesa;
    private int custo;
    private int habilidade = 0;
    private int quantidade;
    private int pontosVida;

    public Carta(String nome, String imagem, String tipo, Raridade raridade, int ataque, int defesa, int custo, int quantidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = gerarRaridade();
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        if (tipo.equals("Mana")) {
            this.quantidade = quantidade;
        }
        else {
           this.quantidade = Math.min(quantidade,3);
        }
    }
    public Carta() {
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Raridade getRaridade() {
        return raridade;
    }
    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
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
    public int getCusto() {
        return custo;
    }
    public void setCusto(int custo) {
        this.custo = custo;
    }
    public int getHabilidade() {
        return habilidade;
    }
    public void setHabilidade(int habilidade) {
        this.habilidade = habilidade;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (tipo.equals("Mana")) {
            this.quantidade = quantidade;
        }
        else {
           this.quantidade = Math.min(quantidade,3);
        }
    }
    public int getPontosVida() {
        return pontosVida;
    }
    private static Raridade gerarRaridade() {
        Random random = new Random();
        double probabilidadeTotal = 0.0;
        double probabilidadeAleatoria = random.nextDouble();

        for (Raridade raridade : Raridade.values()) {
            probabilidadeTotal += raridade.getProbabilidade();
            if (probabilidadeAleatoria <= probabilidadeTotal) {
                return raridade;
            }
        }
 
        return Raridade.COMUM;
    }
}