
package fr.univ.nantes.dsmwawarness;


/**
 *
 * @author halaskaf
 */
public class PushFeed {
    private String pushFeedID;
    private ChangeSet hasPushHead;
  
    
    public PushFeed(String id) {
        pushFeedID =id;
    }

    public String getPushFeedID() {
        return pushFeedID;
    }

    public void setPushFeedID(String pushFeedID) {
        this.pushFeedID = pushFeedID;
    }


    public ChangeSet getHasPushHead() {
        return hasPushHead;
    }

    public void setHasPushHead(ChangeSet hasPushHead) {
        this.hasPushHead = hasPushHead;
    }

}
