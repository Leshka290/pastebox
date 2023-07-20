package com.myproject.pastebox.repository;

import com.myproject.pastebox.model.PasteboxEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PasteboxRepository extends CrudRepository<PasteboxEntity, Long> {
    PasteboxEntity getByHash(String hash);

    List<PasteboxEntity> getAllBy();
}
