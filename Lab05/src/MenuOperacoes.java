public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    GERAR_SEGURO(3),
    EXCLUIR(4),
    GERAR_SINISTRO(5),
    ATUALIZAR_FROTA(6),
    CALCULAR_RECEITA_SEGURADORA(7);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao(){
        return this.operacao;
    }

}
