package yazzyyas.studentportal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class AddActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webViewID);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}
