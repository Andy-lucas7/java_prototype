import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Transacao {
    protected String descricao;
    protected double valor;
    protected LocalDate data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDate.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public abstract String getTipoDeTransacao();
    {
        
    }

    public String formatarParaRelatorio() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s] %s: R$ %.2f (%s)", 
        this.data.format(formatador), 
        this.getTipoDeTransacao(), 
        this.valor, 
        this.descricao);
    }

}



