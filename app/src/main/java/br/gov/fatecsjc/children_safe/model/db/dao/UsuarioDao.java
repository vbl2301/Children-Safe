package br.gov.fatecsjc.children_safe.model.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.gov.fatecsjc.children_safe.model.Usuario;

/**
 Created by vinicius on 04/03/2015.

 Implementa as operações no SQLite de usuario.
 */
public class UsuarioDao {

    private SQLiteDatabase db;

    public UsuarioDao(Context context) {
        BDCore auxBd = new BDCore(context);
        db = auxBd.getWritableDatabase();
    }

    public void inserir(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("login", usuario.getLogin());
        valores.put("senha", usuario.getSenha());

        db.insert("usuario",null,valores);
    }

    public void atualizar(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("login", usuario.getLogin());

        db.update("usuario",valores,"_id = ?",new String[]{""+usuario.getId()});
    }

    public void deletar(Usuario usuario){
        db.delete("usuario","_id = "+usuario.getId(),null);
    }

    public List<Usuario> buscar(Usuario usuario){
        List<Usuario> list = new ArrayList<>();
        String[] colunas = new String[]{"_id","nome","login"};

        Cursor cursor = db.query("usuario", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Usuario u = new Usuario();

                u.setId(cursor.getInt(0));
                u.setNome(cursor.getString(1));
                u.setLogin(cursor.getString(2));
                list.add(u);

            }while(cursor.moveToNext());
        }
        return list;
    }

    public boolean logar(Usuario usuario){
        String[] colunas = new String[]{"login","senha"};
        String selecao = "login = "+usuario.getLogin()+" AND senha = "+usuario.getSenha();
        String whereClause = "login = ? AND senha = ?";
        String[] whereArgs = new String[] {
                usuario.getLogin(),
                usuario.getSenha()
        };

        Cursor cursor = db.query("usuario", colunas, whereClause, whereArgs, null, null, null);

        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
