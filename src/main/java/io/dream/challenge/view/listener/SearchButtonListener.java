package io.dream.challenge.view.listener;

import io.dream.challenge.search.MySearch;
import io.dream.challenge.search.MySearchAlgorithm;
import io.dream.challenge.view.ParentView;
import io.dream.challenge.view.user.UserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchButtonListener implements ActionListener {

  private final UserView userView;
  private final MySearch<ParentView> search;

  public SearchButtonListener(UserView userView) {
    this.userView = userView;
    this.search = new MySearchAlgorithm();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    search.perform(userView);
  }

}
