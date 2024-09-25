package com.example.login_to_profile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login_form, Long> {

  

}
