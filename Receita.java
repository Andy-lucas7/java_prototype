public class Receita extends Transacao {
    public Receita(String descricao, double valor) {
        super(descricao, valor);
    }
    @Override
    public String getTipoDeTransacao() {
        return "Receita";
    }
}
