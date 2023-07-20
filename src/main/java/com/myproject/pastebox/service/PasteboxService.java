package com.myproject.pastebox.service;

import com.myproject.pastebox.api.repsonse.PasteBoxUrlResponse;
import com.myproject.pastebox.api.repsonse.PasteboxResponse;
import com.myproject.pastebox.api.request.PasteboxRequest;

import java.util.List;

public interface PasteboxService {

    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPasteboxes();
    PasteBoxUrlResponse create(PasteboxRequest request);
}
