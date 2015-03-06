package br.gov.fatecsjc.children_safe.model;

import java.util.ArrayList;

public class AppsBloqueados {

    ArrayList<AppInfo> bloqueados = new ArrayList<>();

    public AppsBloqueados(ArrayList<AppInfo> bloqueados) {
        this.bloqueados = bloqueados;
    }

    public ArrayList<AppInfo> getBloqueados() {
        return bloqueados;
    }

    public void setBloqueados(ArrayList<AppInfo> bloqueados) {
        this.bloqueados = bloqueados;
    }

    public void addAppsBloqueados(AppInfo appInfo){
        bloqueados.add(appInfo);
    }

    public void removeAppsBloqueados(AppInfo appInfo) {
        bloqueados.remove(appInfo);
    }
    
}
