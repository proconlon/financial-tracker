package com.jamesconlon.financetracker.service;

import com.jamesconlon.financetracker.model.Entry;
import com.jamesconlon.financetracker.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/*
    EntryService is a SpringBoot service class that provides methods for creating, reading, updating,
    and deleting Entry objects in the database.
    It uses the EntryRepository interface to interact with the database.
*/

@Service
public class EntryService {
    @Autowired
    private EntryRepository entryRepository;

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public Entry getEntryById(Long id) {
        return entryRepository.findById(id).orElse(null);
    }

    public List<Entry> getAllEntries() {
        return entryRepository.findAll();
    }

    public void deleteEntry(Long id) {
        entryRepository.deleteById(id);
    }

    public Entry updateEntry(Long id, Entry entry) {
        Entry existingEntry = entryRepository.findById(id).orElse(null);
        if (existingEntry != null) {
            existingEntry.setAmount(entry.getAmount());
            existingEntry.setCategory(entry.getCategory());
            existingEntry.setMerchant(entry.getMerchant());
            existingEntry.setDate(entry.getDate());
            return entryRepository.save(existingEntry);
        } else {
            return null;
        }
    }
}

