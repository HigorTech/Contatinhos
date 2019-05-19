package contatinhos.example.higor.contatinhos;

import android.content.Context;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContatinhoDBHealper extends SQLiteOpenHelper {

    private static  final String SQL_CREATE=
            "CREATE TABLE "+ContatinhoContract.NOME_TABELA+" ( "+ ContatinhoContract.COLUNA_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +ContatinhoContract.COLUNA_NOME+" TEXT, "+ContatinhoContract.COLUNA_TELEFONE+" TEXT, "+ContatinhoContract.COLUNA_INFO+" TEXT);";


    private  static final String SQL_DELETE = "DROP TABLE  IF EXISTS "+ContatinhoContract.NOME_TABELA;

    public static final  int DATABASE_VERSION = 3;

    public static final String DATABASE_NAME = "AgendaContatinhos.db";



    public ContatinhoDBHealper(Context context){
    super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);

    }
}
