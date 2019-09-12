package patia.silicon.com.logicalcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button db,bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=(Button)findViewById(R.id.db);
        bd=(Button)findViewById(R.id.bd);
    }
    public void operation(View view)
    {
        switch (view.getId())
        {
            case R.id.db:
                Log.i("Button pressed","decimal-binary");
                Intent intent1=new Intent(MainActivity.this,DecimalToBinary.class);
                startActivity(intent1);
                break;
            case R.id.bd:
                Log.i("button pressed","binary-decimal");
                Intent intent2=new Intent(MainActivity.this,BinaryToDecimal.class);
                startActivity(intent2);
                break;
            case R.id.ob:
                Log.i("button pressed","octal-binary");
                Intent intent3=new Intent(MainActivity.this,OctalToBinary.class);
                startActivity(intent3);
                break;
            case R.id.cb:
                Log.i("button pressed","complement");
                Intent intent4=new Intent(MainActivity.this,ComplementNumber.class);
                startActivity(intent4);
                break;
            case R.id.bc:
                Log.i("button pressed","binary calculation");
                Intent intent5=new Intent(MainActivity.this,BinaryCalculation.class);
                startActivity(intent5);
        }
    }
}
