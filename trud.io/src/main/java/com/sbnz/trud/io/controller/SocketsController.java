package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.sockets.SocketsModule;

@RestController
@RequestMapping("/api/v1/sockets")
public class SocketsController {

  private final SocketsModule socketsModule;

  @Autowired
  public SocketsController(SocketsModule socketsModule) {
    this.socketsModule = socketsModule;
  }

  @PostMapping("{namespaceName}")
  public ResponseEntity<Object> initializeNamespace(@PathVariable String namespaceName) {
    socketsModule.tryToRegisterNameSpace(namespaceName);

    return ResponseEntity.ok(null);
  }
  
}
