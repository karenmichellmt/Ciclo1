package co.edu.usa.reto1.web;

import co.edu.usa.reto1.model.User;
import co.edu.usa.reto1.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karen Herrera
 * clase UserController
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    
    /**
     *inyecta unas dependencias con otras dentro spring
     */
    @Autowired
    /**
     * privado se llama a UserService
     */
    private UserService userService;
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    /**
     * publica lista user
     */
    public List<User> getAll() {
        /**
         * retornar user
         */
        return userService.getAll();
    }
    /**
     * 
     * @param user
     * @return 
     */
    @PostMapping("/new")
    /**
     * resposito 
     */
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * publica user registro
     */
    public User registrar(@RequestBody User user) {
        /**
         * retornar usre sercicio
         */
        return userService.registrar(user);
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{email}/{password}")
    /**
     * publico user autorizacion
     */
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        /**
         * retornar user servicio
         */
        return userService.autenticarUsuario(email, password);
    }
    /**
     * 
     * @param email
     * @return 
     */
    @GetMapping("/{email}")
    /**
     * publico email
     */
    public boolean existeEmail(@PathVariable("email") String email) {
        /**
         * retornar user servicio
         */
        return userService.existeEmail(email);
    }
    
}