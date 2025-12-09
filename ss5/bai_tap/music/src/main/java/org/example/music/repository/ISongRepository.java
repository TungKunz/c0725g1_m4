package org.example.music.repository;

import org.example.music.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface ISongRepository extends JpaRepository<Song,Integer>{
    Page<Song> findByNameSongContaining(String name, Pageable pageable);
    @Query(value = "select * from song where name like :searchName",nativeQuery = true)
    List<Song> searchName(@Param("searchName") String name);
}
