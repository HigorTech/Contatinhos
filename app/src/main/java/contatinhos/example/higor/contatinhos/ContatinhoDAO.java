package contatinhos.example.higor.contatinhos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContatinhoDAO {

//    public ContatinhoDAO() {
//    }

    private ContatinhoDBHealper contatinhoDBHealper;

    public ContatinhoDAO(Context context) {
        this.contatinhoDBHealper = new ContatinhoDBHealper(context);
    }

    public boolean inserirContatinho(Contatinho contato){
        SQLiteDatabase db = this.contatinhoDBHealper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(ContatinhoContract.COLUNA_NOME, contato.getNome());
        valores.put(ContatinhoContract.COLUNA_TELEFONE,contato.getTelefone());
        valores.put(ContatinhoContract.COLUNA_INFO,contato.getInfos());

        long newRowId = db.insert(ContatinhoContract.NOME_TABELA, null, valores);
        if (newRowId==-1)return false;
        return true;
    }

    public boolean editarContatinho(Contatinho contato){
        SQLiteDatabase db = this.contatinhoDBHealper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(ContatinhoContract.COLUNA_NOME, contato.getNome());
        valores.put(ContatinhoContract.COLUNA_TELEFONE,contato.getTelefone());
        valores.put(ContatinhoContract.COLUNA_INFO,contato.getInfos());

        String condicao = ContatinhoContract.COLUNA_ID+" = ?";
        String[] argumentosWere ={String.valueOf(contato.getId())};     //   Olha Aqui o metodo errado O/

        int linhasAfetadas = db.update(ContatinhoContract.NOME_TABELA, valores, condicao, argumentosWere);
        if (linhasAfetadas==-1)return false;
        return true;

    }

    public boolean apagarContatinho(Integer id){
        SQLiteDatabase db = this.contatinhoDBHealper.getWritableDatabase();
        String condicao = ContatinhoContract.COLUNA_ID+" = ?";

        String[] argumentosWhere = {id.toString()};

        int linhasAfetadas = db.delete(ContatinhoContract.NOME_TABELA, condicao, argumentosWhere);
        if(linhasAfetadas ==-1)return false;
        return true;



    }




//    public boolean buscarContatinho(Integer id){
//
//    }


    public ArrayList<Contatinho>buscarTodosContatinhos(){
        SQLiteDatabase db = this.contatinhoDBHealper.getReadableDatabase();

        String[] colunas = {ContatinhoContract.COLUNA_ID, ContatinhoContract.COLUNA_NOME, ContatinhoContract.COLUNA_TELEFONE, ContatinhoContract.COLUNA_INFO};
        String ordenar = ContatinhoContract.COLUNA_NOME + " ASC";

        Cursor result = db.query(ContatinhoContract.NOME_TABELA,colunas,null,null,null,null,ordenar);
        ArrayList<Contatinho> contatinhos = new ArrayList<Contatinho>();

        while (result.moveToNext()){
            Contatinho contato = new Contatinho();
            contato .setId(result.getInt(result.getColumnIndex(ContatinhoContract.COLUNA_ID)));
            contato.setNome(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_NOME)));
            contato.setTelefone(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_TELEFONE)));
            contato.setInfos(result.getString(result.getColumnIndex(ContatinhoContract.COLUNA_INFO)));
            contatinhos.add(contato);
        }
        return contatinhos;

    }

}
