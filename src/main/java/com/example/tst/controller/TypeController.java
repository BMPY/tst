package com.example.tst.controller;

import com.example.tst.entity.TypeEntity;
import com.example.tst.exception.NotFoundTypeException;
import com.example.tst.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"/type"})
public class TypeController {

    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody TypeEntity type) {
        try {
            this.typeService.post(type);
            return ResponseEntity.ok("Type was created");
        } catch (Exception var3) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping
    public ResponseEntity getType(@RequestParam(required = false) Long id) {
        try {
            if(id == null)
                return ResponseEntity.ok(this.typeService.getAllType());

            return ResponseEntity.ok(this.typeService.getOneType(id));
        } catch (Exception var2) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.typeService.delete(id));
        } catch (Exception var3) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
