public class CartaComum extends Carta implements Ativacao{
    private int ataque;
    private int defesa;
    private String habilidadePadrao;

    
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
    public String getHabilidadePadrao() {
        return habilidadePadrao;
    }
    public void setHabilidadePadrao(String habilidadePadrao) {
        this.habilidadePadrao = habilidadePadrao;
    }

    private String gerarHabilidadeAleatoria() {
        String[] habilidades = {"Habilidade1", "Habilidade2", "Habilidade3"};
        int indiceAleatorio = (int) (Math.random() * habilidades.length);
        return habilidades[indiceAleatorio];
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