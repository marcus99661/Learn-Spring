package com.github.marcus99661.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@Validated
public class TaskController {

    @PostMapping("/user")
    public String userStatus(@RequestBody UserInfo user) {
        if (user.isEnabled()) {
            return "Hello! " + user.getName() + ". Your account is enabled.";
        } else {
            return "Hello! Nice to see you, " + user.getName() + "! Your account is disabled.";
        }
    }

    /*
    ConcurrentMap<String, String> addressBook = new ConcurrentHashMap<>();

    @PostMapping("/addresses")
    public void postAddress(@RequestParam String name, @RequestParam String address) {
        addressBook.put(name, address);
    }

    @GetMapping("/addresses/{name}")
    public String getAddress(@PathVariable String name) {
        return addressBook.get(name);
    }
     */

    /*
    List<Task> taskList = List.of(
            new Task(1, "task1", "A first test task", false),
            new Task(2, "task2", "A second test task", true)
    );

    @GetMapping("/tasks/{id}")
    public Task getTasks(@PathVariable @Min(1) int id) {
        return taskList.get(id);
    }

    @GetMapping("/agents/{id}")
    ResponseEntity<String> validateAgentPathVariable(@PathVariable("id") @Min(1) int id) {
        return ResponseEntity.ok("Agent id is valid.");
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskList;
    }

    @GetMapping("/test")
    public int returnOne() {
        return 1;
    }
     */

}

class Task {

    private int id;
    private String name;
    private String description;
    private boolean completed;

    public Task() {}

    public Task(int id, String name, String description, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
}

class UserInfo {

    private int id;
    private String name = "Richard";
    private String phone;
    private boolean enabled;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    UserInfo() {}
}