package com.example.hp.gatepass;

/**
 * Created by accentc2 on 2/8/18.
 */

public class OneClass {

    int id;
    String patentid, onone, ontwo, onthree,onfour,onfive;


    public OneClass(String onone, String ontwo, String onthree, String onfour,String onfive) {
        //this.patentid = patentid;
        this.onone = onone;
        this.ontwo = ontwo;
        this.onthree = onthree;
        this.onfour=onfour;
        this.onfive=onfive;

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

    public String getOnfive(){return onfive;}


}
