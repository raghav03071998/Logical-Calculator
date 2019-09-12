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

public class ComplementNumber extends AppCompatActivity {
    Button b1,b2;
    EditText ip;
    TextView op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complement_number);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        ip=(EditText)findViewById(R.id.ipc);
        op=(TextView)findViewById(R.id.opc);
        Log.i("inside","complement");

    }
    public void complement(View view) {
        if (view.getId() == R.id.b1) {
            Log.i("inside", "1s complement method");
            String input = ip.getText().toString();
            String output = one4all(input);
            op.setText(output);

        }
        //op.setText(one(input));
        if (view.getId() == R.id.b2) {
            Log.i("inside", "2s complement method");
            String input = ip.getText().toString();
            int x, cd = 0, c = 0;
            for (x = 0; x < input.length(); x++) {
                if (input.charAt(x) == '.') {
                    cd = x;
                    c++;
                }
            }
            if (c == 0) {
              /*  String one = one4all(input);
                int resnum = bin2dec(Integer.parseInt(one));
                resnum = resnum + 1;
                String ops = decimal2binary(resnum);*/
                op.setText(twos(input));
            }
            if (c == 1) {
                StringBuilder fp = new StringBuilder();
                StringBuilder sp = new StringBuilder();
                for (x = 0; x < cd; x++) {
                    fp.append(input.charAt(x));
                }
                for (x = cd + 1; x < input.length(); x++) {
                    sp.append(input.charAt(x));
                }
                StringBuilder res=new StringBuilder();
                res.append(twos(fp.toString()));
                res.append('.');
                res.append(twos(sp.toString()));
                op.setText(res.toString());
            }
            if(c>1)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(ComplementNumber.this).create();
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
    }
    public String one(String i)
    {
        StringBuilder res=new StringBuilder();
        int x;
        for(x=0;x<i.length();x++)
        {
            if(i.charAt(x)=='1')
            {
                res.append('0');
            }
            if(i.charAt(x)=='0')
            {
                res.append('1');
            }
        }
        return res.toString();
    }
    public String one4all(String i)
    {
        Log.i("inside","1s complement method");
     //   String input=ip.getText().toString();
        String input=i,output="";
        int x=0,c=0,cdp=0,cd=0;
        for(x=0;x<input.length();x++) {
            if (input.charAt(x) == '1' || input.charAt(x) == '0' || input.charAt(x) == '.') {
                c++;
                if (input.charAt(x) == '.') {
                    cdp = x;
                    cd++;
                }
            }
        }
        if(c==x && cd<=1)
        {
            if(cdp==0)
            {
                output=one(input);
            }
            else
            {
                StringBuilder a=new StringBuilder();
                StringBuilder b=new StringBuilder();
                for(x=0;x<cdp;x++)
                {
                    a.append(input.charAt(x));
                }
                for(x=cdp;x<input.length();x++)
                {
                    b.append(input.charAt(x));
                }
                StringBuilder res=new StringBuilder();
                res.append(one(a.toString()));
                res.append('.');
                res.append(one(b.toString()));
                output=(res.toString());
            }
        }
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(ComplementNumber.this).create();
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
        return output;
    }
    public int bin2dec(int i)
    {
        int p=i;
        int d,res=0,pp=0;

        while(p>0)
        {
            d=p%10;
            res=res+(d*((int)Math.pow(2,pp)));
            pp++;
            p=p/10;
        }
        return res;
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
    public String twos(String i)
    {
        String one = one4all(i);
        int resnum = bin2dec(Integer.parseInt(one));
        resnum = resnum + 1;
        String ops = decimal2binary(resnum);
        return  ops;
    }
}


