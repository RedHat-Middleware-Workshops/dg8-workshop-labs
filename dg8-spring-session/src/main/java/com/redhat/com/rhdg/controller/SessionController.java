package com.redhat.com.rhdg.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpSession;

import org.infinispan.spring.embedded.provider.SpringEmbeddedCacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
  private final AtomicInteger count = new AtomicInteger();

  @Autowired
  private SpringEmbeddedCacheManager cacheManager;

  @GetMapping("/session")
  public Map<String, String> createSession(HttpSession session) {
    Map<String, String> result = new HashMap<>();
    String sessionId = session.getId();

    result.put("created:", sessionId);
    result.put("active", this.cacheManager.getCache("sessions").getNativeCache().keySet().toString());
    result.put("count:", String.valueOf(this.count.getAndIncrement()));

    return result;
  }

  @GetMapping("/delete")
  public void deleteSession(HttpSession session) {
    session.invalidate();
    this.count.set(0);
  }
}