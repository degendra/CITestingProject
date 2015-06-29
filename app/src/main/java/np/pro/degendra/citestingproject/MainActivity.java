package np.pro.degendra.citestingproject;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName;
    TextView textView;
    Button save;
    TextInputLayout firstNameWrapper, lastNameWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);

        firstNameWrapper = (TextInputLayout) findViewById(R.id.firstNameWrapper);
        lastNameWrapper = (TextInputLayout) findViewById(R.id.lastNameWrapper);

        firstNameWrapper.setErrorEnabled(true);
        lastNameWrapper.setErrorEnabled(true);

        textView = (TextView) findViewById(R.id.textView);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTextView();
            }
        });
    }

    private void updateTextView() {
        if (firstName.getText().toString().isEmpty()) {
            firstNameWrapper.setError(getString(R.string.error_first_name_empty));
            lastNameWrapper.setError(null);
        } else if (lastName.getText().toString().isEmpty()) {
            firstNameWrapper.setError(null);
            lastNameWrapper.setError(getString(R.string.error_last_name_empty));
        } else {
            lastNameWrapper.setError(null);
            textView.setText(firstName.getText().toString() + " " + lastName.getText().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
