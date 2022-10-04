package rikkei.music.model;

import java.util.ArrayList;
import java.util.List;

public class Band {
    private int id;
    private String name;
    private List<Singer> singerList = new ArrayList<>();

    public Band() {
    }

    public Band(int id, String name, List<Singer> singerList) {
        this.id = id;
        this.name = name;
        this.singerList = singerList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Singer> getSingerList() {
        return singerList;
    }

    public void setSingerList(List<Singer> singerList) {
        this.singerList = singerList;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singerList=" + singerList +
                '}';
    }
}
