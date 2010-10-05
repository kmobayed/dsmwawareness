/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.univ.nantes.dsmwawarness;

/**
 *
 * @author halaskaf
 */
public class Operation {
 private String opID;
 private String optype;

public Operation (String ID, String type) {
    opID = ID;
    optype = type;
    }

    public String getOpID() {
        return opID;
    }

    public void setOpID(String opID) {
        this.opID = opID;
    }

    public String getOptype() {
        return optype;
    }

    public void setOptype(String optype) {
        this.optype = optype;
    }

}
