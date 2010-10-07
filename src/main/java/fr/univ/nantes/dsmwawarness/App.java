package fr.univ.nantes.dsmwawarness;

import com.hp.hpl.jena.query.QueryExecution;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length<2)
        {
                System.err.println("Usage: java -jar loadData <TDB folder> <ontology file> ");
                System.exit(0);
        }

        String DBdirectory = args[0] ;
        String ontoFile = "file:"+args[1];
        
        Site MySite = new Site("Site1");

        Jena J= new Jena(DBdirectory,ontoFile);

        J.addSite(MySite);

        J.listSites();
        System.out.println("===========");
        J.listStatements();
        J.close();
    }

    
}
