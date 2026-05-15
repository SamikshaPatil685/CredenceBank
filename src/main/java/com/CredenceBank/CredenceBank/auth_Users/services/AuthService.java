package com.CredenceBank.CredenceBank.auth_Users.services;

import com.CredenceBank.CredenceBank.auth_Users.dtos.LoginRequest;
import com.CredenceBank.CredenceBank.auth_Users.dtos.LoginResponse;
import com.CredenceBank.CredenceBank.auth_Users.dtos.RegistrationRequest;
import com.CredenceBank.CredenceBank.auth_Users.dtos.ResetPasswordRequest;
import com.CredenceBank.CredenceBank.res.Response;

public interface AuthService {

    Response<String > register(RegistrationRequest request);
    Response<LoginResponse> login(LoginRequest loginRequest);
    Response<? > forgetPassword(String email);
    Response<? > updatePasswordViaResetCode(ResetPasswordRequest resetPasswordRequest);
}
