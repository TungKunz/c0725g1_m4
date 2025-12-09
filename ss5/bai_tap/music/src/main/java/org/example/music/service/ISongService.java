package org.example.music.service;

import org.example.music.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ISongService {
    boolean addSong(Song song);
    boolean deleteSong(int id);
    Page<Song> findAll(String name, Pageable pageable);
}
