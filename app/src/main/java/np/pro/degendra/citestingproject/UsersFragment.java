package np.pro.degendra.citestingproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bajra on 6/30/15.
 */
public class UsersFragment extends Fragment{
    private ListView userListView;
    public UsersFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        RecyclerView recList = (RecyclerView) v.findViewById(R.id.userList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        UserAdapter ca = new UserAdapter(createList(30));
        recList.setAdapter(ca);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(getActivity(), UserActivity.class));
            }
        });

        return v;
    }

    private List createList(int size) {

        List result = new ArrayList();
        for (int i=1; i <= size; i++) {
            User ci = new User();
            ci.name = User.NAME_PREFIX + i;
            ci.surname = User.SURNAME_PREFIX + i;
            ci.email = User.EMAIL_PREFIX + i + "@test.com";

            result.add(ci);

        }

        return result;
    }
}
