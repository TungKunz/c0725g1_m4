package org.example.dictionary;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("dog", "con chó");
        dictionary.put("cat", "con mèo");
        dictionary.put("car", "xe hơi");
    }

    @GetMapping("/")
    public String home() {
        return "dictionary";
    }


    @PostMapping("/translate")
    public String translate(@RequestParam(name = "word") String word, Model model) {
        String result = dictionary.get(word.toLowerCase());
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        model.addAttribute("searched", true);
        return "dictionary";
    }
}