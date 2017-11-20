package com.trabalho.ifrs.appeventos;

import java.io.Serializable;

/**
 * Created by marcos on 20/11/2017.
 */

public class Event implements Serializable {
    private String name;
    private int img;
    private String url;

    public static final Event[] eventos = {
            new Event("Mostra POA", R.drawable.mostrapoa, "http://mostra.poa.ifrs.edu.br/2017/index.html"),
            new Event("ChimaCode", R.drawable.chimacode, "http://chimacode.xyz/")
    };

    public Event(String name, int img, String url){
        this.setName(name);
        this.setImg(img);
        this.setUrl(url);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return name;
    }
}
