package main.controllers;

import lombok.extern.log4j.Log4j2;
import main.api.request.PresentationRequest;
import main.api.request.UserRequest;
import main.service.PresentationService;
import main.service.ScheduleService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2
@RestController
@RequestMapping("/api/")
public class ApiGeneralController
{
    private final UserService userService;
    private final PresentationService presentationService;
    private final ScheduleService scheduleService;

    @Autowired
    public ApiGeneralController(UserService userService,
                                PresentationService presentationService,
                                ScheduleService scheduleService)
    {
        this.userService = userService;
        this.presentationService = presentationService;
        this.scheduleService = scheduleService;
    }

//    @GetMapping("users/roles")
//    public ResponseEntity getRolesUsers()
//    {
//        return ResponseEntity.ok(userService.getRoles());
//    }

    @PutMapping("users")
    public ResponseEntity updateUsers(@RequestBody UserRequest userRequest)
    {
        userService.updateUser(userRequest);
        return ResponseEntity.ok(userRequest);
    }

    @PostMapping("users")
    public ResponseEntity registrationUser(@RequestBody UserRequest userRequest)
    {
        userService.regUser(userRequest);
        return ResponseEntity.ok(userRequest);
    }

    @DeleteMapping("users")
    public ResponseEntity deleteUsers(@PathVariable String login)
    {
        userService.deleteUser(login);
        return ResponseEntity.ok(login);
    }

    @DeleteMapping("presentation")
    public ResponseEntity deletePresentation(@PathVariable Integer id)
    {
        presentationService.deletePresentation(id);
        return ResponseEntity.ok(id);
    }

    @PutMapping("presentation")
    public ResponseEntity updatePresentation(@RequestBody PresentationRequest presentationRequest)
    {
        presentationService.updatePresentation(presentationRequest);
        return ResponseEntity.ok(presentationRequest);
    }
}