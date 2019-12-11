package com.easysoft.widget.fragment;

import android.app.Activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import com.easysoft.widget.lib.R;

import java.util.List;



public class FragmentHelper {


	public  static final  String AnimationsType="animationsType";


	/**
	 * 
	 * 创建者：ldh 时间：2015年5月7日 下午6:19:47 注释：回退到上一层
	 * 
	 */
	public static void popBackFragment(FragmentActivity activity) {
		activity.getSupportFragmentManager().popBackStack();

//		activity.getFragmentManager().popBackStack();

	}
	/**
	 * 
	 * <br>创建者：ldh
	 * <br>修改时间：2015年5月20日 上午10:20:50 
	 * <br>注释：清除栈中的fragment
	 * @param activity
	 */
	public static void cleanAllFragement(FragmentActivity activity){
		FragmentManager manager = activity.getSupportFragmentManager();
		int i = manager.getBackStackEntryCount();
		while (i > 0) {
			manager.popBackStack();
			i--;
		}
	}

	public static void showFrag(final FragmentActivity activity,final int resourceId,
								final Fragment showFragment,final Bundle bundle){



		  activity.runOnUiThread(new Runnable() {
			  @Override
			  public void run() {
				  FragmentManager manager = activity.getSupportFragmentManager();
				  FragmentTransaction fragmentTransaction = manager.beginTransaction();

				  Fragment from=manager.findFragmentById(resourceId);

				  FragmentTransactionExtended fragmentTransactionExtended = new FragmentTransactionExtended(activity, fragmentTransaction, from, showFragment,resourceId);
				  int animationsType=FragmentTransactionExtended.SLIDE_HORIZONTAL;
				  if (bundle!=null&&bundle.containsKey(AnimationsType)){

					  animationsType=bundle.getInt(AnimationsType);

				  }
				  fragmentTransactionExtended.addTransition(animationsType);


				  if (bundle != null) {
					  if (!showFragment.isRemoving()) {
						  try {
							  showFragment.setArguments(bundle);
						  } catch (Exception e) {
							  e.printStackTrace();
						  }
					  }
				  }
				  fragmentTransactionExtended.commit();
			  }
		  });


	}
	/**
	 *
	 * <br>创建者：ldh
	 * <br>修改时间：2015年5月30日 上午10:35:41
	 * <br>注释：activity中 显示Fragment
	 * @param activity
	 * @param resourceId  Fragmentlayout id
	 * @param showFragment 要显示的Fragment
	 * @param bundle
	 */
	public static void showFragSystem(FragmentActivity activity, int resourceId,
								Fragment showFragment, Bundle bundle){

		FragmentManager manager = activity.getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
//		int i = manager.getBackStackEntryCount();

//		int  enter=R.anim.slide_right_enter;
//		int  out= R.anim.slide_left_exit;
//		int  enterPop=R.anim.slide_right_enter;
//		int  outPop= R.anim.slide_left_exit;
		transaction.setCustomAnimations(
				R.animator.slide_right_in, R.animator.fragment_slide_left_out,
				R.animator.fragment_slide_left_in, R.animator.fragment_slide_right_out);



		Fragment from=manager.findFragmentById(resourceId);
		 if (from!=null){
			 transaction.hide(from);

		 }
		transaction.replace(resourceId, showFragment);

		transaction.addToBackStack(showFragment.getTag());

		if (bundle != null) {
			if (!showFragment.isRemoving()) {
				try {
					showFragment.setArguments(bundle);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		transaction.commitAllowingStateLoss();

	}

	
}
