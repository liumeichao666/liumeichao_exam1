package com.bwei.liumeichao_exam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化视图
        initview();
    }

    private void initview() {
        flowLayout=findViewById(R.id.flowLayaout);

        flowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"动画",Toast.LENGTH_SHORT).show();
             Toast.makeText(MainActivity.this,"成功",Toast.LENGTH_SHORT).show();
                switch (v.getId()){
                    case R.id.tv_ddd:
                        Toast.makeText(MainActivity.this,"动画",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.tv_donghua:
                        Toast.makeText(MainActivity.this,"动画",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.tv_mianshi:
                        Toast.makeText(MainActivity.this,"面试",Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.tv_Studio3:
                        Toast.makeText(MainActivity.this,"Studio3",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.tv_toutiao:
                        Toast.makeText(MainActivity.this,"开发者头条",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.tv_xingnneg:
                        Toast.makeText(MainActivity.this,"性能优化",Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
    }
}
