package com.jcupzz.ccenotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.firebase.storage.StorageReference;
import static com.jcupzz.ccenotes.Branch.j;
import static com.jcupzz.ccenotes.StudentDetailsCategory.i;
import static com.jcupzz.ccenotes.Subject.k;

import java.util.ArrayList;

import io.opencensus.resource.Resource;

public class MainActivity extends AppCompatActivity {
    public static String s4s6s8var;
    public static String path;
    public static String renamed_edit_text_name;
    public String rename_linkz;
    FirebaseFirestore db;
    LottieAnimationView lottieAnimationView;
    RecyclerView mRecyclerView;
    ArrayList<DownModel> downModelArrayList = new ArrayList<>();
    MyAdapter myAdapter;
    Button upload_btn;
    SharedPreferences sharedpreferences;
//1==teacher
//0==student

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (isNetworkConnected() == false) {
            Toast.makeText(getApplicationContext(), "You will need Internet Connection", Toast.LENGTH_LONG).show();
        }

        upload_btn = findViewById(R.id.upload_btn_id);
        lottieAnimationView = findViewById(R.id.animation_view);
        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"No Content Found",Toast.LENGTH_SHORT).show();
            }
        });
        //sharedpreferences=getSharedPreferences();
        //StudentTeacherCategory.stc_integer=0;

        sharedpreferences = getSharedPreferences("loginSave", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        String priv = sharedpreferences.getString("staff", "");
        StudentTeacherCategory.stc_integer = priv.equals("1") ? 1 : 0;

        if (StudentTeacherCategory.stc_integer == 0) {
            upload_btn.setVisibility(View.GONE);
        } else if (StudentTeacherCategory.stc_integer == 1) {
            upload_btn.setVisibility(View.VISIBLE);
        } else {
            //do nothing
        }

        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        j = intent.getIntExtra("key",0);

        //s2
        if (i == 2 && j == 1) {
            s4s6s8var = "Cs";
        }
        if (i == 2 && j == 2) {
            s4s6s8var = "Physics";
        }
        if (i == 2 && j == 3) {
            s4s6s8var = "Graphics";
        }
        if (i == 2 && j == 4) {
            s4s6s8var = "Chemistry";
        }
        if (i == 2 && j == 5) {
            s4s6s8var = "Mechanics";
        }
        if (i == 2 && j == 6) {
            s4s6s8var = "Mathematics";
        }
        if (i == 2 && j == 7) {
            s4s6s8var = "Civil";
        }
        if (i == 2 && j == 8) {
            s4s6s8var = "Electrical";
        }
        if (i == 2 && j == 9) {
            s4s6s8var = "Electronics";
        }
        if (i == 2 && j == 10) {
            s4s6s8var = "Mechanical";
        }

        //s4
        //1
        if (i == 4 && j == 1 && k==1) {
            s4s6s8var = "S4_CSE_OS";
        }
        if (i == 4 && j == 2 && k==1) {
            s4s6s8var = "S4_CSE_DSL";
        }
        if (i == 4 && j == 3 && k==1) {
            s4s6s8var = "S4_CSE_BE";
        }
        if (i == 4 && j == 4 && k==1) {
            s4s6s8var = "S4_CSE_MATHS";
        }
        if (i == 4 && j == 5 && k==1) {
            s4s6s8var = "S4_CSE_PDD";
        }
        if (i == 4 && j == 6 && k==1) {
            s4s6s8var = "S4_CSE_FAOSSL";
        }
        if (i == 4 && j == 7 && k==1) {
            s4s6s8var = "S4_CSE_COAA";
        }
        if (i == 4 && j == 8 && k==1) {
            s4s6s8var = "S4_CSE_OPDAP";
        }
        //2
        if (i == 4 && j == 1 && k==2) {
            s4s6s8var = "S4_EC_LS";
        }
        if (i == 4 && j == 2 && k==2) {
            s4s6s8var = "S4_EC_SAS";
        }
        if (i == 4 && j == 3 && k==2) {
            s4s6s8var = "S4_EC_CO";
        }
        if (i == 4 && j == 4 && k==2) {
            s4s6s8var = "S4_EC_AIC";
        }
        if (i == 4 && j == 5 && k==2) {
            s4s6s8var = "S4_EC_ACE";
        }
        if (i == 4 && j == 6 && k==2) {
            s4s6s8var = "S4_EC_PDRP";
        }
        //3
        if (i == 4 && j == 1 && k==3) {
            s4s6s8var = "S4_EE_LS";
        }
        if (i == 4 && j == 2 && k==3) {
            s4s6s8var = "S4_EE_MS";
        }
        if (i == 4 && j == 3 && k==3) {
            s4s6s8var = "S4_EE_MAI";
        }
        if (i == 4 && j == 4 && k==3) {
            s4s6s8var = "S4_EE_DEALD";
        }
        if (i == 4 && j == 5 && k==3) {
            s4s6s8var = "S4_EE_SAIM";
        }
        if (i == 4 && j == 6 && k==3) {
            s4s6s8var = "S4_EE_PDTANM";
        }
        //4
        if (i == 4 && j == 1 && k==4) {
            s4s6s8var = "S4_MECH_FM";
        }
        if (i == 4 && j == 2 && k==4) {
            s4s6s8var = "S4_MECH_BE";
        }
        if (i == 4 && j == 3 && k==4) {
            s4s6s8var = "S4_MECH_TE";
        }
        if (i == 4 && j == 4 && k==4) {
            s4s6s8var = "S4_MECH_MT";
        }
        if (i == 4 && j == 5 && k==4) {
            s4s6s8var = "S4_MECH_AMOS";
        }
        if (i == 4 && j == 6 && k==4) {
            s4s6s8var = "S4_MECH_PDTANM";
        }
        //5
        if (i == 4 && j == 1 && k==5) {
            s4s6s8var = "S4_CE_LS";
        }
        if (i == 4 && j == 2 && k==5) {
            s4s6s8var = "S4_CE_FM";
        }
        if (i == 4 && j == 3 && k==5) {
            s4s6s8var = "S4_CE_SA";
        }
        if (i == 4 && j == 4 && k==5) {
            s4s6s8var = "S4_CE_CT";
        }
        if (i == 4 && j == 5 && k==5) {
            s4s6s8var = "S4_CE_GE";
        }
        if (i == 4 && j == 6 && k==5) {
            s4s6s8var = "S4_CE_PDTANM";
        }




        //s6
        //1
        if (i == 6 && j == 1 && k==1) {
            s4s6s8var = "S6_CSE_WT";
        }
        if (i == 6 && j == 2 && k==1) {
            s4s6s8var = "S6_CSE_CD";
        }
        if (i == 6 && j == 3 && k==1) {
            s4s6s8var = "S6_CSE_CN";
        }
        if (i == 6 && j == 4 && k==1) {
            s4s6s8var = "S6_CSE_POM";
        }
        if (i == 6 && j == 5 && k==1) {
            s4s6s8var = "S6_CSE_DAAOA";
        }
        if (i == 6 && j == 6 && k==1) {
            s4s6s8var = "S6_CSE_SEAPM";
        }
        //2
        if (i == 6 && j == 1 && k==2) {
            s4s6s8var = "S6_EC_VLSI";
        }
        if (i == 6 && j == 2 && k==2) {
            s4s6s8var = "S6_EC_ES";
        }
        if (i == 6 && j == 3 && k==2) {
            s4s6s8var = "S6_EC_CE";
        }
        if (i == 6 && j == 4 && k==2) {
            s4s6s8var = "S6_EC_ML";
        }
        if (i == 6 && j == 5 && k==2) {
            s4s6s8var = "S6_EC_DC";
        }
        if (i == 6 && j == 6 && k==2) {
            s4s6s8var = "S6_EC_DIP";
        }
        if (i == 6 && j == 7 && k==2) {
            s4s6s8var = "S6_EC_OOP";
        }
        if (i == 6 && j == 8 && k==2) {
            s4s6s8var = "S6_EC_AAWP";
        }
        if (i == 6 && j == 9 && k==2) {
            s4s6s8var = "S6_EC_CEL";
        }

        //3

        if (i == 6 && j == 1 && k==3) {
            s4s6s8var = "S6_EEE_ED";
        }
        if (i == 6 && j == 2 && k==3) {
            s4s6s8var = "S6_EEE_EM";
        }
        if (i == 6 && j == 3 && k==3) {
            s4s6s8var = "S6_EEE_PSA";
        }
        if (i == 6 && j == 4 && k==3) {
            s4s6s8var = "S6_EEE_ACT";
        }
        if (i == 6 && j == 5 && k==3) {
            s4s6s8var = "S6_EEE_POM";
        }
        if (i == 6 && j == 6 && k==3) {
            s4s6s8var = "S6_EEE_BI";
        }

        //4

        if (i == 6 && j == 1 && k==4) {
            s4s6s8var = "S6_MECH_DOM";
        }
        if (i == 6 && j == 2 && k==4) {
            s4s6s8var = "S6_MECH_HAMT";
        }
        if (i == 6 && j == 3 && k==4) {
            s4s6s8var = "S6_MECH_ME";
        }
        if (i == 6 && j == 4 && k==4) {
            s4s6s8var = "S6_MECH_MAI";
        }
        if (i == 6 && j == 5 && k==4) {
            s4s6s8var = "S6_MECH_AMT";
        }
        if (i == 6 && j == 6 && k==4) {
            s4s6s8var = "S6_MECH_CADAA";
        }

        //5

        if (i == 6 && j == 1 && k==5) {
            s4s6s8var = "S6_CE_CE";
        }
        if (i == 6 && j == 2 && k==5) {
            s4s6s8var = "S6_CE_POM";
        }
        if (i == 6 && j == 3 && k==5) {
            s4s6s8var = "S6_CE_GIT";
        }
        if (i == 6 && j == 4 && k==5) {
            s4s6s8var = "S6_CE_DOCS";
        }
        if (i == 6 && j == 5 && k==5) {
            s4s6s8var = "S6_CE_DOHS";
        }
        if (i == 6 && j == 6 && k==5) {
            s4s6s8var = "S6_CE_TE1";
        }
        if (i == 6 && j == 7 && k==5) {
            s4s6s8var = "S6_CE_TEL";
        }
        if (i == 6 && j == 8 && k==5) {
            s4s6s8var = "S6_CE_CACEL";
        }
        if (i == 6 && j == 9 && k==5) {
            s4s6s8var = "S6_CE_CPACT";
        }

        //s8
        //1
        if (i == 8 && j == 1 && k==1) {
            s4s6s8var = "S8_CSE_ES";
        }
        if (i == 8 && j == 2 && k==1) {
            s4s6s8var = "S8_CSE_DM";
        }
        if (i == 8 && j == 3 && k==1) {
            s4s6s8var = "S8_CSE_EIA";
        }
        if (i == 8 && j == 4 && k==1) {
            s4s6s8var = "S8_CSE_POIS";
        }

        //2

        if (i == 8 && j == 1 && k==2) {
            s4s6s8var = "S8_EC_NE";
        }
        if (i == 8 && j == 2 && k==2) {
            s4s6s8var = "S8_EC_DM";
        }
        if (i == 8 && j == 3 && k==2) {
            s4s6s8var = "S8_EC_SC";
        }
        if (i == 8 && j == 4 && k==2) {
            s4s6s8var = "S8_EC_ACS";
        }

        //3

        //4

        if (i == 8 && j == 1 && k==4) {
            s4s6s8var = "S8_MECH_IS";
        }
        if (i == 8 && j == 2 && k==4) {
            s4s6s8var = "S8_MECH_IE";
        }
        if (i == 8 && j == 3 && k==4) {
            s4s6s8var = "S8_MECH_MNM";
        }
        if (i == 8 && j == 4 && k==4) {
            s4s6s8var = "S8_MECH_DOME2";
        }

        //
        setUpFB();
        setUpRV();
        dataFromFirebase();


    }


    private void setUpFB() {
        db = FirebaseFirestore.getInstance();
    }

    private void setUpRV() {
        mRecyclerView = findViewById(R.id.recycle);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void dataFromFirebase() {
        if (downModelArrayList.size() > 0)
            downModelArrayList.clear();


        db.collection(s4s6s8var)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @SuppressLint("ResourceType")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {


                        if(!(task.getResult().isEmpty()))
                        {
                            for (DocumentSnapshot documentSnapshot : task.getResult()) {

                                DownModel downModel = new DownModel(documentSnapshot.getString("name"),
                                        documentSnapshot.getString("link"));
                                downModelArrayList.add(downModel);

                            }
                        }
                        else{
                            mRecyclerView.setVisibility(View.GONE);
                            lottieAnimationView.setVisibility(View.VISIBLE);
                        }
                        myAdapter = new MyAdapter(MainActivity.this, downModelArrayList);
                        mRecyclerView.setAdapter(myAdapter);
                    }
                })


                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error ;-.-;", Toast.LENGTH_SHORT).show();
                    }
                })
        ;


    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 121:
                deletealertdialog();
                break;
            case 122:
                rename_firebase_firestore();
                return true;

        }
        return super.onContextItemSelected(item);
    }

    private void deletealertdialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogStyle_delete);
        builder.setMessage("Do you want to delete "+MyViewHolder.ve+"?");
        builder.setTitle("Delete");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deletefirebasefirestore();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Toast.makeText(getApplicationContext(),"\uD83D\uDE01",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    //
    private void rename_firebase_firestore() {
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View promptView = layoutInflater.inflate(R.layout.rename_prompt, null);
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogStyle_rename);
        alertdialog.setView(promptView);
        final EditText rename_edit_text = promptView.findViewById(R.id.Rename_edit_text_id);
        alertdialog.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        renamed_edit_text_name = rename_edit_text.getText().toString();
                        if(renamed_edit_text_name.equals(MyViewHolder.ve)) {
                            Toast.makeText(getApplicationContext(),"Filename should be different!!!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            rename();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Toast.makeText(getApplicationContext(), "Rename Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });
        alertdialog.create();
        alertdialog.show();
    }

    private void rename() {
        final DocumentReference docRef = db.collection(MainActivity.s4s6s8var).document(MyViewHolder.ve);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                if (task.isSuccessful()) {
                    rename_linkz = task.getResult().getString("link");
                    DownModel downModels = new DownModel(renamed_edit_text_name,rename_linkz);
                    db.collection(MainActivity.s4s6s8var).document(renamed_edit_text_name)
                            .set(downModels);
                    docRef.delete();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.aboutus_id) {

            Intent myIntent = new Intent(MainActivity.this,  AboutUs.class);

            MainActivity.this.startActivity(myIntent);


            return true;
        }

        if(id==R.id.open_downloads_id){
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            Uri uri = Uri.parse("/storage/self/primary/Android/data/com.jcupzz.ccenotes/files");
            intent.setDataAndType(uri, "application/pdf");
            startActivity(Intent.createChooser(intent, "Open folder"));
        }

        if (id == R.id.signOut_id) {
            //warning



            //warning






            FirebaseAuth.getInstance().signOut();
            sharedpreferences = getSharedPreferences("loginSave",
                    MODE_PRIVATE);

            SharedPreferences.Editor myEdit = sharedpreferences.edit();

            myEdit.putString("name", "");
            myEdit.putString("pass", "");
            myEdit.putString("staff", "");
            myEdit.commit();
            finish();

            Intent myIntent = new Intent(MainActivity.this,  Register.class);

            MainActivity.this.startActivity(myIntent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void deletefirebasefirestore() {


        db.collection(s4s6s8var).document(MyViewHolder.ve)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,"Successfully deleted "+MyViewHolder.ve,Toast.LENGTH_SHORT).show();
                        myAdapter.notifyDataSetChanged();
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //Log.w(TAG, "Error deleting document", e);
                    }
                });




    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


}
