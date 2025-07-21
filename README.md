# java_prototype
Ideia de Projeto: Gerenciador de Finanças Pessoais (Versão Console)
O Conceito Principal:

Um programa de linha de comando onde você pode registrar suas receitas (salário, vendas, etc.) e suas despesas (aluguel, alimentação, lazer). O programa calcula e exibe seu saldo atual, além de gerar relatórios simples.

É um projeto extremamente prático que você pode até usar no seu dia a dia, e os conceitos de POO se encaixam nele como uma luva.

Como a POO se Encaixa? (A Estrutura das Classes)
Aqui está a beleza do projeto. Nós vamos modelar o problema usando classes que representam conceitos do mundo real.

1. A Classe Transacao (Abstrata - O Modelo)
Não existe uma "transação" genérica; ela é sempre uma receita ou uma despesa. Portanto, Transacao será nossa superclasse abstrata.

Atributos:

protected String descricao;

protected double valor;

protected LocalDate data; (Usar a classe de data do Java é uma boa prática!)

Métodos:

Métodos para obter os dados (getDescricao(), getValor(), etc.).

Um método abstrato getTipoDeTransacao() que forçará as classes filhas a se identificarem.

2. As Classes Receita e Despesa (As Filhas - A Especialização)
Aqui usamos a herança.

public class Receita extends Transacao: Representa o dinheiro que entra. O valor dela será sempre positivo.

public class Despesa extends Transacao: Representa o dinheiro que sai. Podemos fazer com que o valor dela seja sempre armazenado como negativo para facilitar os cálculos de saldo.

Ambas as classes implementarão o método getTipoDeTransacao(), retornando "RECEITA" ou "DESPESA". Isso é polimorfismo em ação.

3. A Classe GerenciadorFinanceiro (O Cérebro da Aplicação)
Esta classe vai orquestrar tudo. Ela não herda de ninguém, mas usa os outros objetos.

Atributos:

private List<Transacao> transacoes; (Aqui usamos o ArrayList<Transacao>! Esta lista conterá tanto objetos Receita quanto Despesa, outro exemplo de polimorfismo).

Métodos:

adicionarReceita(String descricao, double valor): Cria um objeto Receita e o adiciona à lista.

adicionarDespesa(String descricao, double valor): Cria um objeto Despesa e o adiciona à lista.

calcularSaldo(): Percorre a lista de transações, somando os valores (receitas são positivas, despesas negativas) e retorna o saldo total.

gerarRelatorio(): Exibe todas as transações de forma organizada.

4. A Classe App (O Ponto de Entrada)
Uma classe simples que contém o método main. Ela vai criar uma instância do GerenciadorFinanceiro e exibir um menu de texto para o usuário interagir.

Menu:

Adicionar Receita

Adicionar Despesa

Ver Saldo

Ver Extrato Completo

Sair

Funcionalidades (Do Simples ao Completo)
Este projeto tem um caminho de crescimento claro:

Versão 1.0 (O Básico): Apenas as funcionalidades do menu acima. Adicionar transações e ver o saldo.

Versão 2.0 (Relatórios Melhorados): Adicionar um campo categoria na classe Despesa (ex: "Alimentação", "Transporte", "Lazer"). O relatório poderá então mostrar os gastos por categoria.

Versão 3.0 (Filtros): Permitir que o usuário veja as transações de um mês específico.

Versão Bônus (Persistência): Aprender a salvar a lista de transações em um arquivo de texto (.csv ou .txt) para que os dados não se percam quando o programa fechar, e a carregar esses dados quando o programa iniciar.