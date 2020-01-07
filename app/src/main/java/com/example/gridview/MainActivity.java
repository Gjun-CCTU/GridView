package com.example.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ImageView imageView;
    int images[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,
            R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10,
            R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridview);
        imageView = findViewById(R.id.imageView);
        gridView.setAdapter(new IamgeAdapter(MainActivity.this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "No."+(position+1), Toast.LENGTH_SHORT).show();
                imageView.setImageResource(images[position]);
            }
        });
    }

    public class IamgeAdapter extends BaseAdapter{
        Context context;

        public IamgeAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv;
            if(convertView == null){
                iv = new ImageView(context);
                iv.setLayoutParams(new GridView.LayoutParams(125, 150));
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
            }else{
                iv = (ImageView)convertView;
            }
            iv.setImageResource(images[position]);
            return iv;
        }
    }
}
