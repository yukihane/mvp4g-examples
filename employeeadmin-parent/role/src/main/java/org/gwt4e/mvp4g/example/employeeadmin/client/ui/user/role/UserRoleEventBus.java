package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = UserRolePresenter.class, module = UserRoleModule.class)
public interface UserRoleEventBus extends EventBus {

    @Event(handlers = UserRolePresenter.class)
    void start();

    @Event(forwardToParent = true)
    void setRoleView(Widget widget);

    @Event(forwardToParent = true)
    void preSelectUser(UserBean user);

    @Event(handlers = UserRolePresenter.class)
    void selectUser(UserBean user);

    @Event(handlers = UserRolePresenter.class)
    void unselectUser();

    @Event(handlers = UserRolePresenter.class)
    void createNewUser(UserBean user);
}
