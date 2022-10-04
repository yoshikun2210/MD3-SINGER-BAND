package rikkei.music.service.band;

import rikkei.music.model.Band;
import rikkei.music.service.IGeneric;

import java.util.List;

public interface IBandService extends IGeneric<Band> {
    List<Band> findByName(String name);
}
