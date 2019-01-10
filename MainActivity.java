package com.example.will.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private InputStream imagesStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IamOptions options = new IamOptions.Builder()
                .apiKey("SDrCQVQpqSustGxOKs4hN-732l3mS3dxxX5G7Vo6Q_8G")
                .build();

        VisualRecognition service = new VisualRecognition("2018-03-19", options);
        try {
            imagesStream = new FileInputStream("./fruit.jpg");
        }catch(FileNotFoundException e){

        }
        ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
                .imagesFile(imagesStream)
                .imagesFilename("fruit.jpg")
                .threshold((float) 0.6)
                .owners(Arrays.asList("me"))
                .build();
        ClassifiedImages result = service.classify(classifyOptions).execute();
        System.out.println(result);
    }
}
