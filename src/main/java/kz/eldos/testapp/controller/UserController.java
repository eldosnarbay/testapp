package kz.eldos.testapp.controller;

import kz.eldos.testapp.model.User;
import kz.eldos.testapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable(value = "id") Long id) {

        User user = userService.getById(id);
        if (user == null) {
            return new ResponseEntity<>("Пользователь не найден", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody User user) {

        try {
            // validations
            if(user.getName() == null) {
                throw new IllegalArgumentException("Поле имя не может быть пустым");
            }
            if(user.getPassword() == null) {
                throw new IllegalArgumentException("Пароль не может быть пустым");
            }
            if(user.getPassword().length() < 4 || user.getPassword().length() > 50) {
                throw new ValidationException("Невреная длина пароля");
            }

            userService.addUser(user);

            Map<String, Long> obj = new HashMap<>();
            obj.put("id", user.getId());

            return new ResponseEntity<>(obj, HttpStatus.OK);
        } catch (ValidationException | IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable(value = "id") Long id, @RequestBody User user) {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }


        if(user == null) {
            return ResponseEntity.noContent().build();
        }

        if(user.getId() == null) {
            user.setId(id);
        }

        userService.updateUser(user);

        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        if(id == null) {
            return ResponseEntity.noContent().build();
        }

        User user = userService.getById(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            userService.delete(user);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Ошибки с сервером", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
