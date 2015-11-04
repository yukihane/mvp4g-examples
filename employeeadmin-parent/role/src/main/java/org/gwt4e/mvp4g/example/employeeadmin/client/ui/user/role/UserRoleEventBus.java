package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.event.EventBus;

public interface UserRoleEventBus extends EventBus {

    void setRoleView(Widget widget);

    void selectUser(UserBean user);

}
