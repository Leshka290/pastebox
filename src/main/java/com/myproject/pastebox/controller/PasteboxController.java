package com.myproject.pastebox.controller;

import com.myproject.pastebox.api.request.PasteboxRequest;
import com.myproject.pastebox.service.PasteboxService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/paste")
@RequiredArgsConstructor
public class PasteboxController {

   private final PasteboxService pasteboxService;
    @GetMapping("/{hash}")
    public ResponseEntity<?> getHash(@PathVariable String hash) {
        pasteboxService.getByHash(hash);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<?> getFirstPublicPasteboxes() {
        pasteboxService.getFirstPublicPasteboxes();
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<?> add(PasteboxRequest pasteboxRequest) {
        pasteboxService.create(pasteboxRequest);
        return ResponseEntity.ok().build();
    }
}
