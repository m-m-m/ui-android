/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package io.github.mmm.ui.android;

import java.util.concurrent.Callable;

import io.github.mmm.ui.spi.AbstractUiDispatcher;

/**
 * Implementation of {@link io.github.mmm.ui.api.UiDispatcher} for android.
 *
 * @since 1.0.0
 */
public class AndroidDispatcher extends AbstractUiDispatcher {

  @Override
  public boolean isDispatchThread() {

    return true;
  }

  @Override
  public void invokeUiTask(Runnable task) {

    task.run();
  }

  @Override
  public void invokeAsynchron(Runnable task) {

    // TODO
    task.run();
  }

  @Override
  public void invokeTimer(Runnable task, int delayMilliseconds) {

    // TODO Auto-generated method stub
    task.run();
  }

  @Override
  public void invokeTimer(Callable<Boolean> task, int delayMilliseconds) {

    // TODO Auto-generated method stub
    try {
      task.call();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
