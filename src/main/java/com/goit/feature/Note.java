package com.goit.feature;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Note {
    private String id;
    private String title;
    private String content;
}
