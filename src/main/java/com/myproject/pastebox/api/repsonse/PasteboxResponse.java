package com.myproject.pastebox.api.repsonse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PasteboxResponse {

    private String data;
    private boolean isPublic;
}
