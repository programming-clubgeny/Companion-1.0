package gas.geny.com.companion;

import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by garvi on 3/11/2017.
 */

public class firebase {

    DatabaseReference myRef ;

    public firebase(DatabaseReference myRef) {
        this.myRef = myRef;
    }

    ArrayList<String> garray = new ArrayList<String>();


//    private void fetch(DataSnapshot dataSnapshot){
//        for (DataSnapshot ds:dataSnapshot.getChildren()){
//            Log.d("sds",ds.toString());
//
//            group g = dataSnapshot.getValue(group.class);
//            garray.add(g);
//            Log.d("adv","Dva");
//        }
//    }

    public ArrayList<String> retrieve(){

        myRef.addChildEventListener(new ChildEventListener() {
                                        @Override
                                        public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                                            group g = dataSnapshot.getValue(group.class);
                                            Log.d("added","onChildAdded:" + dataSnapshot.getValue().toString());

                                            garray.add(g.getName().toString());
//                                           fetch(dataSnapshot);

                                        }

                                        @Override
                                        public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                                            Log.d("changed","onChildChanged:" + dataSnapshot.getKey());


                                        }

                                        @Override
                                        public void onChildRemoved(DataSnapshot dataSnapshot) {
                                            Log.d("removed","onChildRemoved:" + dataSnapshot.getKey());

                                        }

                                        @Override
                                        public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                                            Log.d("moved","onChildMoved:" + dataSnapshot.getKey());

                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            Log.w("cancel", "postComments:onCancelled", databaseError.toException());

                                        }});
        return garray;
    }

}
