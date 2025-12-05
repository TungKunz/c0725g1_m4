package org.example.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private int idBlog;
    private String content;
    private String detail;
    private int idCategory;
    private String nameCategory;

}
