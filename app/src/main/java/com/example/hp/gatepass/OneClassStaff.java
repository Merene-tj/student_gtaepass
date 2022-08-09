package com.example.hp.gatepass;

/**
 * Created by accentc2 on 2/8/18.
 */

public class OneClassStaff {

    int id;
    String patentid, onone, ontwo, onthree,onfour,onfive,onsix,onseven;


    public OneClassStaff(String onone, String ontwo, String onthree, String onfour,String onfive,String onsix,String onseven) {
        //this.patentid = patentid;
        this.onone = onone;
        this.ontwo = ontwo;
        this.onthree = onthree;
        this.onfour=onfour;
        this.onfive=onfive;
        this.onsix=onsix;
        this.onseven=onseven;

    }


    public String getOnone() {
        return onone;
    }

    public String getOntwo() {
        return ontwo;
    }

    public String getOnthree() {
        return onthree;
    }

    public String getOnfour() {
        return onfour;
    }

    public String getOnfive() {
        return onfive;
    }
    public String getOnsix() {
        return onsix;
    }

    public String getOnseven() {
        return onseven;
    }

}
