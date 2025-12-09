package org.example.music.controller;

import jakarta.validation.Valid;
import org.example.music.dto.SongDTO;
import org.example.music.entity.Song;
import org.example.music.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService songService;
    @GetMapping(value = "")
    public String showList(
            @RequestParam(name = "page", required = false, defaultValue ="0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "3") int size,
            @RequestParam(name = "searchName", required = false, defaultValue = "") String searchName,
            Model model) {
        Sort sort = Sort.by("nameSong").ascending().and(Sort.by("nameArtist").descending());
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Song> songPage = songService.findAll(searchName, pageable);
        model.addAttribute("songPage", songPage);
        model.addAttribute("searchName", searchName);
        return "song/list";
    }

    @GetMapping(value = "/create")
    public String showFormAdd(Model model){
        model.addAttribute("song",new SongDTO());
        return "song/create";
    }
    @PostMapping(value = "/create")
    public String addSong(@Valid @ModelAttribute("song") SongDTO songDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        songService.addSong(song);
        redirectAttributes.addFlashAttribute("message", "Thêm bài hát thành công!");
        return "redirect:";
    }

}
