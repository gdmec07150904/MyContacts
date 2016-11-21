package com.example.chenkangjin.mycontacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactsMessageActivity extends AppCompatActivity {
    private TextView name;
    private TextView mobile;
    private TextView qq;
    private TextView danwei;
    private TextView address;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        name = (TextView) findViewById(R.id.name);
        mobile = (TextView) findViewById(R.id.mobile);
        danwei = (TextView) findViewById(R.id.danwei);
        qq = (TextView) findViewById(R.id.qq);
        address = (TextView) findViewById(R.id.address);
        //获得activity传过来的数据
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        //用id查找联系人
        ContactsTable contactsTable  = new ContactsTable(this);
        user = contactsTable.getUserByID(id);
        //显示联系人信息
        name.setText("姓名："+user.getName());
        mobile.setText("电话："+user.getMobile());
        qq.setText("QQ："+user.getQq());
        danwei.setText("单位："+user.getDanwei());
        address.setText("地址："+user.getAddress());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
