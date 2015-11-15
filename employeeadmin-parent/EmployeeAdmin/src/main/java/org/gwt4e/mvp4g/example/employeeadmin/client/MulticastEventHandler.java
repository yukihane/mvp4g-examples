package org.gwt4e.mvp4g.example.employeeadmin.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.mvp4g.client.annotation.EventHandler;
import com.mvp4g.client.event.BaseEventHandler;

@EventHandler
public class MulticastEventHandler extends BaseEventHandler<EmployeeAdminEventBus> {

    public void onPreSelectUser(UserBean user){
        getEventBus().selectUser(user);
    }

    public void onPreUnselectUser() {
        getEventBus().unselectUser();
    }

}
