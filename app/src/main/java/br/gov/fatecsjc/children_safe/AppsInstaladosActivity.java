package br.gov.fatecsjc.children_safe;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.gov.fatecsjc.children_safe.model.AppInfo;


public class AppsInstaladosActivity extends ActionBarActivity {

    ListView lsvApps;
    List<AppInfo> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_instalados);

        lsvApps = (ListView) findViewById(R.id.lsvApps_appsInstalados);

        apps = getInstalledApps();

        ArrayAdapter<AppInfo> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, apps);
        lsvApps.setAdapter(adapter);
        lsvApps.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apps_instalados, menu);
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

    public void btnBloquearAppsClick_appsInstalados(View view){
        showSelectedItems();
    }

    private void showSelectedItems() {
        final StringBuffer sb = new StringBuffer("Selection: ");

        // Get an array that tells us for each position whether the item is
        // checked or not
        // --

        final SparseBooleanArray checkedItems = lsvApps.getCheckedItemPositions();
        if (checkedItems == null) {
            Toast.makeText(this, "No selection info available", Toast.LENGTH_LONG).show();
            return;
        }

        // For each element in the status array
        // --
        boolean isFirstSelected = true;
        final int checkedItemsCount = checkedItems.size();
        for (int i = 0; i < checkedItemsCount; ++i) {
            // This tells us the item position we are looking at
            // --
            final int position = checkedItems.keyAt(i);

            // This tells us the item status at the above position
            // --
            final boolean isChecked = checkedItems.valueAt(i);

            if (isChecked) {
                if (!isFirstSelected) {
                    sb.append(", ");
                }
                sb.append(apps.get(position).getAppName());
                isFirstSelected = false;
            }
        }

        // Show a message with the countries that are selected
        // --
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
    }

    private ArrayList<AppInfo> getInstalledApps() {
        ArrayList<AppInfo> res = new ArrayList<>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(1);

        for(PackageInfo p : packs){
            AppInfo appInfo = new AppInfo();
            appInfo.setAppName(p.applicationInfo.loadLabel(getPackageManager()).toString());
            appInfo.setAppPackage(p.packageName);
            res.add(appInfo);
        }
        return res;
    }

}
