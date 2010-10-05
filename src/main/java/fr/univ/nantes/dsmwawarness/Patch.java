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
public class Patch {
private String patchID;
private Collection<Operation> operations;
private Boolean published;
private Document doc;


public Patch(String id) {
    patchID = id;
}

public Patch(String id,Boolean p) {
    patchID= id;
    published =p;
}

public Patch(String id, Document mydoc,Boolean p) {
    patchID= id;
    published =p;
    doc = mydoc;
}

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }



    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }


    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }

    public String getPatchID() {
        return patchID;
    }

    public void setPatchID(String patchID) {
        this.patchID = patchID;
    }

   
    
}
