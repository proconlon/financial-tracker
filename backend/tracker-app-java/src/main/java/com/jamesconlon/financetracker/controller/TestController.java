package com.jamesconlon.financetracker.controller;

import com.jamesconlon.financetracker.model.Entry;
import com.jamesconlon.financetracker.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/entries")
    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    @PostMapping("/entries")
    public Entry createEntry(@RequestBody Entry entry) {
        entry.setDate(LocalDate.now());
        return entryRepository.save(entry);
    }
}