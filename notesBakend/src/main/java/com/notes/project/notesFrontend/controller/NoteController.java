package com.notes.project.notesFrontend.controller;

import com.notes.project.notesFrontend.model.NoteModel;
import com.notes.project.notesFrontend.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:5173")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Create Note
    @PostMapping
    public NoteModel createNote(@RequestBody NoteModel note) {
        return noteService.createNote(note);
    }

    // Get All Notes
    @GetMapping
    public List<NoteModel> getAllNotes() {
        return noteService.getAllNotes();
    }

    // Get Note by ID
    @GetMapping("/{id}")
    public NoteModel getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    // Update Note
    @PutMapping("/{id}")
    public NoteModel updateNote(@PathVariable Long id, @RequestBody NoteModel noteDetails) {
        return noteService.updateNote(id, noteDetails);
    }

    // Delete Note
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "Note deleted successfully with id " + id;
    }
}
