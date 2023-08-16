package sg.edu.rp.c346.id22025164.enrolment_ps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvEnrol;
    AsyncHttpClient client;
    ArrayList<Enrolment> alEnrol;
    ArrayAdapter<Enrolment> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEnrol = findViewById(R.id.lvEnrolment);
        client = new AsyncHttpClient();
        alEnrol = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alEnrol);
        lvEnrol.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            int year;
            String type_of_study;
            int enrolment;

            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("result");
                    JSONArray jsonArrResult = jsonObject.getJSONArray("records");
                    for(int i = 0; i < jsonArrResult.length(); i++) {
                        JSONObject jsonObjResult = jsonArrResult.getJSONObject(i);
                        year = jsonObjResult.getInt("year");
                        type_of_study = jsonObjResult.getString("type_of_study");
                        enrolment = jsonObjResult.getInt("enrolment");
                        Enrolment enrol = new Enrolment(year, type_of_study,enrolment);
                        alEnrol.add(enrol);
                    }
                }
                catch(JSONException e){
                }
                //POINT X – Code to display List View
                adapter.notifyDataSetChanged();

            }//end onSuccess
        });
    }//end onResume
}