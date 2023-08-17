package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {

                    {"Doctor Name: Ajit", "Address : pimpri", "Exp: 5 yr","Mobile: 99999999999","600"},
                    {"Doctor Name: Rovi", "Address : rajasan", "Exp: 5 yr","Mobile: 99999999999","900"},
                    {"Doctor Name: Vati", "Address : rajin", "Exp: 5 yr","Mobile: 99999999999","300"},
                    {"Doctor Name: Vami", "Address : jalpi", "Exp: 5 yr","Mobile: 99999999999","500"},
                    {"Doctor Name: Vampi", "Address : japa", "Exp: 5 yr","Mobile: 99999999999","800"}
            };

    private String[][] doctor_details2 =
            {

                    {"Doctor Name: sobur", "Address : pimpri", "Exp: 5 yr","Mobile: 99999999999","600"},
                    {"Doctor Name: sam chui", "Address : rajasan", "Exp: 5 yr","Mobile: 99999999999","900"},
                    {"Doctor Name: agra", "Address : rajin", "Exp: 5 yr","Mobile: 99999999999","300"},
                    {"Doctor Name: alo", "Address : jalpi", "Exp: 5 yr","Mobile: 99999999999","500"},
                    {"Doctor Name: sampari", "Address : japa", "Exp: 5 yr","Mobile: 99999999999","800"}
            };

    private String[][] doctor_details3=
            {

                    {"Doctor Name: rohit", "Address : pimpri", "Exp: 5 yr","Mobile: 99999999999","600"},
                    {"Doctor Name: kohli", "Address : rajasan", "Exp: 5 yr","Mobile: 99999999999","900"},
                    {"Doctor Name: virat", "Address : rajin", "Exp: 5 yr","Mobile: 99999999999","300"},
                    {"Doctor Name: gleen", "Address : jalpi", "Exp: 5 yr","Mobile: 99999999999","500"},
                    {"Doctor Name: maxwell", "Address : japa", "Exp: 5 yr","Mobile: 99999999999","800"}
            };

    private String[][] doctor_details4 =
            {

                    {"Doctor Name: abul", "Address : pimpri", "Exp: 5 yr","Mobile: 99999999999","600"},
                    {"Doctor Name: kalam", "Address : rajasan", "Exp: 5 yr","Mobile: 99999999999","900"},
                    {"Doctor Name: azad", "Address : rajin", "Exp: 5 yr","Mobile: 99999999999","300"},
                    {"Doctor Name: sharma", "Address : jalpi", "Exp: 5 yr","Mobile: 99999999999","500"},
                    {"Doctor Name: singh", "Address : japa", "Exp: 5 yr","Mobile: 99999999999","800"}
            };

    private String[][] doctor_details5 =
            {

                    {"Doctor Name: salam", "Address : pimpri", "Exp: 5 yr","Mobile: 99999999999","600"},
                    {"Doctor Name: jabbar", "Address : rajasan", "Exp: 5 yr","Mobile: 99999999999","900"},
                    {"Doctor Name: rofique", "Address : rajin", "Exp: 5 yr","Mobile: 99999999999","300"},
                    {"Doctor Name: barkat", "Address : jalpi", "Exp: 5 yr","Mobile: 99999999999","500"},
                    {"Doctor Name: sofique", "Address : japa", "Exp: 5 yr","Mobile: 99999999999","800"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent(); //intent obj
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("family physicians") == 0)
            doctor_details = doctor_details1;
        else if(title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if(title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if(title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

       list = new ArrayList();// list obj
        for(int i=0; i<doctor_details.length; i++){
            item = new HashMap<String,String>();//create obj of hashmap
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5","cons Fees:"+ doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.ListViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointment.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[position][0]);
                it.putExtra("text3", doctor_details[position][1]);
                it.putExtra("text4", doctor_details[position][3]);
                it.putExtra("text5", doctor_details[position][4]);
                startActivity(it);
            }
        });
    }
}