package com.myproject.pastebox.api.repsonse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteBoxUrlResponse {

    private final String url;
}
