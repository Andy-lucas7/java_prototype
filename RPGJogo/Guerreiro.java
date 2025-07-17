// Guerreiro.java
import java.util.Random;

// A classe Guerreiro HERDA tudo o que a classe Personagem tem.
public class Guerreiro extends Personagem {

    private Random aleatorio = new Random();
    private int furia = 0; // Recurso especial do Guerreiro

    public Guerreiro(String nome) {
        // Chama o construtor da classe pai (Personagem) com os status base do Guerreiro.
        // Formato: super(nome, vida, ataque, defesa)
        super(nome, 150, 15, 10);
    }

    // Implementação obrigatória do método abstrato da classe pai
    @Override
    public void atacar(Personagem alvo) {
        System.out.println(this.nome + " desfere um golpe de espada em " + alvo.getNome() + "!");
        int danoBase = this.ataque + aleatorio.nextInt(6); // Dano varia um pouco
        int danoReal = danoBase - alvo.defesa;

        if (danoReal < 0) danoReal = 0;
        
        alvo.receberDano(danoReal);
        this.furia += 10; // Ganha fúria ao atacar
        System.out.println(this.nome + " agora tem " + this.furia + " de fúria.");
    }

    // Implementação obrigatória do método abstrato da classe pai
    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        if (this.furia >= 30) {
            System.out.println(this.nome + " usa GOLPE FULMINANTE com toda sua fúria!");
            int danoEspecial = this.ataque * 2; // Dano dobrado
            alvo.receberDano(danoEspecial);
            this.furia -= 30; // Gasta a fúria
        } else {
            System.out.println("Fúria insuficiente! O ataque falhou.");
        }
    }
}