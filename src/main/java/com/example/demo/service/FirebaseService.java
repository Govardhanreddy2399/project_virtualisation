package com.example.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.object.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firestore.v1.WriteResult;

@Service
public class FirebaseService {
	
	public String saveUserDetails(Person person) throws InterruptedException, ExecutionException {
		Firestore dbfirestore=FirestoreClient.getFirestore();
		ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture=dbfirestore.collection("users").document(person.getName()).set(person);
		return collectionApiFuture.get().getUpdateTime().toString();
	}
	
	public Person getUserDetails(String name) throws InterruptedException, ExecutionException {
		Firestore dbfirestore=FirestoreClient.getFirestore();
		DocumentReference documentReference=dbfirestore.collection("users").document(name);
		ApiFuture<DocumentSnapshot> future=documentReference.get();
		DocumentSnapshot document =future.get();
		Person person=null;
		if(document.exists()) {
			person=document.toObject(Person.class);
			return person;
		}else {
			return null;
		}
		
	}
	
	public String updateUserDetails(Person person) throws InterruptedException, ExecutionException {
		Firestore dbfirestore=FirestoreClient.getFirestore();
		ApiFuture<com.google.cloud.firestore.WriteResult> collectionApiFuture=dbfirestore.collection("users").document(person.getName()).set(person);
		return collectionApiFuture.get().getUpdateTime().toString();
		
	}
	
	public String deleteUser(String name) {
		Firestore dbfirestore=FirestoreClient.getFirestore();
		ApiFuture<com.google.cloud.firestore.WriteResult> deleteuser=dbfirestore.collection("users").document(name).delete();
		return "Name :"+name+" "+"has been deleted";
		
		
	}
	
	
	
	
	

}
