package com.example.controller;

import com.example.model.MetaData;
import com.example.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class interviewProjectController {
    private final KafkaTemplate<String, MetaData> kafkaTemplate;

    public interviewProjectController(KafkaTemplate<String, MetaData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/store-content")
    public ResponseEntity<Void> storeMetadata(@RequestBody MetaData storeRequestMetadata){
        kafkaTemplate.send(
                KafkaProducer.DOCUMENT_METADATA,
                storeRequestMetadata.getDocumentId(),
                storeRequestMetadata
        );

        return ResponseEntity.accepted().build();

    }
}
