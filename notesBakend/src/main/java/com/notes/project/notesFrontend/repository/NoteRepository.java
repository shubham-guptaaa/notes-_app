package com.notes.project.notesFrontend.repository;

import com.notes.project.notesFrontend.model.NoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<NoteModel, Long> {

}
