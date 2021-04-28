package com.example.androlearn.firestorequery

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot

class FireStoreQuery {

    private val firebaseFireStore : FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getCategories(): Task<QuerySnapshot> {
        return firebaseFireStore.collection("Categories").get()
    }

    fun getComponents(compName : String): Task<QuerySnapshot> {
        return firebaseFireStore.collection("Components").whereEqualTo("comp_name", compName).get()
    }

}