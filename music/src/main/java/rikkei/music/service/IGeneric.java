package rikkei.music.service;

import rikkei.music.model.Singer;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();
    void save(Singer singer);
    Singer findById(int id);
    void deleteById(int id);
}
