package br.gov.fatecsjc.children_safe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.gov.fatecsjc.children_safe.model.AppInfo;

public class ListAppsAdapter extends ArrayAdapter<AppInfo> {
    private final Context context;
    private final ArrayList<AppInfo> apps;

    public ListAppsAdapter(Context context, ArrayList<AppInfo> apps) {
        super(context,R.layout.list_apps_layout, apps);
        this.context = context;
        this.apps = apps;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_apps_layout, parent, false);
        TextView firstLine = (TextView) rowView.findViewById(R.id.firstLine);
        TextView secondLine = (TextView) rowView.findViewById(R.id.secondLine);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        firstLine.setText(apps.get(position).getAppName());
        secondLine.setText(apps.get(position).getAppPackage());
        // change the icon for Windows and iPhone
        //imageView.setImageResource(R.drawable.ok);
        return rowView;

    }
}