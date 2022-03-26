package com.example.tst.controller;

import com.example.tst.entity.TypeEntity;
import com.example.tst.exception.NotFoundTypeException;
import com.example.tst.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/type"})
public class TypeController {
    @Autowired
    private TypeService typeService;

    public TypeController() {
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
    public ResponseEntity getType() {
        try {
            return ResponseEntity.ok(this.typeService.getAllType());
        } catch (Exception var2) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping({"/{id}"})
    public ResponseEntity getOneType(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(this.typeService.getOneType(id));
        } catch (NotFoundTypeException var3) {
            return ResponseEntity.badRequest().body(var3.getMessage());
        } catch (Exception var4) {
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
