package com.fullStack.serviceBookingSystem.services.authantcation;

import com.fullStack.serviceBookingSystem.dto.SignupRequestDTO;
import com.fullStack.serviceBookingSystem.dto.UserDto;

public interface AuthService {
     UserDto signupClient(SignupRequestDTO signupRequestDTO);
     boolean presentByEmail(String email);
     UserDto signupCompany(SignupRequestDTO signupRequestDTO);
}
