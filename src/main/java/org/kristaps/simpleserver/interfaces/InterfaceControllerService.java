package org.kristaps.simpleserver.interfaces;

import org.kristaps.simpleserver.models.UserModel;

public interface InterfaceControllerService {

    Long createUser(UserModel userModel);

    boolean checkEmailExists(String email);

};
