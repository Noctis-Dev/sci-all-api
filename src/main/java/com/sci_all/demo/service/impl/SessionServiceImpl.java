package com.sci_all.demo.service.impl;

import com.sci_all.demo.persistance.entities.Session;
import com.sci_all.demo.persistance.entities.User;
import com.sci_all.demo.persistance.repositories.SessionRepository;
import com.sci_all.demo.service.ISessionService;
import com.sci_all.demo.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SessionServiceImpl implements ISessionService {

    @Autowired
    private SessionRepository repository;

    @Override
    public Session createSession(User user) {
        Session session = new Session();

        session.setCreatedAt(LocalDate.now());
        session.setUser(user);
        session.setVerified(true);
        session.setUuid(UUIDUtils.generateUniqueUUID(repository));

        return repository.save(session);
    }
}
