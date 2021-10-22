package com.example.practice26;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Web;
    Button Map;
    Button Call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Web = (Button) findViewById(R.id.Web);
        Map = (Button) findViewById(R.id.Map);
        Call = (Button) findViewById(R.id.Call);
        Web.setOnClickListener(this::onClick);
        Map.setOnClickListener(this::onClick);
        Call.setOnClickListener(this::onClick);
    }

    public  void onClick(View v){
        Intent intetn;
        switch (v.getId()) {
            case R.id.Web:
                intetn = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                startActivity(intetn);
                break;
            case R.id.Map:
                intetn = new Intent();
                intetn.setAction(Intent.ACTION_VIEW);
                intetn.setData(Uri.parse("geo:55.754283,37.62002"));
                startActivity(intetn);
                break;
            case R.id.Call:
                intetn = new Intent(Intent.ACTION_DIAL);
                intetn.setData(Uri.parse("tel:12345"));
                startActivity(intetn);
                break;
            default:
                break;
        }
    }
}

// Uri - объект, который разбирает строку на составляющие и хранит информацию из нее.
//---------------------------------------------------------------------------------------------
// Тип содержимого можно определить по Scheme. И этот же Scheme можно настроить в Intent Filter
// и отсеивать Intent, только с нужным нам типом данных в Uri, например только http.
//------------------------------------------------------------------------------------------------
//ACTION_VIEW - константа класса Intent, означающая, что мы хотем посмотреть что-либо.
