package com.jamesconlon.financetracker.repository;

import com.jamesconlon.financetracker.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
