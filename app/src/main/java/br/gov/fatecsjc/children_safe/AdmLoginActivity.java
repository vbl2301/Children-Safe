package br.gov.fatecsjc.children_safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.gov.fatecsjc.children_safe.model.Usuario;
import br.gov.fatecsjc.children_safe.model.db.dao.UsuarioDao;


public class AdmLoginActivity extends ActionBarActivity {

    EditText edtLogin;
    EditText edtSenha;
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_login);

        edtLogin = (EditText) findViewById(R.id.edtLogin_admLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha_admLogin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adm_login, menu);
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

    public void btnCadastrarClick_admLogin(View view){
        Intent intent = new Intent(this, CadUserActivity.class);
        startActivity(intent);
    }

    public void btnLogarClick_admLogin(View view){
        usuario.setLogin(edtLogin.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());

        UsuarioDao dao = new UsuarioDao(this);

        if (dao.logar(usuario)){
            Intent intent = new Intent(this, AdmMainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Login ou Senha Incorretos", Toast.LENGTH_LONG).show();
        }
    }

}