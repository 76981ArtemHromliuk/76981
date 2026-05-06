package com.example.backend;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class Controller 
{

    @PostMapping("/form")
    public String handleForm(@RequestBody User user) 
    {   

        try
        {
            String data = "\nImię: " + user.name + "\nNazwisko: " + user.surname +"\nEmail: " + user.email +"\nWiadomość: " + user.message;

            Files.writeString(Path.of("Dane.txt"), data, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } 
        catch (IOException e) 
        {
            return "Błąd zapisu";
        }
        
        System.out.println(user.name);
        System.out.println(user.surname);
        System.out.println(user.email);
        System.out.println(user.message);
        return "Dane zostały pomyślnie wysłane";
    }
}

 
//   .\mvnw.cmd spring-boot:run
//   76981  