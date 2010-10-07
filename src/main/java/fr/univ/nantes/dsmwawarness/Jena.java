
package fr.univ.nantes.dsmwawarness;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.tdb.TDBFactory;


/**
 *
 * @author klm
 */
public class Jena {
    private String DBdirectory;
    private Model data;
    private String ontoFile;

    public Jena(String DB, String onto)
    {
        DBdirectory=DB;
        ontoFile=onto;
        data = TDBFactory.createModel(DBdirectory);
        data.read(ontoFile,"RDF/XML");
    }

    public void close()
    {
      data.close(); 
    }

    public void addSite(Site S)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+S.getSiteID());
      Resource object=data.createResource(dsmwUri+"WikiSite");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);  
    }

    public void addDocument(Document D)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+D.getDocID());
      Resource object=data.createResource(dsmwUri+"Document");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);

    }

    public void addOperation(Operation O)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+O.getOpID());
      Resource object=data.createResource(dsmwUri+"Operation");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);

    }

    public void addPatch(Patch P)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+P.getPatchID());
      Resource object=data.createResource(dsmwUri+"Patch");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);
    }

    public void addChangeSet(ChangeSet C)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+C.getChgSetID());
      Resource object=data.createResource(dsmwUri+"ChangeSet");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);
    }

    public void addPullFeed(PullFeed PF)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+PF.getPullFeedID());
      Resource object=data.createResource(dsmwUri+"PullFeed");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);
    }

    public void addPushFeed(PushFeed PF)
    {
      String rdfUri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
      String dsmwUri = "http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#";
      Property predicate = data.createProperty(rdfUri,"type");
      Resource subject=data.createResource(dsmwUri+PF.getPushFeedID());
      Resource object=data.createResource(dsmwUri+"PushFeed");
      Statement st=data.createStatement(subject,predicate,object);
      data.add(st);
    }


    public void loadData(String dataFile)
    {
		System.out.print("Loading the data ... ");
		data.read(dataFile,"N3");
		System.out.println("\tDONE");
    }

    public void listSites()
    {
        String query1;
        QueryExecution qe1;
        query1="prefix rdfs:    <http://www.w3.org/2000/01/rdf-schema#> "
			+"prefix rdf:     <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			+"PREFIX MS2W: <http://www.semanticweb.org/ontologies/2009/4/MS2W.owl#> "
			+"SELECT DISTINCT ?site WHERE { "
			+"{?site a MS2W:WikiSite} "
			+"}";

        qe1 = QueryExecutionFactory.create(query1, data);
        for (ResultSet rs1 = qe1.execSelect() ; rs1.hasNext() ; )
        {
                QuerySolution binding1 = rs1.nextSolution();
            Resource patch1=((Resource) binding1.get("site"));
            System.out.print(patch1.getLocalName()+"\n");
        }
    }
    public void listStatements()
    {
        StmtIterator iter = data.listStatements();
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();  
            Resource  subject   = stmt.getSubject();     
            Property  predicate = stmt.getPredicate();   
            RDFNode   object    = stmt.getObject();      

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
               System.out.print(object.toString());
            } else {
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }
    }
    
}
