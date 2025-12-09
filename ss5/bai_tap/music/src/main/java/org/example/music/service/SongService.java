package org.example.music.service;

import org.example.music.entity.Song;
import org.example.music.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public boolean addSong(Song song) {
        return songRepository.save(song)!=null;
    }

    @Override
    public boolean deleteSong(int id) {
        try {
            songRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Page<Song> findAll(String name, Pageable pageable) {
        return songRepository.findByNameSongContaining(name,pageable);
    }
}
