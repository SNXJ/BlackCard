package com.zsh.blackcard.untils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * @author SXJ
 * @date 2016-11-17 上午10:47:05
 * @description 小数点位数监听
 */
public class EditTextDecimalUntil {
    private static int beforeDecimal = 5; // 没有小数点时需要限制的位数
    private static int afterDecimal = 2; // 小数点后限制既保留小数点的位数

    /**
     * 自定义EditText的小数点位数
     * <p>
     * （EditText的长度限制可以在XML maxLength设置为 berDecimal+ afrDecimal+1
     * android:numeric="decimal"）
     *
     * @param editText
     * @param berDecimal 小数点前位数（没有小数点需要限制的位数）
     * @param afrDecimal 需要限制的小数点位数
     */
    public static void customEditText(final EditText editText, int berDecimal,
                                      int afrDecimal) {
        beforeDecimal = berDecimal;
        afterDecimal = afrDecimal;
        editTextWatch(editText);
    }

    /**
     * 限制EditText的小数点位数
     *
     * @param editText
     */
    public static void editTextWatch(final EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > afterDecimal) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + afterDecimal + 1);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                    if (s.toString().indexOf(".") > beforeDecimal) {
                        s = s.toString().subSequence(
                                s.toString().indexOf(".") - beforeDecimal,
                                s.length());
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }

                } else {
                    if (s.length() > beforeDecimal) {
                        s = s.toString().subSequence(0, beforeDecimal);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                }
//               // s.toString().startswith(".");
//                String ss = s.toString().trim().substring(0);
//                if (ss.equals(".")) {
//                    s = "0" + s;
//                    editText.setText(s);
//                    editText.setSelection(2);
//                }
                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        editText.setText(s.subSequence(0, 1));
                        editText.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
        // 以.结尾则去除
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (editText.getText().toString().trim().endsWith(".")) {
                        editText.setText(editText
                                .getText()
                                .toString()
                                .substring(
                                        0,
                                        editText.getText().toString().length() - 1));
                    }
                }
            }
        });
    }
}
