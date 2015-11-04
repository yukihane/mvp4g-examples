package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.list;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = UserListPresenter.class, module = UserListModule.class)
public interface UserListEventBus extends EventBus {

    @Event(handlers = UserListPresenter.class)
    void start();

    @Event(forwardToParent = true)
    void setMasterView(Widget asWidget);

    @Event(handlers = UserListPresenter.class)
    public void showUserList();

    @Event(forwardToParent = true)
    void createNewUser(UserBean userBean);

    @Event(forwardToParent = true, handlers={UserListPresenter.class})
    void selectUser(UserBean user);

    @Event(forwardToParent = true, handlers={UserListPresenter.class})
    void unselectUser();

}
