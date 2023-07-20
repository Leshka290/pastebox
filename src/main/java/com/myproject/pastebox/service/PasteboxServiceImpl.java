package com.myproject.pastebox.service;

import com.myproject.pastebox.api.PublicStatus;
import com.myproject.pastebox.api.repsonse.PasteBoxUrlResponse;
import com.myproject.pastebox.api.repsonse.PasteboxResponse;
import com.myproject.pastebox.api.request.PasteboxRequest;
import com.myproject.pastebox.model.PasteboxEntity;
import com.myproject.pastebox.repository.PasteboxRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@PropertySource("application.properties")
public class PasteboxServiceImpl implements PasteboxService {

    @Value("${pastebox.host}")
    String host;

    @Autowired
    private PasteboxRepository pasteboxRepository;


    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity pasteboxEntity = pasteboxRepository.getByHash(hash);
        return new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic());
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPasteboxes() {
        List<PasteboxEntity> list = pasteboxRepository.getAllBy();


        return list.stream().map(pasteboxEntity ->
                        new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public PasteBoxUrlResponse create(PasteboxRequest request) {
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setId(1L);
        pasteboxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        pasteboxEntity.setData(request.getData());
        pasteboxEntity.setHash(randomStrGenerator());
        pasteboxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);

        pasteboxRepository.save(pasteboxEntity);
        return new PasteBoxUrlResponse(host + "/" + pasteboxEntity.getHash());
    }

    private String randomStrGenerator() {
        RandomString randomString = new RandomString(8, ThreadLocalRandom.current());
        return randomString.nextString().toLowerCase();
    }
}
