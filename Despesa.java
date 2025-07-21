public class Despesa extends Transacao {
    public Despesa(String descricao, double valor) {
        super(descricao, Math.abs(valor)); // Garante que o valor da despesa seja positivo
    }
    @Override
    public String getTipoDeTransacao() {
        return "Despesa";
    }
}
