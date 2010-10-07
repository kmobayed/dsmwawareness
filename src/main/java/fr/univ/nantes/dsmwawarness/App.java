package fr.univ.nantes.dsmwawarness;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length<4)
        {
                System.err.println("Usage: java -jar loadData <TDB folder> <ontology file> <data file> <output file>");
                System.exit(0);
        }

        String directory = args[0] ;
        String ontoFile = "file:"+args[1];
        String dataFile = "file:"+args[2];
        String outputFile = args[3];
        
        Jena J= new Jena(directory);

        J.loadData(ontoFile, dataFile);
        J.extractKnows(outputFile);

        J.close();
    }

    
}
