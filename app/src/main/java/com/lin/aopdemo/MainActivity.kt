package com.lin.aopdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import com.lin.aopdemo.click.CommonBaseClick
import com.lin.aopdemo.databinding.ActivityMainBinding
import com.lin.aopdemo.model.MainModel
import com.lin.clickmodel.ClickInter
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.lin.aopdemo.databinding.TestItemBinding


class MainActivity : AppCompatActivity(), ClickInter {
    var mainModel: MainModel? = null
     var mDatas = mutableListOf<MainModel>()
    lateinit var recyleView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val bind: ActivityMainBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
            R.layout.activity_main, null, false)
        setContentView(bind.root)

        mainModel = MainModel()
        mainModel?.name = "你好呀"
        mainModel?.elementId  = 101
        mainModel?.title = "dsddd";
        bind.module = mainModel

        recyleView = findViewById<RecyclerView>(R.id.vapilogRecycleView)
        Log.e("lin",bind.root.getClickData())

        bind.click = MainClickListener()

        for( i in 0..20){
           var  main = MainModel()
            main.name = "你好呀 " +i;
            main.elementId  = 101
            main.title = "dsddd";
            mDatas.add(main)

        }

        recyleView.setLayoutManager(LinearLayoutManager(this))
        recyleView.setAdapter(HomeAdapter())
    }

    override fun getPageParam(): Map<String, String> {
        return  mapOf<String,String>("pageCode" to localClassName)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    inner class MainClickListener: CommonBaseClick{
        fun onMainClick( m: MainModel,view: View){

        }

        override fun testClick() {

        }
    }


     inner class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

         override fun getItemCount(): Int {
             return mDatas.size
         }

       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
           var binding = DataBindingUtil.inflate<TestItemBinding>(layoutInflater, R.layout.test_item, parent, false)
           return MyViewHolder(binding)
        }

         override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
             holder.binding.module = mDatas[position]
        }

         inner class MyViewHolder(var binding: TestItemBinding): RecyclerView.ViewHolder(binding.root) {

         }
    }
}
