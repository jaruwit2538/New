package com.example.khowoatt.test2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PastryMenu extends AppCompatActivity {


    private MenuTable objMenuTable;
    private ListView pastryListView;
    private Toolbar barpastry;
    private Button btnmenu;
    private Button btncart;
    private TextView title;


    // DB // DB// DB// DB// DB// DB// DB// DB
    SQLiteDatabase sqliteMyDB ;
    MySQLiteOpenHelper mHelper;
    Cursor myDBCursor;
    // DB // DB// DB// DB// DB// DB// DB// DB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastry_menu);

        BindWidget();
        Cdatabase();
        createListView();
    }
    @Override
    public void onPause() {
        super.onPause();
        mHelper.close();
        sqliteMyDB.close();
    }

    public void Cdatabase(){ // Open DataBase

        objMenuTable = new MenuTable(this);
    } // เปิดใช้งาน sqlite

    private void createListView() {
        MenuTable objMenuTable = new MenuTable(this);
        //String[] strC_Name = objMenuTable.readALLMenuTable(1);
        //String[] strC_Pic = objMenuTable.readALLMenuTable(3);
        //String[] strC_Price = objMenuTable.readALLMenuTable(4);

        String[] o1 = {"ht","hy","hu"};
        String[] o2 = {"123","456","789"};
        String[] o3 = {"http://bitmouse.96.lt/GUPER/pic/iphone7.png","http://bitmouse.96.lt/GUPER/pic/iphone7.png","http://bitmouse.96.lt/GUPER/pic/iphone7.png"};
        //AdapterPastry objMyAdapter = new AdapterPastry(PastryMenu.this, strC_Name,strC_Price,strC_Pic);
        MyAdapter objMyAdapter = new MyAdapter(PastryMenu.this, o1,o3,o2);
        pastryListView.setAdapter(objMyAdapter);

    }

    private void BindWidget() {

        pastryListView = (ListView) findViewById(R.id.livpastry);
        barpastry = (Toolbar) findViewById(R.id.barpastry);
        btnmenu = (Button) findViewById(R.id.btnMenu);
        btncart = (Button) findViewById(R.id.btnCart);
        title = (TextView) findViewById(R.id.titlepastry);


    }

}
