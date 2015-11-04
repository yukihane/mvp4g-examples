package org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.profile;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.event.EventBus;

public interface UserProfileEventBus extends EventBus {

    void unselectUser();

    void showUserList();

    void setProfileView(Widget widget);

}
