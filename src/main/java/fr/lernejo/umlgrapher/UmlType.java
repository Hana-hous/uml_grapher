package fr.lernejo.umlgrapher;

public class UmlType {
    private final Class tClasse;
    private final String name;
    private final String packageName;

    public UmlType(Class aClass) {
        this.tClasse = aClass;
        this.name = aClass.getSimpleName();
        this.packageName = aClass.getPackageName();
    }

    public Class tClasse() { return this.tClasse; }

    public String name(){return this.name;}

    public String packageName(){return this.packageName;}
}
