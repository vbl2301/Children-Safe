package br.gov.fatecsjc.children_safe.model.db.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vinicius on 04/03/2015.
 */
public class BDCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "ChildrenSafe.bd";
    private static final int VERSAO_BD = 2;

    public BDCore(Context context) {
        super(context, NOME_BD, null, VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(_id integer primary key autoincrement, nome text not null, login text not null," +
                " senha text not null);");
        db.execSQL("create table AppBloqueado(package text primary key, nome text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuario;");
        db.execSQL("drop table AppBloqueado");
        onCreate(db);
    }

}
