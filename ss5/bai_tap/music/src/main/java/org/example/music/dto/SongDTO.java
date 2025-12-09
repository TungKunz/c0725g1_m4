package org.example.music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL; // Cần thêm dependency cho @URL

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {

    @NotBlank(message = "Tên bài hát không được để trống.")
    @Size(min = 2, max = 100, message = "Tên bài hát phải từ 2 đến 100 ký tự.")
    private String nameSong;

    @NotBlank(message = "Tên nghệ sĩ không được để trống.")
    @Size(min = 2, max = 100, message = "Tên nghệ sĩ phải từ 2 đến 100 ký tự.")
    private String nameArtist;

    @NotBlank(message = "Thể loại không được để trống.")
    @Size(max = 50, message = "Thể loại không được vượt quá 50 ký tự.")
    private String style;

    @URL(message = "URL bài hát phải là một địa chỉ hợp lệ.")
    private String urlSong;
}