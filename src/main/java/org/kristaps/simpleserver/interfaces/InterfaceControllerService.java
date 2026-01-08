package org.kristaps.simpleserver.interfaces;

import java.util.ArrayList;

import org.kristaps.simpleserver.models.UserModel;

public interface InterfaceControllerService {

    ArrayList<UserModel> getUsers();

    UserModel getUser(long id);

}
