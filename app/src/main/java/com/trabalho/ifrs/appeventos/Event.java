package com.trabalho.ifrs.appeventos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcos on 20/11/2017.
 */

public class Event implements Serializable {
    public int id;
    public String name;
    public String img;
    public int img1;
    public String url;

    public static final List<Event> events() {
            String nameUrlRest = new Object(){}.getClass().getEnclosingMethod().getName();
            List<Event> e = new ArrayList<Event>();

            e.add(new Event(1,"Mostra POA", "http://localhost:8080/ServicoREST/image/chimacode.png", "http://mostra.poa.ifrs.edu.br/2017/index.html"));
            e.add(new Event(2,"ChimaCode", "http://localhost:8080/ServicoREST/image/mostrapoa.png", "http://chimacode.xyz/"));
            return e;
    }

    public static final List<Event> eventsLocal() {
        List<Event> e = new ArrayList<Event>();

        e.add(new Event(1,"Mostra POA", R.drawable.mostrapoa, "http://mostra.poa.ifrs.edu.br/2017/index.html"));
        e.add(new Event(2,"ChimaCode", R.drawable.chimacode, "http://chimacode.xyz/"));
        return e;
    }

    public Event(int id, String name, String img, String url){
        this.setId(id);
        this.setName(name);
        this.setImg(img);
        this.setUrl(url);
    }

    public Event(int id, String name, int img1, String url){
        this.setId(id);
        this.setName(name);
        this.img1 = (img1);
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
