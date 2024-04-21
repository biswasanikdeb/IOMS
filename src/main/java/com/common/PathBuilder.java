package com.common;

public class PathBuilder { // to build arbitary paths
    private String path;

    public PathBuilder(String data1, String data2, String data3, String data4, String data5, String data6, String data7,
            String data8) {
        path = "D:/code/PS_projects/ioms/src/main/java/com" + data1 + "/" + data2 + "/" + data3 + "/" + data4 + "/"
                + data5
                + "/" + data6 + "/" + data7 + "/" + data8;
    }

    public PathBuilder(String data1, String data2, String data3, String data4, String data5, String data6, String data7,
            String data8, String data9) {
        path = "D:/code/PS_projects/ioms/src/main/java/com" + data1 + "/" + data2 + "/" + data3 + "/" + data4 + "/"
                + data5
                + "/" + data6 + "/" + data7
                + "/" + data8 + "/" + data9;
    }

    public String getPath() {
        return this.path;
    }

}
