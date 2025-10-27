package com.example.moviereview.dto;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDTO {
    private Long id;
    private String title;
    private String genre;
    private int year;
    private List<ReviewResponseDTO> reviews;
}
