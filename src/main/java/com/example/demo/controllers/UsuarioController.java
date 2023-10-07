package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsuarioRepository;
import com.example.demo.exceptions.UsuarioNotFoundException;
import com.example.demo.model.Usuario;

@RestController
// @RequestMapping(path = "/api")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(path = "/add")
    public Usuario addNewUser(@RequestBody Usuario newUsuario) {
        return usuarioRepository.save(newUsuario);
    }

    @GetMapping("/usuarios")
    List<Usuario> all() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/{id}")
    Usuario one(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    @PutMapping("/usuarios/{id}")
    Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setName(newUsuario.getName());
                    usuario.setEmail(newUsuario.getEmail());
                    return usuarioRepository.save(usuario);
                })
                .orElseGet(() -> {
                    newUsuario.setId(id);
                    return usuarioRepository.save(newUsuario);
                });
    }

    @DeleteMapping("/usuarios/{id}")
    void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

}
