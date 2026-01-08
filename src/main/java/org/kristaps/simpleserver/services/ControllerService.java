package org.kristaps.simpleserver.services;

import java.util.ArrayList;

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
    public ArrayList<UserModel> getUsers() {

        return (ArrayList<UserModel>) controllerRepository.findAll();
    }

    public UserModel getUser(long id) {
        return controllerRepository.findById(id).orElse(null);
    }
}
