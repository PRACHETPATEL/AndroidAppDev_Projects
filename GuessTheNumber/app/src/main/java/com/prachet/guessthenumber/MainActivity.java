package com.prachet.guessthenumber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startbtn, guessbtn, resetbtn, easybtn, hardbtn, mediumbtn, resetbtn2;
    private TextView o1,o2,out;
    private EditText inp;
    private RelativeLayout gameinput,result,reset,start,difficulty;
    Integer in=new Integer(0);
    Integer count=new Integer(0),prev,n;

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
        ActionBar actionBar=getSupportActionBar();
        actionBar.setIcon(R.mipmap.ic_logo_2);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main);
        gameinput=findViewById(R.id.gameui);
        difficulty=findViewById(R.id.difficulty);
        result=findViewById(R.id.nestedrelone);
        reset=findViewById(R.id.endui);
        resetbtn2 =findViewById(R.id.reset2);
        start=findViewById(R.id.startui);
        startbtn =findViewById(R.id.startbtn);
        resetbtn =findViewById(R.id.resetbtn);
        guessbtn =findViewById(R.id.guessbtn);
        easybtn =findViewById(R.id.easy);
        hardbtn =findViewById(R.id.hard);
        mediumbtn =findViewById(R.id.medium);
        o1=findViewById(R.id.out1);
        o2=findViewById(R.id.out2);
        out=findViewById(R.id.output);
        inp=findViewById(R.id.input);
        startbtn.setOnClickListener(this);
        resetbtn.setOnClickListener(this);
        guessbtn.setOnClickListener(this);
        easybtn.setOnClickListener(this);
        mediumbtn.setOnClickListener(this);
        hardbtn.setOnClickListener(this);
        resetbtn2.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.startbtn:
                difficulty.setVisibility(View.VISIBLE);
                start.setVisibility(View.GONE);
                break;
            case R.id.reset2:
                gameinput.setVisibility(View.GONE);
                inp.setText("");
                count=0;
                o1.setText("Display:Guess Higher/Lower");
                o2.setText("Total Guess Available: Infinte");
                start.setVisibility(View.VISIBLE);
                break;
            case R.id.easy:
                Random j=new Random();
                in=j.nextInt(100)+1;
                inp.setHint("Guess Number(1to100)");
                o2.setText("Total Guess Available: 10");
                difficulty.setVisibility(View.GONE);
                gameinput.setVisibility(View.VISIBLE);
                n=10;
                break;
            case R.id.medium:
                Random k=new Random();
                in=k.nextInt(1000)+1;
                inp.setHint("Guess Number(1to1000)");
                o2.setText("Total Guess Available: 15");
                difficulty.setVisibility(View.GONE);
                gameinput.setVisibility(View.VISIBLE);
                n=15;
                break;
            case R.id.hard:
                Random l=new Random();
                in=l.nextInt(10000)+1;
                inp.setHint("Guess Number(1to10000)");
                o2.setText("Total Guess Available: 20");
                difficulty.setVisibility(View.GONE);
                gameinput.setVisibility(View.VISIBLE);
                n=20;
                break;
            case R.id.guessbtn:
                String s= String.valueOf(inp.getText());
                Integer temp;
                if(s.matches("")){
                    Toast.makeText(this, "Enter Valid Number", Toast.LENGTH_SHORT).show();
                    break;
                }
                else {
                    temp=Integer.valueOf(s);
                    if(temp<in&&count<n){
                        o1.setText("Guess Higher");
                        count++;
                        inp.setText("");
                        prev=temp;
                        o2.setText("Total Guesses Made: "+count+"\nPrevious Guess:\t"+prev);
                    }
                    else if(temp>in&&count<n){
                        o1.setText("Guess Lower");
                        count++;
                        inp.setText("");
                        prev=temp;
                        o2.setText("Total Guesses Made: "+count+"\nPrevious Guess:\t"+prev);
                    }
                    else if(temp.equals(in) &&count<=n){
                        out.setText("CONGRATS, YOU WON!"+"\nTotal Guess Made :"+(count+1));
                        inp.setText("");
                        count=0;
                        gameinput.setVisibility(View.GONE);
                        result.setVisibility(View.VISIBLE);
                        reset.setVisibility(View.VISIBLE);
                    }
                    if(count==n){
                        out.setText("ALAS, YOU LOST:(\nCORRECT ANSWER WAS:"+in+"\nTotal Guess Made :"+(count));
                        inp.setText("");
                        count=0;
                        gameinput.setVisibility(View.GONE);
                        result.setVisibility(View.VISIBLE);
                        reset.setVisibility(View.VISIBLE);
                        break;
                    }
                }
                break;
            case R.id.resetbtn:
                reset.setVisibility(View.GONE);
                o1.setText("Display:Guess Higher/Lower");
                o2.setText("Total Guess Available: Infinte");
                inp.setText("");
                result.setVisibility(View.GONE);
                start.setVisibility(View.VISIBLE);
                count=0;
                break;
            default:
                break;
        }
    }
}