package br.gov.fatecsjc.children_safe.model.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.gov.fatecsjc.children_safe.model.AppInfo;

public class AppBloqueadoDao {

    private SQLiteDatabase db;

    public AppBloqueadoDao(Context context){
        BDCore auxBd = new BDCore(context);
        db = auxBd.getWritableDatabase();
    }

    // insere um novo aplicativo a lista de bloqueio caso ja não esteja,
    // retorna 0 caso ja exista na lista e 1 se não existia e foi inserido.
    public int inserir(AppInfo appInfo){

        if (isBlocked(appInfo)){
            return 0;
        }else{
            ContentValues valores = new ContentValues();
            valores.put("package", appInfo.getAppPackage());
            valores.put("nome", appInfo.getAppName());

            db.insert("AppBloqueado",null,valores);
            return 1;
        }
    }

    public void deletar(AppInfo appInfo){
        db.delete("AppBloqueado","package = "+appInfo.getAppPackage(),null);
    }

    public ArrayList<AppInfo> buscar(){
        ArrayList<AppInfo> list = new ArrayList<>();
        String[] colunas = new String[]{"package","nome"};

        Cursor cursor = db.query("AppBloqueado", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                AppInfo app = new AppInfo();

                app.setAppPackage(cursor.getString(0));
                app.setAppName(cursor.getString(1));
                list.add(app);

            }while(cursor.moveToNext());
        }
        return list;
    }

    public boolean isBlocked(AppInfo appInfo){
        String[] colunas = new String[]{"package","nome"};
        String whereClause = "package = ?";
        String[] whereArgs = new String[] {
                appInfo.getAppPackage(),
        };

        Cursor cursor = db.query("AppBloqueado", colunas, whereClause, whereArgs, null, null, null);

        return cursor.getCount() > 0;
    }

}