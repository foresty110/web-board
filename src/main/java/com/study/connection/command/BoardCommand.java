package com.study.connection.command;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface BoardCommand {
    public Object processCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
