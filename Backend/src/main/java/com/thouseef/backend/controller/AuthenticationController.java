package com.thouseef.backend.controller;


import com.thouseef.backend.dto.LoginRequest;
import com.thouseef.backend.services.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController {
    private final EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(employeeService.login(request));
    }
}
