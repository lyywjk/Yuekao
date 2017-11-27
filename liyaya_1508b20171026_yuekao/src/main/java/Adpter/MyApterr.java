package Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ViewStubCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

import Bean.Beann;
import ccc.ww.liyaya_1508b20171026_yuekao.R;

/**
 * Created by dell on 2017/10/26.
 */

public class MyApterr extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Beann.DataBean> list;
    private  OnItemListener onItemListener;

    public MyApterr(Context context,List<Beann.DataBean> list){
        this.context=context;
        this.list=list;
    }

    public interface OnItemListener{
        public void onItemClick(Beann.DataBean dataBean);
    }
    public void setonItemListener(OnItemListener onItemListener){
        this.onItemListener=onItemListener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyAdpterHolde(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       MyAdpterHolde holder1 =(MyAdpterHolde) holder;

        holder1.tv.setText(list.get(position).getTitle());
        holder1.tv1.setText(list.get(position).getOccupation());
        holder1.tv2.setText(list.get(position).getIntroduction());
        ImageLoader.getInstance().displayImage(list.get(position).getImg(),holder1.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyAdpterHolde extends RecyclerView.ViewHolder {
        private TextView tv,tv1,tv2;
        private ImageView img;
        public MyAdpterHolde(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            img=itemView.findViewById(R.id.img);
        }
    }
}
