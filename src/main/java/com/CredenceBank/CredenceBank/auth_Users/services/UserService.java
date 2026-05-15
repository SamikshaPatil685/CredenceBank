package com.CredenceBank.CredenceBank.auth_Users.services;

import com.CredenceBank.CredenceBank.auth_Users.dtos.UpdatePasswordRequest;
import com.CredenceBank.CredenceBank.auth_Users.dtos.UserDTO;
import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.res.Response;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User getCurrentLoggedInUser();

    Response<UserDTO> getMyProfile();

    Response<Page<UserDTO>> getAllUsers(int page, int size);

    Response<?> updatePassword(UpdatePasswordRequest updatePasswordRequest);

    Response<?> uploadProfilePicture(MultipartFile file);

  //  Response<?> uploadProfilePictureToS3(MultipartFile file);
}
