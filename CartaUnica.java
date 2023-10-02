public class CartaUnica extends Carta {
    private int ataque;
    private int defesa;
    private String habilidadePadrao;


    public CartaUnica() {
        super();
        this.ataque += 1;
        this.defesa += 1;
        this.habilidadePadrao += ", " + gerarHabilidadeAleatoria();
    }



    private String gerarHabilidadeAleatoria() {
        return null;
    }
}