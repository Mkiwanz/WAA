package edu.miu.LabHW.service;


import edu.miu.LabHW.entity.dto.request.LoginRequest;
import edu.miu.LabHW.entity.dto.request.RefreshTokenRequest;
import edu.miu.LabHW.entity.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
