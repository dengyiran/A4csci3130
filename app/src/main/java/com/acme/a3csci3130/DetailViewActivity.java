
package com.acme.a3csci3130;
/*@author Yiran Deng
 *@function update and erase the data
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class DetailViewActivity extends Activity {

    private EditText business_numberField, nameField, primarybusinessField, addressField, provinceField;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        business_numberField = (EditText) findViewById(R.id.businessnumber);
        nameField = (EditText) findViewById(R.id.name);
        primarybusinessField = (EditText) findViewById(R.id.primary);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);


        if(receivedPersonInfo != null){
            business_numberField.setText(receivedPersonInfo.business_number);
            nameField.setText(receivedPersonInfo.name);
            primarybusinessField.setText(receivedPersonInfo.primary);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);

        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality
        final MyApplicationData appState;
        appState = ((MyApplicationData) getApplicationContext());

        Button button = (Button) findViewById(R.id.updateButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                String personID = receivedPersonInfo.uid;
                appState.firebaseReference.child(personID).child("business_number").setValue(business_numberField.getText().toString());
                appState.firebaseReference.child(personID).child("name").setValue(nameField.getText().toString());
                appState.firebaseReference.child(personID).child("primary").setValue(primarybusinessField.getText().toString());
                appState.firebaseReference.child(personID).child("address").setValue(addressField.getText().toString());
                appState.firebaseReference.child(personID).child("province").setValue(provinceField.getText().toString());

                finish();
            }
        });
    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        final MyApplicationData appState;
        appState = ((MyApplicationData) getApplicationContext());

        Button button = (Button) findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                appState.firebaseReference.removeValue();

                finish();
            }
        });
    }
}
