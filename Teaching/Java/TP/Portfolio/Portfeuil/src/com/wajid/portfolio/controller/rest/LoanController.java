/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wajid.portfolio.controller.rest;

import com.wajid.portfolio.exception.ResourceNotFoundException;
import com.wajid.portfolio.model.LoanDetail;
import com.wajid.portfolio.repository.LoanRepository;
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
public class LoanController {

    @Autowired
    LoanRepository trep;

    @GetMapping("/loans")
    public List<LoanDetail> getAllNotes() {
        return trep.findAll();
    }

    @PostMapping("/loans")
    public LoanDetail createNote(@Valid @RequestBody LoanDetail note) {
        return trep.save(note);
    }

    @GetMapping("/loans/{id}")
    public LoanDetail getNoteById(@PathVariable(value = "id") Long noteId) {
        return trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/loans/{id}")
    public LoanDetail updateNote(@PathVariable(value = "id") Long noteId,
            @Valid @RequestBody LoanDetail det) {

        LoanDetail ld = trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        ld.setLoanName(det.getLoanName());
        ld.setLoanAmount(det.getLoanAmount());

        LoanDetail updatedNote = trep.save(ld);
        return updatedNote;
    }

    @DeleteMapping("/loans/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        LoanDetail note = trep.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        trep.delete(note);

        return ResponseEntity.ok().build();
    }

}
