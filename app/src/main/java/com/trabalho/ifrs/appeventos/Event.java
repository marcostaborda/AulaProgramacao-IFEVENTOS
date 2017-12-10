package com.trabalho.ifrs.appeventos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 20/11/2017.
 */

public class Event implements Serializable {
    private int id;
    private String name;
    private String img;
    private String url;

    public static final Event[] eventos = {
            new Event("Mostra POA", R.drawable.mostrapoa, "http://mostra.poa.ifrs.edu.br/2017/index.html"),
            new Event("ChimaCode", R.drawable.chimacode, "http://chimacode.xyz/")
    };

    public static final List<Event> eventos() {
            List<Event> e = new ArrayList<Event>();
            e.add(new Event("Mostra POA", R.drawable.mostrapoa, "http://mostra.poa.ifrs.edu.br/2017/index.html"));
            e.add(new Event("ChimaCode", R.drawable.chimacode, "http://chimacode.xyz/"));
            return e;
    }

    public Event(String name, String img, String url){
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
