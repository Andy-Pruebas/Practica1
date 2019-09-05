package pe.avilca.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private TextView Promediot,Promediol,mensaje,PromedioM;
     private EditText nota1,nota2,notal1,notal2,notal3,notal4;
     private Button calcular;
     private Spinner selecionar;
     private double totalfinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selecionar = (Spinner)findViewById(R.id.seleccionar);

        mensaje = (TextView)findViewById(R.id.mesanje);

        nota1 = (EditText)findViewById(R.id.nota1);
        nota2 = (EditText)findViewById(R.id.nota2);
        notal1= (EditText)findViewById(R.id.notal1);
        notal2 = (EditText)findViewById(R.id.notal2);
        notal3= (EditText)findViewById(R.id.notal3);
        notal4 = (EditText)findViewById(R.id.notal4);

        calcular =  (Button)findViewById(R.id.calcular);

        Promediot = (TextView)findViewById(R.id.Promediot);
        Promediol = (TextView)findViewById(R.id.Promedio1);

        PromedioM= (TextView)findViewById(R.id.PromedioM);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = selecionar.getSelectedItemPosition();
                Double teoria1 = Double.parseDouble(nota1.getText().toString());
                Double teoria2 = Double.parseDouble(nota2.getText().toString());
                Double nota_teoria = (teoria1+teoria2)/2;

                if (teoria1>teoria2){
                    Promediot.setText("Prom: "+teoria1);
                }else{
                    Promediot.setText("Prom: "+teoria2);
                }
                Double lab1 = Double.parseDouble(notal1.getText().toString());
                Double lab2 = Double.parseDouble(notal2.getText().toString());
                Double lab3 = Double.parseDouble(notal3.getText().toString());
                Double lab4 = Double.parseDouble(notal4.getText().toString());

                Double nota_lab = (lab1+lab2+lab3+lab4)/4;
                Promediol.setText("Prom: "+nota_lab);

                if (pos == 0){
                    Double prom_teo1 = nota_teoria*0.3;
                    Double prom_lab1 = nota_lab*0.7;
                    totalfinal = prom_teo1+prom_lab1;
                    PromedioM.setText("Promedio: "+totalfinal);
                    if(totalfinal>=13){
                        mensaje.setText("Aprobado!!!");
                    }else{
                        mensaje.setText("Desaprobado!!!");
                    }

                }else if(pos == 1){
                    Double prom_teo1 = nota_teoria*0.4;
                    Double prom_lab1 = nota_lab*0.6;
                    totalfinal = prom_teo1+prom_lab1;
                    PromedioM.setText("Promedio: "+totalfinal);
                    if(totalfinal>=13){
                        mensaje.setText("Aprobado!!!");
                    }else{
                        mensaje.setText("Desaprobado!!!");
                    }
                }else{
                    Double prom_teo1 = nota_teoria*0.2;
                    Double prom_lab1 = nota_lab*0.8;
                    totalfinal = prom_teo1 + prom_lab1;
                    PromedioM.setText("Promedio: "+totalfinal);
                    if(totalfinal>=13){
                        mensaje.setText("Aprobado!!!");
                    }else{
                        mensaje.setText("Desaprobado!!!");
                    }
                }
            }
        });

    }
}
