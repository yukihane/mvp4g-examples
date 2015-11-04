package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.list;

import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.event.EventBus;

public interface UserListEventBus extends EventBus {

    void setMasterView(Widget asWidget);

    void showUserList();

    void createNewUser(UserBean userBean);

    void selectUser(UserBean user);

    void unselectUser();

}
