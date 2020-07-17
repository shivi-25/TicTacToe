package shivani.com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     int active =0;
     // 0=orange and 1=blue
    boolean isplaying = true;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int[][] winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
     public void dropIn(View view){
         ImageView current = (ImageView) view;

         int x= Integer.parseInt(current.getTag().toString());
         if(gameState[x]==2 && isplaying){
             current.setTranslationY(-1000f);
             gameState[x]=active;
         if(active==0)
         {
             current.setImageResource(R.drawable.orange);
             active =1;
         }
         else {
             current.setImageResource(R.drawable.blue);
             active =0;
         }
             current.animate().translationYBy(1000f).setDuration(300);}
         for(int[] win: winning)
         {
             if(gameState[win[0]]==gameState[win[1]] && gameState[win[1]]==gameState[win[2]] && gameState[win[0]]!=2)
             {   System.out.println(gameState[win[0]]);
                 String mm="Blue";
                 isplaying=false;
                 if(gameState[win[0]]==0) {
                 mm="Orange";
                }
                 TextView winner=(TextView) findViewById(R.id.winnerId);
                 winner.setText(mm + " has won!");
                 LinearLayout layout = (LinearLayout) findViewById(R.id.textLayout);
                 layout.setVisibility(View.VISIBLE);
             }
             else {
                 boolean gameOver = true;
                 for (int a : gameState) {
                     if (a == 2)
                         gameOver = false;
                 }
                 if (gameOver) {

                    TextView winner = (TextView) findViewById(R.id.winnerId);
                     winner.setText("Draw");
                     LinearLayout layout = (LinearLayout) findViewById(R.id.textLayout);
                     layout.setVisibility(View.VISIBLE);
                 }
             }
             }
         }
         public void playAgain(View view){
             //Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();

         LinearLayout layout=(LinearLayout)findViewById(R.id.textLayout);
         layout.setVisibility(View.INVISIBLE);

         active = 0;
         isplaying = true;
         for (int i=0;i<gameState.length;i++)
         {
             gameState[i]=2;
         }
             androidx.gridlayout.widget.GridLayout gridLayout=findViewById(R.id.gridLayout);

              for (int i=0;i<gridLayout.getChildCount();i++){
                  ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
              }

         }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
