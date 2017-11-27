package ccc.ww.liyaya_1508b20171026_yuekao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.BaseActivity;
import net.BaseBean;
import net.OnNetListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adpter.MyApterr;
import Bean.Beann;

public class MainActivity extends BaseActivity {
    private List<Beann.DataBean> list=new ArrayList<Beann.DataBean>();
    private RecyclerView recycle;
    private Beann.DataBean bean;
    private MyApterr apterr;
    private String url="http://www.yulin520.com/a2a/impressApi/news/mergeList?sign=C7548DE604BCB8A17592EFB9006F9265&pageSize=20&gender=2&ts=1871746850&page=1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=(RecyclerView)findViewById(R.id.recycle);
        httpUtil.doGet(url, Beann.class, new OnNetListener() {


            @Override
            public void onSuccess(BaseBean baseBean) throws IOException {
                apterr = new MyApterr(MainActivity.this, list);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
                recycle.setLayoutManager(linearLayoutManager);
                recycle.setAdapter(apterr);
            }

            @Override
            public void onError(IOException e) {

            }
        });
    }
}
