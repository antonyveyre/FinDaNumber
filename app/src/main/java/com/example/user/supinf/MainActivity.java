package com.example.user.supinf;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.AliasActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button b;

    int toFind;
    //TextView Primary ;
    TextView resultat;
    EditText input;
    TextView hist;
    ProgressBar prog;
    int counter;
    int comparable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /*int i = 10000;
        while (toFind+1!=0) {
            i = (int) ((Math.random() * 100) + 1);
            Log.i("start", "Starting " + i );
         */
//        findViewById(R.layout.activity_main)
        b = (Button) findViewById(R.id.btn);
        resultat = (TextView) findViewById(R.id.resultat);
        input = (EditText) findViewById(R.id.input);
        hist = (TextView) findViewById(R.id.history);
        prog = (ProgressBar) findViewById(R.id.progressBar);
        b.setOnClickListener(this);
        this.reset();




        }


        public  void reset(){
            counter = 0;
            comparable = 0;
            toFind = (int)(Math.random()*100)+1;
            resultat.setText(" ");
            hist.setText(" ");
            prog.setProgress(counter);

        }


    @Override
    public void onClick(View v) {



      //  hist.append((String.format("%d%n",toFind) ));

//        hist.setText(input.getText().toString());
        Log.i("i","onclick ");

        try {

        comparable = Integer.parseInt(input.getText().toString());
        }
        catch (Exception e){
            Toast.makeText(v.getContext(), "le numero saisie n'est pas bon !!!", Toast.LENGTH_LONG).show();
            comparable = 0;
        }

        if (comparable > 100){
            resultat.setText("TROP grand!");
        }
        else if (comparable > toFind )
        {
            resultat.setText("Trop grand!");
                    hist.append((String.format("%d%n",comparable) ));
            prog.setProgress(counter);

        }
        else if (comparable < toFind )
        {
            resultat.setText("Trop petit!");
                    hist.append((String.format("%d%n",comparable) ));
            prog.setProgress(counter);

        }
        else if (comparable == toFind){

            resultat.setText("Bingo !!!");
//            b.setOnClickListener(null);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Vous avez gagné !!!");
            builder.setPositiveButton("Encore", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            reset();
                        }
                    });
                    builder.setNegativeButton("OU pas?", null);
            AlertDialog gain = builder.create();
            gain.show();
        }

        counter++;
        input.setText("")   ;

        if (counter>8) {
            new AlertDialog.Builder(this).setMessage("Vous avez perdu!!!").create().show();
            this.reset();
        }
    }


}

