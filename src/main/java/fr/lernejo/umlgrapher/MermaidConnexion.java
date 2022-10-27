package fr.lernejo.umlgrapher;

public class MermaidConnexion {
    private final String ChildClass;
    private final String ParentClass;
    private final String liaisonBetweenClass;

    public MermaidConnexion(Class ParentClass,Class ChildClass,String liaisonBetweenClass){
        this.ChildClass = ChildClass.getSimpleName();
        this.ParentClass = ParentClass.getSimpleName();
        this.liaisonBetweenClass = liaisonBetweenClass;
    }

    public String getChildClass(){
        return this.ChildClass;
    }

    public String getParentClass(){
        return this.ParentClass;
    }
    public String getLink(){
        return this.liaisonBetweenClass;
    }
}
