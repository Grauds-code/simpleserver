package org.kristaps.simpleserver.services;

import org.kristaps.simpleserver.interfaces.InterfaceControllerService;
import org.kristaps.simpleserver.models.UserModel;
import org.kristaps.simpleserver.repository.ControllerRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ControllerService implements InterfaceControllerService {

    private final ControllerRepository controllerRepository;

    @Override
    public Long createUser(UserModel userModel) {
        if (userModel.getChildren() != null) {
            userModel.getChildren().forEach(child -> child.setUserModel(userModel));
        }

        UserModel savedUser = controllerRepository.saveAndFlush(userModel);
        System.out.println(savedUser);
        return savedUser.getId();
    }

    @Override

    public boolean checkEmailExists(String email) {
        return controllerRepository.existsByEmail(email);
    }
}
