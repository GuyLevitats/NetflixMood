package com.example.netflixmood.UtilsPackage;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixmood.AdaptersPackage.AdapterMovies;
import com.example.netflixmood.ModelsPackage.MovieModel;
import com.example.netflixmood.PagesPackage.MainActivity;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirebaseManager {

    private FirebaseFirestore firestore;
    private final ArrayList<MovieModel> arrayList = new ArrayList<>();
    private AdapterMovies adapterMovies;

    public void initFirestore() {
        firestore = FirebaseFirestore.getInstance();
    }

    public void getAllDataFirestore(Activity activity, RecyclerView recyclerView) {
        firestore.collection("movie")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        arrayList.clear();

                        for (DocumentSnapshot doc : task.getResult()) {
                            MovieModel note = doc.toObject(MovieModel.class);
                            assert note != null;
                            note.setId(doc.getId());
                            arrayList.add(note);
                        }

                        adapterMovies = new AdapterMovies(arrayList, activity);
                        adapterMovies.setMovies(arrayList);
                        recyclerView.setAdapter(adapterMovies);
                    } else {
                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void getDocumentDataFirestore(String type, String language, String who, String typeMovie, TextView tvDetails) {
        firestore.collection("movie")
                .whereEqualTo("type", type)
                .whereEqualTo("language", language)
                .whereEqualTo("who", who)
                .whereEqualTo("typeMovie", typeMovie)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            tvDetails.setText(document.getId());
                        }
                    } else {
                        Log.i("check1", "Error getting documents: ", task.getException());
                    }
                });
    }

    public void addDocumentDataFirestore(String type, String language, String who, String typeMovie,
                                         String url, String name, Activity activity) {
        Map<String, Object> user = new HashMap<>();
        user.put("type", type);
        user.put("language", language);
        user.put("who", who);
        user.put("typeMovie", typeMovie);
        user.put("url", url);
        user.put("name", name);

        firestore.collection("movie")
                .document(name)
                .set(user)
                .addOnSuccessListener(aVoid -> {
                    Intent intentAddInternetToMain = new Intent(activity, MainActivity.class);
                    activity.startActivity(intentAddInternetToMain);

                    activity.finish();
                })
                .addOnFailureListener(e -> Toast.makeText(activity, "Error: " + e, Toast.LENGTH_SHORT).show());
    }

}
