package com.study.connection.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface CommandHandler {
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
