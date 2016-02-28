package com.example.mizuno.prog_networkcheck;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NetworkCheckActivity extends AppCompatActivity {

    //ConnectivityManagerの取得
    ConnectivityManager cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_check);

        //ConnectivityManagerの取得
        cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);

        Button button = (Button)findViewById(R.id.button);
        final TextView textView = (TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //network情報の取得
                //マニフェストにACCESS_NETWORK_STATEを追加
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();

                if(networkInfo == null){
                    textView.setText("No Network Connection!");
                    return;
                }
                if(networkInfo.isConnected()){
                    //ネットワーク接続可能
                    textView.setText(String.valueOf(networkInfo.getTypeName()));
                }else{
                    //ネットワーク接続不可能
                    textView.setText("No Network Connection!!");
                }
            }
        });

    }
}
