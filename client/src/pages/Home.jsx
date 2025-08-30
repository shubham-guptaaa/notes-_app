import React, { useEffect, useState } from "react";
import axios from "axios";

export default function Notes() {
  const [notes, setNotes] = useState([]);
  const [newNote, setNewNote] = useState("");
  const [editingId, setEditingId] = useState(null);
  const [editText, setEditText] = useState("");

  useEffect(() => {
    loadNotes();
  }, []);

  // Fetch notes from backend
  const loadNotes = async () => {
    const result = await axios.get("http://localhost:8080/notes");
    setNotes(result.data);
  };

  // Add note
  const addNote = async () => {
    if (!newNote.trim()) return;
    await axios.post("http://localhost:8080/notes", { content: newNote });
    setNewNote("");
    loadNotes();
  };

  // Delete note
  const deleteNote = async (id) => {
    await axios.delete(`http://localhost:8080/notes/${id}`);
    loadNotes();
  };

  // Update note
  const updateNote = async (id) => {
    await axios.put(`http://localhost:8080/notes/${id}`, { content: editText });
    setEditingId(null);
    setEditText("");
    loadNotes();
  };

  return (
    <div className="container mt-4">
      <h2 className="mb-3">Notes App</h2>

      {/* Add new note */}
      <div className="d-flex mb-3">
        <textarea
          className="form-control"
          rows="2"
          placeholder="Write your note here..."
          value={newNote}
          onChange={(e) => setNewNote(e.target.value)}
        />
        <button onClick={addNote} className="btn btn-success ms-2">
          Add
        </button>
      </div>

      {/* Notes List */}
      <ul className="list-group">
        {notes.map((note) => (
          <li key={note.id} className="list-group-item d-flex justify-content-between align-items-center mt-2 shadow">
            {editingId === note.id ? (
              <>
                <textarea
                  className="form-control"
                  rows="2"
                  value={editText}
                  onChange={(e) => setEditText(e.target.value)}
                />
                <button className="btn btn-primary ms-2" onClick={() => updateNote(note.id)}>
                  Save
                </button>
                <button className="btn btn-secondary ms-2" onClick={() => setEditingId(null)}>
                  Cancel
                </button>
              </>
            ) : (
              <>
                <span>{note.content}</span>
                <div>
                  <button
                    className="btn btn-outline-primary btn-sm mx-1"
                    onClick={() => {
                      setEditingId(note.id);
                      setEditText(note.content);
                    }}
                  >
                    Edit
                  </button>
                  <button className="btn btn-danger btn-sm mx-1" onClick={() => deleteNote(note.id)}>
                    Delete
                  </button>
                </div>
              </>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}
