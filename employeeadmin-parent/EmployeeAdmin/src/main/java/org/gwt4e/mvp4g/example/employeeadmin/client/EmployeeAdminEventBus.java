package org.gwt4e.mvp4g.example.employeeadmin.client;

import org.gwt4e.mvp4g.example.employeeadmin.client.ui.shell.ShellPresenter;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.list.UserListModule;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.profile.UserProfileModule;
import org.gwt4e.mvp4g.example.employeeadmin.client.ui.user.role.UserRoleModule;
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
        @ChildModule(moduleClass = UserProfileModule.class, autoDisplay = false),
        @ChildModule(moduleClass = UserRoleModule.class, autoDisplay = false) })
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface EmployeeAdminEventBus
    extends EventBus {

  @Start
  @Event(forwardToModules = { UserListModule.class, UserProfileModule.class, UserRoleModule.class })
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

  @Event(forwardToModules = { UserListModule.class, UserProfileModule.class, UserRoleModule.class })
  public void selectUser(UserBean user);

  @Event(handlers = MulticastEventHandler.class)
  void preUnselectUser();

  @Event(forwardToModules = { UserListModule.class, UserProfileModule.class, UserRoleModule.class })
  public void unselectUser();

  @Event(forwardToModules = { UserProfileModule.class, UserRoleModule.class })
  public void createNewUser(UserBean user);

}
