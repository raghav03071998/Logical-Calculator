package patia.silicon.com.logicalcalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OctalToBinary extends AppCompatActivity {
    EditText ip;
    TextView op;
    Button convert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal_to_binary);
        ip=(EditText)findViewById(R.id.ipob);
        op=(TextView)findViewById(R.id.opob);
        convert=(Button)findViewById(R.id.cob);
        Log.i("inside","octal to binary");
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ips=ip.getText().toString();
                try
                {
                    int x,c=0;
                    for(x=0;x<ips.length();x++)
                    {
                        if(ips.charAt(x)=='.')
                        {
                            c=x;
                        }
                    }
                    if(c==0) {
                        Log.i("inside","valid int ip");
                        int ipi = Integer.parseInt(ips);
                       // op.setText(oc2bin(Integer.toString(ipi)));
                        String res=oc2bin(ipi);
                        op.setText(res);

                    }
                    if(c!=0)
                    {
                        Log.i("inside","valid double ip");
                        Double ipi=Double.parseDouble(ips);
                        StringBuilder a=new StringBuilder();
                        StringBuilder b=new StringBuilder();
                        for(x=0;x<c;x++)
                        {
                            a.append(ips.charAt(x));
                        }
                        for(x=c+1;x<ips.length();x++)
                        {
                            b.append(ips.charAt(x));
                        }
                        //op.setText(b.toString());
                        StringBuilder res=new StringBuilder();
                        int p1=Integer.parseInt(a.toString());
                        int p2=Integer.parseInt(b.toString());
                        res.append(oc2bin(p1));
                        res.append('.');
                        res.append(oc2bin(p2));
                        op.setText(res.toString());
                    }

                }catch (Exception e)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(OctalToBinary.this).create();
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
    public String oc2bin(int n)
    {
        Log.i("inside","octal to bin");
        int d;String res="";
        StringBuilder fres=new StringBuilder();
        StringBuilder t1=new StringBuilder();
        t1.append(n);
        t1.reverse();
        Log.i("value",t1.toString());
        int n2=Integer.parseInt(t1.toString());
        while (n2>0)
        {
            d=n2%10;
            res=decimal2binary(d);
            fres.append(res);
            n2=n2/10;
        }
       // fres.reverse();
        return fres.toString();
    }
    public String decimal2binary(int n)
    {
//        Log.i("inside ","dec to bin");
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
