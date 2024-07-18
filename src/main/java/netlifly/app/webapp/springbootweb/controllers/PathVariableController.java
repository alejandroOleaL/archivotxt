package netlifly.app.webapp.springbootweb.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${regiones}")
    private String regiones;

    @Value("${ciclos}")
    private String ciclos;

    @GetMapping("/archivo")
    public void archivo() {
        String fileName = "my-file.txt";
		System.out.println("Regiones: " + regiones);
		System.out.println("Ciclos: " + ciclos);

        try {
        List<String> lines = Arrays.asList(regiones, ciclos);
        Path file = Paths.get(fileName);
        Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }
}
