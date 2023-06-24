package com.gt.exploreindia.domain;

public enum Region {
    West_India("WI"), North_India("NI"), East_India("EI"), South_India("SI");
    
    private String label;

    private Region(String label){
        this.label = label;
    }

    public static Region findByLabel(String byLabel){
        for(Region r: Region.values()){
            if(r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

}
