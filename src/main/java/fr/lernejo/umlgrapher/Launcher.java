package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;


public class Launcher implements Runnable{
    @Option(names={"-c","--classes"},required = true,description = "Permet de renseigner les classes d'où faire partir l'analyse ", paramLabel = "test")
    private final Class<?>[] myclass = null;
    @Option( names = {"-g","--graph-type"},required = false,description = "Permet de sélectionner le type de graph que l'on souhaite en sortie (default: ${DEFAULT-VALUE})",defaultValue = "Mermaid")
    private final GraphType graphTyp = GraphType.Mermaid ;

    @Override
    public void run() {
        try {
            UmlGraph um = new UmlGraph(myclass);
            String outPut = um.as(graphTyp);
            System.out.println(outPut);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }


}
