package dream.view.listener;

import dream.search.MySearch;
import dream.search.MySearchAlgorithm;
import dream.view.ParentView;
import dream.view.user.UserView;

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
