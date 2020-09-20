package com.example.calc;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et;
    Button clear,one,two,thre,fou,fiv,six,sev,eig,nin,zero,dot,addsub,add,sub,mul,div,mod,eql,bract;
    ImageView backspace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        et=findViewById(R.id.et);
        backspace=findViewById(R.id.backspace);
        clear=findViewById(R.id.clear);
        bract=findViewById(R.id.bract);
        mod=findViewById(R.id.mod);
        div=findViewById(R.id.div);
        mul=findViewById(R.id.mul);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        eql=findViewById(R.id.eql);
        dot=findViewById(R.id.dot);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        thre=findViewById(R.id.thre);
        fou=findViewById(R.id.fou);
        fiv=findViewById(R.id.fiv);
        six=findViewById(R.id.six);
        sev=findViewById(R.id.sev);
        eig=findViewById(R.id.eig);
        nin=findViewById(R.id.nin);
        zero=findViewById(R.id.zero);
        addsub=findViewById(R.id.addsub);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                  compute("1",true);


            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("2",true);
            }
        });

        thre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("3",true);
            }
        });

        fou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("4",true);
            }
        });

        fiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("5",true);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("6",true);
            }
        });

        sev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("7",true);
            }
        });

        eig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("8",true);
            }
        });

        nin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("9",true);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                compute("0",true);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute(".",true);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().isEmpty() && tv.getText().toString().isEmpty())
                {
                    et.setText("");
                }

                else{

                    compute("+",false);
                }




            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().isEmpty() && tv.getText().toString().isEmpty())
                {
                    et.setText("");
                }

                else{

                    compute("-",false);
                }

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().isEmpty() && tv.getText().toString().isEmpty())
                {
                    et.setText("");
                }

                else{

                    compute("*",false);
                }

            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().isEmpty() && tv.getText().toString().isEmpty())
                {
                    et.setText("");
                }

                else{

                    compute("/",false);
                }

            }
        });

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().isEmpty() && tv.getText().toString().isEmpty())
                {
                    et.setText("");
                }

                else{

                    compute("%",false);
                }

            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String str=et.getText().toString();

               if (!str.isEmpty())
               {
                   et.setText(str.substring(0,str.length()-1));

               }

                   tv.setText("");



            }
        });

        eql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(et.getText().toString().equals(""))
                {
                    et.setText("");
                }
                else
                {

                    try {
                        Expression expression= new ExpressionBuilder(et.getText().toString()).build();
                        double result=expression.evaluate();
                        tv.setText(result+"");
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(getApplicationContext(),"send",Toast.LENGTH_LONG).show();
                    }


                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et.setText("");
                tv.setText("");
            }
        });








    }

    void compute(String str,Boolean canclear)
    {
        if(!tv.getText().toString().isEmpty())
        {
            et.setText("");
        }
        if (canclear)
        {
            tv.setText("");
            et.append(str);
        }
        else {


                String string=et.getText().toString();

                if (!string.isEmpty())
                {
                    if(string.substring(string.length()-1).equals("+") || string.substring(string.length()-1).equals("-") ||
                            string.substring(string.length()-1).equals("/") || string.substring(string.length()-1).equals("*") )
                    {
                        et.setText(string.substring(0,string.length()-1));
                        et.append(str);
                        tv.setText("");
                    }
                    else{
                        et.append(tv.getText());
                        et.append(str);
                        tv.setText("");
                    }
                }


                else
                {
                    et.append(tv.getText());
                    et.append(str);
                    tv.setText("");
                }



        }
    }


}