package com.notes.project.notesFrontend.service;

import com.notes.project.notesFrontend.model.NoteModel;

import java.util.List;

public interface NoteService {
    NoteModel createNote(NoteModel note);
    List<NoteModel> getAllNotes();
    NoteModel getNoteById(Long id);
    NoteModel updateNote(Long id, NoteModel noteDetails);
    void deleteNote(Long id);


}
