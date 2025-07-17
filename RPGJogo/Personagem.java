// Personagem.java
// Esta é uma classe ABSTRATA. Ela serve como um modelo para outras classes.
// Não podemos criar um "new Personagem()", apenas um "new Guerreiro()", etc.
public abstract class Personagem {

    // Atributos protegidos podem ser acessados diretamente pelas classes filhas.
    protected String nome;
    protected int vida;
    protected int vidaMaxima;
    protected int ataque;
    protected int defesa;

    // Construtor que será chamado pelas classes filhas
    public Personagem(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida; // A vida máxima começa igual à vida inicial
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Método concreto: a lógica é a mesma para todos os personagens.
    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(">> " + this.nome + " sofreu " + dano + " de dano! Vida atual: " + this.vida);
    }

    // Método concreto
    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Método concreto
    public void mostrarStatus() {
        System.out.printf("   - %s (Vida: %d/%d)\n", this.nome, this.vida, this.vidaMaxima);
    }

    // Métodos ABSTRATOS: Cada classe filha (Guerreiro, Mago, etc.)
    // será OBRIGADA a ter sua própria implementação destes métodos.
    public abstract void atacar(Personagem alvo);
    public abstract void usarHabilidadeEspecial(Personagem alvo);

    // Getter para o nome
    public String getNome() {
        return nome;
    }
}