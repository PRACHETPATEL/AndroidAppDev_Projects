package com.prachet.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener{
    private Button dis,btn,nsbtn;
    private CheckBox harry,john,gog;
    private RadioGroup married;
    @Override
    public void onClick(View v) {
        Random j=new Random();
        Random k=new Random();
        TextView text=findViewById(R.id.text1);
        int num=j.nextInt(20);
        int num2=k.nextInt(15);
        Jokes jokes=new Jokes();
        switch (v.getId()){
            case R.id.btn1:
                System.out.println(jokes.joke.get(num));
                text.setText(jokes.joke.get(num));
                nsbtn.setVisibility(View.GONE);
                btn.setText("Next");
                dis.setText("Reset");
                break;
            case R.id.btn2:
                System.out.println(dis.getText());
                if(dis.getText()!="NO"){
                    Toast.makeText(this,"Display Reset",Toast.LENGTH_SHORT).show();
                }
                text.setText("Do you want to display a random joke?");
                dis.setText("NO");
                nsbtn.setVisibility(View.GONE);
                btn.setVisibility(View.VISIBLE);
                btn.setText("yes");
                nsbtn.setText("NSFW JOKE");
                break;
            case R.id.btn3:
                System.out.println(jokes.nsfw.get(num2));
                btn.setVisibility(View.GONE);
                text.setText(jokes.nsfw.get(num2));
                nsbtn.setText("Next NSFW");
                dis.setText("Reset");
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                Toast.makeText(this, "Developed By Prachet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.github:
                browser();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    void browser(){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.github.com//prachetpatel"));
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn1);
        dis=findViewById(R.id.btn2);
        nsbtn=findViewById(R.id.btn3);
        btn.setOnClickListener(this);
        dis.setOnClickListener(this);
        nsbtn.setOnClickListener(this);
        harry=findViewById(R.id.checkboxharry);
        harry.setOnCheckedChangeListener(this);
        john=findViewById(R.id.checkboxjohn);
        john.setOnCheckedChangeListener(this);
        gog=findViewById(R.id.checkboxGOGVOL3);
        gog.setOnCheckedChangeListener(this);
        married=findViewById(R.id.isMarried);
        married.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkboxjohn:
                if(isChecked)
                    Toast.makeText(this,"You have Watched John Wick",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this,"You have Not Watched John Wick",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkboxharry:
                if(isChecked)
                    Toast.makeText(this,"You have Watched HarryPotter",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this,"You have Not Watched HarryPotter",Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkboxGOGVOL3:
                if(isChecked)
                    Toast.makeText(this,"You have Watched Guardians of the galaxy vol.3",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this,"You have Not Watched Guardians of the galaxy vol.3",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.yesradio:
                Toast.makeText(this,"Married",Toast.LENGTH_SHORT).show();
                nsbtn.setVisibility(View.VISIBLE);
                break;
            case R.id.noradio:
                nsbtn.setVisibility(View.GONE);
//                Toast.makeText(this,"Not married,find a girl",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}