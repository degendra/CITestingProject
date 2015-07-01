package np.pro.degendra.citestingproject;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public UserAdapter(List<User> contactList) {
            this.userList = contactList;
    }

    @Override
    public int getItemCount() {
          return userList.size();
    }

    @Override
    public void onBindViewHolder(UserViewHolder userViewHolder, int i) {
        User ci = userList.get(i);
        userViewHolder.vToolbar.setTitle(ci.name);
        userViewHolder.vName.setText(ci.name);
        userViewHolder.vSurname.setText(ci.surname);
        userViewHolder.vEmail.setText(ci.email);
//        userViewHolder.vTitle.setText(ci.name + " " + ci.surname);

        if(i%2==0){
            userViewHolder.vToolbar.getMenu().findItem(R.id.navigation_item_1).setVisible(false);
        }else{
            userViewHolder.vToolbar.getMenu().findItem(R.id.navigation_item_1).setVisible(true);
        }

   }

   @Override
   public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.card_layout, viewGroup, false);
        return new UserViewHolder(itemView);
   }

  public static class UserViewHolder extends RecyclerView.ViewHolder {
      protected Toolbar vToolbar;
      protected TextView vName;
      protected TextView vSurname;
      protected TextView vEmail;
//      protected TextView vTitle;

      public UserViewHolder(View v) {
          super(v);
          vToolbar = (Toolbar)v.findViewById(R.id.card_toolbar);
          vToolbar.inflateMenu(R.menu.menu_drawer);
          vName =  (TextView) v.findViewById(R.id.txtName);
          vSurname = (TextView)  v.findViewById(R.id.txtSurname);
          vEmail = (TextView)  v.findViewById(R.id.txtEmail);
//          vTitle = (TextView) v.findViewById(R.id.title);
      }
  }
}