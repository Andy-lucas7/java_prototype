// Arena.java
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; // Precisamos importar a classe ArrayList

public class Arena {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // --- NOVO: SELEÇÃO DE PERSONAGEM ---
        System.out.println("========================================");
        System.out.println("BEM-VINDO À ARENA DOS CAMPEÕES!");
        System.out.println("========================================");
        System.out.println("Escolha seu herói:");
        System.out.println("1 - Guerreiro (Vida Alta, Defesa Boa)");
        System.out.println("2 - Mago (Ataque Alto, Pouca Vida)");
        System.out.println("3 - Arqueiro (Equilibrado, Chance de Crítico)");
        System.out.print("Digite o número do seu personagem: ");
        int escolhaPersonagem = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer do scanner

        System.out.print("Digite o nome do seu herói: ");
        String nomeJogador = scanner.nextLine();

        Personagem jogador = null; // Começa como nulo

        // Cria o objeto do jogador baseado na escolha
        switch (escolhaPersonagem) {
            case 1:
                jogador = new Guerreiro(nomeJogador);
                break;
            case 2:
                jogador = new Mago(nomeJogador);
                break;
            case 3:
                jogador = new Arqueiro(nomeJogador);
                break;
            default:
                System.out.println("Escolha inválida! Você será um Guerreiro por padrão.");
                jogador = new Guerreiro(nomeJogador);
                break;
        }

        // --- NOVO: CRIAÇÃO DE INIMIGO ALEATÓRIO ---
        // Vamos criar uma lista de possíveis inimigos
        ArrayList<Personagem> inimigosPossiveis = new ArrayList<>();
        inimigosPossiveis.add(new Guerreiro("Ogro Brutal"));
        inimigosPossiveis.add(new Mago("Feiticeiro das Sombras"));
        inimigosPossiveis.add(new Arqueiro("Caçadora da Floresta"));

        // Sorteia um inimigo aleatório da lista
        int indiceInimigo = random.nextInt(inimigosPossiveis.size());
        Personagem inimigo = inimigosPossiveis.get(indiceInimigo);


        System.out.println("\n--- A BATALHA COMEÇA! ---");
        System.out.println(jogador.getNome() + " VS " + inimigo.getNome());

        int turno = 1;

        // O loop principal do jogo (continua o mesmo)
        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.printf("\n<<<<<<<<<<<<<< TURNO %d >>>>>>>>>>>>>>\n", turno);

            System.out.println("STATUS ATUAL:");
            jogador.mostrarStatus();
            inimigo.mostrarStatus();

            System.out.println("\n--- SEU TURNO ---");
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Habilidade Especial");
            System.out.print("Sua escolha: ");
            int escolhaAcao = scanner.nextInt();

            if (escolhaAcao == 1) {
                jogador.atacar(inimigo);
            } else if (escolhaAcao == 2) {
                jogador.usarHabilidadeEspecial(inimigo);
            } else {
                System.out.println("Opção inválida! Você perdeu o turno.");
            }

            if (inimigo.estaVivo()) {
                System.out.println("\n--- TURNO DO INIMIGO ---");
                if (random.nextInt(100) < 70) {
                    inimigo.atacar(jogador);
                } else {
                    inimigo.usarHabilidadeEspecial(jogador);
                }
            }
            
            turno++;
        }

        // Fim da batalha (continua o mesmo)
        System.out.println("\n============= FIM DA BATALHA! =============");
        if (jogador.estaVivo()) {
            System.out.println("🎉 PARABÉNS! " + jogador.getNome() + " é o grande campeão! 🎉");
        } else {
            System.out.println("☠️ VOCÊ FOI DERROTADO! " + inimigo.getNome() + " venceu a batalha. ☠️");
        }

        scanner.close();
    }
}