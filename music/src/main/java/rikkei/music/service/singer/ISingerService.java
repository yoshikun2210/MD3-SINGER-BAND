package rikkei.music.service.singer;

import rikkei.music.model.Singer;
import rikkei.music.service.IGeneric;

import java.util.List;

public interface ISingerService extends IGeneric<Singer> {
//    List<Singer> findAll();
    List<Singer> findByName(String name);
}
