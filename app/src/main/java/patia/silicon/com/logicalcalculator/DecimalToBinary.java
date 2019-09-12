package patia.silicon.com.logicalcalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DecimalToBinary extends AppCompatActivity {
    EditText ip;
    TextView op;
    Button convert,jump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_to_binary);
        Log.i("iniside activity","db");
        ip=(EditText)findViewById(R.id.ipdb);
        op=(TextView)findViewById(R.id.opdb);
        convert=(Button)findViewById(R.id.cdb);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = ip.getText().toString();
                try {
                    int x, c = 0, i, cpd = 0;
                    Double id;
                    for (x = 0; x < a.length(); x++) {
                        if (a.charAt(x) == '.') {
                            c++;
                            cpd = x;
                        }
                    }
                    if (c == 1) {
                        id = Double.parseDouble(a);
                        int npn, dpn;
                        StringBuilder np = new StringBuilder();
                        StringBuilder dp = new StringBuilder();
                        Log.i("ip", "correct ip in decimal");
                        for (x = 0; x < cpd; x++) {
                            np.append(a.charAt(x));
                        }
                        //   op.setText(np.toString();
                        npn = Integer.parseInt(np.toString());
                        String op1 = decimal2binary(npn);
                        for (x = cpd + 1; x < a.length(); x++) {
                            dp = dp.append(a.charAt(x));
                        }
                        // op.setText(dp.toString());
                        dpn = Integer.parseInt(dp.toString());
                        int p = dpn;
                        int cp=dpn,cdd=0;
                        while(cp>0)
                        {
                            cdd++;
                            cp=cp/10;
                        }
                        StringBuilder op2=new StringBuilder();
                        int cnum = 0;

                           // while (p > 0) {
                                while (cnum<8)
                                {
                                p = p * 2;
                                int fp =  (p /(int) Math.pow(10,cdd));
                                op2.append(fp);
                                p = p% (int)(Math.pow(10,cdd));
                                cnum++;
                                }
                        //}
                        Log.i("evaluated","while");
                        StringBuilder resultant=new StringBuilder();
                        resultant.append(op1);
                        resultant.append('.');
                        resultant.append(op2.toString());
                        op.setText(resultant.toString());
                    }
                    if(c==0)
                    {
                        String f;
                        i=Integer.parseInt(a);
                        Log.i(" ip","correct ip in integer");
                        f=decimal2binary(i);
                        op.setText(f);
                    }
                    if(c>1)
                    {
                        AlertDialog alertDialog = new AlertDialog.Builder(DecimalToBinary.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Insert valid input (with one decimal point max)");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                }
                catch (Exception e)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(DecimalToBinary.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Insert valid input (numbers without space)and upto 10 digits before decimal and 10 after");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
            });
    }
    public String decimal2binary(int n)
    {
        int d,copy=n;
        String r="",f="";
        while (copy>0)
        {
            d=copy%2;
            r=r.concat(Integer.toString(d));
            copy=copy/2;
         //   Log.i("inside","while");
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(r);
        stringBuilder.reverse();
        f=stringBuilder.toString();
        return  f;
    }


}
