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
import android.widget.Toast;

public class BinaryToDecimal extends AppCompatActivity {
    Button convert;
    EditText ip;
    TextView op;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("inside activity", "bd");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_to_decimal);
        convert = (Button) findViewById(R.id.cbd);
        ip = (EditText) findViewById(R.id.ipbd);
        op = (TextView) findViewById(R.id.opbd);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ips=ip.getText().toString();int x=0,c=0 ,cd=0;
                for( x=0;x<ips.length();x++) {
                    if (ips.charAt(x) == '1' || ips.charAt(x) == '0' || ips.charAt(x) == '.') {
                        c++;
                        //cd++;
                    }
                }
                  if(c==x)
                  {
                      int cpd=0;
                      Toast.makeText(BinaryToDecimal.this, "valid", Toast.LENGTH_SHORT).show();
                      for(x=0;x<ips.length();x++)
                      {
                          if(ips.charAt(x)=='.')
                          {
                              cpd=x;

                          }
                      }
                      if(cpd==0)
                      {
                          int ii=Integer.parseInt(ips);
                          int res=bin2dec(ii);
                          op.setText(Integer.toString(res));
                      }
                      else
                      {
                          StringBuilder p1=new StringBuilder();
                          StringBuilder p2=new StringBuilder();
                          for(x=0;x<cpd;x++)
                          {
                              p1.append(ips.charAt(x));
                          }
                          for(x=cpd+1;x<ips.length();x++)
                          {
                              p2.append(ips.charAt(x));
                          }
                          int res1=bin2dec(Integer.parseInt(p1.toString()));
                          int pi2=Integer.parseInt(p2.toString());
                          int d=0,l=p2.length();
                          double res2=0;
                          while(pi2>0)
                          {
                              d=pi2%10;
                              res2=res2+(d*Math.pow(2,-l));
                              l--;
                              pi2=pi2/10;
                          }
                          String top=Double.toString(res2);
                          StringBuilder resu2=new StringBuilder();
                          for(x=2;x<top.length();x++)
                          {
                              resu2.append(top.charAt(x));
                          }
                          StringBuilder fres=new StringBuilder();
                          fres.append(Integer.toString(res1));
                          fres.append('.');
                          fres.append(resu2.toString());
                          op.setText(fres.toString());
                      }
                  }
                  else
                  {
                      AlertDialog alertDialog = new AlertDialog.Builder(BinaryToDecimal.this).create();
                      alertDialog.setTitle("Alert");
                      alertDialog.setMessage("Insert valid input (1 or 0 only)");
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
}

