package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;


public class Launcher implements Runnable {
    @Option(names = {"-g", "--graph-type"}, description = "Type of graph")
    private final GraphType graphType = GraphType.Mermaid;

    @Option(names = {"-c", "--classes"}, required = true, description = "Class to analyse")
    private final Class<?> myClass = null;

    public void run(){
        UmlGraph graph = new UmlGraph(myClass);
        String output = graph.as(graphType);
        System.out.print(output);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
