package com.sucre.testndk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.sina.weibo.WeiboApplication;

import tv.xiaoka.base.util.Encrypt;

public class MainActivity extends AppCompatActivity {
    WeiboApplication i = null;
    Encrypt e = null;
    String temp;
    EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        i = new WeiboApplication();
        e = new Encrypt();
        edit = (EditText) findViewById(R.id.editText);
        edit.setText("5l0WXnhiY4pJ794KIJ7Rw5F45VXg9sjo3852098887");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    temp = i.newCalculateS(edit.getText().toString());
                    //temp=e.get563("123123123");
                    SocketThread socket=new SocketThread();
                    Thread thread=new Thread(socket);
                    thread.start();

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                Snackbar.make(view, "Replace with your own action" + temp, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
