package com.myproject.pastebox.service;

import com.myproject.pastebox.api.PublicStatus;
import com.myproject.pastebox.api.repsonse.PasteBoxUrlResponse;
import com.myproject.pastebox.api.repsonse.PasteboxResponse;
import com.myproject.pastebox.api.request.PasteboxRequest;
import com.myproject.pastebox.model.PasteboxEntity;
import com.myproject.pastebox.repository.PasteboxRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PasteboxServiceImplTest {

    @InjectMocks
    private PasteboxServiceImpl pasteboxService;

    @Mock
    private PasteboxRepository pasteboxRepository;

    private final String HASHCODE = "hashcode";
    private final String DATA = "data";
    private final boolean ISPUBLIC = true;

    private final PasteboxEntity pasteboxEntity = new PasteboxEntity();

    public PasteboxEntity getPasteboxEntity(PasteboxEntity entity) {
        pasteboxEntity.setHash(HASHCODE);
        pasteboxEntity.setData(DATA);
        pasteboxEntity.setPublic(ISPUBLIC);
        pasteboxEntity.setId(1L);
        pasteboxEntity.setLifetime(LocalDateTime.now());
        return entity;
    }
    @Test
    public void getByHashTest() {

        PasteboxResponse response = new PasteboxResponse(DATA, ISPUBLIC);

        Mockito.when(pasteboxRepository.save(pasteboxEntity)).thenReturn(getPasteboxEntity(pasteboxEntity));
        Mockito.when(pasteboxRepository.getByHash(HASHCODE)).thenReturn(pasteboxEntity);

        assertEquals(response, pasteboxService.getByHash(HASHCODE));
    }

    @Test
    public void createTest() {

        PasteboxRequest request = new PasteboxRequest();
        request.setData(DATA);
        request.setExpirationTimeSeconds(1);
        request.setPublicStatus(PublicStatus.PUBLIC);

        assertNotNull(pasteboxService.create(request));
    }
}
