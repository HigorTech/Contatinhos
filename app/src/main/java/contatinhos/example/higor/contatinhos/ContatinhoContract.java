package contatinhos.example.higor.contatinhos;

import android.provider.BaseColumns;

public class ContatinhoContract implements BaseColumns {
    private ContatinhoContract(){}

    public static final String NOME_TABELA = "contatinhos";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_INFO = "info";
}
