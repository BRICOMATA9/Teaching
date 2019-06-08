/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wajid.portfolio.controller.rest;

import com.wajid.portfolio.exception.ResourceNotFoundException;
import com.wajid.portfolio.model.TransactionEntry;
import com.wajid.portfolio.repository.TransactionRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api")
public class TransactionController {

    @Autowired
    TransactionRepository trep;

    @GetMapping("/transactions")
    public List<TransactionEntry> getAllNotes() {
        return trep.findAll();
    }

    @PostMapping("/transactions")
    public TransactionEntry createNote(@Valid @RequestBody TransactionEntry note) {
        return trep.save(note);
    }

    @GetMapping("/transactions/{id}")
    public TransactionEntry getNoteById(@PathVariable(value = "id") Long noteId) {
        return trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/transactions/{id}")
    public TransactionEntry updateNote(@PathVariable(value = "id") Long noteId,
            @Valid @RequestBody TransactionEntry noteDetails) {

        TransactionEntry note = trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setStockName(noteDetails.getStockName());
        note.setStockQuantity(noteDetails.getStockQuantity());

        TransactionEntry updatedNote = trep.save(note);
        return updatedNote;
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        TransactionEntry note = trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        trep.delete(note);
        return ResponseEntity.ok().build();
    }

}
