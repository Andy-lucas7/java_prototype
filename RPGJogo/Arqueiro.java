// Arqueiro.java
import java.util.Random;

public class Arqueiro extends Personagem {

    private Random aleatorio = new Random();
    private int flechas = 20; // Recurso especial do Arqueiro

    public Arqueiro(String nome) {
        // Arqueiros são equilibrados.
        super(nome, 100, 20, 7);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " dispara uma flecha precisa em " + alvo.getNome() + "!");
        int danoBase = this.ataque;
        
        // Chance de 25% de um acerto crítico!
        if (aleatorio.nextInt(100) < 25) {
            System.out.println("ACERTO CRÍTICO!");
            danoBase *= 1.5; // Dano aumenta em 50%
        }
        
        int danoReal = danoBase - alvo.defesa;
        if (danoReal < 0) danoReal = 0;
        
        alvo.receberDano(danoReal);
        this.flechas++; // Recupera uma flecha
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (this.flechas >= 3) {
            System.out.println(this.nome + " utiliza CHUVA DE FLECHAS!");
            int danoPorFlecha = 8;
            alvo.receberDano(danoPorFlecha);
            alvo.receberDano(danoPorFlecha);
            alvo.receberDano(danoPorFlecha);
            this.flechas -= 3;
        } else {
            System.out.println("Flechas insuficientes!");
        }
    }
    
    @Override
    public void mostrarStatus() {
        // Sobrescrevemos para mostrar as flechas também
        System.out.printf("   - %s (Vida: %d/%d | Flechas: %d)\n", this.nome, this.vida, this.vidaMaxima, this.flechas);
    }
}