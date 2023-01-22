package com.goit.feature;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteService {
    private List<Note> noteList = new ArrayList<>();


    public List<Note> listAll() {
        return noteList;
    }

    public Note add(Note note) {
        String tempId = UUID.randomUUID().toString();
        while(isMatch(tempId, listAll())) {
            tempId = UUID.randomUUID().toString();
        }
        note.setId(tempId);
        return note;
    }

    public Note getById(String id) {
       return listAll().stream().filter(note -> note.getId().equals(id)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public void deleteById(String id) {
        listAll().remove(getById(id));
    }

    public void update(Note note) {
        Note noteForUpdate = getById(note.getId());
        noteForUpdate.setTitle(note.getTitle());
        noteForUpdate.setContent(note.getContent());
    }

    private static boolean isMatch(String tempId, List<Note> noteList) {
        return noteList.stream()
                .anyMatch(n -> n.getId().equals(tempId));
    }
}
