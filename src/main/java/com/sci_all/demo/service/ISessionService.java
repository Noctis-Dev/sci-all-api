package com.sci_all.demo.service;

import com.sci_all.demo.persistance.entities.Session;
import com.sci_all.demo.persistance.entities.User;

public interface ISessionService {
    Session createSession(User email);
}
