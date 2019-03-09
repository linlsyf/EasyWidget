package com.easysoft.widget.edittextview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easysoft.widget.base.BaseCustomView;
import com.easysoft.widget.lib.R;



public class ValidateEdittextView extends BaseCustomView {


	private TextView verifyCodeOneText;

	private ImageView mCursorImgOne;

	RelativeLayout mcontentOneRL;


	private TextView verifyCodeTwoText;

	private ImageView mCursorImgTwo;

	RelativeLayout mcontentTwoRL;


	private TextView verifyCodeThreeText;

	private ImageView mCursorImgThree;

	RelativeLayout mcontentThreeRL;


	private TextView verifyCodeFourText;

	private ImageView mCursorImgFour;

	RelativeLayout mcontentFourRL;


	private TextView verifyCodeFiveText;

	private ImageView mCursorImgFive;

	RelativeLayout mcontentFiveRL;


	private TextView verifyCodeSixText;

	private ImageView mCursorImgSix;

	RelativeLayout mcontentSixRL;


	private BoundEditText verifyCodeEditText;
	public BoundEditText getVerifyCodeEditText() {
		return verifyCodeEditText;
	}



	public ValidateEdittextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initUI(context);
		initListener(null);
	}

	public void initUI(Context context) {

		rootView = LayoutInflater.from(context).inflate(
				R.layout.common_verify_layout, this, true);
		verifyCodeOneText = getViewById(R.id.tv_one);
		mCursorImgOne = getViewById(R.id.cursorImgOne);
		 mcontentOneRL = getViewById(R.id.contentOneRL);



		verifyCodeTwoText = getViewById(R.id.tv_two);
		mCursorImgTwo = getViewById(R.id.cursorImgTwo);
		mcontentTwoRL = getViewById(R.id.contentTwoRL);


		verifyCodeThreeText = getViewById(R.id.tv_three);
		mCursorImgThree = getViewById(R.id.cursorImgThree);
		mcontentThreeRL = getViewById(R.id.contentThreeRL);


		verifyCodeFourText = getViewById(R.id.tv_four);
		mCursorImgFour = getViewById(R.id.cursorImgfour);
		mcontentFourRL = getViewById(R.id.contentFourRL);


		verifyCodeFiveText = getViewById(R.id.tv_five);
		mCursorImgFive = getViewById(R.id.cursorImgFive);
		mcontentFiveRL = getViewById(R.id.contentFiveRL);


		verifyCodeSixText = getViewById(R.id.tv_six);
		mCursorImgSix = getViewById(R.id.cursorImgSix);
		mcontentSixRL = getViewById(R.id.contentSixRL);


		verifyCodeEditText = getViewById(R.id.et_validate);

		AnimationDrawable spinner = (AnimationDrawable) mCursorImgOne.getBackground();
		spinner.start();
		AnimationDrawable spinnerTwo = (AnimationDrawable) mCursorImgTwo.getBackground();
		spinnerTwo.start();
		AnimationDrawable spinneThree = (AnimationDrawable) mCursorImgThree.getBackground();
		spinneThree.start();
		AnimationDrawable spinneFour = (AnimationDrawable) mCursorImgFour.getBackground();
		spinneFour.start();
		AnimationDrawable spinnerFive = (AnimationDrawable) mCursorImgFive.getBackground();
		spinnerFive.start();
		AnimationDrawable spinnerSix = (AnimationDrawable) mCursorImgSix.getBackground();
		spinnerSix.start();
	}

	@Override
	public void initListener(View.OnClickListener listener) {

		verifyCodeEditText.setCursorInEnd(true);
		verifyCodeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (!hasFocus){
					mCursorImgOne.setVisibility(View.INVISIBLE);

					mCursorImgTwo.setVisibility(View.INVISIBLE);

					mCursorImgThree.setVisibility(View.INVISIBLE);

					mCursorImgFour.setVisibility(View.INVISIBLE);

					mCursorImgFive.setVisibility(View.INVISIBLE);

					mCursorImgSix.setVisibility(View.INVISIBLE);
				}else{
					checkLengthSetCursorShow(verifyCodeEditText.getText().toString().trim().length());
				}

			}
		});
		verifyCodeEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {

				String currentVerifyText = verifyCodeEditText.getText()
						.toString().trim();

				verifyCodeOneText.setText("");
				mCursorImgOne.setVisibility(View.INVISIBLE);

				verifyCodeTwoText.setText("");
				mCursorImgTwo.setVisibility(View.INVISIBLE);

				verifyCodeThreeText.setText("");
				mCursorImgThree.setVisibility(View.INVISIBLE);

				verifyCodeFourText.setText("");
				mCursorImgFour.setVisibility(View.INVISIBLE);

				verifyCodeFiveText.setText("");
				mCursorImgFive.setVisibility(View.INVISIBLE);

				verifyCodeSixText.setText("");
				mCursorImgSix.setVisibility(View.INVISIBLE);

				int length = currentVerifyText.length();
				checkLengthSetCursorShow(length);
				if (length > 0) {
					verifyCodeOneText.setText(currentVerifyText.subSequence(0,
							1));

					if (length > 1) {
						verifyCodeTwoText.setText(currentVerifyText
								.subSequence(1, 2));

						if (length > 2) {
							verifyCodeThreeText.setText(currentVerifyText
									.subSequence(2, 3));

							if (length > 3) {
								verifyCodeFourText.setText(currentVerifyText
										.subSequence(3, 4));

								if (length > 4) {
									verifyCodeFiveText.setText(currentVerifyText
													.subSequence(4, 5));

									if (length > 5) {
										verifyCodeSixText.setText(currentVerifyText
														.subSequence(5, 6));

									}
								}
							}
						}
					}
				}

			}
		});
		//layout 点击设置光标位置

	}


	private void checkLengthSetCursorShow(int length){
		if (length==0){
			mCursorImgOne.setVisibility(View.VISIBLE);
		}else if (length==1){
			mCursorImgTwo.setVisibility(View.VISIBLE);

		}else if (length==2){
			mCursorImgThree.setVisibility(View.VISIBLE);

		}else 	if (length==3){
			mCursorImgFour.setVisibility(View.VISIBLE);

		}else if (length==4){
			mCursorImgFive.setVisibility(View.VISIBLE);

		}else if (length==5){
			mCursorImgSix.setVisibility(View.VISIBLE);

		}else if (length==6){
			mCursorImgSix.setVisibility(View.VISIBLE);

		}
	}


	public String getValidateCode() {
		return verifyCodeEditText.getText().toString();
	}

}
