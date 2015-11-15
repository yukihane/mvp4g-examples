package org.gwt4e.mvp4g.example.employeeadmin.client;

import org.gwt4e.mvp4g.example.employeeadmin.client.ui.shell.ShellPresenter;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.list.UserListModule;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.profile.UserProfileModule;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role.UserRoleEventBus;
import org.gwt4e.mvp4g.example.employeeadmin.shared.dto.UserBean;

import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.annotation.Debug;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.annotation.module.ChildModule;
import com.mvp4g.client.annotation.module.ChildModules;
import com.mvp4g.client.event.EventBus;

@Events(startPresenter = ShellPresenter.class,
           historyOnStart = false)
@ChildModules({ @ChildModule(moduleClass = UserListModule.class, autoDisplay = false),
        @ChildModule(moduleClass = UserProfileModule.class, autoDisplay = false) })
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface EmployeeAdminEventBus
    extends EventBus, UserRoleEventBus {

  @Start
  @Event(handlerNames = { "userRolePresenter" }, forwardToModules = { UserListModule.class, UserProfileModule.class })
  public void start();

  @Event(handlerNames = "shellPresenter")
  public void setMasterView(Widget widget);

  @Event(handlerNames = "shellPresenter")
  public void setProfileView(Widget widget);

  @Event(handlerNames = "shellPresenter")
  public void setRoleView(Widget widget);

  @Event(forwardToModules = { UserListModule.class })
  public void showUserList();

  @Event(handlers = MulticastEventHandler.class)
  void preSelectUser(UserBean user);

  @Event(handlerNames = {"userRolePresenter"}, forwardToModules = { UserListModule.class, UserProfileModule.class })
  public void selectUser(UserBean user);

  @Event(handlers = MulticastEventHandler.class)
  void preUnselectUser();

  @Event(handlerNames = {"userRolePresenter"}, forwardToModules = { UserListModule.class, UserProfileModule.class })
  public void unselectUser();

  @Event(handlerNames = { "userRolePresenter" }, forwardToModules = { UserProfileModule.class })
  public void createNewUser(UserBean user);

}
