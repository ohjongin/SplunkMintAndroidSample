package me.ji5.test.splunk.mint;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.splunk.mint.Mint;

public class MainMintActivity extends MainActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apikey = getString(R.string.splunk_mint_api_key);
        if (TextUtils.isEmpty(apikey)) {
            Toast.makeText(this, "API가 없습니다", Toast.LENGTH_LONG).show();
            finish();
        }

        Mint.initAndStartSession(this.getApplication(), apikey);

        initViews();
    }

    protected void initViews() {
        Button btnCrash = findViewById(R.id.btn_crash);
        btnCrash.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_crash:
                onBtnCrash();
                break;
        }
    }

    protected void onBtnCrash() {
        throw new RuntimeException("User generate a crash !!!");
    }
}
