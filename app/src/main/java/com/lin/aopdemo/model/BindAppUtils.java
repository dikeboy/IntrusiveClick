package com.lin.aopdemo.model;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.lin.aopdemo.R;

public class BindAppUtils {
    @BindingAdapter("bindClickData")
    public static void bindClickData(View view, String data) {
        Log.e("lin","bindData="+data);
        view.setTag(R.id.snow_click_id,data);
    }
}
