/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univ.nantes.dsmwawarness;

import java.util.Collection;

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
