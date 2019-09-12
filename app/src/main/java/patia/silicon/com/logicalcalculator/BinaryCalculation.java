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
public class BinaryCalculation extends AppCompatActivity {
    EditText ip1, ip2;
    TextView op;
    Button add, sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_calculation);
        ip1 = (EditText) findViewById(R.id.ip1);
        ip2 = (EditText) findViewById(R.id.ip2);
        op = (TextView) findViewById(R.id.opbc);
        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
    }
    public void addm(View view) {
            String i1 = ip1.getText().toString();
            String i2 = ip2.getText().toString();
            Log.i("inside", "add");
            int x, c1 = 0, cd1 = 0, c2 = 0, cd2 = 0;
        int bc1=0,bc2=0;
        for(x=0;x<i1.length();x++)
        {
            if(i1.charAt(x)=='1'||i1.charAt(x)=='0'||i1.charAt(x)=='.')
            {
                bc1++;
            }
        }
        for(x=0;x<i2.length();x++)
        {
            if(i2.charAt(x)=='1'||i2.charAt(x)=='0'||i2.charAt(x)=='.')
            {
                bc2++;
            }
        }
        if(bc1==ip1.length()&& bc2==ip2.length()) {
            for (x = 0; x < i1.length(); x++) {
                if (i1.charAt(x) == '.') {
                    c1++;
                    cd1 = x;
                }
            }
            for (x = 0; x < i2.length(); x++) {
                if (i2.charAt(x) == '.') {
                    cd2 = x;
                    c2++;
                }
            }
            if (c1 == 0 && c2 == 0) {
                int ipi1 = bin2dec(Integer.parseInt(i1));
                int ipi2 = bin2dec(Integer.parseInt(i2));
                int res = ipi1 + ipi2;
                op.setText(decimal2binary(res));
            }
            if (c1 == 1 && c2 == 1) {
                Log.i("inside both decimal", ".");
                Double ipd1 = Double.parseDouble(doublebinary(ip1.getText().toString(), cd1));
                Double ipd2 = Double.parseDouble(doublebinary(ip2.getText().toString(), cd2));
                Double res = ipd1 + ipd2;
                op.setText(double2bin(res));
                //  op.setText("both number in decimal");
            }
            if (c1 == 0 && c2 == 1) {
                //  int ii1=bin2dec(Integer.parseInt(ip1.getText().toString()));
                //Double id2=doublebinary(Double.parseDouble(ip2.getText().toString()),c2);
                int ii1 = bin2dec(Integer.parseInt(i1));
                Double ipd2 = Double.parseDouble(doublebinary(ip2.getText().toString(), cd2));
                Double res = ii1 + ipd2;
                op.setText(double2bin(res));
            }
            if (c2 == 0 && c1 == 1) {
                Double ipd1 = Double.parseDouble(doublebinary(ip1.getText().toString(), cd1));
                int ii2 = bin2dec(Integer.parseInt(i2));
                Double res = ipd1 + ii2;
                op.setText(double2bin(res));
            }
            if (c1 > 1 || c2 > 1) {
                AlertDialog alertDialog = new AlertDialog.Builder(BinaryCalculation.this).create();
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
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(BinaryCalculation.this).create();
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
    public  void subm(View view) {

            String i1 = ip1.getText().toString();
            String i2 = ip2.getText().toString();
            Log.i("inside", "add");
            int x, c1 = 0, cd1 = 0, c2 = 0, cd2 = 0;
            int bc1=0,bc2=0;
            for(x=0;x<i1.length();x++)
            {
                if(i1.charAt(x)=='1'||i1.charAt(x)=='0'||i1.charAt(x)=='.')
                {
                    bc1++;
                }
            }
            Log.i("bc1",Integer.toString(bc1));
            for(x=0;x<i2.length();x++)
            {
                if(i2.charAt(x)=='1'||i2.charAt(x)=='0'||i2.charAt(x)=='.')
                {
                    bc2++;
                }
            }
            Log.i("bc2",Integer.toString(bc2));
            if(bc1==i1.length()&& bc2==i2.length()) {
                for (x = 0; x < i1.length(); x++) {
                    if (i1.charAt(x) == '.') {
                        c1++;
                        cd1 = x;
                    }
                }
                for (x = 0; x < i2.length(); x++) {
                    if (i2.charAt(x) == '.') {
                        cd2 = x;
                        c2++;
                    }
                }
                if (c1 == 0 && c2 == 0) {
                    int ipi1 = bin2dec(Integer.parseInt(i1));
                    int ipi2 = bin2dec(Integer.parseInt(i2));
                    if (ipi2 < ipi1) {
                        int res = ipi1 - ipi2;
                        op.setText(decimal2binary(res));
                    } else {
                        int res = ipi2 - ipi1;
                        StringBuilder resn = new StringBuilder();
                        resn.append('-');
                        resn.append(decimal2binary(res));
                        op.setText(resn.toString());
                    }
                }
                if (c1 == 1 && c2 == 1) {
                    Log.i("inside both decimal", ".");
                    Double ipd1 = Double.parseDouble(doublebinary(ip1.getText().toString(), cd1));
                    Double ipd2 = Double.parseDouble(doublebinary(ip2.getText().toString(), cd2));
                    if (ipd2 < ipd1) {
                        Double res = ipd1 - ipd2;
                        op.setText(double2bin(res));
                    } else {
                        Double res = ipd2 - ipd1;
                        StringBuilder resn = new StringBuilder();
                        resn.append('-');
                        resn.append(double2bin(res));
                        op.setText(resn.toString());//  op.setText("both number in decimal");
                    }
                }
                if (c1 == 0 && c2 == 1) {
                    //  int ii1=bin2dec(Integer.parseInt(ip1.getText().toString()));
                    //Double id2=doublebinary(Double.parseDouble(ip2.getText().toString()),c2);
                    int ii1 = bin2dec(Integer.parseInt(i1));
                    Double ipd2 = Double.parseDouble(doublebinary(ip2.getText().toString(), cd2));
                    if (ii1 < ipd2) {
                        Double res = ii1 - ipd2;
                        op.setText(double2bin(res));
                    } else {
                        Double res = ipd2 - ii1;
                        StringBuilder resn = new StringBuilder();
                        resn.append('-');
                        resn.append(double2bin(res));
                        op.setText(resn.toString());
                    }
                }
                if (c2 == 0 && c1 == 1) {
                    Double ipd1 = Double.parseDouble(doublebinary(ip1.getText().toString(), cd1));
                    int ii2 = bin2dec(Integer.parseInt(i2));
                    if (ipd1 > ii2) {
                        Double res = ipd1 - ii2;
                        op.setText(double2bin(res));
                    } else {
                        Double res = ii2 - ipd1;
                        StringBuilder resn = new StringBuilder();
                        resn.append('-');
                        resn.append(double2bin(res));
                        op.setText(resn.toString());
                    }
                }
                if (c1 > 1 || c2 > 1) {
                    AlertDialog alertDialog = new AlertDialog.Builder(BinaryCalculation.this).create();
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
             else {
            AlertDialog alertDialog = new AlertDialog.Builder(BinaryCalculation.this).create();
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
    public int bin2dec(int i) {
        int p = i;
        int d, res = 0, pp = 0;

        while (p > 0) {
            d = p % 10;
            res = res + (d * ((int) Math.pow(2, pp)));
            pp++;
            p = p / 10;
        }
        return res;
    }

    public String decimal2binary(int n) {
        int d, copy = n;
        String r = "", f = "";
        while (copy > 0) {
            d = copy % 2;
            r = r.concat(Integer.toString(d));
            copy = copy / 2;
            //   Log.i("inside","while");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public String doublebinary(String string, int cpd) {
        Log.i("iniside","double binary");
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        int x;
        for (x = 0; x < cpd; x++) {
            p1.append(string.charAt(x));
        }
        for (x = cpd + 1; x < string.length(); x++) {
            p2.append(string.charAt(x));
        }
        Log.i("p1",p1.toString());
        Log.i("p2",p2.toString());
        int t=Integer.parseInt(p1.toString());
        int res1=bin2dec(t);
        int pi2=Integer.parseInt(p2.toString());
        //int res1 = bin2dec(Integer.parseInt(p1.toString()));
        //int pi2 = Integer.parseInt(p2.toString());
        //int res1=0,pi2=0;
        int d = 0, l = p2.length();
        double res2 = 0;
        while (pi2 > 0) {
            d = pi2 % 10;
            res2 = res2 + (d * Math.pow(2, -l));
            l--;
            pi2 = pi2 / 10;
        }
        String top = Double.toString(res2);
        StringBuilder resu2 = new StringBuilder();
        for (x = 2; x < top.length(); x++) {
            resu2.append(top.charAt(x));
        }
        StringBuilder fres = new StringBuilder();
        fres.append(Integer.toString(res1));
        fres.append('.');
        fres.append(resu2.toString());
        // op.setText(fres.toString());
        String n=fres.toString();
        Log.i("exiting with",n);
        return fres.toString();
        //Log.i("exiting with",fres.toString());
    }
    public String double2bin(Double n)
    {
        String ipn=Double.toString(n);
        int x=0,cpd=0;
        for(x=0;x<ipn.length();x++)
        {
            if(ipn.charAt(x)=='.')
            {
                cpd=x;
            }
        }
        int npn, dpn;
        StringBuilder np = new StringBuilder();
        StringBuilder dp = new StringBuilder();
        Log.i("ip", "correct ip in decimal");
        for (x = 0; x < cpd; x++) {
            np.append(ipn.charAt(x));
        }
        //   op.setText(np.toString();
        npn = Integer.parseInt(np.toString());
        String op1 = decimal2binary(npn);
        for (x = cpd + 1; x < ipn.length(); x++) {
            dp = dp.append(ipn.charAt(x));
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
        return resultant.toString();
    }
}
