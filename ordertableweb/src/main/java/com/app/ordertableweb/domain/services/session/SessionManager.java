

package com.app.ordertableweb.domain.services.session;

import java.util.HashMap;
import java.util.Map;

import com.app.ordertableweb.domain.models.data.Session;

public class SessionManager {
    private static SessionManager instance;
    private Map<String, Session> sessionMap;

    private SessionManager() {
        sessionMap = new HashMap<>();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

