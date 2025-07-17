import java.util.*;

public class Masacote
{
  private String nome;
  private Integer vida;
  private Integer atk;
  private Integer def;
  private Random aleatorio = new Random();
  
  public Masacote(String nome , int vida, int atk, int def) {
    this.nome = nome;
    this.vida = vida;
    this.atk = atk;
    this.def = def;
  }
 
  public void atacar(Masacote alvo)
  {
    System.out.println("--------------------------------------");
    System.out.println(this.nome + " ataca " + alvo.nome + "!");
    int atkComSorte = this.atk + aleatorio.nextInt(5);
    int danoReal = atkComSorte - alvo.def;
    if (danoReal < 0) {
      danoReal = 0;
    }
    System.out.println("Dano causado: " + danoReal);
    alvo.receberDano(danoReal);
    System.out.println("--------------------------------------");
  }
  public void receberDano(int qtyDano)
  {
    this.vida -= qtyDano;
    if (this.vida < 0) {
      this.vida = 0;
    }
    System.out.println(this.nome + " sofreu dano! Vida restante: " + this.vida);
  }
  public boolean estarVivo()
  {
    return this.vida > 0;
  }
  public void mostrarStatus()
  {
    System.out.println(String.format("Nome: %s | Vida: %d", this.nome, this.vida));
  }
  public static void main(String[] args)
  {
    Masacote pikachu = new Masacote("Pikachu", 100, 20, 10);
    Masacote charmander = new Masacote("Charmander", 120, 24, 12);
    int turno = 1;
    while (pikachu.estarVivo() && charmander.estarVivo()) {
      System.out.println("\n>> TURNO " + turno);
      pikachu.mostrarStatus();
      charmander.mostrarStatus();
      
      // pikachu ataca charmander
      pikachu.atacar(charmander);
      if (charmander.estarVivo()){
        charmander.atacar(pikachu);
      }
      turno++;
    } 
    System.out.println("\nFIM DA BATALHA!");
    if (pikachu.estarVivo()) {
      System.out.println(pikachu.nome + " é o vencedor!");
    } else {
      System.out.println(charmander.nome + " é o vencedor!");
    }
  }
}



