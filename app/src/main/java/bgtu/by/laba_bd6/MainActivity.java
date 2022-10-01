package bgtu.by.laba_bd6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private final static String FILE_NAME = "content.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExistBase(FILE_NAME);
        ExistBase1(FILE_NAME);

    }


    public boolean ExistBase(String FILE_NAME)
    {
        boolean rc = false;
        File f=new File(super.getFilesDir(),FILE_NAME);
        if(rc = f.exists())
        {
            Log.d("Log_02","File "+FILE_NAME+" существует");
        }
        else
        {
            Log.d("Log_02","File "+FILE_NAME+"не найден");
            Dialog();
        }
        return rc;
    }
    public void Dialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Create file " + FILE_NAME).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Log_3", "Create file " + FILE_NAME);
            }
        });
        AlertDialog ad = b.create();
        ad.show();
    };
    private File getExternalPath() {
        return new File(getExternalFilesDir(null), FILE_NAME);
    }



    public boolean ExistBase1(String FILE_NAME)
    {
        boolean rc = false;
        File f=getExternalPath();
        if(rc = f.exists())
        {
            Log.d("Log_02","File "+FILE_NAME+" существует");
        }
        else
        {
            Log.d("Log_02","File "+FILE_NAME+"не найден");
            Dialog1();
        }
        return rc;
    }
    public void Dialog1(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("Create file " + FILE_NAME).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Log_3", "Create file " + FILE_NAME);
            }
        });
        AlertDialog ad = b.create();
        ad.show();
    };



    public void saveText(View view){



        EditText Name =findViewById(R.id.editTextName);
        EditText SecondName =findViewById(R.id.editTextSecondName);
        EditText Phone = findViewById(R.id.editTextPhone);
        DatePicker Data = this.findViewById(R.id.textData);

        String name = Name.getText().toString();
        String secondName = SecondName.getText().toString();
        int  phone = Integer.parseInt(Phone.getText().toString());
        int day=Data.getDayOfMonth();
        int month = Data.getMonth();
        int year = Data.getYear();
        String data = day+"."+month+"."+year;

        if(name == null  )
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }

        if (secondName == null )
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(phone == 0)
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        if (data == null)
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        FileOutputStream fos = null;
        try {
String text = name+";"+secondName+";"+phone+";"+data+"\r\n";
            fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }




    public void saveText1(View view){


        EditText Name =findViewById(R.id.editTextName);
        EditText SecondName =findViewById(R.id.editTextSecondName);
        EditText Phone = findViewById(R.id.editTextPhone);
        DatePicker Data = this.findViewById(R.id.textData);

        String name = Name.getText().toString();
        String secondName = SecondName.getText().toString();
        int  phone = Integer.parseInt(Phone.getText().toString());
        int day=Data.getDayOfMonth();
        int month = Data.getMonth();
        int year = Data.getYear();
        String data = day+"."+month+"."+year;

        if(name == null  )
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }

        if (secondName == null || secondName.length()<3)
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        if(phone == 0)
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        if (data == null || data.length()<3)
        {
            Toast toast = Toast.makeText(this, "Error!",Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Toast toast = Toast.makeText(this, "Good!",Toast.LENGTH_LONG);
            toast.show();
        }
        String text = name+";"+secondName+";"+phone+";"+data+"\r\n";
        try(FileOutputStream fos = new FileOutputStream(getExternalPath())) {
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}