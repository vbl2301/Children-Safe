package br.gov.fatecsjc.children_safe.model;

public class AppInfo {

    private String appName;
    private String appPackage;

    public AppInfo(){

    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    @Override
    public String toString() {
        return appName + " (" + appPackage + ") ";
    }

}
