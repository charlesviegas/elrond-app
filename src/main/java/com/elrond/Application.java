package com.elrond;

import com.elrond.entity.Parametro;
import com.elrond.entity.Usuario;
import com.elrond.entity.UsuarioPerfil;
import com.elrond.repository.ParametroRepository;
import com.elrond.repository.UsuarioPerfilRepository;
import com.elrond.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ParametroRepository parametroRepository,
                                  UsuarioRepository usuarioRepository,
                                  UsuarioPerfilRepository usuarioPerfilRepository) {
        return (args) -> {

            parametroRepository.save(new Parametro("Parametro1", "Valor1", "Descrição 1"));
            parametroRepository.save(new Parametro("Parametro2", "Valor2", "Descrição 2"));
            parametroRepository.save(new Parametro("Parametro3", "Valor3", "Descrição 3"));
            log.info("Parametros importados com sucesso");

            Usuario admin = usuarioRepository.save(new Usuario("admin@elrond.com", "e7d80ffeefa212b7c5c55700e4f7193e"));
            usuarioPerfilRepository.save(new UsuarioPerfil(admin, "ADMINISTRADOR"));
            usuarioPerfilRepository.save(new UsuarioPerfil(admin, "CONSULTOR"));
            log.info("Usuario admin importado com sucesso");

            Usuario consultor = usuarioRepository.save(new Usuario("consultor@elrond.com", "e7d80ffeefa212b7c5c55700e4f7193e"));
            usuarioPerfilRepository.save(new UsuarioPerfil(consultor, "CONSULTOR"));
            log.info("Usuario consultor importado com sucesso");
        };
    }
}
