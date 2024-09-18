package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditLog;
import com.example.demo.repository.AuditLogRepository;

@Service
public class KafkaConsumerService {

    private final AuditLogRepository auditLogRepository;

    @Autowired
    public KafkaConsumerService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @KafkaListener(topics = "user_topic", groupId = "group_id")
    public void consumeMessage(String message) {
        AuditLog auditLog = new AuditLog();
        auditLog.setMessage(message);
        auditLogRepository.save(auditLog);
    }
}
