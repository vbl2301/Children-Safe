package br.gov.fatecsjc.children_safe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.gov.fatecsjc.children_safe.model.AppInfo;
import br.gov.fatecsjc.children_safe.model.db.dao.AppBloqueadoDao;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lsvApps = (ListView) findViewById(R.id.lsvApps);

        ListAppsAdapter appsAdapter = new ListAppsAdapter(this, getBlockedApps());
        lsvApps.setAdapter(appsAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void btnPainelAdmClick(View view){
        Intent intent = new Intent(this, AdmLoginActivity.class);
        startActivity(intent);
    }

    private ArrayList<AppInfo> getBlockedApps(){
        AppBloqueadoDao dao = new AppBloqueadoDao(this);
        return dao.buscar();
    }

}