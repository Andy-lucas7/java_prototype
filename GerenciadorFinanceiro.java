import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinanceiro {
    private List<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarReceita(String descricao, double valor) {
        Receita novaReceita = new Receita(descricao, valor);
        this.transacoes.add(novaReceita);
        System.out.println("Receita adicionada: " + novaReceita.formatarParaRelatorio());
    }

    public void adicionarDespesa(String descricao, double valor) {
        Despesa novaDespesa = new Despesa(descricao, valor);
        this.transacoes.add(novaDespesa);
        System.out.println("Despesa adicionada: " + novaDespesa.formatarParaRelatorio());
    }

    public double calcularSaldo() {
        double saldo = 0.0;
        for (Transacao t : this.transacoes) {
            if (t instanceof Receita) {
                saldo += t.getValor();
            } else if (t instanceof Despesa) {
                saldo -= t.getValor();
            }
        }
        return saldo;
    }

    public void gerarRelatorio() {
        System.out.println("\n--- Extrato Completo ---");
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada.");
        } else {
            for (Transacao t : this.transacoes) {
                System.out.println(t.formatarParaRelatorio());
            }
        }
        System.out.printf("--- SALDO FINAL: R$ %.2f ---\n", this.calcularSaldo());
    }


}
