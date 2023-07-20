package com.myproject.pastebox.api.request;

import com.myproject.pastebox.api.PublicStatus;
import lombok.Data;

@Data
public class PasteboxRequest {

    private String data;
    private long expirationTimeSeconds;
    private PublicStatus publicStatus;
}
