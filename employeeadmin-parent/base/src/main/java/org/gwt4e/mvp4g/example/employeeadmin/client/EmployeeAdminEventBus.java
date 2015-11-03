package org.gwt4e.mvp4g.example.employeeadmin.client;

import org.gwt4e.mvp4g.example.employeeadmin.client.ui.shell.ShellPresenter;
import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = ShellPresenter.class,
           historyOnStart = false)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface EmployeeAdminEventBus
    extends EventBus {

  @Start
  @Event(handlerNames = {"userProfilePresenter", "userRolePresenter", "userListPresenter"})
  public void start();

  @Event(handlerNames = "shellPresenter")
  public void setMasterView(Widget widget);

  @Event(handlerNames = "shellPresenter")
  public void setProfileView(Widget widget);

  @Event(handlerNames = "shellPresenter")
  public void setRoleView(Widget widget);

  @Event(handlerNames = "userListPresenter")
  public void showUserList();

  @Event(handlerNames = {"userProfilePresenter", "userRolePresenter", "userListPresenter"})
  public void selectUser(UserBean user);

  @Event(handlerNames = {"userProfilePresenter", "userRolePresenter", "userListPresenter"})
  public void unselectUser();

  @Event(handlerNames = {"userProfilePresenter", "userRolePresenter"})
  public void createNewUser(UserBean user);

}
