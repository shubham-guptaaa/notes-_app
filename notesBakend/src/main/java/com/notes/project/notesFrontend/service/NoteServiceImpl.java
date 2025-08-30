package com.notes.project.notesFrontend.service;

import com.notes.project.notesFrontend.model.NoteModel;
import com.notes.project.notesFrontend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteModel createNote(NoteModel note) {
        return noteRepository.save(note);
    }

    @Override
    public List<NoteModel> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public NoteModel getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
    }

    @Override
    public NoteModel updateNote(Long id, NoteModel noteDetails) {
        NoteModel existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));

        existingNote.setContent(noteDetails.getContent());
        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNote(Long id) {
        NoteModel existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id " + id));
        noteRepository.delete(existingNote);
    }
}
