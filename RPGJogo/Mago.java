// Mago.java
import java.util.Random;

public class Mago extends Personagem {

    private Random aleatorio = new Random();
    private int mana = 100; // Recurso especial do Mago
    private int manaMaxima = 100;

    public Mago(String nome) {
        // Magos têm menos vida e defesa, mas mais ataque.
        super(nome, 80, 25, 5);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " lança um raio arcano em " + alvo.getNome() + "!");
        int danoBase = this.ataque + aleatorio.nextInt(8);
        int danoReal = danoBase - alvo.defesa; // Magos ignoram parte da defesa, por exemplo
        
        if (danoReal < 0) danoReal = 0;

        alvo.receberDano(danoReal);
        this.mana += 5; // Recupera um pouco de mana no ataque básico
        if (this.mana > this.manaMaxima) this.mana = this.manaMaxima;
        System.out.println(this.nome + " agora tem " + this.mana + " de mana.");
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (this.mana >= 40) {
            System.out.println(this.nome + " conjura uma gigantesca BOLA DE FOGO!");
            int danoEspecial = 50 + aleatorio.nextInt(21); // Dano mágico alto e variável
            alvo.receberDano(danoEspecial);
            this.mana -= 40; // Gasta a mana
        } else {
            System.out.println("Mana insuficiente! O feitiço falhou.");
        }
    }
    
    @Override
    public void mostrarStatus() {
        // Sobrescrevemos para mostrar a mana também
        System.out.printf("   - %s (Vida: %d/%d | Mana: %d/%d)\n", this.nome, this.vida, this.vidaMaxima, this.mana, this.manaMaxima);
    }
}