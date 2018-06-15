package com.azuray.decodeme.Proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        this.loadFile();
    }

    @Override
    public void dispaly() {
        System.out.println("display:"+fileName);
    }

    public void loadFile() {
        System.out.println("loading:"+fileName);
    }
}
