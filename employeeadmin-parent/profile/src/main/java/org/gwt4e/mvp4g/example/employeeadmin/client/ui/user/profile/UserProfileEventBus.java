package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.profile;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = UserProfilePresenter.class, module = UserProfileModule.class)
public interface UserProfileEventBus extends EventBus {

    @Event(handlers = UserProfilePresenter.class)
    void start();

    @Event(handlers = UserProfilePresenter.class)
    public void selectUser(UserBean user);

    @Event(forwardToParent = true)
    void preUnselectUser();

    @Event(handlers = UserProfilePresenter.class)
    void unselectUser();

    @Event(forwardToParent = true)
    void showUserList();

    @Event(forwardToParent = true)
    void setProfileView(Widget widget);

    @Event(handlers = UserProfilePresenter.class)
    void createNewUser(UserBean user);
}
