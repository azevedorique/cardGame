public class CartaComum extends Carta {
    private int ataque;
    private int defesa;
    private String habilidadePadrao;

    
    public CartaComum() {
        super();
        this.ataque = 1;
        this.defesa = 1;
        this.habilidadePadrao = gerarHabilidadeAleatoria();
    }

    private String gerarHabilidadeAleatoria() {
        String[] habilidades = {"Habilidade1", "Habilidade2", "Habilidade3"};
        int indiceAleatorio = (int) (Math.random() * habilidades.length);
        return habilidades[indiceAleatorio];
    }
}