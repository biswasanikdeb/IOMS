package com.common;

public class PathToData {
    private String directory;
    public PathToData(String directory){
        this.directory=directory;
        
    }
    public String[] toData(){
        String dataArr[] = directory.split("/");
        return dataArr;
    }
}
