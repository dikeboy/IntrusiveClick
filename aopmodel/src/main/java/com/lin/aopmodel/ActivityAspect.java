package com.lin.aopmodel;

import android.util.Log;
import android.view.View;
import com.lin.clickmodel.ClickInter;
import com.lin.clickmodel.ClickModel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ActivityAspect {
    public  final String TAG = this.getClass().getSimpleName().toString();

    @After("execution(* androidx.fragment.app.FragmentActivity.onResume(..))")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","resume="+joinPoint.getThis());

    }

    @After("execution(* androidx.fragment.app.FragmentActivity.onPause(..))")
    public void onPauseMethod(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","pause="+joinPoint.getThis());
    }
    @Before("execution(* androidx.fragment.app.FragmentActivity.onCreate(..))")
    public void beforeCreate(JoinPoint joinPoint) throws Throwable {
        Log.e("lin","onCreate="+joinPoint.getThis());
    }


    @Before("execution(* com.lin.aopdemo.generated.callback.OnClickListener.onClick(..))")
    public void onCommonClick(JoinPoint joinPoint) throws Throwable {
        View view  = (View)joinPoint.getArgs()[0];
        Log.e("lin","onClick="+joinPoint.getThis());
        if(view.getContext() instanceof ClickInter){
            ClickModel.INSTANCE.doClick(view,((ClickInter)view.getContext()).getPageParam());
        }
    }

}
