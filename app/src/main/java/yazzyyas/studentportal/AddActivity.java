package yazzyyas.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText url, titleText;
    private Button addPortal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addportal);

        url = findViewById(R.id.urlText);
        titleText = findViewById(R.id.titleText);
        addPortal = findViewById(R.id.AddPortalBtn);

        url.setText("https://");
        addPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(AddActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("portal", new Portal(url.getText().toString(), titleText.getText().toString()));
                data.putExtras(bundle);

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
