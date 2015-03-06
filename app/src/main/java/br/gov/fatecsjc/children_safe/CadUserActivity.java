package br.gov.fatecsjc.children_safe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.gov.fatecsjc.children_safe.model.Usuario;
import br.gov.fatecsjc.children_safe.model.db.dao.UsuarioDao;


public class CadUserActivity extends ActionBarActivity {

    EditText edtNome;
    EditText edtLogin;
    EditText edtSenha;
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_user);

        edtNome = (EditText) findViewById(R.id.edtNome_cadUser);
        edtLogin = (EditText) findViewById(R.id.edtLogin_cadUser);
        edtSenha = (EditText) findViewById(R.id.edtSenha_cadUser);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cad_pais, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnCadastrarClick_cadUser(View view){

        usuario.setNome(edtNome.getText().toString());
        usuario.setLogin(edtLogin.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());

        if ((usuario.getNome().equals("")) || (usuario.getNome().equals("")) || (usuario.getNome().equals(""))){
            Toast.makeText(this,"Necessário preencher todos os campos", Toast.LENGTH_SHORT).show();
        }else{
            UsuarioDao dao = new UsuarioDao(this);
            dao.inserir(usuario);
            Toast.makeText(this,"Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }

    }

}
