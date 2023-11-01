package com.ciai.assignment.presentation

import com.ciai.assignment.data.User
import com.ciai.assignment.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userRepository: UserRepository
) {

    @PostMapping
    fun addUser(@RequestBody user: User) =
        userRepository.save(user)

    @GetMapping
    fun getUsers(): MutableIterable<User> = userRepository.findAll()

}