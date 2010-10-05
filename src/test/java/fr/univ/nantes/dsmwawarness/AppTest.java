package fr.univ.nantes.dsmwawarness;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test: push site 1 and pull site2
     * Create 1 document, doc1 on site1
     * Create 3 operations:op1,op2,op3
     * Create 1 patch: p1
     * add op1,op2,op3 to p1
     * add patch1 to doc1
     * patch1 is the head of doc1
     * * create 2 sites: site1, site2
     * Create a push feed on site1:pushf1
     * create a changeSet: chg1
     * add p1 to chg1
     * push chg1 on pushf1
     * create pull feed on site 2:pullf1
     * relate pullf1 to pushf1
     * pullf1 pull from pushf1
     */
     
    public void testApp()
    {

        // create a document doc1
        Document doc1= new Document("doc1");

        Operation op1= new Operation("op1", "insert");
        Operation op2= new Operation("op2","delete");
        Operation op3= new Operation("op3","insert");


        // create patch p1, p1 on doc1, p1 is unpublished
        Patch p1 = new Patch("p1",doc1,false);
        // add op1,op1,op3 to  p1
        Collection<Operation> ops = new HashSet<Operation>();

        ops.add(op1);
        ops.add(op2);
        ops.add(op3);

        p1.setOperations(ops);
        
        // add p1 is the head
        
        doc1.setHead(p1);

        // create site1 and site2
        Site site1 = new Site("site1");
        Site site2 = new Site("site2");
        // add doc1 to site1
        Collection<Document> docs = new HashSet<Document>();
        docs.add(doc1);
        site1.setDocs(docs);

        // create pushFeed pushf1
        PushFeed pushf1 = new PushFeed("pushf1");

        // add pushf1 to site 1
        Collection<PushFeed> pushs = new HashSet<PushFeed>();
        pushs.add(pushf1);
        site1.setPushs(pushs);

        // create changeSet  chg1 inPushFeed pushf1
        ChangeSet chg1 = new ChangeSet("chg1",pushf1);

        //push p1
        Collection<Patch> pts = new HashSet<Patch>();
        pts.add(p1);
        chg1.push(pts,doc1);

        PullFeed pullf1 = new PullFeed("pullf1",pushf1);

       // add pullfeed pullf1 to site2
        Collection<PullFeed> pulls = new HashSet<PullFeed>();
        pulls.add(pullf1);
        site2.setPulls(pulls);
        

        pullf1.pull();

        assertTrue( true );
       
    }
}
