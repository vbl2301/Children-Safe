package br.gov.fatecsjc.children_safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class AdmMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adm_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adm_main, menu);
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

    public void btnBloquearAppsClick_admMain(View view){
        Intent intent = new Intent(this, AppsInstaladosActivity.class);
        startActivity(intent);
    }

    public void btnDesbloquearAppsClick_admMain(View view){
        Intent intent = new Intent(this, AppsBloqueadosActivity.class);
        startActivity(intent);
    }

    public void btnDeslogarClick_admMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
