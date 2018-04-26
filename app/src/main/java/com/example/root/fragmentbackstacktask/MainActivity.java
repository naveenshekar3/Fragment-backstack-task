package com.example.root.fragmentbackstacktask;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {


    private SecondFragment mSecFrag;
    private ThirdFragment mThirdFrag;
    private FourthFragment mFourthFrag;
    private FifthFragment mFifthFrag;
    private FragmentManager mFragManager;
    private FirstFragment mFirstFrag;
    private FragmentTransaction mFragTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSecFrag=new SecondFragment();
        mThirdFrag=new ThirdFragment();
        mFourthFrag=new FourthFragment();
        mFifthFrag=new FifthFragment();
        
        mFragManager=getFragmentManager();
        mFirstFrag=(FirstFragment)mFragManager.findFragmentById(R.id.fragment1);
        mFragTransaction=mFragManager.beginTransaction();
        mFragTransaction.add(R.id.myframe,mSecFrag);
        mFragTransaction.commit();
    }

    public void change()
    {
        mFragTransaction=mFragManager.beginTransaction();
        if (mSecFrag.isResumed())
        {
            mThirdFrag=new ThirdFragment();
            mFragTransaction.replace(R.id.myframe,mThirdFrag);
        }
        else if(mThirdFrag.isResumed())
        {
            mFourthFrag=new FourthFragment();
            mFragTransaction.replace(R.id.myframe,mFourthFrag);
        }
        else if (mFourthFrag.isResumed())
        {
            mFifthFrag=new FifthFragment();
            mFragTransaction.replace(R.id.myframe,mFifthFrag);
        }
        else if (mFifthFrag.isResumed())
        {
            mSecFrag=new SecondFragment();
            mFragTransaction.replace(R.id.myframe,mSecFrag);
        }

        mFragTransaction.addToBackStack(null);
        mFragTransaction.commit();
    }
}
