package com.example.demo.service;

import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseIntialise {
	@PostConstruct
	public void intialize() {
try {
FileInputStream serviceAccount =new FileInputStream("./projectusingrestcalls-firebase-adminsdk-5wgz9-a276ddcde7.json");

FirebaseOptions options = new FirebaseOptions.Builder()
  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
  .setDatabaseUrl("https://projectusingrestcalls.firebaseio.com")
  .build();

        FirebaseApp.initializeApp(options);

	}catch(Exception e) {
		e.printStackTrace();
		
	}
	}

}
