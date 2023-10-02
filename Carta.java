public class Carta {
    private String nome;
    private String imagem;
    private String tipo;
    private String raridade;
    protected int ataque;
    protected int defesa;
    private int custo;
    private int habilidade = 0;
    private int quantidade;

    public Carta(String nome, String imagem, String tipo, String raridade, int ataque, int defesa, int custo, int habilidade, int quantidade) {
        this.nome = nome;
        this.imagem = imagem;
        this.tipo = tipo;
        this.raridade = raridade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.custo = custo;
        this.habilidade = habilidade;
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
    public String getRaridade() {
        return raridade;
    }
    public void setRaridade(String raridade) {
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
}