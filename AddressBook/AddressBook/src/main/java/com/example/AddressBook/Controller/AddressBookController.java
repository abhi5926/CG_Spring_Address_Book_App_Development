package com.example.AddressBook.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Returning all contacts");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Returning contact with ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> addContact(@RequestBody String contact) {
        return ResponseEntity.ok("Contact added: " + contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id, @RequestBody String contact) {
        return ResponseEntity.ok("Contact updated with ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {
        return ResponseEntity.ok("Contact deleted with ID: " + id);
    }
}
